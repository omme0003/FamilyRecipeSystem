package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.entity.Comment;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptions;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptionsImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.entity.RecipeImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Unit;
import edu.stthomas.gps.familyrecipesystem.service.RecipeService;
import edu.stthomas.gps.familyrecipesystem.service.RecipeServiceImpl;

public class RecipePanel extends JPanel {

	private final JPanel panel;
	private final JTextPane recipeName;
	private final JTable ingredientsTable;
	private JButton newIngredientButton;
	private final JTextPane instructionsHeader;
	private final JTextArea recipeDescription;
	private final JTextPane commentsHeader;
	private JPanel commentsPanel;
	private JButton saveChangesButton;

	/**
	 * Create the panel.
	 */
	public RecipePanel(final ClassPathXmlApplicationContext CTX, final MainWindow parent, final int recipeId) {
		final RecipeService recipeService = CTX.getBean("recipeService", RecipeServiceImpl.class);
		Recipe recipe;
		if (recipeId > 0) {
			recipe = recipeService.getById(recipeId);
		}
		else {
			recipe = new RecipeImpl();
		}

		this.setSize(new Dimension(360, 554));
		this.setLayout(null);

		boolean canEdit = false;
		if ((recipeId <= 0) || AppSession.getInstance().getUser().getId().equals(recipe.getManagedBy().getId())) {
			canEdit = true;
		}

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 5, 354, 544);
		this.add(scrollPane);

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(this.panel);

		this.recipeName = new JTextPane();
		this.recipeName.setMaximumSize(new Dimension(354, 60));
		this.recipeName.setBackground(UIManager.getColor("InternalFrame.background"));
		this.recipeName.setText(recipe.getName());
		this.recipeName.setEditable(canEdit);
		this.panel.add(this.recipeName);

		this.ingredientsTable = new JTable(new IngredientsTableModel(canEdit));
		this.ingredientsTable.setMaximumSize(new Dimension(354, 0));
		this.ingredientsTable.getColumnModel().getColumn(1).setCellEditor(new UnitTableCellEditor());
		final IngredientsTableModel model = (IngredientsTableModel) this.ingredientsTable.getModel();
		this.panel.add(this.ingredientsTable.getTableHeader());
		this.panel.add(this.ingredientsTable);

		final List<IngredientOptions> ingredientOptions = recipe.getIngredientOptions();

		for (final IngredientOptions ig : ingredientOptions) {
			final String[] data = new String[4];
			data[0] = ig.getQuantityFormatted();
			data[1] = ig.getUnit().toString();
			data[2] = ig.getIngredient().getName();
			data[3] = ig.getId().toString();
			model.addRow(data);
		}

		if (canEdit) {
			this.newIngredientButton = new JButton();
			this.newIngredientButton.setText("Add New Ingredient...");
			this.newIngredientButton.addActionListener(e -> model.addRow());
			this.panel.add(this.newIngredientButton);
		}

		this.instructionsHeader = new JTextPane();
		this.instructionsHeader.setMaximumSize(new Dimension(354, 58));
		this.instructionsHeader.setText("Instructions:");
		this.instructionsHeader.setEditable(false);
		this.panel.add(this.instructionsHeader);

		this.recipeDescription = new JTextArea();
		this.recipeDescription.setText(recipe.getDescription());
		this.recipeDescription.setEditable(canEdit);
		this.recipeDescription.setLineWrap(true);
		this.recipeDescription.setWrapStyleWord(true);
		this.recipeDescription.setMargin(new Insets(10, 10, 10, 10));
		this.panel.add(this.recipeDescription);

		this.panel.add(Box.createVerticalGlue());

		this.commentsHeader = new JTextPane();
		this.commentsHeader.setMaximumSize(new Dimension(354, 2147483647));
		this.commentsHeader.setText("Comments");
		this.commentsHeader.setEditable(false);
		this.panel.add(this.commentsHeader);

		final List<Comment> commentList = recipe.getComments();
		for (final Comment comment : commentList) {
			final JTextPane commentText = new JTextPane();
			commentText.setText(comment.getText());
			this.panel.add(commentText);
		}

		if (canEdit) {
			this.saveChangesButton = new JButton();
			this.saveChangesButton.setText("Save Changes");
			this.saveChangesButton.addActionListener(e -> {
				recipe.getIngredientOptions().clear();
				recipe.setName(RecipePanel.this.recipeName.getText());
				recipe.setDescription(RecipePanel.this.recipeDescription.getText());
				for (int i = 0; i < model.getRowCount(); i++) {
					final float quantity = RecipePanel.numberOrZero(model.getValueAt(i, 0).toString());
					final Unit unit = Unit.valueOf(model.getValueAt(i, 1).toString());
					final String ingredient = model.getValueAt(i, 2).toString();
					final int id = Integer.parseInt(model.getValueAt(i, 3).toString());
					final IngredientOptions option = new IngredientOptionsImpl(quantity, unit, ingredient, recipe);
					if (id > 0) {
						option.setId(id);
					}
					recipe.addIngredientOptions(option);
				}
				recipeService.insertOrUpdate(recipe);
			});
			this.panel.add(this.saveChangesButton);
		}

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
