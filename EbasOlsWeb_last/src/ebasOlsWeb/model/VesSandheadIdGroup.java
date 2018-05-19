package ebasOlsWeb.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(VesSandheadIdGroup.class)
public class VesSandheadIdGroup implements Serializable {

	@Id
	@Column(name="opr_dt")
	private Date opr_dt;
	
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;

	public VesSandheadIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VesSandheadIdGroup(Date opr_dt, String ves_opr_no) {
		super();
		this.opr_dt = opr_dt;
		this.ves_opr_no = ves_opr_no;
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
	
	
}
