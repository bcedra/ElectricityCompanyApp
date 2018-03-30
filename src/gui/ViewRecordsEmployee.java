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

import businessLogicLayer.StaffBLL;
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

public class ViewRecordsEmployee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRecordsEmployee frame = new ViewRecordsEmployee();
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
	private JButton btnNewButton_1;
	private JTextField textField;
	
	public ViewRecordsEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(46, 30, 558, 369);
		contentPane.add(table);
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(36, 13, 249, 334);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setBounds(102, 360, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				String query = "select clientNumber, message, isAccepted from `complaint` where `isAccepted`=0;";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Accept request");
		btnNewButton_1.setBounds(140, 398, 166, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				int clientNumber = Integer.parseInt(textField.getText());
				StaffBLL.sentForm(clientNumber);
				JOptionPane.showMessageDialog(new JFrame(), "Accepted");
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(12, 399, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}

}
