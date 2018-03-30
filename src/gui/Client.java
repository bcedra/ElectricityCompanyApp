package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import businessLogicLayer.AccountBLL;
import connection.ConnectionFactory;
import dao.AccountDAO;
import net.proteanit.sql.DbUtils;
import ps1.Complaint;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import java.awt.Button;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField ServiceQuality;
	private JTextField QuickResponse;
	private JTextField CustomerServiceQuality;
	private JTextField Date;
	public static String username;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	private JScrollPane scrollPane;
	private JTextField payBill;
	/**
	 * Create the frame.
	 */
	public Client(String username) {
		Client.username=username;
		setTitle("CLIENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton UnpaidBills = new JButton("Unpaid Bills");
		UnpaidBills.setBounds(403, 73, 116, 25);
		UnpaidBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				AccountBLL accountBLL = new AccountBLL();
				String query = "select `sum`,`idBill` from `Bill` where `isPaid`=0 and `clientNumber`=" + accountBLL.findByUsername(username).getClientNumber() + ";";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(UnpaidBills);
		
		
		
		JButton History = new JButton("History");
		History.setBounds(597, 73, 97, 25);
		History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				AccountBLL accountBLL = new AccountBLL();
				String query = "select `sum` from `Bill` where `isPaid`=1 and `clientNumber`=" + accountBLL.findByUsername(username).getClientNumber() + ";";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e1){e1.printStackTrace();}
		}
		}	);
		contentPane.add(History);
		JLabel lblComplaint = new JLabel("COMPLAINTS");
		lblComplaint.setBounds(130, 32, 91, 16);
		contentPane.add(lblComplaint);
		JLabel lblBills = new JLabel("BILLS");
		lblBills.setBounds(532, 32, 56, 16);
		contentPane.add(lblBills);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(10, 124, 56, 16);
		contentPane.add(lblMessage);
		
		
		
		JLabel title = new JLabel(username);
		title.setFont(new Font("Tahoma", Font.PLAIN, 15));
		title.setBounds(393, 0, 91, 30);
		contentPane.add(title);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(354, 7, 45, 16);
		contentPane.add(lblUser);
		
		TextArea message = new TextArea();
		message.setBounds(10, 146, 154, 153);
		contentPane.add(message);
		
		JButton btnNewButton = new JButton("Request Complaint");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection dbConnection = ConnectionFactory.getConnection();
				AccountBLL accountBLL = new AccountBLL();
				String messageText = message.getText();
				int clientNumber = accountBLL.findByUsername(username).getClientNumber();
				accountBLL.sentRequest(messageText, clientNumber);
				JOptionPane.showMessageDialog(new JFrame(), "Request Sent");
				message.setText("");
			}
		});
		btnNewButton.setBounds(12, 73, 149, 25);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(46, 30, 558, 369);
		contentPane.add(table);
		
		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(403, 122, 291, 333);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("If you have any problem,");
		lblNewLabel.setBounds(10, 318, 149, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("request a complaint form");
		lblNewLabel_1.setBounds(10, 336, 154, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("and you will receive a  ");
		lblNewLabel_2.setBounds(12, 354, 152, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("form here to complete.");
		lblNewLabel_3.setBounds(10, 373, 154, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnPayBill = new JButton("Pay bill");
		btnPayBill.setBounds(403, 469, 97, 25);
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{	
				Connection dbConnection = ConnectionFactory.getConnection();
				String query = "update `bill` set `isPaid`=1 where `idBill`= " + payBill.getText() + ";";
				PreparedStatement pst = (PreparedStatement) dbConnection.prepareStatement(query);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(new JFrame(), "Paid");
			}catch(Exception e1){JOptionPane.showMessageDialog(new JFrame(), "Invalid request");}
		}
		}	);
		contentPane.add(btnPayBill);
		
		payBill = new JTextField();
		payBill.setBounds(581, 470, 116, 22);
		contentPane.add(payBill);
		payBill.setColumns(10);
		
		JLabel lblIdBill = new JLabel("id Bill");
		lblIdBill.setBounds(581, 456, 56, 16);
		contentPane.add(lblIdBill);
		
		//System.out.println(AccountBLL.findByUsername(username).getClientNumber()+ "!!!!!!!!!");
		if(AccountBLL.isComplaintActive(AccountBLL.findByUsername(username).getClientNumber())==1){
			
			ServiceQuality = new JTextField();
			ServiceQuality.setBounds(202, 182, 116, 22);
			contentPane.add(ServiceQuality);
			ServiceQuality.setColumns(10);
			
			QuickResponse = new JTextField();
			QuickResponse.setBounds(202, 227, 116, 22);
			contentPane.add(QuickResponse);
			QuickResponse.setColumns(10);
			
			CustomerServiceQuality = new JTextField();
			CustomerServiceQuality.setBounds(202, 277, 116, 22);
			contentPane.add(CustomerServiceQuality);
			CustomerServiceQuality.setColumns(10);
			
			Date = new JTextField();
			Date.setBounds(202, 136, 116, 22);
			contentPane.add(Date);
			Date.setColumns(10);
			
			JLabel DateLabel = new JLabel("Date");
			DateLabel.setBounds(202, 121, 56, 16);
			contentPane.add(DateLabel);
			
			JLabel SQLabel = new JLabel("Service Quality (1-10)");
			SQLabel.setBounds(202, 167, 133, 16);
			contentPane.add(SQLabel);
			
			JLabel QRLabel = new JLabel("Quick Response (1-10)");
			QRLabel.setBounds(202, 213, 149, 16);
			contentPane.add(QRLabel);
			
			JLabel DetailsLabel = new JLabel("Details about your problem");
			DetailsLabel.setBounds(186, 302, 165, 16);
			contentPane.add(DetailsLabel);
			
			JLabel CSQLabel = new JLabel("Customer Service Quality (1-10)");
			CSQLabel.setBounds(173, 262, 184, 16);
			contentPane.add(CSQLabel);
			
			TextArea details = new TextArea();
			details.setBounds(173, 326, 177, 168);
			contentPane.add(details);
			
			
				JButton SubmitForm = new JButton("Submit Form");
				SubmitForm.setBounds(202, 73, 116, 25);
				SubmitForm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int error=0;
							try{
								String d= details.getText();
								String date = Date.getText();
								int sq = Integer.parseInt(ServiceQuality.getText());
								int qr = Integer.parseInt(QuickResponse.getText());
								int csq = Integer.parseInt(CustomerServiceQuality.getText());
							
								Complaint complaint = new Complaint(d,date,sq,qr,csq);
							
							
								AccountBLL.sentFormBack(complaint, AccountBLL.findByUsername(username).getClientNumber());
							} catch (Exception e1){
								error=1;
								JOptionPane.showMessageDialog(new JFrame(), "Empty Fields");
							}
							if(error==0){
								ServiceQuality.hide();
								QuickResponse.hide();
								CustomerServiceQuality.hide();
								Date.hide();
								details.hide();
								CSQLabel.hide();
								DetailsLabel.hide();
								QRLabel.hide();
								SQLabel.hide();
								DateLabel.hide();
								SubmitForm.hide();
								JOptionPane.showMessageDialog(new JFrame(), "Form Submited");
							}
							
					}
				});
				contentPane.add(SubmitForm);
			
		}	
		
	}
}
