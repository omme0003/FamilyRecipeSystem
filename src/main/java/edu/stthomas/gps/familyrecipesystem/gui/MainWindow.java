package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;

public class MainWindow {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 360, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.BLACK);
		toolBar.setFloatable(false);
		frame.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		JButton btnSearch = new JButton("Search");
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
		
		JButton btnUsers = new JButton("People");
		btnUsers.setIcon(new ImageIcon(MainWindow.class.getResource("/edu/stthomas/gps/familyrecipesystem/gui/resources/UITabBarContacts_2x.png")));
		btnUsers.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUsers.setPreferredSize(new Dimension(120, 60));
		btnUsers.setMinimumSize(new Dimension(115, 60));
		btnUsers.setMaximumSize(new Dimension(115, 60));
		btnUsers.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUsers.setForeground(Color.WHITE);
		btnUsers.setBorderPainted(false);
		toolBar.add(btnUsers);
		
		JButton btnRecipes = new JButton("My Recipes");
		btnRecipes.setIcon(new ImageIcon(MainWindow.class.getResource("/edu/stthomas/gps/familyrecipesystem/gui/resources/UIBarButtonBookmarks_2x.png")));
		btnRecipes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRecipes.setPreferredSize(new Dimension(120, 60));
		btnRecipes.setMinimumSize(new Dimension(115, 60));
		btnRecipes.setMaximumSize(new Dimension(115, 60));
		btnRecipes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRecipes.setForeground(Color.WHITE);
		btnRecipes.setBorderPainted(false);
		toolBar.add(btnRecipes);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JScrollPane scrollPaneRecipe = new JScrollPane();
		layeredPane.setLayer(scrollPaneRecipe, 3);
		scrollPaneRecipe.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRecipe.setBounds(0, 0, 360, 554);
		layeredPane.add(scrollPaneRecipe);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(245, 222, 179));
		layeredPane.setLayer(panelSearch, 4);
		panelSearch.setBounds(0, 0, 360, 554);
		layeredPane.add(panelSearch);
		panelSearch.setLayout(null);
		
		JTextPane txtpnSearchRecipesAnd = new JTextPane();
		txtpnSearchRecipesAnd.setBackground(new Color(245, 222, 179));
		txtpnSearchRecipesAnd.setText("Search Recipes and People:");
		txtpnSearchRecipesAnd.setBounds(18, 19, 179, 22);
		panelSearch.add(txtpnSearchRecipesAnd);
		
		textField_1 = new JTextField();
		textField_1.setBounds(18, 43, 314, 28);
		panelSearch.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBounds(18, 83, 314, 43);
		panelSearch.add(btnSearch_1);
		
		JList listRecipeResults = new JList();
		listRecipeResults.setBounds(21, 138, 311, 398);
		panelSearch.add(listRecipeResults);
		
		JPanel panelCreate = new JPanel();
		layeredPane.setLayer(panelCreate, 2);
		panelCreate.setBounds(0, 0, 360, 554);
		layeredPane.add(panelCreate);
		panelCreate.setLayout(null);
		panelCreate.setFocusTraversalPolicyProvider(true);
		panelCreate.setBackground(new Color(245, 222, 179));
		
		JTextPane textPane = new JTextPane();
		textPane.setText("My Family Recipes");
		textPane.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setEditable(false);
		textPane.setBackground(new Color(245, 222, 179));
		textPane.setBounds(65, 50, 229, 39);
		panelCreate.add(textPane);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(40, 223, 280, 28);
		panelCreate.add(textField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField_1.setBounds(40, 281, 280, 28);
		panelCreate.add(passwordField_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Username:");
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(245, 222, 179));
		textPane_1.setBounds(40, 205, 66, 16);
		panelCreate.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Password:");
		textPane_2.setFocusTraversalKeysEnabled(false);
		textPane_2.setEditable(false);
		textPane_2.setBackground(new Color(245, 222, 179));
		textPane_2.setBounds(40, 263, 66, 16);
		panelCreate.add(textPane_2);
		
		JButton button_1 = new JButton("Create Account");
		button_1.setBounds(40, 423, 280, 39);
		panelCreate.add(button_1);
		
		JTextPane txtpnErrorMessage = new JTextPane();
		txtpnErrorMessage.setVisible(false);
		txtpnErrorMessage.setText("Error Message");
		txtpnErrorMessage.setForeground(Color.RED);
		txtpnErrorMessage.setEditable(false);
		txtpnErrorMessage.setBackground(new Color(245, 222, 179));
		txtpnErrorMessage.setBounds(40, 383, 280, 28);
		panelCreate.add(txtpnErrorMessage);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField_2.setBounds(40, 339, 280, 28);
		panelCreate.add(passwordField_2);
		
		JTextPane txtpnConfirmPassword = new JTextPane();
		txtpnConfirmPassword.setText("Confirm Password:");
		txtpnConfirmPassword.setFocusTraversalKeysEnabled(false);
		txtpnConfirmPassword.setEditable(false);
		txtpnConfirmPassword.setBackground(new Color(245, 222, 179));
		txtpnConfirmPassword.setBounds(40, 321, 131, 16);
		panelCreate.add(txtpnConfirmPassword);
		
		JTextPane txtpnCreateAccount = new JTextPane();
		txtpnCreateAccount.setFont(new Font("Cronos Pro", Font.PLAIN, 20));
		txtpnCreateAccount.setBackground(new Color(245, 222, 179));
		txtpnCreateAccount.setEditable(false);
		txtpnCreateAccount.setText("Create Account");
		txtpnCreateAccount.setBounds(114, 102, 123, 28);
		panelCreate.add(txtpnCreateAccount);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setFocusTraversalPolicyProvider(true);
		panelLogin.setBackground(new Color(245, 222, 179));
		layeredPane.setLayer(panelLogin, 1);
		panelLogin.setBounds(0, 0, 360, 554);
		layeredPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JTextPane txtpnMyFamilyRecipes = new JTextPane();
		txtpnMyFamilyRecipes.setFocusTraversalKeysEnabled(false);
		txtpnMyFamilyRecipes.setBounds(65, 50, 229, 39);
		txtpnMyFamilyRecipes.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		txtpnMyFamilyRecipes.setBackground(new Color(245, 222, 179));
		txtpnMyFamilyRecipes.setEditable(false);
		txtpnMyFamilyRecipes.setText("My Family Recipes");
		panelLogin.add(txtpnMyFamilyRecipes);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setBounds(40, 223, 280, 28);
		panelLogin.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(40, 281, 280, 28);
		panelLogin.add(passwordField);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setFocusTraversalKeysEnabled(false);
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(new Color(245, 222, 179));
		txtpnUsername.setText("Username:");
		txtpnUsername.setBounds(40, 205, 66, 16);
		panelLogin.add(txtpnUsername);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setFocusTraversalKeysEnabled(false);
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("Password:");
		txtpnPassword.setBackground(new Color(245, 222, 179));
		txtpnPassword.setBounds(40, 263, 66, 16);
		panelLogin.add(txtpnPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(40, 367, 122, 39);
		panelLogin.add(btnLogIn);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(198, 367, 122, 39);
		panelLogin.add(btnCreateAccount);
		
		JTextPane txtpnInvalidCredentialsPlease = new JTextPane();
		txtpnInvalidCredentialsPlease.setVisible(false);
		txtpnInvalidCredentialsPlease.setEditable(false);
		txtpnInvalidCredentialsPlease.setForeground(new Color(255, 0, 0));
		txtpnInvalidCredentialsPlease.setBackground(new Color(245, 222, 179));
		txtpnInvalidCredentialsPlease.setText("Invalid credentials. Please try again.");
		txtpnInvalidCredentialsPlease.setBounds(40, 313, 280, 42);
		panelLogin.add(txtpnInvalidCredentialsPlease);
	}
}
