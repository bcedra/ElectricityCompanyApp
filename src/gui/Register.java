package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.AccountBLL;
import businessLogicLayer.StaffBLL;
import ps1.Account;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 235, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(46, 39, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 83, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(46, 130, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(46, 177, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(46, 225, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Client Number");
		lblNewLabel.setBounds(46, 24, 81, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(46, 66, 81, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(46, 116, 81, 16);
		contentPane.add(lblAddress);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(46, 161, 81, 16);
		contentPane.add(lblCnp);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(46, 210, 81, 16);
		contentPane.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(46, 272, 116, 22);
		contentPane.add(passwordField);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(46, 255, 81, 16);
		contentPane.add(lblPassword);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBounds(56, 305, 97, 25);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int error=0;
				try {
					int clientNumber = Integer.parseInt(textField.getText());
					String name = textField_1.getText();
					String address = textField_2.getText();
					String cnp = textField_3.getText();
					String username = textField_4.getText();
					String password = passwordField.getText();
					
					Account account = new Account(clientNumber,name,address,cnp,username,password);
					AccountBLL.insertClient(account);
				} catch (Exception exception){
					JOptionPane.showMessageDialog(new JFrame(), "Invalid");
					error=1;
				}
				if (error==0)
					JOptionPane.showMessageDialog(new JFrame(), "Request Sent");
			}
		});
		contentPane.add(btnSignUp);
	}
}
