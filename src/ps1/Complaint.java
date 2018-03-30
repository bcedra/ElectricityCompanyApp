package ps1;

public class Complaint {
	private String details;
	private String date;
	private int serviceQuality;
	private int quickResponse;
	private int customerServiceQuality;

	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getServiceQuality() {
		return serviceQuality;
	}
	public void setServiceQuality(int serviceQuality) {
		this.serviceQuality = serviceQuality;
	}
	public int getQuickResponse() {
		return quickResponse;
	}
	public void setQuickResponse(int quickResponse) {
		this.quickResponse = quickResponse;
	}
	public int getCustomerServiceQuality() {
		return customerServiceQuality;
	}
	public void setCustomerServiceQuality(int customerServiceQuality) {
		this.customerServiceQuality = customerServiceQuality;
	}
	

	public Complaint(String details, String date, int serviceQuality, int quickResponse, int customerServiceQuality) {
		super();
		this.details = details;
		this.date = date;
		this.serviceQuality = serviceQuality;
		this.quickResponse = quickResponse;
		this.customerServiceQuality = customerServiceQuality;
	}
	
}
