package ebasOlsWeb.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="pay_process_det")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class PayProcessDet {

	@Id
	@Column(name="as_ref_no",length=20)
	private String as_ref_no;
	
	@Column(name="as_ref_dt")
	private Date as_ref_dt;
	
	@Column(name="pan",length=10)
    private String pan;
	
	@Column(name="party_cd",length=5)
    private String party_cd;
	
	@Column(name="party_nm",length=100)
    private String party_nm;
	
	@Column(name="party_bill_no",length=40)
    private String party_bill_no;
	
	@Column(name="party_bill_dt")
    private Date party_bill_dt;
	
	@Column(name="order_no",length=40)
    private String order_no;
	
	@Column(name="order_dt")
    private Date order_dt;
	
	@Column(name="pay_ref_no",length=40)
    private String pay_ref_no;
	
	@Column(name="pay_ref_dt")
    private Date pay_ref_dt;
	
	@Column(name="pass_amt")
    private double pass_amt;
	
	@Column(name="net_amt")
    private double net_amt;
	
	@Column(name="copy_by",length=10)
    private String copy_by;
	
	@Column(name="copy_dt")
    private Timestamp copy_dt;

	public String getAs_ref_no() {
		return as_ref_no;
	}

	public void setAs_ref_no(String as_ref_no) {
		this.as_ref_no = as_ref_no;
	}

	public Date getAs_ref_dt() {
		return as_ref_dt;
	}

	public void setAs_ref_dt(Date as_ref_dt) {
		this.as_ref_dt = as_ref_dt;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getParty_cd() {
		return party_cd;
	}

	public void setParty_cd(String party_cd) {
		this.party_cd = party_cd;
	}

	public String getParty_nm() {
		return party_nm;
	}

	public void setParty_nm(String party_nm) {
		this.party_nm = party_nm;
	}

	public String getParty_bill_no() {
		return party_bill_no;
	}

	public void setParty_bill_no(String party_bill_no) {
		this.party_bill_no = party_bill_no;
	}

	public Date getParty_bill_dt() {
		return party_bill_dt;
	}

	public void setParty_bill_dt(Date party_bill_dt) {
		this.party_bill_dt = party_bill_dt;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public Date getOrder_dt() {
		return order_dt;
	}

	public void setOrder_dt(Date order_dt) {
		this.order_dt = order_dt;
	}

	public String getPay_ref_no() {
		return pay_ref_no;
	}

	public void setPay_ref_no(String pay_ref_no) {
		this.pay_ref_no = pay_ref_no;
	}

	public Date getPay_ref_dt() {
		return pay_ref_dt;
	}

	public void setPay_ref_dt(Date pay_ref_dt) {
		this.pay_ref_dt = pay_ref_dt;
	}

	public double getPass_amt() {
		return pass_amt;
	}

	public void setPass_amt(double pass_amt) {
		this.pass_amt = pass_amt;
	}

	public double getNet_amt() {
		return net_amt;
	}

	public void setNet_amt(double net_amt) {
		this.net_amt = net_amt;
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
