package ebasOlsWeb.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(PlanDepartureIdGroup.class)

public class PlanDepartureIdGroup implements Serializable{

	@Id
	@Column(name="opr_dt")
	private Date opr_dt;
	
	@Id
	@Column(name="berth_cd",length=5)
	private String berth_cd;
	
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;

	public PlanDepartureIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanDepartureIdGroup(Date opr_dt, String berth_cd, String ves_opr_no) {
		super();
		this.opr_dt = opr_dt;
		this.berth_cd = berth_cd;
		this.ves_opr_no = ves_opr_no;
	}

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
	
	
}
