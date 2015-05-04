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
import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class RecipePanel extends JPanel {
	
	private JPanel panel;
	private JTextPane recipeName;
	private JTable ingredientsTable;
	private JButton newIngredientButton;
	private JTextPane instructionsHeader;
	private JTextPane recipeDescription;
	private JTextPane commentsHeader;
	private JPanel commentsPanel;

	/**
	 * Create the panel.
	 */
	public RecipePanel(ClassPathXmlApplicationContext CTX, final MainWindow parent, Recipe recipe) {
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		boolean canEdit = (AppSession.getInstance().getUser().getId() == recipe.getManagedBy().getId());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 344, 538);
		add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panel);
		
		recipeName = new JTextPane();
		recipeName.setMaximumSize(new Dimension(360, 60));
		recipeName.setBackground(UIManager.getColor("InternalFrame.background"));
		recipeName.setText(recipe.getName());
		recipeName.setEditable(canEdit);
		panel.add(recipeName);
		
		ingredientsTable = new JTable(new IngredientsTableModel(canEdit));
		IngredientsTableModel model = (IngredientsTableModel) ingredientsTable.getModel();
		panel.add(ingredientsTable.getTableHeader());
		panel.add(ingredientsTable);
		
		List<IngredientOptions> ingredientOptions = recipe.getIngredientOptions();
		
		for(IngredientOptions ig: ingredientOptions) {
			final Object[] data = new Object[3];
			data[0] = ig.getQuantityFormatted();
			data[1] = ig.getUnit();
			data[2] = ig.getIngredient().getName();
			model.addRow(data);
			
//			ingredientUnit = new JComboBox<Unit>();
//			for (Unit unit: Unit.values()) {
//				ingredientUnit.addItem(unit);
//			}
			
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
		instructionsHeader.setText("Instructions:");
		instructionsHeader.setEditable(false);
		panel.add(instructionsHeader);
		
		recipeDescription = new JTextPane();
		recipeDescription.setText(recipe.getDescription());
		recipeDescription.setEditable(canEdit);
		
		panel.add(Box.createVerticalGlue());
		
		commentsHeader = new JTextPane();
		commentsHeader.setText("Comments");
		commentsHeader.setEditable(false);
		panel.add(commentsHeader);
		
//		List<Comment> commentList = recipe.getComments();
//		for(Comment comment: commentList) {
//			commentText = new JTextPane();
//			commentText.setText(comment.getText());
//			panel.add(commentText, constraints);
//		}

	}
}
