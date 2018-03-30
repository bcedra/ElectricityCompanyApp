package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.AccountBLL;
import businessLogicLayer.StaffBLL;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField usernameClients;
	private JTextField usernameA;
	private JLabel lblCacat;
	private JLabel lblPassword;
	private JLabel lblPsername;
	private JLabel lblPassword_1;
	private JLabel lblClients;
	private JLabel lblAdministration;
	private JButton btnRegister;
	private JLabel lblNewLabel;
	private JPasswordField passwordA;
	private JPasswordField passwordClients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 private JTable table;
	
	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameClients = new JTextField();
		usernameClients.setBounds(120, 156, 116, 22);
		contentPane.add(usernameClients);
		usernameClients.setColumns(10);
		
		
		usernameA = new JTextField();
		usernameA.setBounds(390, 153, 116, 22);
		contentPane.add(usernameA);
		usernameA.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usernameClient = usernameClients.getText();
				String passwordClient = passwordClients.getText();
				AccountBLL accountBLL= new AccountBLL();
				
				if (accountBLL.logInClient(usernameClient, passwordClient)==1){
					Client client = new Client(usernameClient);
					client.setVisible(true);
					dispose();
				}
				else{
					if (accountBLL.logInClient(usernameClient, passwordClient)==2){
						JOptionPane.showMessageDialog(new JFrame(), "Invalid username");
					}
					if (accountBLL.logInClient(usernameClient, passwordClient)==3){
						JOptionPane.showMessageDialog(new JFrame(), "Invalid password");
					}
					if (accountBLL.logInClient(usernameClient, passwordClient)==4){
						JOptionPane.showMessageDialog(new JFrame(), "Connection Error");
					}
				}
			}
		});
		btnNewButton.setBounds(120, 251, 116, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usernameManager = usernameA.getText();
				String passwordManger = passwordA.getText();
				StaffBLL staffBLL = new StaffBLL();
				
				if (staffBLL.isManager(usernameManager, passwordManger)==1){
					Manager manager = new Manager();
					manager.setVisible(true);
					dispose();
				}
				
				if (staffBLL.isManager(usernameManager, passwordManger)==0){
					Employee employee = new Employee();
					employee.setVisible(true);
					dispose();
				}
				
				if (staffBLL.isManager(usernameManager, passwordManger)==3){
					JOptionPane.showMessageDialog(new JFrame(), "Invalid username");
				}
				
				if (staffBLL.isManager(usernameManager, passwordManger)==4){
					JOptionPane.showMessageDialog(new JFrame(), "Invalid password");
				}
			}
		});
		btnNewButton_1.setBounds(390, 251, 116, 25);
		contentPane.add(btnNewButton_1);
		
		lblCacat = new JLabel("Username");
		lblCacat.setBounds(47, 159, 65, 16);
		contentPane.add(lblCacat);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(47, 205, 81, 16);
		contentPane.add(lblPassword);
		
		lblPsername = new JLabel("Psername");
		lblPsername.setBounds(323, 159, 65, 16);
		contentPane.add(lblPsername);
		
		lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(323, 205, 88, 16);
		contentPane.add(lblPassword_1);
		
		lblClients = new JLabel("CLIENTS");
		lblClients.setBounds(120, 127, 56, 16);
		contentPane.add(lblClients);
		
		lblAdministration = new JLabel("ADMINISTRATION");
		lblAdministration.setBounds(391, 124, 103, 16);
		contentPane.add(lblAdministration);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(120, 289, 116, 25);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register r = new Register();
				r.setVisible(true);
			}
		});
		contentPane.add(btnRegister);
		
		lblNewLabel = new JLabel("     ELECTRICA ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(120, 28, 374, 68);
		contentPane.add(lblNewLabel);
		
		passwordA = new JPasswordField();
		passwordA.setBounds(390, 205, 116, 22);
		contentPane.add(passwordA);
		
		passwordClients = new JPasswordField();
		passwordClients.setBounds(120, 202, 116, 22);
		contentPane.add(passwordClients);
		
		
		
	}
}
