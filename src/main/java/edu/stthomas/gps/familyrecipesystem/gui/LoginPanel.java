package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;

public class LoginPanel extends JPanel {
	private final JTextField textFieldUsername;
	private final JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel(final ClassPathXmlApplicationContext CTX) {
		this.setBackground(new Color(255, 255, 255));
		this.setSize(new Dimension(360, 554));
		this.setLayout(null);

		final JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setText("My Family Recipes");
		txtpnTitle.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		txtpnTitle.setFocusTraversalKeysEnabled(false);
		txtpnTitle.setEditable(false);
		txtpnTitle.setBackground(new Color(255, 255, 255));
		txtpnTitle.setBounds(64, 59, 229, 39);
		this.add(txtpnTitle);

		final JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setText("Username:");
		txtpnUsername.setFocusTraversalKeysEnabled(false);
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(new Color(255, 255, 255));
		txtpnUsername.setBounds(36, 180, 66, 16);
		this.add(txtpnUsername);

		this.textFieldUsername = new JTextField();
		this.textFieldUsername.setSize(new Dimension(280, 21));
		this.textFieldUsername.setBounds(35, 198, 288, 28);
		this.add(this.textFieldUsername);
		this.textFieldUsername.setColumns(10);

		final JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password:");
		txtpnPassword.setFocusTraversalKeysEnabled(false);
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(new Color(255, 255, 255));
		txtpnPassword.setBounds(36, 238, 66, 16);
		this.add(txtpnPassword);

		this.passwordField = new JPasswordField();
		this.passwordField.setSize(new Dimension(280, 21));
		this.passwordField.setBounds(34, 260, 288, 21);
		this.add(this.passwordField);

		final JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(e -> {
			// Go to create account screen
		});
		btnCreateAccount.setBounds(179, 349, 133, 45);
		this.add(btnCreateAccount);

		final JTextPane txtpnErrorMessage = new JTextPane();
		txtpnErrorMessage.setEditable(false);
		txtpnErrorMessage.setForeground(new Color(255, 0, 0));
		txtpnErrorMessage.setBackground(new Color(255, 255, 255));
		txtpnErrorMessage.setText("Error Message");
		txtpnErrorMessage.setBounds(36, 293, 282, 39);
		this.add(txtpnErrorMessage);

		final JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(e -> {
			boolean status = false;
			final String username = LoginPanel.this.textFieldUsername.getText();
			final String password = String.valueOf(LoginPanel.this.passwordField.getPassword());
			final MemberService memberService = CTX.getBean("memberService", MemberServiceImpl.class);
			status = memberService.login(username, password);
			if (status) {
				txtpnErrorMessage.setText("Login successful");
			} else {
				txtpnErrorMessage.setText("Invalid credentials");
			}
		});
		btnLogIn.setBounds(34, 349, 133, 45);
		this.add(btnLogIn);

	}
}
