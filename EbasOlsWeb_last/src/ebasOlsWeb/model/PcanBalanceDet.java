package ebasOlsWeb.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name="pcan_balance_det")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(PcanBalanceDetIdGroup.class)
public class PcanBalanceDet {

	@Id
	@Column(name="pcan",length=16)
	private String pcan;
	
	@Id
	@Column(name="srv_cd",length=3)
	private String srv_cd;

	@Column(name="srv_desc",length=30)
	private String srv_desc;
	
	@Column(name="pan",length=10)
	private String pan;
	
	@Column(name="agent_cd",length=5)
	private String agent_cd;
	
	@Column(name="agent_nm",length=100)
	private String agent_nm;
	
	@Column(name="cur_bal_amt")
	private double cur_bal_amt;
	
	@Column(name="reserve_amt")
	private double reserve_amt;
	
	@Column(name="min_bal_amt")
	private double min_bal_amt;
	
	@Column(name="net_bal_amt")
	private double net_bal_amt;
	
	@Column(name="remark",length=100)
    private String remark;
	
	@Column(name="copy_by",length=10)
    private String copy_by;
	
	@Column(name="copy_dt")
    private Timestamp copy_dt;

	public String getPcan() {
		return pcan;
	}

	public void setPcan(String pcan) {
		this.pcan = pcan;
	}

	public String getSrv_cd() {
		return srv_cd;
	}

	public void setSrv_cd(String srv_cd) {
		this.srv_cd = srv_cd;
	}

	public String getSrv_desc() {
		return srv_desc;
	}

	public void setSrv_desc(String srv_desc) {
		this.srv_desc = srv_desc;
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

	public double getCur_bal_amt() {
		return cur_bal_amt;
	}

	public void setCur_bal_amt(double cur_bal_amt) {
		this.cur_bal_amt = cur_bal_amt;
	}

	public double getReserve_amt() {
		return reserve_amt;
	}

	public void setReserve_amt(double reserve_amt) {
		this.reserve_amt = reserve_amt;
	}

	public double getMin_bal_amt() {
		return min_bal_amt;
	}

	public void setMin_bal_amt(double min_bal_amt) {
		this.min_bal_amt = min_bal_amt;
	}

	public double getNet_bal_amt() {
		return net_bal_amt;
	}

	public void setNet_bal_amt(double net_bal_amt) {
		this.net_bal_amt = net_bal_amt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
