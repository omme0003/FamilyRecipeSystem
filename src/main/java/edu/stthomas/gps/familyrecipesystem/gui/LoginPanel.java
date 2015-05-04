package edu.stthomas.gps.familyrecipesystem.gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel(ClassPathXmlApplicationContext CTX, final MainWindow parent) {
		setBackground(new Color(255, 255, 255));
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setText("My Family Recipes");
		txtpnTitle.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		txtpnTitle.setFocusTraversalKeysEnabled(false);
		txtpnTitle.setEditable(false);
		txtpnTitle.setBackground(new Color(255, 255, 255));
		txtpnTitle.setBounds(60, 60, 240, 40);
		add(txtpnTitle);
		
		JLabel labelUsername = new JLabel("Username:");
		labelUsername.setBounds(40, 180, 66, 16);
		add(labelUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setSize(new Dimension(280, 21));
		textFieldUsername.setBounds(38, 198, 284, 21);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setBounds(40, 240, 66, 16);
		add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setSize(new Dimension(280, 21));
		passwordField.setBounds(38, 258, 284, 21);
		add(passwordField);
		 
		JTextPane txtpnErrorMessage = new JTextPane();
		txtpnErrorMessage.setVisible(false);
		txtpnErrorMessage.setEditable(false);
		txtpnErrorMessage.setForeground(new Color(255, 0, 0));
		txtpnErrorMessage.setBackground(new Color(255, 255, 255));
		txtpnErrorMessage.setText("Error Message");
		txtpnErrorMessage.setBounds(40, 288, 284, 32);
		add(txtpnErrorMessage);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status = false;
				String username = textFieldUsername.getText();
				String password = String.valueOf(passwordField.getPassword());
				MemberService memberService = CTX.getBean("memberService", MemberServiceImpl.class);
				status = memberService.login(username, password);
				if (status) {
					JPanel panel = new SearchPanel(CTX, parent);
					parent.setPanel(LoginPanel.this, panel);
				} else {
					txtpnErrorMessage.setVisible(true);
					txtpnErrorMessage.setText("Invalid credentials");
				}
			}
		});
		btnLogIn.setBounds(40, 350, 130, 40);
		add(btnLogIn);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new CreateAccountPanel(CTX, parent);
				parent.setPanel(LoginPanel.this, panel);
			}
		});
		btnCreateAccount.setBounds(190, 350, 130, 40);
		add(btnCreateAccount);

	}
}
