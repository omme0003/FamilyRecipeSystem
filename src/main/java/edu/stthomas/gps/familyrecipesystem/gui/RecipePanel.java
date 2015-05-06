package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.FamilyRecipeSystemApplication;
import edu.stthomas.gps.familyrecipesystem.entity.Comment;
import edu.stthomas.gps.familyrecipesystem.entity.CommentImpl;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptions;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptionsImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.entity.RecipeImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Unit;
import edu.stthomas.gps.familyrecipesystem.service.CommentService;
import edu.stthomas.gps.familyrecipesystem.service.CommentServiceImpl;
import edu.stthomas.gps.familyrecipesystem.service.RecipeService;
import edu.stthomas.gps.familyrecipesystem.service.RecipeServiceImpl;

public class RecipePanel extends JPanel {

	private final JPanel panel;
	private final JTextPane recipeName;
	private final JTable ingredientsTable;
	private final JLabel instructionsHeader;
	private final JTextArea recipeDescription;
	private final JLabel commentsHeader;
	private final JEditorPane commentArea;
	private JButton saveChangesButton;
	private final Recipe recipe;

	/**
	 * Create the panel.
	 * 
	 * @throws ParseException
	 */
	public RecipePanel(final ClassPathXmlApplicationContext CTX, final MainWindow parent, final int recipeId) {
		final RecipeService recipeService = CTX.getBean("recipeService", RecipeServiceImpl.class);
		if (recipeId > 0) {
			this.recipe = recipeService.getById(recipeId);
		}
		else {
			this.recipe = new RecipeImpl();
		}

		this.setSize(new Dimension(360, 554));
		this.setLayout(null);

		boolean canEdit = false;
		if ((recipeId <= 0) || AppSession.getInstance().getUser().getId().equals(this.recipe.getManagedBy().getId())) {
			canEdit = true;
		}

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 5, 350, 544);
		this.add(scrollPane);

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(this.panel);

		this.recipeName = new JTextPane();
		this.recipeName.setMaximumSize(new Dimension(350, 60));
		this.recipeName.setBackground(UIManager.getColor("InternalFrame.background"));
		this.recipeName.setText(this.recipe.getName());
		this.recipeName.setEditable(canEdit);
		this.panel.add(this.recipeName);

		this.ingredientsTable = new JTable(new IngredientsTableModel(canEdit));
		this.ingredientsTable.setMaximumSize(new Dimension(350, 0));
		this.ingredientsTable.getColumnModel().getColumn(1).setCellEditor(new UnitTableCellEditor());
		final IngredientsTableModel model = (IngredientsTableModel) this.ingredientsTable.getModel();
		this.panel.add(this.ingredientsTable.getTableHeader());
		this.panel.add(this.ingredientsTable);

		final List<IngredientOptions> ingredientOptions = this.recipe.getIngredientOptions();

		for (final IngredientOptions ig : ingredientOptions) {
			final String[] data = new String[4];
			data[0] = ig.getQuantityFormatted();
			data[1] = ig.getUnit().toString();
			data[2] = ig.getIngredient().getName();
			data[3] = ig.getId().toString();
			model.addRow(data);
		}

		if (canEdit) {
			final JButton newIngredientButton = new JButton();
			newIngredientButton.setText("Add New Ingredient...");
			newIngredientButton.addActionListener(e -> model.addRow());
			this.panel.add(newIngredientButton);
		}

		this.instructionsHeader = new JLabel("Instructions:");
		this.instructionsHeader.setAlignmentY(Component.LEFT_ALIGNMENT);
		this.panel.add(this.instructionsHeader);

		this.recipeDescription = new JTextArea();
		this.recipeDescription.setText(this.recipe.getDescription());
		this.recipeDescription.setEditable(canEdit);
		this.recipeDescription.setLineWrap(true);
		this.recipeDescription.setWrapStyleWord(true);
		this.recipeDescription.setMargin(new Insets(10, 10, 10, 10));
		this.panel.add(this.recipeDescription);

		this.panel.add(Box.createVerticalGlue());

		this.commentsHeader = new JLabel("Comments:");
		this.commentsHeader.setAlignmentY(Component.LEFT_ALIGNMENT);
		this.panel.add(this.commentsHeader);

		this.commentArea = new JEditorPane();
		this.renderCommentArea();
		this.panel.add(this.commentArea);

		this.panel.add(new JLabel("Add new comment:"));
		final JTextArea newComment = new JTextArea();
		newComment.setLineWrap(true);
		newComment.setWrapStyleWord(true);
		newComment.setMinimumSize(new Dimension(newComment.getWidth(), 100));
		this.panel.add(newComment);

		final JButton saveCommentButton = new JButton();
		saveCommentButton.setText("Save comment");
		final CommentService commentService = FamilyRecipeSystemApplication.getContext().getBean("commentService",
				CommentServiceImpl.class);

		saveCommentButton.addActionListener(e -> {
			SwingUtilities.invokeLater(() -> {
				final String newCommentText = newComment.getText().trim();
				if (newCommentText.isEmpty()) {
					JOptionPane.showMessageDialog(RecipePanel.this, "Please enter some text in the comment field.");
				}
					else {
					final Comment comment = new CommentImpl(newCommentText, AppSession.getInstance().getUser(),
							RecipePanel.this.recipe);
						commentService.insert(comment);
						RecipePanel.this.renderCommentArea();
						newComment.setText("");
					}
				});

		});

		if (canEdit) {
			this.saveChangesButton = new JButton();
			this.saveChangesButton.setText("Save Changes");
			this.saveChangesButton.addActionListener(e -> {
				this.recipe.getIngredientOptions().clear();
				this.recipe.setName(RecipePanel.this.recipeName.getText());
				this.recipe.setDescription(RecipePanel.this.recipeDescription.getText());
				for (int i = 0; i < model.getRowCount(); i++) {
					final float quantity = RecipePanel.numberOrZero(model.getValueAt(i, 0).toString());
					final Unit unit = Unit.valueOf(model.getValueAt(i, 1).toString());
					final String ingredient = model.getValueAt(i, 2).toString();
					final int id = Integer.parseInt(model.getValueAt(i, 3).toString());
					final IngredientOptions option = new IngredientOptionsImpl(quantity, unit, ingredient, this.recipe);
					if (id > 0) {
						option.setId(id);
					}
					this.recipe.addIngredientOptions(option);
				}
				recipeService.insertOrUpdate(this.recipe);
				JOptionPane.showMessageDialog(this, "Recipe saved.");
			});
		}

		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		buttonsPanel.add(saveCommentButton);
		if (canEdit) {
			buttonsPanel.add(this.saveChangesButton);
		}
		this.panel.add(buttonsPanel);
	}

	private void renderCommentArea() {
		final List<Comment> commentList = this.recipe.getComments();
		this.commentArea.setText("");
		this.commentArea.setContentType("text/html");
		this.commentArea.setText("<html>");
		this.commentArea.setEditable(false);
		this.commentArea.setAutoscrolls(true);
		final DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		final StringBuilder commentText = new StringBuilder();
		for (final Comment comment : commentList) {
			final String creatorName = comment.getMember().getFullName();
			final String textToAdd = String
					.format("<b>%s</b> %s<br>%s", creatorName, format.format(comment.getCreated()), comment.getText());
			if (commentText.toString().isEmpty()) {
				commentText.append(textToAdd);
			}
			else {
				commentText.append("<br><br>" + textToAdd);
			}
		}
		this.commentArea.setText("<html>" + commentText + "</html>");
	}

	private static float numberOrZero(final String s) {
		float f;
		try {
			f = Float.parseFloat(s);
		} catch (final NumberFormatException e) {
			f = 0;
		}
		return f;
	}
}
