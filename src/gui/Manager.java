package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.AccountBLL;
import businessLogicLayer.StaffBLL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JTextField deleteUsername;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField updateUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		setTitle("MANAGER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setBounds(40, 47, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblComplaints = new JLabel("Complaints");
		lblComplaints.setBounds(390, 47, 114, 16);
		contentPane.add(lblComplaints);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(12, 76, 97, 25);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateClient createClient = new CreateClient();
				createClient.setVisible(true);
			}
		});
		contentPane.add(btnCreate);
		
		JButton btnRead = new JButton("Read");
		btnRead.setBounds(12, 124, 97, 25);
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadClients readClients = new ReadClients();
				readClients.setVisible(true);
			}
		});
		contentPane.add(btnCreate);
		contentPane.add(btnRead);
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(12, 219, 97, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = deleteUsername.getText();
				StaffBLL staffBLL = new StaffBLL();
				if (username.equals("")){
					JOptionPane.showMessageDialog(new JFrame(), "Empty field");
				}
				else{
					staffBLL.deleteClient(username);
					JOptionPane.showMessageDialog(new JFrame(), "Deleted");
					deleteUsername.setText("");
				}
			}
		});
		contentPane.add(btnDelete);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(374, 124, 97, 25);
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int clientNumber = Integer.parseInt(textField_2.getText());
					StaffBLL staffBLL = new StaffBLL();
					staffBLL.deleteComplaint(clientNumber);
					JOptionPane.showMessageDialog(new JFrame(), "Deleted");
					deleteUsername.setText("");
				} catch (Exception e1){
					JOptionPane.showMessageDialog(new JFrame(), "Empty field");
				}
			}
		});
		contentPane.add(btnDelete);
		contentPane.add(btnDelete_1);
		
		JButton btnClientNumber = new JButton("Add Client Number");
		btnClientNumber.setBounds(12, 265, 146, 25);
		btnClientNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clientNumber = Integer.parseInt(textField_1.getText());
				StaffBLL.insertClientNumber(clientNumber);
			}
		});
		contentPane.add(btnClientNumber);
		
		deleteUsername = new JTextField();
		deleteUsername.setBounds(121, 222, 116, 22);
		contentPane.add(deleteUsername);
		deleteUsername.setColumns(10);
		
		JLabel lblDeleteByUsername = new JLabel("by username");
		lblDeleteByUsername.setBounds(121, 207, 116, 16);
		contentPane.add(lblDeleteByUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 266, 67, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 125, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDeleteByClient = new JLabel("by client number");
		lblDeleteByClient.setBounds(246, 108, 113, 16);
		contentPane.add(lblDeleteByClient);
		
		JButton btnReports = new JButton("Reports");
		btnReports.setBounds(374, 76, 97, 25);
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewReports vr = new ViewReports();
				vr.setVisible(true);
			}
		});
		contentPane.add(btnReports);
		
		updateUsername = new JTextField();
		updateUsername.setBounds(121, 174, 116, 22);
		contentPane.add(updateUsername);
		updateUsername.setColumns(10);
		
		JLabel label_1 = new JLabel("by username");
		label_1.setBounds(121, 158, 116, 16);
		contentPane.add(label_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(12, 173, 97, 25);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = updateUsername.getText();
				UpdateClient updateClient = new UpdateClient(username);
				updateClient.setVisible(true);
				updateUsername.setText("");
			}
		});
		contentPane.add(btnUpdate);
		
		JButton btnNewButton = new JButton("Manage Requests");
		btnNewButton.setBounds(12, 303, 146, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageRequests mr = new ManageRequests();
				mr.setVisible(true);
			}
		});
		contentPane.add(btnUpdate);
		contentPane.add(btnNewButton);
	}
}
