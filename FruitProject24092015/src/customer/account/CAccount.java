package customer.account;

public class CAccount {

	private String saleId;
	private String saleDate;
	private Double saleAmt;
	private Double paidAmt;
	private String status;
	
	
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public Double getSaleAmt() {
		return saleAmt;
	}
	public void setSaleAmt(Double saleAmt) {
		this.saleAmt = saleAmt;
	}
	public Double getPaidAmt() {
		return paidAmt;
	}
	public void setPaidAmt(Double paidAmt) {
		this.paidAmt = paidAmt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
