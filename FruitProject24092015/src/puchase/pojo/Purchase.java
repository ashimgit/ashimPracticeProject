package puchase.pojo;

import java.util.List;

public class Purchase {

	private String purchaseNo;
	private String purchaseDate;
	private String purchaseBillNo;
	private String supplierNo;
	private String goDownNo;
	private Double totalPurchaseAmount;
	private List<PurchaseItemDetail> purchaseIteamList;
	
	public List<PurchaseItemDetail> getPurchaseIteamList() {
		return purchaseIteamList;
	}
	public void setPurchaseIteamList(List<PurchaseItemDetail> purchaseIteamList) {
		this.purchaseIteamList = purchaseIteamList;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPurchaseBillNo() {
		return purchaseBillNo;
	}
	public void setPurchaseBillNo(String purchaseBillNo) {
		this.purchaseBillNo = purchaseBillNo;
	}
	public String getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getGoDownNo() {
		return goDownNo;
	}
	public void setGoDownNo(String goDownNo) {
		this.goDownNo = goDownNo;
	}
	public Double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(Double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
}
