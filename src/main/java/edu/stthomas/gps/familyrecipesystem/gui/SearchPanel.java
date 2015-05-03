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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class SearchPanel extends JPanel {
	private JTextField txtSearchText;

	/**
	 * Create the panel.
	 */
	public SearchPanel(ClassPathXmlApplicationContext CTX, final MainWindow parent) {
		setBackground(Color.WHITE);
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		txtSearchText = new JTextField();
		txtSearchText.setBounds(21, 28, 227, 28);
		add(txtSearchText);
		txtSearchText.setColumns(10);
		
		DefaultListModel<Recipe> listModel = new DefaultListModel<Recipe>();
		
		JList<Recipe> listResults = new JList<Recipe>(listModel);
		listResults.setBackground(new Color(245, 245, 245));
		listResults.setBounds(21, 72, 319, 454);
		add(listResults);
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent event) {
		        if (event.getClickCount() == 2) {
		        	Recipe recipe = listResults.getSelectedValue();
		        	JPanel panel = new RecipePanel(CTX, parent, recipe);
					parent.setPanel(SearchPanel.this, panel);
		        }
		    }
		};
		listResults.addMouseListener(mouseListener);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeAllElements();
				String searchText = txtSearchText.getText();
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
