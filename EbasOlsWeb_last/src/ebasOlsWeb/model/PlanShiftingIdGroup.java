package ebasOlsWeb.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(PlanShiftingIdGroup.class)
public class PlanShiftingIdGroup implements Serializable{
	
	@Id
	@Column(name="opr_dt")
	private Date opr_dt;
	
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;

	@Id
	@Column(name="from_dt")
	private Date from_dt;
	
	@Id
	@Column(name="from_tm")
	private Timestamp from_tm;

	public PlanShiftingIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanShiftingIdGroup(Date opr_dt, String ves_opr_no, Date from_dt, Timestamp from_tm) {
		super();
		this.opr_dt = opr_dt;
		this.ves_opr_no = ves_opr_no;
		this.from_dt = from_dt;
		this.from_tm = from_tm;
	}

	public Date getOpr_dt() {
		return opr_dt;
	}

	public void setOpr_dt(Date opr_dt) {
		this.opr_dt = opr_dt;
	}

	public String getVes_opr_no() {
		return ves_opr_no;
	}

	public void setVes_opr_no(String ves_opr_no) {
		this.ves_opr_no = ves_opr_no;
	}

	public Date getFrom_dt() {
		return from_dt;
	}

	public void setFrom_dt(Date from_dt) {
		this.from_dt = from_dt;
	}

	public Timestamp getFrom_tm() {
		return from_tm;
	}

	public void setFrom_tm(Timestamp from_tm) {
		this.from_tm = from_tm;
	}
	
	


}
