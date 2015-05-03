package edu.stthomas.gps.familyrecipesystem.gui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CreateAccountPanel extends JPanel {
	private JTextField textFieldFirstName;
	private JPasswordField passwordFieldConfirm;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public CreateAccountPanel(ClassPathXmlApplicationContext CTX, final MainWindow parent) {
		setBackground(new Color(255, 255, 255));
		setSize(new Dimension(360, 554));
		setLayout(null);
		
		JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setText("My Family Recipes");
		txtpnTitle.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		txtpnTitle.setFocusTraversalKeysEnabled(false);
		txtpnTitle.setEditable(false);
		txtpnTitle.setBackground(new Color(255, 255, 255));
		txtpnTitle.setBounds(64, 59, 229, 39);
		add(txtpnTitle);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setText("First Name:");
		txtpnUsername.setFocusTraversalKeysEnabled(false);
		txtpnUsername.setEditable(false);
		txtpnUsername.setBackground(new Color(255, 255, 255));
		txtpnUsername.setBounds(42, 139, 83, 16);
		add(txtpnUsername);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setSize(new Dimension(280, 21));
		textFieldFirstName.setBounds(40, 160, 288, 21);
		add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JTextPane txtpnConfirmPassword = new JTextPane();
		txtpnConfirmPassword.setText("Confirm Password:");
		txtpnConfirmPassword.setFocusTraversalKeysEnabled(false);
		txtpnConfirmPassword.setEditable(false);
		txtpnConfirmPassword.setBackground(new Color(255, 255, 255));
		txtpnConfirmPassword.setBounds(40, 389, 170, 16);
		add(txtpnConfirmPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setSize(new Dimension(280, 21));
		passwordFieldConfirm.setBounds(40, 410, 288, 21);
		add(passwordFieldConfirm);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Go to create account screen
			}
		});
		btnCreateAccount.setBounds(36, 478, 276, 45);
		add(btnCreateAccount);
		
		JTextPane txtpnErrorMessage = new JTextPane();
		txtpnErrorMessage.setVisible(false);
		txtpnErrorMessage.setEditable(false);
		txtpnErrorMessage.setForeground(new Color(255, 0, 0));
		txtpnErrorMessage.setBackground(new Color(255, 255, 255));
		txtpnErrorMessage.setText("Error Message");
		txtpnErrorMessage.setBounds(38, 438, 282, 28);
		add(txtpnErrorMessage);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password:");
		txtpnPassword.setFocusTraversalKeysEnabled(false);
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(Color.WHITE);
		txtpnPassword.setBounds(40, 339, 170, 16);
		add(txtpnPassword);
		
		passwordField = new JPasswordField();
		passwordField.setSize(new Dimension(280, 21));
		passwordField.setBounds(40, 360, 288, 21);
		add(passwordField);
		
		JTextPane txtpnLastName = new JTextPane();
		txtpnLastName.setText("Last Name:");
		txtpnLastName.setFocusTraversalKeysEnabled(false);
		txtpnLastName.setEditable(false);
		txtpnLastName.setBackground(Color.WHITE);
		txtpnLastName.setBounds(42, 189, 83, 16);
		add(txtpnLastName);
		
		textField = new JTextField();
		textField.setSize(new Dimension(280, 21));
		textField.setColumns(10);
		textField.setBounds(40, 210, 288, 21);
		add(textField);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Username:");
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.WHITE);
		textPane_1.setBounds(42, 289, 66, 16);
		add(textPane_1);
		
		textField_1 = new JTextField();
		textField_1.setSize(new Dimension(280, 21));
		textField_1.setColumns(10);
		textField_1.setBounds(40, 310, 288, 21);
		add(textField_1);
		
		JTextPane txtpnFamilies = new JTextPane();
		txtpnFamilies.setText("Families:");
		txtpnFamilies.setFocusTraversalKeysEnabled(false);
		txtpnFamilies.setEditable(false);
		txtpnFamilies.setBackground(Color.WHITE);
		txtpnFamilies.setBounds(42, 239, 83, 16);
		add(txtpnFamilies);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(40, 260, 284, 27);
		add(comboBox);

	}
}
