package ps1;

public class Staff {
	private int idStaff;
	private boolean isManager;
	private String username;
	private String password;
	public Staff(int idStaff, boolean isManager, String username, String password) {
		this.idStaff = idStaff;
		this.isManager = isManager;
		this.username = username;
		this.password = password;
	}
	public Staff(boolean isManager, String username, String password) {
		this.idStaff = -1;
		this.isManager = isManager;
		this.username = username;
		this.password = password;
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
