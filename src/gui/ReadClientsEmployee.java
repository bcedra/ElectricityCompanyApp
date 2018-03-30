package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import businessLogicLayer.AccountBLL;
import connection.ConnectionFactory;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ReadClientsEmployee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadClientsEmployee frame = new ReadClientsEmployee();
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
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTextField clientNumberTextField;
	private JLabel lblClientNumber;
	
	public ReadClientsEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(46, 30, 558, 369);
		contentPane.add(table);
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(20, 13, 400, 215);
		contentPane.add(scrollPane);
		
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(323, 253, 97, 25);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				String query = "select clientNumber,name,address,cnp from `account`";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(btnLoad);
		

		clientNumberTextField = new JTextField();
		clientNumberTextField.setBounds(123, 254, 82, 22);
		contentPane.add(clientNumberTextField);
		clientNumberTextField.setColumns(10);
		
		lblClientNumber = new JLabel("Client Number");
		lblClientNumber.setBounds(123, 238, 116, 16);
		
		btnNewButton = new JButton("Update");
		btnNewButton.setBounds(14, 253, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int clientNumber = Integer.parseInt(clientNumberTextField.getText());
					UpdateClientEmployee uce = new UpdateClientEmployee(clientNumber);
					uce.setVisible(true);
				} catch (Exception e){
					JOptionPane.showMessageDialog(new JFrame(), "Invalid request");
				}
			}
		});
		contentPane.add(btnNewButton);
		
		
	}
}
