package ps1;

public class Account {
	private int clientNumber;
	private int isActive;
	private String name;
	private String address;
	private String CNP;
	private String username;
	private String password;
	
	public Account(int clientNumber, String name, String address, String cNP, String username,
			String password) {
		super();
		this.clientNumber = clientNumber;
		this.name = name;
		this.address = address;
		CNP = cNP;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Account [clientNumber=" + clientNumber + ", isActive=" + isActive + ", name=" + name + ", address="
				+ address + ", CNP=" + CNP + ", username=" + username + ", password=" + password + "]";
	}

	public Account(int clientNumber, int isActive, String name, String address, String cNP, String username,
			String password) {
		super();
		this.clientNumber = clientNumber;
		this.isActive = isActive;
		this.name = name;
		this.address = address;
		CNP = cNP;
		this.username = username;
		this.password = password;
	}

	public Account() {
		
	}

	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCNP() {
		return CNP;
	}
	public void setCNP(String cNP) {
		CNP = cNP;
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
