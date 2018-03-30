package start;

import businessLogicLayer.AccountBLL;
import businessLogicLayer.StaffBLL;
import dao.AccountDAO;
import dao.StaffDAO;
import ps1.Account;
import ps1.Complaint;
import ps1.Stats;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccountBLL accountBLL= new AccountBLL();
		StaffBLL staffBLL = new StaffBLL();
		StaffDAO staffDAO = new StaffDAO();
		AccountBLL registerBLL = new AccountBLL();
		AccountDAO accountDAO = new AccountDAO();
		Complaint complaint = new Complaint("mi o puscat becu","31 feb",5,4,3);
		Account account = new Account(3,"moro","baciu","296","moro","moro");
		
		//Stats s = new Stats();
		//s = StaffBLL.returnStats();
		//System.out.println(s.getCustomerServiceQuality() - s.getQuickResponse() - s.getServiceQuality());
		//staffBLL.deleteClient("daianaaa");
		//accountDAO.isComplaintActive(2);
		
		//System.out.println(staffBLL.isManager("employee", "employee"));
		//System.out.println(accountBLL.logInClient("cacat", "cacat"));
		//staffDAO.manageRequest("cedra");
		
		//accountBLL.showBills(6969);
		//accountBLL.sentFormBack(complaint, 6969);
		//accountBLL.sentRequest("ma pis pe serviciile voastre de cacat", 6969);
		//staffBLL.sentForm(6969);
		//Account client = new Account(6969,"hantatar","turzii 69","1967818429","username","password");
		//System.out.println(registerBLL.findByUsername("username"));
		
		//registerBLL.register(client);
		//System.out.println(accountBLL.logInClient("ionut","pulaa"));
	}
}
