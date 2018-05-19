package ebasOlsWeb.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(FinVesBerCargoIdGroup.class)

public class FinVesBerCargoIdGroup implements Serializable{
	
	@Id
	@Column(name="opr_dt")
	private Date opr_dt;
	
	@Id
	@Column(name="berth_cd",length=5)
	private String berth_cd;
	
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;
	
	@Id
	@Column(name="purpose_cd",length=1)
	private String purpose_cd;
	
	@Id
	@Column(name="cargo_cd",length=5)
	private String cargo_cd;
	
	@Id
	@Column(name="div_cd",length=2)
	private String div_cd;

	public FinVesBerCargoIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinVesBerCargoIdGroup(Date opr_dt, String berth_cd, String ves_opr_no, String purpose_cd, String cargo_cd,
			String div_cd) {
		super();
		this.opr_dt = opr_dt;
		this.berth_cd = berth_cd;
		this.ves_opr_no = ves_opr_no;
		this.purpose_cd = purpose_cd;
		this.cargo_cd = cargo_cd;
		this.div_cd = div_cd;
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

	public String getPurpose_cd() {
		return purpose_cd;
	}

	public void setPurpose_cd(String purpose_cd) {
		this.purpose_cd = purpose_cd;
	}

	public String getCargo_cd() {
		return cargo_cd;
	}

	public void setCargo_cd(String cargo_cd) {
		this.cargo_cd = cargo_cd;
	}

	public String getDiv_cd() {
		return div_cd;
	}

	public void setDiv_cd(String div_cd) {
		this.div_cd = div_cd;
	}
	
	

}
