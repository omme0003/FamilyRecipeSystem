package edu.stthomas.gps.familyrecipesystem.gui;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
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
import java.util.LinkedHashSet;
import java.util.List;

public class PeoplePanel extends JPanel {

	private DefaultListModel<Member> listModel;
	private JList<Member> listResults;
	
	/**
	 * Create the panel.
	 */
	public PeoplePanel(ClassPathXmlApplicationContext CTX, final MainWindow parent) {
		
		setBackground(Color.WHITE);
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		listModel = new DefaultListModel<Member>();
		listResults = new JList<Member>(listModel);
		listResults.setBackground(new Color(245, 245, 245));
		listResults.setBounds(5, 5, 350, 544);
		add(listResults);
		
		List<Family> families = new ArrayList<Family>();
		List<Member> members = new ArrayList<Member>();
		
		families = AppSession.getInstance().getUser().getFamilies();
		for(Family family: families) {
			members.addAll(family.getMembers());
		}
		
		members = new ArrayList<Member>(new LinkedHashSet<Member>(members));
		
		for(Member member: members) {
			listModel.addElement(member);
		}
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent event) {
		        if (event.getClickCount() == 2) {
		        	Member member = listResults.getSelectedValue();
		        	JPanel panel = new RecipeListPanel(CTX, parent, member);
					parent.setPanel(panel);
		        }
		    }
		};
		listResults.addMouseListener(mouseListener);
	}
}
