package puchase.pojo;

public class PurchaseItemDetail {

	private String purchaseNo;
	private String fruitId;
	private String fruitName;
	private String fruitUnit;
	private String quantity;
	private Double purchaseItemRate;
	private Double purchaseItemTotal;
	
	
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getFruitId() {
		return fruitId;
	}
	public void setFruitId(String fruitId) {
		this.fruitId = fruitId;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public String getFruitUnit() {
		return fruitUnit;
	}
	public void setFruitUnit(String fruitUnit) {
		this.fruitUnit = fruitUnit;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Double getPurchaseItemRate() {
		return purchaseItemRate;
	}
	public void setPurchaseItemRate(Double purchaseItemRate) {
		this.purchaseItemRate = purchaseItemRate;
	}
	public Double getPurchaseItemTotal() {
		return purchaseItemTotal;
	}
	public void setPurchaseItemTotal(Double purchaseItemTotal) {
		this.purchaseItemTotal = purchaseItemTotal;
	}
	
}
