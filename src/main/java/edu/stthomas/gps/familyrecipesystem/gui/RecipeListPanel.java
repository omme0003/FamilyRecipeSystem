package edu.stthomas.gps.familyrecipesystem.gui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.entity.RecipeImpl;
import edu.stthomas.gps.familyrecipesystem.service.FamilyService;
import edu.stthomas.gps.familyrecipesystem.service.FamilyServiceImpl;
import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;
import edu.stthomas.gps.familyrecipesystem.service.RecipeService;
import edu.stthomas.gps.familyrecipesystem.service.RecipeServiceImpl;

import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class RecipeListPanel extends JPanel {

	private DefaultListModel<Recipe> listModel;
	private JList<Recipe> listResults;
	
	/**
	 * Create the panel.
	 */
	public RecipeListPanel(ClassPathXmlApplicationContext CTX, final MainWindow parent, final Member member) {
		
		setBackground(Color.WHITE);
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		RecipeService recipeService = CTX.getBean("recipeService", RecipeServiceImpl.class);
		
		listModel = new DefaultListModel<Recipe>();
		listResults = new JList<Recipe>(listModel);
		listResults.setBackground(new Color(245, 245, 245));
		listResults.setBounds(5, 5, 350, 544);
		add(listResults);
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		recipes = recipeService.getByMember(member);
		
		for(Recipe recipe: recipes) {
			listModel.addElement(recipe);
		}
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent event) {
		        if (event.getClickCount() == 2) {
		        	Recipe recipe = listResults.getSelectedValue();
		        	JPanel panel = new RecipePanel(CTX, parent, recipe);
					parent.setPanel(panel);
		        }
		    }
		};
		listResults.addMouseListener(mouseListener);
		
		if (member.getId() == AppSession.getInstance().getUser().getId()) {
			listResults.setBounds(5, 5, 350, 514);
			JButton addNewRecipeButton = new JButton("Add New Recipe");
			addNewRecipeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Recipe recipe = new RecipeImpl();
					recipe.setName("New Recipe");
					recipe.setDescription("How do you make this?");
					recipe.setId(0);
					JPanel panel = new RecipePanel(CTX, parent, recipe);
					parent.setPanel(panel);
				}
			});
			addNewRecipeButton.setBounds(30, 524, 300, 25);
			add(addNewRecipeButton);
		}
	}
}
