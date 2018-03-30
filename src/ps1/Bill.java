package ps1;

public class Bill {
	private int idBill;
	private float sum;
	private int clientNumber;
	
	
	public Bill(int idBill, float sum, int clientNumber) {
		super();
		this.idBill = idBill;
		this.sum = sum;
		this.clientNumber = clientNumber;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	
}
