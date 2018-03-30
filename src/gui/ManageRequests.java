package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import businessLogicLayer.StaffBLL;
import connection.ConnectionFactory;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ManageRequests extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageRequests frame = new ManageRequests();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JButton btnLoad;
	private JLabel lblUsername;
	
	/**
	 * Create the frame.
	 */
	public ManageRequests() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(1, 1, 399, 0);
		contentPane.add(table);
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 13, 410, 176);
		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("AcceptRequest");
		btnNewButton.setBounds(242, 215, 125, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				String username = textField.getText();
				StaffBLL.manageRequest(username);
				JOptionPane.showMessageDialog(new JFrame(), "Accepted");
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(56, 216, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnLoad = new JButton("LOAD");
		btnLoad.setBounds(156, 244, 97, 25);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				String query = "select * from `account` where `isActive`=0";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(btnLoad);
		
		lblUsername = new JLabel("username");
		lblUsername.setBounds(56, 202, 86, 16);
		contentPane.add(lblUsername);
		
	}

}
