package edu.stthomas.gps.familyrecipesystem.gui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;
import edu.stthomas.gps.familyrecipesystem.service.RecipeService;
import edu.stthomas.gps.familyrecipesystem.service.RecipeServiceImpl;

import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class SearchPanel extends JPanel {
	private JTextField textField;
	private JTextField txtSearchText;

	/**
	 * Create the panel.
	 */
	public SearchPanel(ClassPathXmlApplicationContext CTX, final MainWindow parent) {
		setBackground(Color.WHITE);
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		txtSearchText = new JTextField();
		txtSearchText.setText("Search text...");
		txtSearchText.setBounds(21, 28, 227, 28);
		add(txtSearchText);
		txtSearchText.setColumns(10);
		
		DefaultListModel listModel = new DefaultListModel();
		
		JList listResults = new JList(listModel);
		listResults.setBackground(new Color(245, 245, 245));
		listResults.setBounds(21, 72, 319, 454);
		add(listResults);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			String searchText = txtSearchText.getText();
			public void actionPerformed(ActionEvent e) {
				RecipeService recipeService = CTX.getBean("recipeService", RecipeServiceImpl.class);
				List<Recipe> recipes = recipeService.searchByKeyword(searchText);
				for(Recipe recipe: recipes) {
					listModel.addElement(recipe);
				}
			}
		});
		btnSearch.setBounds(249, 29, 91, 29);
		add(btnSearch);
	}
}
