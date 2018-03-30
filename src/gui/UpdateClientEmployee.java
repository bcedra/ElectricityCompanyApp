package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UpdateClientEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public static String username;
	private JLabel user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClientEmployee frame = new UpdateClientEmployee(-1);
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
	public UpdateClientEmployee(int clientNumber) {
		UpdateClient.username=username;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 279, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Name");
		btnNewButton_1.setBounds(152, 93, 97, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//try{	
					try {
					Connection dbConnection = ConnectionFactory.getConnection();
					String query = "update account set `name` = '" + textField_1.getText() + "'" +  " where `clientNumber` = " + Integer.toString(clientNumber) + ";";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					
					
					if (textField_1.getText().equals("") || clientNumber==-1){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");
					pst.execute();}
				
					pst.close();
					//} catch(Exception e2){JOptionPane.showMessageDialog(null,"Invalid request.");}
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Address");
		btnNewButton_2.setBounds(152, 138, 97, 25);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					try {
					Connection dbConnection = ConnectionFactory.getConnection();
					String query = "update account set `address` = '" + textField_2.getText() + "'" +  " where `clientNumber` = " + clientNumber + ";";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					
					
					if (textField_2.getText().equals("") || clientNumber==-1){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");
					pst.execute();}
				
					pst.close();
					} catch(Exception e2){JOptionPane.showMessageDialog(null,"Invalid request.");}
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CNP");
		btnNewButton_3.setBounds(152, 176, 97, 25);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					try {
					Connection dbConnection = ConnectionFactory.getConnection();
					String query = "update account set `CNP` = '" + textField_3.getText() + "'" +  " where `clientNumber` = " + clientNumber + ";";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					
					
					if (textField_3.getText().equals("") || clientNumber==-1){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");
					pst.execute();}
				
					pst.close();
					} catch(Exception e2){JOptionPane.showMessageDialog(null,"Invalid request.");}
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		contentPane.add(btnNewButton_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 94, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 139, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(12, 177, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		user = new JLabel(username);
		user.setBounds(103, 39, 56, 16);
		contentPane.add(user);
		user.setText(Integer.toString(clientNumber));
	}
}
