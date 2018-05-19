package ebasOlsWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
@IdClass(VesCargoIdGroup.class)

public class VesCargoIdGroup implements Serializable{
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no ;
	
	@Id
	@Column(name="cargo_cd",length=5)
	private String cargo_cd;
	
	@Id
	@Column(name="opr_type",length=1)
	private String opr_type;

	public VesCargoIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VesCargoIdGroup(String ves_opr_no, String cargo_cd, String opr_type) {
		super();
		this.ves_opr_no = ves_opr_no;
		this.cargo_cd = cargo_cd;
		this.opr_type = opr_type;
	}

	public String getVes_opr_no() {
		return ves_opr_no;
	}

	public void setVes_opr_no(String ves_opr_no) {
		this.ves_opr_no = ves_opr_no;
	}

	public String getCargo_cd() {
		return cargo_cd;
	}

	public void setCargo_cd(String cargo_cd) {
		this.cargo_cd = cargo_cd;
	}

	public String getOpr_type() {
		return opr_type;
	}

	public void setOpr_type(String opr_type) {
		this.opr_type = opr_type;
	}
	
	

}
