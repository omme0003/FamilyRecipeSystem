package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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

		final JPanel panel = new LoginPanel(this.CTX);
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

		final JPanel panelCreate = new JPanel();
		layeredPane.setLayer(panelCreate, 2);
		panelCreate.setBounds(0, 0, 360, 554);
		layeredPane.add(panelCreate);
		panelCreate.setLayout(null);
		panelCreate.setFocusTraversalPolicyProvider(true);
		panelCreate.setBackground(new Color(245, 222, 179));

		final JTextPane textPane = new JTextPane();
		textPane.setText("My Family Recipes");
		textPane.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setEditable(false);
		textPane.setBackground(new Color(245, 222, 179));
		textPane.setBounds(65, 50, 229, 39);
		panelCreate.add(textPane);

		this.textCreateUsername = new JTextField();
		this.textCreateUsername.setHorizontalAlignment(SwingConstants.LEFT);
		this.textCreateUsername.setColumns(10);
		this.textCreateUsername.setBounds(40, 173, 280, 28);
		panelCreate.add(this.textCreateUsername);

		this.pwCreatePassword = new JPasswordField();
		this.pwCreatePassword.setHorizontalAlignment(SwingConstants.LEFT);
		this.pwCreatePassword.setBounds(40, 347, 280, 28);
		panelCreate.add(this.pwCreatePassword);

		final JTextPane txtpnFirstName = new JTextPane();
		txtpnFirstName.setText("Username:");
		txtpnFirstName.setFocusTraversalKeysEnabled(false);
		txtpnFirstName.setEditable(false);
		txtpnFirstName.setBackground(new Color(245, 222, 179));
		txtpnFirstName.setBounds(40, 155, 84, 16);
		panelCreate.add(txtpnFirstName);

		final JTextPane txtpnCreatePassword = new JTextPane();
		txtpnCreatePassword.setText("Password:");
		txtpnCreatePassword.setFocusTraversalKeysEnabled(false);
		txtpnCreatePassword.setEditable(false);
		txtpnCreatePassword.setBackground(new Color(245, 222, 179));
		txtpnCreatePassword.setBounds(40, 329, 66, 16);
		panelCreate.add(txtpnCreatePassword);

		final JButton btnCreate = new JButton("Create Account");
		btnCreate.addActionListener(e -> {
			/*
			 * Create user If input is valid, add the user to the database and
			 * log in If input is invalid, set the text of
			 * txtpnCreateErrorMessage to explain why the user is invalid
			 */
		});
		btnCreate.setBounds(40, 489, 280, 39);
		panelCreate.add(btnCreate);

		final JTextPane txtpnCreateErrorMessage = new JTextPane();
		txtpnCreateErrorMessage.setVisible(false);
		txtpnCreateErrorMessage.setText("Error Message");
		txtpnCreateErrorMessage.setForeground(Color.RED);
		txtpnCreateErrorMessage.setEditable(false);
		txtpnCreateErrorMessage.setBackground(new Color(245, 222, 179));
		txtpnCreateErrorMessage.setBounds(40, 449, 280, 28);
		panelCreate.add(txtpnCreateErrorMessage);

		this.pwCreateConfirmPassword = new JPasswordField();
		this.pwCreateConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		this.pwCreateConfirmPassword.setBounds(40, 405, 280, 28);
		panelCreate.add(this.pwCreateConfirmPassword);

		final JTextPane txtpnCreateConfirmPassword = new JTextPane();
		txtpnCreateConfirmPassword.setText("Confirm Password:");
		txtpnCreateConfirmPassword.setFocusTraversalKeysEnabled(false);
		txtpnCreateConfirmPassword.setEditable(false);
		txtpnCreateConfirmPassword.setBackground(new Color(245, 222, 179));
		txtpnCreateConfirmPassword.setBounds(40, 387, 131, 16);
		panelCreate.add(txtpnCreateConfirmPassword);

		final JTextPane txtpnCreateAccount = new JTextPane();
		txtpnCreateAccount.setFont(new Font("Cronos Pro", Font.PLAIN, 20));
		txtpnCreateAccount.setBackground(new Color(245, 222, 179));
		txtpnCreateAccount.setEditable(false);
		txtpnCreateAccount.setText("Create Account");
		txtpnCreateAccount.setBounds(114, 102, 123, 28);
		panelCreate.add(txtpnCreateAccount);

		this.textCreateFirstName = new JTextField();
		this.textCreateFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		this.textCreateFirstName.setColumns(10);
		this.textCreateFirstName.setBounds(40, 231, 280, 28);
		panelCreate.add(this.textCreateFirstName);

		final JTextPane txtpnLastName = new JTextPane();
		txtpnLastName.setText("First Name:");
		txtpnLastName.setFocusTraversalKeysEnabled(false);
		txtpnLastName.setEditable(false);
		txtpnLastName.setBackground(new Color(245, 222, 179));
		txtpnLastName.setBounds(40, 213, 84, 16);
		panelCreate.add(txtpnLastName);

		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Last Name:");
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(245, 222, 179));
		textPane_1.setBounds(40, 271, 84, 16);
		panelCreate.add(textPane_1);

		this.textCreateLastName = new JTextField();
		this.textCreateLastName.setHorizontalAlignment(SwingConstants.LEFT);
		this.textCreateLastName.setColumns(10);
		this.textCreateLastName.setBounds(40, 289, 280, 28);
		panelCreate.add(this.textCreateLastName);

		final JPanel panelLogin = new JPanel();
		panelLogin.setFocusTraversalPolicyProvider(true);
		panelLogin.setBackground(new Color(245, 222, 179));
		layeredPane.setLayer(panelLogin, 4);
		panelLogin.setBounds(0, 0, 360, 554);
		layeredPane.add(panelLogin);
		panelLogin.setLayout(null);

		final JTextPane txtpnMyFamilyRecipes = new JTextPane();
		txtpnMyFamilyRecipes.setFocusTraversalKeysEnabled(false);
		txtpnMyFamilyRecipes.setBounds(65, 50, 229, 39);
		txtpnMyFamilyRecipes.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		txtpnMyFamilyRecipes.setBackground(new Color(245, 222, 179));
		txtpnMyFamilyRecipes.setEditable(false);
		txtpnMyFamilyRecipes.setText("My Family Recipes");
		panelLogin.add(txtpnMyFamilyRecipes);

		this.txtUsername = new JTextField();
		this.txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		this.txtUsername.setBounds(40, 223, 280, 28);
		panelLogin.add(this.txtUsername);
		this.txtUsername.setColumns(10);

		this.passwordField = new JPasswordField();
		this.passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		this.passwordField.setBounds(40, 281, 280, 28);
		panelLogin.add(this.passwordField);

		final JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setFocusTraversalKeysEnabled(false);
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(new Color(245, 222, 179));
		txtpnUsername.setText("Username:");
		txtpnUsername.setBounds(40, 205, 66, 16);
		panelLogin.add(txtpnUsername);

		final JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setFocusTraversalKeysEnabled(false);
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("Password:");
		txtpnPassword.setBackground(new Color(245, 222, 179));
		txtpnPassword.setBounds(40, 263, 66, 16);
		panelLogin.add(txtpnPassword);

		final JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(40, 367, 122, 39);
		panelLogin.add(btnLogIn);

		final JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(198, 367, 122, 39);
		panelLogin.add(btnCreateAccount);

		final JTextPane txtpnInvalidCredentialsPlease = new JTextPane();
		txtpnInvalidCredentialsPlease.setVisible(false);
		txtpnInvalidCredentialsPlease.setEditable(false);
		txtpnInvalidCredentialsPlease.setForeground(new Color(255, 0, 0));
		txtpnInvalidCredentialsPlease.setBackground(new Color(245, 222, 179));
		txtpnInvalidCredentialsPlease.setText("Invalid credentials. Please try again.");
		txtpnInvalidCredentialsPlease.setBounds(40, 313, 280, 42);
		panelLogin.add(txtpnInvalidCredentialsPlease);
	}

	public void setVisible(final boolean visible) {
		this.frame.setVisible(visible);
	}
}
