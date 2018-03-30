package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import ps1.Account;
import ps1.Complaint;

public class AccountDAO implements AccountDAOInt{
	protected static final Logger LOGGER = Logger.getLogger(StaffDAO.class.getName());
	private final static String logInStatementIsManager = "SELECT * FROM `Account` where `username` = ?";
	private static final String insertStatementString = "INSERT INTO `Account` (clientNumber,isActive,name,address,CNP,username,password)"
			+ " VALUES (?,?,?,?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM Account where username = ?";
	   private final static String updateIsActiveStatementString = "UPDATE Account "
				+ "SET isActive = ? WHERE username = ?";
	   private static final String insertMessageStatementString = "INSERT INTO `complaint` (message,clientNumber,isAccepted)"
				+ " VALUES (?,?,0)";
	   private static final String completeFormStatementString = "update `complaint` set details= ? ,`date`= ? , serviceQuality= ? , quickResponse= ? , customerServiceQuality = ?, isAccepted = 2 where clientNumber = ?";
	   private final static String showBillsStatementIsManager = "SELECT * FROM `Bill` where `clientNumber` = ?";
	   private final static String isComplaintActiveStatementStringr = "SELECT `isAccepted` FROM `complaint` where `clientNumber` = ?";
	   private static final String insertClientStatementString = "INSERT INTO `account` (clientNumber,isActive,name,address,CNP,username,password)"
				+ " VALUES (?,0,?,?,?,?,?)";
	   
	public int logInClient(String username, String password){ 
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement logInStatement = null;
		ResultSet rs = null;
		
		try {
			logInStatement = dbConnection.prepareStatement(logInStatementIsManager);
			logInStatement.setString(1, username);
			rs = logInStatement.executeQuery();
			if(!rs.next()){
				//System.out.println("Invalid username");
				return 2;
			}
			else{
				String passwordtable = rs.getString("password");
				int isActive = rs.getInt("isActive");
				if(password.equals(passwordtable) && isActive==1){
					return 1;
				} else {
					//System.out.println("invalid password");
					return 3;
				}
			}
		
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"AccoutDAO:LogIn " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(logInStatement);
			ConnectionFactory.close(dbConnection);
		}	
		
		return 4;
	}
	
	public void register(Account client){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement registerStatement = null;
		
		PreparedStatement insertStatement = null;
		try {
			registerStatement = dbConnection.prepareStatement(insertStatementString);
			registerStatement.setInt(1, client.getClientNumber());
			registerStatement.setInt(2, 0);
			registerStatement.setString(3, client.getName());
			registerStatement.setString(4, client.getAddress());
			registerStatement.setString(5, client.getCNP());
			registerStatement.setString(6, client.getUsername());
			registerStatement.setString(7, client.getPassword());
			registerStatement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	public Account findByUsername(String username){
		
		Account toReturn = new Account();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setString(1, username);
			rs = findStatement.executeQuery();
			if(!rs.next()){
				System.out.println("NU stii da un input");
			}
			else{
				int clientNumber = rs.getInt("clientNumber");
				int isActive = rs.getInt("isActive");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String cnp = rs.getString("CNP");
				String password = rs.getString("password");
				toReturn = new Account(clientNumber, isActive, name, address, cnp, username, password);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"AccountDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public void acceptRequest(String username){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement acceptRequestStatement = null;
		try {
			acceptRequestStatement = dbConnection.prepareStatement(updateIsActiveStatementString);
			acceptRequestStatement.setInt(1, 1);
			acceptRequestStatement.setString(2, username);
			acceptRequestStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:update address" + e.getMessage());
		} finally {
			ConnectionFactory.close(acceptRequestStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	public void sentRequest(String message, int clientNumber){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertMessageStatement = null;

			try {

				insertMessageStatement = dbConnection.prepareStatement(insertMessageStatementString, Statement.RETURN_GENERATED_KEYS);
				insertMessageStatement.setString(1, message);
				insertMessageStatement.setInt(2, clientNumber);
				try {
				insertMessageStatement.executeUpdate();
				} catch (Exception e){
					System.out.println("nu exista acest clientNumber");
				}
				System.out.println("message sent");
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				ConnectionFactory.close(insertMessageStatement);
				ConnectionFactory.close(dbConnection);
			}
	}
	
	public void sentFormBack(Complaint complain,int clientNumber){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement completeFormStatement = null;
		
		try {
			completeFormStatement = dbConnection.prepareStatement(completeFormStatementString);
			completeFormStatement.setString(1, complain.getDetails());
			completeFormStatement.setString(2, complain.getDate());
			completeFormStatement.setInt(3, complain.getServiceQuality());
			completeFormStatement.setInt(4, complain.getQuickResponse());
			completeFormStatement.setInt(5, complain.getCustomerServiceQuality());
			completeFormStatement.setInt(6, clientNumber);
			completeFormStatement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(completeFormStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	public void showBills(int clientNumber){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement showBillsStatement = null;
		ResultSet rs = null;
		
		try {
			showBillsStatement = dbConnection.prepareStatement(showBillsStatementIsManager, Statement.RETURN_GENERATED_KEYS);
			showBillsStatement.setInt(1, clientNumber);
			rs = showBillsStatement.executeQuery();
			
			while(rs.next()){
				String idBill = rs.getString("idBill");
				float sum = rs.getFloat("sum");
				int isPaid = rs.getInt("isPaid");
				if (isPaid==0){
				System.out.println("factura cu codul " + idBill + " in valore de: " + sum +" NU E PLATITA");
				} else{ 
				System.out.println("factura cu codul " + idBill + " in valore de: " + sum +" E PLATITA");
				}
			}
				
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"AccoutDAO:LogIn " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(showBillsStatement);
			ConnectionFactory.close(dbConnection);
		}	
	}
	
	public int isComplaintActive(int clientNumber){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement isComplaintActiveStatement = null;
		ResultSet rs = null;
		
		try {
			isComplaintActiveStatement = dbConnection.prepareStatement(isComplaintActiveStatementStringr, Statement.RETURN_GENERATED_KEYS);
			isComplaintActiveStatement.setInt(1, clientNumber);
			rs = isComplaintActiveStatement.executeQuery();
			
			if (rs.next()){
				return rs.getInt("isAccepted");
				//System.out.println(rs.getInt("isAccepted")+"??????????");
			}
			else {
				return 0;
			}
				
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"AccoutDAO:LogIn " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(isComplaintActiveStatement);
			ConnectionFactory.close(dbConnection);
		}	
		return -1;
	}
	
	public void insertClient(Account account){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertClientStatement = null;

		try {

			insertClientStatement = dbConnection.prepareStatement(insertClientStatementString, Statement.RETURN_GENERATED_KEYS);
			insertClientStatement.setInt(1, account.getClientNumber());
			insertClientStatement.setString(2, account.getName());
			insertClientStatement.setString(3, account.getAddress());
			insertClientStatement.setString(4, account.getCNP());
			insertClientStatement.setString(5, account.getUsername());
			insertClientStatement.setString(6, account.getPassword());
			
			insertClientStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.close(insertClientStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
}
