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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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

		final JLayeredPane layeredPane = new JLayeredPane();
		// frame.getContentPane().add(layeredPane, BorderLayout.CENTER);

		final JPanel panel = new LoginPanel(this.CTX, this.frame);
		this.frame.getContentPane().add(panel, BorderLayout.CENTER);

		final JScrollPane scrollPaneRecipe = new JScrollPane();
		layeredPane.setLayer(scrollPaneRecipe, 0);
		scrollPaneRecipe.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRecipe.setBounds(0, 0, 360, 554);
		layeredPane.add(scrollPaneRecipe);

		final JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(245, 222, 179));
		layeredPane.setLayer(panelSearch, 1);
		panelSearch.setBounds(0, 0, 360, 554);
		layeredPane.add(panelSearch);
		panelSearch.setLayout(null);

		final JTextPane txtpnSearchRecipesAnd = new JTextPane();
		txtpnSearchRecipesAnd.setBackground(new Color(245, 222, 179));
		txtpnSearchRecipesAnd.setText("Search Recipes and People:");
		txtpnSearchRecipesAnd.setBounds(18, 19, 179, 22);
		panelSearch.add(txtpnSearchRecipesAnd);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(18, 43, 314, 28);
		panelSearch.add(this.textField_1);
		this.textField_1.setColumns(10);

		final JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBounds(18, 83, 314, 43);
		panelSearch.add(btnSearch_1);
	}

	public void setVisible(final boolean visible) {
		this.frame.setVisible(visible);
	}
}
