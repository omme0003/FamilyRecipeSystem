package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptions;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptionsImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.entity.RecipeImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Unit;
import edu.stthomas.gps.familyrecipesystem.service.RecipeService;
import edu.stthomas.gps.familyrecipesystem.service.RecipeServiceImpl;

public class RecipePanel extends JPanel {
	
	private JPanel panel;
	private JTextPane recipeName;
	private JTable ingredientsTable;
	private JButton newIngredientButton;
	private JTextPane instructionsHeader;
	private JTextPane recipeDescription;
	private JTextPane commentsHeader;
	private JPanel commentsPanel;
	private JButton saveChangesButton;

	/**
	 * Create the panel.
	 */
	public RecipePanel(ClassPathXmlApplicationContext CTX, final MainWindow parent, final int recipeId) {
		final RecipeService recipeService = CTX.getBean("recipeService", RecipeServiceImpl.class);
		Recipe recipe;
		if (recipeId > 0) {
			recipe = recipeService.getById(recipeId);
		}
		else {
			recipe = new RecipeImpl();
		}
		
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		boolean canEdit = AppSession.getInstance().getUser().getId().equals(recipe.getManagedBy().getId());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 5, 354, 544);
		add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panel);
		
		recipeName = new JTextPane();
		recipeName.setMaximumSize(new Dimension(354, 60));
		recipeName.setBackground(UIManager.getColor("InternalFrame.background"));
		recipeName.setText(recipe.getName());
		recipeName.setEditable(canEdit);
		panel.add(recipeName);
		
		ingredientsTable = new JTable(new IngredientsTableModel(canEdit));
		ingredientsTable.setMaximumSize(new Dimension(354, 0));
		IngredientsTableModel model = (IngredientsTableModel) ingredientsTable.getModel();
		panel.add(ingredientsTable.getTableHeader());
		panel.add(ingredientsTable);
		
		List<IngredientOptions> ingredientOptions = recipe.getIngredientOptions();
		
		for(IngredientOptions ig : ingredientOptions) {
			final String[] data = new String[4];
			data[0] = ig.getQuantityFormatted();
			data[1] = ig.getUnit().toString();
			data[2] = ig.getIngredient().getName();
			data[3] = ig.getId().toString();
			model.addRow(data);		
		}
		
		if (canEdit) {
			newIngredientButton = new JButton();
			newIngredientButton.setText("Add New Ingredient...");
			newIngredientButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model.addRow();
				}
			});
			panel.add(newIngredientButton);
		}
		
		instructionsHeader = new JTextPane();
		instructionsHeader.setMaximumSize(new Dimension(354, 60));
		instructionsHeader.setText("Instructions:");
		instructionsHeader.setEditable(false);
		panel.add(instructionsHeader);
		
		recipeDescription = new JTextPane();
		recipeDescription.setText(recipe.getDescription());
		recipeDescription.setEditable(canEdit);
		panel.add(recipeDescription);
		
		panel.add(Box.createVerticalGlue());
		
		commentsHeader = new JTextPane();
		commentsHeader.setMaximumSize(new Dimension(354, 2147483647));
		commentsHeader.setText("Comments");
		commentsHeader.setEditable(false);
		panel.add(commentsHeader);
		
//		List<Comment> commentList = recipe.getComments();
//		for(Comment comment: commentList) {
//			commentText = new JTextPane();
//			commentText.setText(comment.getText());
//			panel.add(commentText, constraints);
//		}
		
		if (canEdit) {
			saveChangesButton = new JButton();
			saveChangesButton.setText("Save Changes");
			saveChangesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					recipe.getIngredientOptions().clear();
					recipe.setName(recipeName.getText());
					recipe.setDescription(recipeDescription.getText());
					for(int i = 0; i < model.getRowCount(); i++) {
						final float quantity = numberOrZero(model.getValueAt(i, 0).toString());
						final Unit unit = Unit.valueOf(model.getValueAt(i,  1).toString());
						final String ingredient = model.getValueAt(i, 2).toString();
						final int id = Integer.parseInt(model.getValueAt(i, 3).toString());
						final IngredientOptions option = new IngredientOptionsImpl(quantity, unit, ingredient, recipe);
						if (id > 0) {
							option.setId(id);
						}
						recipe.addIngredientOptions(option);
					}
					recipeService.insertOrUpdate(recipe);
				}
			});
			panel.add(saveChangesButton);
		}

	}
	
	private static float numberOrZero(String s) {
		float f;
		try {
			f = Float.parseFloat(s);
		} catch(NumberFormatException e) {
			f = 0;
		}
		return f;
	}
}
