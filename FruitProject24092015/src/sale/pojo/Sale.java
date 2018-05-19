package sale.pojo;

import java.util.List;



public class Sale {

	private String saleNo;
	private String saleDate;
	private String godownId;
	private String customerNo;
	private Double grossAmount;
	private Double discountAmount;
	private Double taxAmount;
	private Double netAmount;
	private List<SaleItemDetail> saleIteamList;
	private Double customerpaidAmount;
	
	
	public Double getCustomerpaidAmount() {
		return customerpaidAmount;
	}
	public void setCustomerpaidAmount(Double customerpaidAmount) {
		this.customerpaidAmount = customerpaidAmount;
	}
	public String getGodownId() {
		return godownId;
	}
	public void setGodownId(String godownId) {
		this.godownId = godownId;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public Double getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	public List<SaleItemDetail> getSaleIteamList() {
		return saleIteamList;
	}
	public void setSaleIteamList(List<SaleItemDetail> saleIteamList) {
		this.saleIteamList = saleIteamList;
	}
}
