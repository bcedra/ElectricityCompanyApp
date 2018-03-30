package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import businessLogicLayer.AccountBLL;
import businessLogicLayer.StaffBLL;
import connection.ConnectionFactory;
import ps1.Account;
import ps1.Staff;
import ps1.Stats;

public class StaffDAO implements StaffDAOInt {
	protected static final Logger LOGGER = Logger.getLogger(StaffDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO `Staff` (isManager, username, password)"
			+ " VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM `Staff` where `idStaff` = ?";
	private final static String existsStatementString = "SELECT * FROM `account` where `clientNumber` = ?";
	private final static String findStatementIsManager = "SELECT * FROM `Staff` where `username` = ?";
	private final static String sentFormStatementString = "UPDATE complaint "
			+ "SET isAccepted = 1 WHERE clientNumber = ?";
	private static final String insertClientStatementString = "INSERT INTO `account` (clientNumber,isActive,name,address,CNP,username,password)"
			+ " VALUES (?,1,?,?,?,?,?)";
	private static final String deleteClientStatement = "DELETE FROM `account` where `username` = ?;";
	private static final String deleteClientNumberStatement = "DELETE FROM `complaint` where `clientNumber` = ?;";
	private static final String insertClientNumber = "INSERT INTO `clientNumber` (clientNumber)"
			+ " VALUES (?);";
	private static final String average1 = "SELECT AVG(serviceQuality) from `complaint` where `isAccepted`=2;";
	private static final String average2 = "SELECT AVG(quickResponse) from `complaint` where `isAccepted`=2;";
	private static final String average3 = "SELECT AVG(customerServiceQuality) from `complaint` where `isAccepted`=2;";
	
	public void insert(Staff staff) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;

		try {

			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setBoolean(1, staff.isManager());
			insertStatement.setString(2, staff.getUsername());
			insertStatement.setString(3, staff.getPassword());

			insertStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
	}

	public void view(int idStaff) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement viewStatement = null;
		ResultSet rs = null;

		try {
			viewStatement = dbConnection.prepareStatement(findStatementString);
			viewStatement.setInt(1, idStaff);
			rs = viewStatement.executeQuery();
			rs.next();

			String username = rs.getString("username");

			System.out.println(username);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StaffDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(viewStatement);
			ConnectionFactory.close(dbConnection);
		}
	}

	public int isManager(String username, String password) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement isManagerStatement = null;
		ResultSet rs = null;

		try {
			isManagerStatement = dbConnection.prepareStatement(findStatementIsManager);
			isManagerStatement.setString(1, username);
			rs = isManagerStatement.executeQuery();
			if (!rs.next()) {
				//System.out.println("Invalid username");
				return 3;
			} else {
				int isM = rs.getInt("isManager");
				String passwordtable = rs.getString("password");
				if (password.equals(passwordtable)) {
					if (isM == 1) {
						return 1;
					}
					if (isM == 0) {
						return 0;
					}
				} else {
					//System.out.println("invalid password");
					return 4;
				}
			}

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StaffDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(isManagerStatement);
			ConnectionFactory.close(dbConnection);
		}

		return 2;
	}

	public void manageRequest(String username){
		Account a = AccountBLL.findByUsername(username);
		if (a == null) {
			throw new NoSuchElementException("The client with username =" + username + " was not found!");
		}
		if(StaffBLL.exists(a.getClientNumber())==true){
			AccountBLL.acceptRequest(a.getUsername());
		}
	}
	
	public void sentForm(int clientNumber){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement sentFormStatement = null;
		try {
			sentFormStatement = dbConnection.prepareStatement(sentFormStatementString);
			sentFormStatement.setInt(1, clientNumber);
			sentFormStatement.executeUpdate();
			System.out.println("completati formularu asta: ..............");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:update address" + e.getMessage());
		} finally {
			ConnectionFactory.close(sentFormStatement);
			ConnectionFactory.close(dbConnection);
		}
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
	
	public void deleteClient(String username){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;

		try {

			deleteStatement = dbConnection.prepareStatement(deleteClientStatement, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setString(1, username);
			deleteStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	public void deleteComplaint(int clientNubmer){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;

		try {

			deleteStatement = dbConnection.prepareStatement(deleteClientNumberStatement, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setInt(1, clientNubmer);
			deleteStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	public boolean exists(int clientNumber){

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement existsStatement = null;
		ResultSet rs = null;
		try {
			existsStatement = dbConnection.prepareStatement(existsStatementString);
			existsStatement.setInt(1, clientNumber);
			rs = existsStatement.executeQuery();
			if(!rs.next()){
				return false;
			}
			else{
				return true;
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"AccountDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(existsStatement);
			ConnectionFactory.close(dbConnection);
		}
		return false;
	}
	
	public void insertClientNumber(int clientNumber){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertClient = null;

		try {

			insertClient = dbConnection.prepareStatement(insertClientNumber, Statement.RETURN_GENERATED_KEYS);
			insertClient.setInt(1, clientNumber);
			insertClient.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.close(insertClient);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	
	
	public Stats returnStats(){
		Stats stats = new Stats();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement statStatement = null;
		PreparedStatement statStatement1 = null;
		PreparedStatement statStatement2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {
			statStatement = dbConnection.prepareStatement(average1);
			rs = statStatement.executeQuery();
			rs.next();
			float sq=rs.getFloat("AVG(serviceQuality)");
			
			statStatement1 = dbConnection.prepareStatement(average2);
			rs1 = statStatement1.executeQuery();
			rs1.next();
			float qr=rs1.getFloat("AVG(quickResponse)");
			
			statStatement2 = dbConnection.prepareStatement(average3);
			rs2 = statStatement2.executeQuery();
			rs2.next();
			float csq=rs2.getFloat("AVG(customerServiceQuality)");
			
			stats = new Stats(sq,qr,csq);
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StaffDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(rs1);
			ConnectionFactory.close(rs2);
			ConnectionFactory.close(statStatement);
			ConnectionFactory.close(statStatement1);
			ConnectionFactory.close(statStatement2);
			ConnectionFactory.close(dbConnection);
		}
		return stats;
	}
	
	
}
