package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Employee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setTitle("EMPLOYEE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 201, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnView = new JButton("View Clients");
		btnView.setBounds(12, 78, 149, 25);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReadClientsEmployee readClientsEmployee = new ReadClientsEmployee();
				readClientsEmployee.setVisible(true);
			}
		});
		contentPane.add(btnView);
		
		JButton btnNewButton = new JButton("View Complaints");
		btnNewButton.setBounds(12, 116, 149, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewRecordsEmployee vr = new ViewRecordsEmployee();
				vr.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(55, 28, 56, 16);
		contentPane.add(lblEmployee);
	}
}
