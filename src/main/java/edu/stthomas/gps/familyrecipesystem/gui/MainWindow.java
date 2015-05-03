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

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JTextField textCreateUsername;
	private JPasswordField pwCreatePassword;
	private JPasswordField pwCreateConfirmPassword;
	private JTextField textField_1;
	private JTextField textCreateFirstName;
	private JTextField textCreateLastName;
	private final ClassPathXmlApplicationContext CTX = new ClassPathXmlApplicationContext("beans.xml");

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
		//frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new LoginPanel(CTX);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPaneRecipe = new JScrollPane();
		layeredPane.setLayer(scrollPaneRecipe, 0);
		scrollPaneRecipe.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRecipe.setBounds(0, 0, 360, 554);
		layeredPane.add(scrollPaneRecipe);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(245, 222, 179));
		layeredPane.setLayer(panelSearch, 1);
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
		
		textCreateUsername = new JTextField();
		textCreateUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textCreateUsername.setColumns(10);
		textCreateUsername.setBounds(40, 173, 280, 28);
		panelCreate.add(textCreateUsername);
		
		pwCreatePassword = new JPasswordField();
		pwCreatePassword.setHorizontalAlignment(SwingConstants.LEFT);
		pwCreatePassword.setBounds(40, 347, 280, 28);
		panelCreate.add(pwCreatePassword);
		
		JTextPane txtpnFirstName = new JTextPane();
		txtpnFirstName.setText("Username:");
		txtpnFirstName.setFocusTraversalKeysEnabled(false);
		txtpnFirstName.setEditable(false);
		txtpnFirstName.setBackground(new Color(245, 222, 179));
		txtpnFirstName.setBounds(40, 155, 84, 16);
		panelCreate.add(txtpnFirstName);
		
		JTextPane txtpnCreatePassword = new JTextPane();
		txtpnCreatePassword.setText("Password:");
		txtpnCreatePassword.setFocusTraversalKeysEnabled(false);
		txtpnCreatePassword.setEditable(false);
		txtpnCreatePassword.setBackground(new Color(245, 222, 179));
		txtpnCreatePassword.setBounds(40, 329, 66, 16);
		panelCreate.add(txtpnCreatePassword);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Create user
				 * If input is valid, add the user to the database and log in
				 * If input is invalid, set the text of txtpnCreateErrorMessage
				 * to explain why the user is invalid
				 */
			}
		});
		btnCreate.setBounds(40, 489, 280, 39);
		panelCreate.add(btnCreate);
		
		JTextPane txtpnCreateErrorMessage = new JTextPane();
		txtpnCreateErrorMessage.setVisible(false);
		txtpnCreateErrorMessage.setText("Error Message");
		txtpnCreateErrorMessage.setForeground(Color.RED);
		txtpnCreateErrorMessage.setEditable(false);
		txtpnCreateErrorMessage.setBackground(new Color(245, 222, 179));
		txtpnCreateErrorMessage.setBounds(40, 449, 280, 28);
		panelCreate.add(txtpnCreateErrorMessage);
		
		pwCreateConfirmPassword = new JPasswordField();
		pwCreateConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		pwCreateConfirmPassword.setBounds(40, 405, 280, 28);
		panelCreate.add(pwCreateConfirmPassword);
		
		JTextPane txtpnCreateConfirmPassword = new JTextPane();
		txtpnCreateConfirmPassword.setText("Confirm Password:");
		txtpnCreateConfirmPassword.setFocusTraversalKeysEnabled(false);
		txtpnCreateConfirmPassword.setEditable(false);
		txtpnCreateConfirmPassword.setBackground(new Color(245, 222, 179));
		txtpnCreateConfirmPassword.setBounds(40, 387, 131, 16);
		panelCreate.add(txtpnCreateConfirmPassword);
		
		JTextPane txtpnCreateAccount = new JTextPane();
		txtpnCreateAccount.setFont(new Font("Cronos Pro", Font.PLAIN, 20));
		txtpnCreateAccount.setBackground(new Color(245, 222, 179));
		txtpnCreateAccount.setEditable(false);
		txtpnCreateAccount.setText("Create Account");
		txtpnCreateAccount.setBounds(114, 102, 123, 28);
		panelCreate.add(txtpnCreateAccount);
		
		textCreateFirstName = new JTextField();
		textCreateFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		textCreateFirstName.setColumns(10);
		textCreateFirstName.setBounds(40, 231, 280, 28);
		panelCreate.add(textCreateFirstName);
		
		JTextPane txtpnLastName = new JTextPane();
		txtpnLastName.setText("First Name:");
		txtpnLastName.setFocusTraversalKeysEnabled(false);
		txtpnLastName.setEditable(false);
		txtpnLastName.setBackground(new Color(245, 222, 179));
		txtpnLastName.setBounds(40, 213, 84, 16);
		panelCreate.add(txtpnLastName);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Last Name:");
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(245, 222, 179));
		textPane_1.setBounds(40, 271, 84, 16);
		panelCreate.add(textPane_1);
		
		textCreateLastName = new JTextField();
		textCreateLastName.setHorizontalAlignment(SwingConstants.LEFT);
		textCreateLastName.setColumns(10);
		textCreateLastName.setBounds(40, 289, 280, 28);
		panelCreate.add(textCreateLastName);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setFocusTraversalPolicyProvider(true);
		panelLogin.setBackground(new Color(245, 222, 179));
		layeredPane.setLayer(panelLogin, 4);
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
