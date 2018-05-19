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
@Table(name="plan_departure")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(PlanDepartureIdGroup.class)
public class PlanDeparture {

	@Id
	@Column(name="opr_dt")
	private Date opr_dt;
	
	@Id
	@Column(name="berth_cd",length=5)
	private String berth_cd;
	
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;
	
	@Column(name="ves_name",length=30)
	private String ves_name;
	
	@Column(name="draft_fwd")
    private double draft_fwd;
	
	@Column(name="berth_nm",length=30)
    private String berth_nm;
	
	@Column(name="berth_ord")
    private int berth_ord;
	
	@Column(name="copy_by",length=10)
    private String copy_by;
	
	@Column(name="copy_dt")
    private Timestamp copy_dt;

	public Date getOpr_dt() {
		return opr_dt;
	}

	public void setOpr_dt(Date opr_dt) {
		this.opr_dt = opr_dt;
	}

	public String getBerth_cd() {
		return berth_cd;
	}

	public void setBerth_cd(String berth_cd) {
		this.berth_cd = berth_cd;
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

	public double getDraft_fwd() {
		return draft_fwd;
	}

	public void setDraft_fwd(double draft_fwd) {
		this.draft_fwd = draft_fwd;
	}

	public String getBerth_nm() {
		return berth_nm;
	}

	public void setBerth_nm(String berth_nm) {
		this.berth_nm = berth_nm;
	}

	public int getBerth_ord() {
		return berth_ord;
	}

	public void setBerth_ord(int berth_ord) {
		this.berth_ord = berth_ord;
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
