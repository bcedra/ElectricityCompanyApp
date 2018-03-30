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

public class ViewReports extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReports frame = new ViewReports();
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
	private JButton btnStats;
	private JLabel lblNewLabel;
	private JLabel lblCustomer;
	private JLabel lblCustomerServiceQuality;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	public ViewReports() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 868, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(46, 30, 558, 369);
		contentPane.add(table);
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 13, 828, 189);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setBounds(741, 215, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				String query = "select * from `complaint` where `isAccepted`=2";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(btnNewButton);
		
		btnStats = new JButton("LOAD STATS");
		btnStats.setBounds(20, 215, 116, 25);
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText(Float.toString(StaffBLL.returnStats().getServiceQuality()));
				lblNewLabel_2.setText(Float.toString(StaffBLL.returnStats().getQuickResponse()));
				lblNewLabel_3.setText(Float.toString(StaffBLL.returnStats().getCustomerServiceQuality()));
		}
		}	);
		contentPane.add(btnStats);
		
		lblNewLabel = new JLabel("Service Quality");
		lblNewLabel.setBounds(168, 238, 116, 16);
		contentPane.add(lblNewLabel);
		
		lblCustomer = new JLabel("Quick Response ");
		lblCustomer.setBounds(371, 238, 116, 16);
		contentPane.add(lblCustomer);
		
		lblCustomerServiceQuality = new JLabel("Customer Service Quality");
		lblCustomerServiceQuality.setBounds(558, 238, 144, 16);
		contentPane.add(lblCustomerServiceQuality);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(168, 219, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(371, 219, 56, 16);
		contentPane.add(lblNewLabel_2);
	
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(558, 219, 56, 16);
		contentPane.add(lblNewLabel_3);
		
	}

}
