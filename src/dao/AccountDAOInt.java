package dao;

import ps1.Account;
import ps1.Complaint;

public interface AccountDAOInt {
	int logInClient(String username, String password);
	void register(Account client);
	Account findByUsername(String username);
	void acceptRequest(String username);
	void sentRequest(String message, int clientNumber);
	void sentFormBack(Complaint complain,int clientNumber);
	void showBills(int clientNumber);
	int isComplaintActive(int clientNumber);
	public void insertClient(Account account);
}
