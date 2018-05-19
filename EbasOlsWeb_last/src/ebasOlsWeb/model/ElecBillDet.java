package ebasOlsWeb.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="elec_bill_det")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(ElecBillDetIdGroup.class)

public class ElecBillDet {
	@Id
	@Column(name="consumer_no",length=12)
	private String consumer_no;
	
	@Id
	@Column(name="bill_mon",length=2)
	private String bill_mon;
	
	@Id
	@Column(name="bill_yr",length=4)
	private String bill_yr;
	
	@Column(name="agent_cd",length=5)
	private String agent_cd;
	
	@Column(name="agent_nm",length=150)
	private String agent_nm;
	
	@Column(name="gr_bill_amt")
	private double gr_bill_amt;
	
	@Column(name="rebate_amt")
	private double rebate_amt;
	
	@Column(name="net_amt")
	private double net_amt;
	
	@Column(name="pay_due_dt")
    private Date pay_due_dt;
	
	@Column(name="copy_by",length=10)
    private String copy_by;
	
	@Column(name="copy_dt")
    private Timestamp copy_dt;
	
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
	public String getAgent_cd() {
		return agent_cd;
	}
	public void setAgent_cd(String agent_cd) {
		this.agent_cd = agent_cd;
	}
	public String getAgent_nm() {
		return agent_nm;
	}
	public void setAgent_nm(String agent_nm) {
		this.agent_nm = agent_nm;
	}
	public double getGr_bill_amt() {
		return gr_bill_amt;
	}
	public void setGr_bill_amt(double gr_bill_amt) {
		this.gr_bill_amt = gr_bill_amt;
	}
	public double getRebate_amt() {
		return rebate_amt;
	}
	public void setRebate_amt(double rebate_amt) {
		this.rebate_amt = rebate_amt;
	}
	public double getNet_amt() {
		return net_amt;
	}
	public void setNet_amt(double net_amt) {
		this.net_amt = net_amt;
	}
	public Date getPay_due_dt() {
		return pay_due_dt;
	}
	public void setPay_due_dt(Date pay_due_dt) {
		this.pay_due_dt = pay_due_dt;
	}
	public String getCopy_by() {
		return copy_by;
	}
	public void setCopy_by(String copy_by) {
		this.copy_by = copy_by;
	}
	public Timestamp getCopy_dt() {
		return copy_dt;
	}
	public void setCopy_dt(Timestamp copy_dt) {
		this.copy_dt = copy_dt;
	}
    
    

}
