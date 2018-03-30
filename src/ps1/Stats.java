package ps1;

public class Stats {
	private float serviceQuality;
	private float quickResponse;
	private float customerServiceQuality;
	
	
	
	public Stats(float serviceQuality, float quickResponse, float customerServiceQuality) {
		this.serviceQuality = serviceQuality;
		this.quickResponse = quickResponse;
		this.customerServiceQuality = customerServiceQuality;
	}
	public float getServiceQuality() {
		return serviceQuality;
	}
	public void setServiceQuality(float serviceQuality) {
		this.serviceQuality = serviceQuality;
	}
	public float getQuickResponse() {
		return quickResponse;
	}
	public void setQuickResponse(float quickResponse) {
		this.quickResponse = quickResponse;
	}
	public Stats() {
		
	}
	public float getCustomerServiceQuality() {
		return customerServiceQuality;
	}
	public void setCustomerServiceQuality(float customerServiceQuality) {
		this.customerServiceQuality = customerServiceQuality;
	}
	
}
