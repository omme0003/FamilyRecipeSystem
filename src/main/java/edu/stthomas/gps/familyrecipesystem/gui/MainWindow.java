package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textField_1;
	private final ClassPathXmlApplicationContext CTX;

	/**
	 * Create the application.
	 */
	public MainWindow(final ClassPathXmlApplicationContext ctx) {
		this.CTX = ctx;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setResizable(false);
		this.frame.setBounds(100, 100, 360, 640);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel panel = new LoginPanel(this.CTX, this);
		this.frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		addToolbar();

	}

	public void setVisible(final boolean visible) {
		this.frame.setVisible(visible);
	}

	public void setPanel(final JPanel oldPanel, final JPanel newPanel) {
		SwingUtilities.invokeLater(() -> {
			this.frame.remove(oldPanel);
			MainWindow.this.frame.getContentPane().add(newPanel, BorderLayout.CENTER);
			MainWindow.this.frame.revalidate();
			MainWindow.this.frame.repaint();
		});
	}
	
	public void setPanel(final JPanel newPanel) {
		SwingUtilities.invokeLater(() -> {
			BorderLayout layout = (BorderLayout) MainWindow.this.frame.getContentPane().getLayout();
			this.frame.remove(layout.getLayoutComponent(BorderLayout.CENTER));
			MainWindow.this.frame.getContentPane().add(newPanel, BorderLayout.CENTER);
			MainWindow.this.frame.revalidate();
			MainWindow.this.frame.repaint();
		});
	}
	
	private void addToolbar() {
		final JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.BLACK);
		toolBar.setFloatable(false);
		this.frame.getContentPane().add(toolBar, BorderLayout.SOUTH);

		final JButton btnSearch = new JButton("Search");
		btnSearch.setMargin(new Insets(0, 0, 0, 0));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBorderPainted(false);
		btnSearch.setMinimumSize(new Dimension(115, 60));
		btnSearch.setMaximumSize(new Dimension(115, 60));
		btnSearch.setPreferredSize(new Dimension(120, 60));
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSearch.setIcon(new ImageIcon(MainWindow.class.getResource("/edu/stthomas/gps/familyrecipesystem/gui/resources/UIBarButtonSearch_2x.png")));
		toolBar.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AppSession.getInstance().getUser() != null) {
					JPanel panel = new SearchPanel(CTX, MainWindow.this);
					setPanel(panel);
				}
			}
		});

		final JButton btnUsers = new JButton("People");
		btnUsers.setIcon(new ImageIcon(MainWindow.class.getResource("/edu/stthomas/gps/familyrecipesystem/gui/resources/UITabBarContacts_2x.png")));
		btnUsers.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUsers.setPreferredSize(new Dimension(120, 60));
		btnUsers.setMinimumSize(new Dimension(115, 60));
		btnUsers.setMaximumSize(new Dimension(115, 60));
		btnUsers.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUsers.setForeground(Color.WHITE);
		btnUsers.setBorderPainted(false);
		toolBar.add(btnUsers);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AppSession.getInstance().getUser() != null) {
					JPanel panel = new PeoplePanel(CTX, MainWindow.this);
					setPanel(panel);
				}
			}
		});

		final JButton btnRecipes = new JButton("My Recipes");
		btnRecipes.setIcon(new ImageIcon(MainWindow.class.getResource("/edu/stthomas/gps/familyrecipesystem/gui/resources/UIBarButtonBookmarks_2x.png")));
		btnRecipes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRecipes.setPreferredSize(new Dimension(120, 60));
		btnRecipes.setMinimumSize(new Dimension(115, 60));
		btnRecipes.setMaximumSize(new Dimension(115, 60));
		btnRecipes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRecipes.setForeground(Color.WHITE);
		btnRecipes.setBorderPainted(false);
		toolBar.add(btnRecipes);
		btnRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AppSession.getInstance().getUser() != null) {
					JPanel panel = new RecipeListPanel(CTX, MainWindow.this, AppSession.getInstance().getUser());
					setPanel(panel);
				}
			}
		});
	}
}
