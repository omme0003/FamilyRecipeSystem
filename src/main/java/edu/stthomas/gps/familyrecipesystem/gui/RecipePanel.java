package edu.stthomas.gps.familyrecipesystem.gui;

import javax.swing.JPanel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.entity.Comment;
import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptions;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.entity.Unit;
import edu.stthomas.gps.familyrecipesystem.service.FamilyServiceImpl;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

public class RecipePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RecipePanel(ClassPathXmlApplicationContext CTX, final MainWindow parent, Recipe recipe) {
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		int recipeFormatRow = 0;
		boolean canEdit = (AppSession.getInstance().getUser().getId() != recipe.getManagedBy().getId());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 344, 538);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.weightx = 1;
		scrollPane.setViewportView(panel);
		
		JTextPane recipeName = new JTextPane();
		JTextPane ingredientQuant;
		JComboBox<Unit> ingredientUnit;
		JTextPane ingredientName;
		JTextPane commentText;
		
		recipeName.setBackground(UIManager.getColor("InternalFrame.background"));
		recipeName.setText(recipe.getName());
		recipeName.setEditable(canEdit);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = 3;
		constraints.gridx = 0;
		constraints.gridy = recipeFormatRow;
		constraints.weighty = 0.05;
		panel.add(recipeName, constraints);
		recipeFormatRow++;
		
		List<IngredientOptions> ingredientOptions = recipe.getIngredientOptions();
		for(IngredientOptions ig: ingredientOptions) {
			
			ingredientQuant = new JTextPane();
			ingredientQuant.setText(ig.getQuantityFormatted());
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridwidth = 1;
			constraints.gridx = 0;
			constraints.gridy = recipeFormatRow;
			ingredientQuant.setEditable(canEdit);
			panel.add(ingredientQuant, constraints);
			
			ingredientUnit = new JComboBox<Unit>();
			for (Unit unit: Unit.values()) {
				ingredientUnit.addItem(unit);
			}
			ingredientUnit.setSelectedItem(ig.getUnit());
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridwidth = 1;
			constraints.gridx = 1;
			constraints.gridy = recipeFormatRow;
			ingredientUnit.setEditable(canEdit);
			panel.add(ingredientUnit, constraints);
			
			ingredientName = new JTextPane();
			ingredientName.setText(ig.getIngredient().getName());
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridwidth = 1;
			constraints.gridx = 2;
			constraints.gridy = recipeFormatRow;
			ingredientName.setEditable(canEdit);
			panel.add(ingredientName, constraints);
			
			recipeFormatRow++;
		}
		
		JTextPane recipeDescription = new JTextPane();
		recipeDescription.setText(recipe.getDescription());
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = 3;
		constraints.gridx = 0;
		constraints.gridy = recipeFormatRow;
		constraints.weighty = 1;
		panel.add(recipeDescription, constraints);
		recipeFormatRow++;
		
		List<Comment> commentList = recipe.getComments();
		for(Comment comment: commentList) {
			commentText = new JTextPane();
			commentText.setText(comment.getText());
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridwidth = 3;
			constraints.gridx = 0;
			constraints.gridy = recipeFormatRow;
			constraints.weighty = 0.05;
			panel.add(commentText, constraints);
			
			recipeFormatRow++;
		}

	}
}
