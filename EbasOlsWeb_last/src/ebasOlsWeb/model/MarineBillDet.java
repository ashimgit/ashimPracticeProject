package ebasOlsWeb.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="marine_bill_det")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class MarineBillDet {
	@Id
	@Column(name="son",length=20)
	private String son;
	
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;
	
	@Column(name="ves_name",length=30)
	private String ves_name;
	
	@Column(name="work_fr_dt")
	private Date work_fr_dt;
	
	@Column(name="work_fr_tm")
    private Timestamp work_fr_tm;
	
	@Column(name="work_fn_dt")
    private Date work_fn_dt;
	
	@Column(name="work_fn_tm")
    private Timestamp work_fn_tm;
	
	@Column(name="pan",length=10)
    private String pan;
	
	@Column(name="agent_cd",length=5)
    private String agent_cd;
	
	@Column(name="agent_nm",length=100)
    private String  agent_nm;
	
	@Column(name="bill_amt")
    private double bill_amt;
	
	@Column(name="paid_amt")
    private double paid_amt;
	
	@Column(name="due_amt")
    private double due_amt;
	
	@Column(name="refund_amt")
    private double refund_amt;
	
	@Column(name="copy_by",length=10)
    private String copy_by;
	
	@Column(name="copy_dt")
    private Timestamp copy_dt;

	public String getSon() {
		return son;
	}

	public void setSon(String son) {
		this.son = son;
	}

	public String getVes_opr_no() {
		return ves_opr_no;
	}

	public void setVes_opr_no(String ves_opr_no) {
		this.ves_opr_no = ves_opr_no;
	}

	public String getVes_name() {
		return ves_name;
	}

	public void setVes_name(String ves_name) {
		this.ves_name = ves_name;
	}

	public Date getWork_fr_dt() {
		return work_fr_dt;
	}

	public void setWork_fr_dt(Date work_fr_dt) {
		this.work_fr_dt = work_fr_dt;
	}

	public Timestamp getWork_fr_tm() {
		return work_fr_tm;
	}

	public void setWork_fr_tm(Timestamp work_fr_tm) {
		this.work_fr_tm = work_fr_tm;
	}

	public Date getWork_fn_dt() {
		return work_fn_dt;
	}

	public void setWork_fn_dt(Date work_fn_dt) {
		this.work_fn_dt = work_fn_dt;
	}

	public Timestamp getWork_fn_tm() {
		return work_fn_tm;
	}

	public void setWork_fn_tm(Timestamp work_fn_tm) {
		this.work_fn_tm = work_fn_tm;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
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

	public double getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(double bill_amt) {
		this.bill_amt = bill_amt;
	}

	public double getPaid_amt() {
		return paid_amt;
	}

	public void setPaid_amt(double paid_amt) {
		this.paid_amt = paid_amt;
	}

	public double getDue_amt() {
		return due_amt;
	}

	public void setDue_amt(double due_amt) {
		this.due_amt = due_amt;
	}

	public double getRefund_amt() {
		return refund_amt;
	}

	public void setRefund_amt(double refund_amt) {
		this.refund_amt = refund_amt;
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
