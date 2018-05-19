package ebasOlsWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(ElecBillDetIdGroup.class)

public class ElecBillDetIdGroup implements Serializable{
	
	@Id
	@Column(name="consumer_no",length=12)
	private String consumer_no;
	
	@Id
	@Column(name="bill_mon",length=2)
	private String bill_mon;
	
	@Id
	@Column(name="bill_yr",length=4)
	private String bill_yr;

	public ElecBillDetIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElecBillDetIdGroup(String consumer_no, String bill_mon, String bill_yr) {
		super();
		this.consumer_no = consumer_no;
		this.bill_mon = bill_mon;
		this.bill_yr = bill_yr;
	}

	public String getConsumer_no() {
		return consumer_no;
	}

	public void setConsumer_no(String consumer_no) {
		this.consumer_no = consumer_no;
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
