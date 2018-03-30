package businessLogicLayer;

import dao.StaffDAO;
import dao.StaffDAOInt;
import ps1.Account;
import ps1.Staff;
import ps1.Stats;

public class StaffBLL {
	final static StaffDAOInt dao=  new StaffDAO();
	
	public static void insert(String username, String password, boolean isManager){
		Staff staff = new Staff(isManager, username, password);
		dao.insert(staff);
	}
	
	public static void view(int idStaff){
		dao.view(idStaff);
	}
	
	public static int isManager(String username,String password){
		return dao.isManager(username,password);
	}
	

	public static void manageRequest(String username) {
		dao.manageRequest(username);
	}
	
	public static void sentForm(int clientNumber){
		dao.sentForm(clientNumber);
	}
	
	public static void insertClient(Account account){
		dao.insertClient(account);
	}
	
	public static void deleteClient(String username){
		dao.deleteClient(username);
	}
	
	public void deleteComplaint(int clientNubmer){
		dao.deleteComplaint(clientNubmer);
	}
	
	public static boolean exists(int clientNumber){
		return dao.exists(clientNumber);
	}
	
	public static void insertClientNumber(int clientNumber){
		dao.insertClientNumber(clientNumber);
	}
	
	public static Stats returnStats(){
		return dao.returnStats();
	}
}
