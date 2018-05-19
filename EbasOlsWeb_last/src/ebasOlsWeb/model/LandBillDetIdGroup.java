package ebasOlsWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(LandBillDetIdGroup.class)
public class LandBillDetIdGroup implements Serializable {
	
	@Id
	@Column(name="hal_no",length=12)
	private String hal_no;
	
	@Id
	@Column(name="hal_no",length=2)
	private String bill_mon;
	
	@Id
	@Column(name="hal_no",length=4)
	private String bill_yr;

	public LandBillDetIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LandBillDetIdGroup(String hal_no, String bill_mon, String bill_yr) {
		super();
		this.hal_no = hal_no;
		this.bill_mon = bill_mon;
		this.bill_yr = bill_yr;
	}

	public String getHal_no() {
		return hal_no;
	}

	public void setHal_no(String hal_no) {
		this.hal_no = hal_no;
	}

	public String getBill_mon() {
		return bill_mon;
	}

	public void setBill_mon(String bill_mon) {
		this.bill_mon = bill_mon;
	}

	public String getBill_yr() {
		return bill_yr;
	}

	public void setBill_yr(String bill_yr) {
		this.bill_yr = bill_yr;
	}

	
	
}
