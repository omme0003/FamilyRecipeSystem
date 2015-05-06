package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.entity.DuplicateUserException;
import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.MemberImpl;
import edu.stthomas.gps.familyrecipesystem.entity.RequiredAttributesEmptyException;
import edu.stthomas.gps.familyrecipesystem.service.FamilyServiceImpl;
import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;

public class CreateAccountPanel extends JPanel {
	private final JTextField textFieldFirstName;
	private final JPasswordField passwordFieldConfirm;
	private final JPasswordField passwordField;
	private final JTextField textFieldLastName;
	private final JTextField textFieldUsername;

	/**
	 * Create the panel.
	 */
	public CreateAccountPanel(final ClassPathXmlApplicationContext CTX, final MainWindow parent) {
		this.setBackground(new Color(255, 255, 255));
		this.setSize(new Dimension(360, 554));
		this.setLayout(null);

		final JTextPane txtpnTitle = new JTextPane();
		txtpnTitle.setText("My Family Recipes");
		txtpnTitle.setFont(new Font("Cronos Pro", Font.ITALIC, 32));
		txtpnTitle.setFocusTraversalKeysEnabled(false);
		txtpnTitle.setEditable(false);
		txtpnTitle.setBackground(Color.WHITE);
		txtpnTitle.setBounds(60, 60, 240, 40);
		this.add(txtpnTitle);

		final JLabel labelFirstName = new JLabel("First Name:");
		labelFirstName.setBounds(40, 140, 200, 16);
		this.add(labelFirstName);

		this.textFieldFirstName = new JTextField();
		this.textFieldFirstName.setSize(new Dimension(284, 21));
		this.textFieldFirstName.setBounds(38, 158, 284, 21);
		this.add(this.textFieldFirstName);
		this.textFieldFirstName.setColumns(10);

		final JLabel labelLastName = new JLabel("Last Name:");
		labelLastName.setBounds(40, 190, 200, 16);
		this.add(labelLastName);

		this.textFieldLastName = new JTextField();
		this.textFieldLastName.setSize(new Dimension(284, 21));
		this.textFieldLastName.setColumns(10);
		this.textFieldLastName.setBounds(40, 208, 284, 21);
		this.add(this.textFieldLastName);

		final JLabel labelFamilies = new JLabel("Family");
		labelFamilies.setBounds(40, 240, 200, 16);
		this.add(labelFamilies);

		final JComboBox<Family> comboBox = new JComboBox<Family>();
		comboBox.setBounds(38, 258, 284, 27);
		final List<Family> families = CTX.getBean("familyService", FamilyServiceImpl.class).getAllFamilies();
		for (final Family family : families) {
			comboBox.addItem(family);
		}
		this.add(comboBox);

		final JLabel labelUsername = new JLabel("Username:");
		labelUsername.setBounds(40, 290, 200, 16);
		this.add(labelUsername);

		this.textFieldUsername = new JTextField();
		this.textFieldUsername.setSize(new Dimension(280, 21));
		this.textFieldUsername.setColumns(10);
		this.textFieldUsername.setBounds(38, 308, 284, 21);
		this.add(this.textFieldUsername);

		final JLabel labelPassword = new JLabel("Password:");
		labelPassword.setBounds(40, 340, 200, 16);
		this.add(labelPassword);

		this.passwordField = new JPasswordField();
		this.passwordField.setSize(new Dimension(280, 21));
		this.passwordField.setBounds(38, 358, 284, 21);
		this.add(this.passwordField);

		final JLabel labelConfirmPassword = new JLabel("Confirm Password:");
		labelConfirmPassword.setBounds(40, 390, 200, 16);
		this.add(labelConfirmPassword);

		this.passwordFieldConfirm = new JPasswordField();
		this.passwordFieldConfirm.setSize(new Dimension(280, 21));
		this.passwordFieldConfirm.setBounds(38, 408, 284, 21);
		this.add(this.passwordFieldConfirm);

		final JTextPane txtpnErrorMessage = new JTextPane();
		txtpnErrorMessage.setVisible(false);
		txtpnErrorMessage.setEditable(false);
		txtpnErrorMessage.setForeground(Color.RED);
		txtpnErrorMessage.setBackground(Color.WHITE);
		txtpnErrorMessage.setText("Error Message");
		txtpnErrorMessage.setBounds(40, 438, 280, 30);
		this.add(txtpnErrorMessage);

		final JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(e -> {
			final String username = CreateAccountPanel.this.textFieldUsername.getText();
			final String password = String.valueOf(CreateAccountPanel.this.passwordField.getPassword());
			final String passwordCheck = String.valueOf(CreateAccountPanel.this.passwordFieldConfirm.getPassword());
			if (password.equals(passwordCheck)) {
				txtpnErrorMessage.setVisible(false);
				final Member member = new MemberImpl();
				member.setUserName(username);
				member.setFirstName(CreateAccountPanel.this.textFieldFirstName.getText());
				member.setLastName(CreateAccountPanel.this.textFieldLastName.getText());
				member.setPassword(String.valueOf(CreateAccountPanel.this.passwordField.getPassword()));
				member.addFamily((Family) comboBox.getSelectedItem());
				try {
					final MemberService memberService = CTX.getBean("memberService", MemberServiceImpl.class);
					memberService.create(member);
					memberService.login(username, password);
					final JPanel panel = new SearchPanel(CTX, parent);
					parent.setPanel(panel);
				} catch (final DuplicateUserException e1) {
					txtpnErrorMessage.setText("That username is already taken");
					txtpnErrorMessage.setVisible(true);
				} catch (final RequiredAttributesEmptyException e2) {
					txtpnErrorMessage.setText("One or more required values is missing");
					txtpnErrorMessage.setVisible(true);
				}
			} else {
				txtpnErrorMessage.setText("Passwords don't match");
				txtpnErrorMessage.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(36, 478, 276, 45);
		this.add(btnCreateAccount);

	}
}
