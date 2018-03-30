package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.StaffBLL;
import ps1.Account;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CreateClient extends JFrame {

	private JPanel contentPane;
	private JTextField clientNumberTextField;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField cnpTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateClient frame = new CreateClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CreateClient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 230, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		clientNumberTextField = new JTextField();
		clientNumberTextField.setBounds(45, 34, 116, 22);
		contentPane.add(clientNumberTextField);
		clientNumberTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(45, 74, 116, 22);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(45, 109, 116, 22);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		
		cnpTextField = new JTextField();
		cnpTextField.setBounds(45, 152, 116, 22);
		contentPane.add(cnpTextField);
		cnpTextField.setColumns(10);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(45, 196, 116, 22);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(45, 241, 116, 22);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBounds(55, 274, 97, 25);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clientNumber = Integer.parseInt(clientNumberTextField.getText());
				String name = nameTextField.getText();
				String address = addressTextField.getText();
				String cnp = cnpTextField.getText();
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				
				Account account = new Account(clientNumber,name,address,cnp,username,password);
				StaffBLL staffBLL = new StaffBLL();
				staffBLL.insertClient(account);
				
				JOptionPane.showMessageDialog(new JFrame(), "Created");
			}
		});
		contentPane.add(btnCreate);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(45, 56, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(45, 95, 56, 16);
		contentPane.add(lblAddress);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(45, 139, 56, 16);
		contentPane.add(lblCnp);
		
		
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(45, 225, 56, 16);
		contentPane.add(lblPassword);
		
		JLabel lblClientnumber = new JLabel("Client Number");
		lblClientnumber.setBounds(45, 13, 91, 16);
		contentPane.add(lblClientnumber);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(45, 179, 107, 16);
		
		contentPane.add(lblUsername);
	}

}
