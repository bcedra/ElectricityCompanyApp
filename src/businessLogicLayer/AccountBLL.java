package businessLogicLayer;

import java.util.NoSuchElementException;

import dao.AccountDAO;
import dao.AccountDAOInt;
import ps1.Account;
import ps1.Complaint;


public class AccountBLL {
	final static AccountDAOInt dao= new AccountDAO();
	
	public static int logInClient(String username,String password){
		return dao.logInClient(username,password);
	}
	
	public static void register(Account client){
		dao.register(client);
	}
	
	public static Account findByUsername(String username){
		Account st = dao.findByUsername(username);
       
        	if (st == null) {
        			throw new NoSuchElementException("The client with username =" + username + " was not found!");
        		}
        	return st;
	}
	
	public static void acceptRequest(String username){
		dao.acceptRequest(username);
	}
	
	public static void sentRequest(String message, int clientNumber){
		dao.sentRequest(message, clientNumber);
	}
	
	public static void sentFormBack(Complaint complain,int clientNumber){
		dao.sentFormBack(complain, clientNumber);
	}
	
	public static void showBills(int clientNumber){
		dao.showBills(clientNumber);
	}
	
	public static int isComplaintActive(int clientNumber){
		return dao.isComplaintActive(clientNumber);
	}
	
	public static void insertClient(Account account){
		dao.insertClient(account);
	}
}
