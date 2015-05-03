package edu.stthomas.gps.familyrecipesystem.gui;

import javax.swing.JPanel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
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
import java.util.List;

import javax.swing.UIManager;

public class RecipePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RecipePanel(ClassPathXmlApplicationContext CTX, final MainWindow parent, Recipe recipe) {
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		boolean canEdit = (AppSession.getInstance().getUser().getId() != recipe.getManagedBy().getId());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 344, 538);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JTextPane recipeName = new JTextPane();
		JTextPane ingredientQuant;
		JComboBox<Unit> ingredientUnit;
		JTextPane ingredientName;
		
		recipeName.setBackground(UIManager.getColor("InternalFrame.background"));
		recipeName.setText(recipe.getName());
		recipeName.setEditable(canEdit);
		panel.add(recipeName);
		
		JPanel ingredientPanel = new JPanel();
		ingredientPanel.setLayout(new GridBagLayout());
		panel.add(ingredientPanel);
		GridBagConstraints constraints;
		int ingredientRow = 0;
		
		for(IngredientOptions ig: recipe.getIngredientOptions()) {
			constraints = new GridBagConstraints();
			
			ingredientQuant = new JTextPane();
			ingredientQuant.setText(ig.getQuantityFormatted());
			constraints.gridx = 0;
			constraints.gridy = ingredientRow;
			ingredientQuant.setEditable(canEdit);
			ingredientPanel.add(ingredientQuant, constraints);
			
			ingredientUnit = new JComboBox<Unit>();
			for (Unit unit: Unit.values()) {
				ingredientUnit.addItem(unit);
			}
			ingredientUnit.setSelectedItem(ig.getUnit());
			constraints.gridx = 1;
			constraints.gridy = ingredientRow;
			ingredientUnit.setEditable(canEdit);
			ingredientPanel.add(ingredientUnit, constraints);
			
			ingredientName = new JTextPane();
			ingredientName.setText(ig.getIngredient().getName());
			constraints.gridx = 2;
			constraints.gridy = ingredientRow;
			ingredientName.setEditable(canEdit);
			ingredientPanel.add(ingredientName, constraints);
			
			ingredientRow++;
		}
		

	}
}
