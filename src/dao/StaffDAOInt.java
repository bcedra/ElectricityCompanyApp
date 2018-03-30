package dao;

import ps1.Account;
import ps1.Staff;
import ps1.Stats;

public interface StaffDAOInt {
	void insert(Staff staff);
	void view(int idStaff);
	int isManager(String username, String password);
	void manageRequest(String username);
	void sentForm(int clientNumber);
	void insertClient(Account account);
	void deleteClient(String username);
	void deleteComplaint(int clientNubmer);
	boolean exists(int clientNumber);
	void insertClientNumber(int clientNumber);
	Stats returnStats();
}
