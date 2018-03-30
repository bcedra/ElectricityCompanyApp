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

public class ReadClients extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadClients frame = new ReadClients();
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
	
	public ReadClients() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(46, 30, 558, 369);
		contentPane.add(table);
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 13, 410, 227);
		contentPane.add(scrollPane);
		
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(162, 253, 97, 25);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				String query = "select * from `account`";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(btnLoad);
	}
}
