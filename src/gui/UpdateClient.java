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

public class UpdateClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public static String username;
	private JLabel user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClient frame = new UpdateClient("");
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
	public UpdateClient(String username) {
		UpdateClient.username=username;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 279, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Name");
		btnNewButton_1.setBounds(152, 93, 97, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					try {
					Connection dbConnection = ConnectionFactory.getConnection();
					String query = "update account set `name` = '" + textField_1.getText() + "'" +  " where `username` = '" + username + "'";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					pst.execute();
					
					if (textField_1.getText().equals("") || username.equals("")){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");}
				
					pst.close();
					} catch(Exception e2){JOptionPane.showMessageDialog(null,"Invalid request.");}
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
					String query = "update account set `address` = '" + textField_2.getText() + "'" +  " where `username` = '" + username + "'";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					pst.execute();
					
					if (textField_2.getText().equals("") || username.equals("")){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");}
				
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
					String query = "update account set `CNP` = '" + textField_3.getText() + "'" +  " where `username` = '" + username + "'";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					pst.execute();
					
					if (textField_3.getText().equals("") || username.equals("")){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");}
				
					pst.close();
					} catch(Exception e2){JOptionPane.showMessageDialog(null,"Invalid request.");}
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Username");
		btnNewButton_4.setBounds(152, 214, 97, 25);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					try {
					Connection dbConnection = ConnectionFactory.getConnection();
					String query = "update account set `username` = '" + textField_4.getText() + "'" +  " where `username` = '" + username + "'";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					pst.execute();
					
					if (textField_4.getText().equals("") || username.equals("")){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");}
				
					pst.close();
					} catch(Exception e2){JOptionPane.showMessageDialog(null,"Invalid request.");}
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Password");
		btnNewButton_5.setBounds(152, 252, 97, 25);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					try {
					Connection dbConnection = ConnectionFactory.getConnection();
					String query = "update account set `password` = '" + textField_5.getText() + "'" +  " where `username` = '" + username + "'";
					PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
					pst.execute();
					
					if (textField_5.getText().equals("") || username.equals("")){
						JOptionPane.showMessageDialog(null,"Invalid request.");
					}
					else {
					JOptionPane.showMessageDialog(null,"Updated.");}
				
					pst.close();
					} catch(Exception e2){JOptionPane.showMessageDialog(null,"Invalid request.");}
				}catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		contentPane.add(btnNewButton_5);
		
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
		
		textField_4 = new JTextField();
		textField_4.setBounds(12, 215, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(12, 253, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		user = new JLabel(username);
		user.setBounds(103, 39, 56, 16);
		contentPane.add(user);
	}
}
