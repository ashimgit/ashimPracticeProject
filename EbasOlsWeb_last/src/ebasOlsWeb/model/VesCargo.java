package ebasOlsWeb.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name="ves_cargo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(VesCargoIdGroup.class)
public class VesCargo {

	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no ;
	
	@Id
	@Column(name="cargo_cd",length=5)
	private String cargo_cd;
	
	@Id
	@Column(name="opr_type",length=1)
	private String opr_type;
	
	@Column(name="qty")
	private int qty;
	
	@Column(name="copy_by",length=10)
	private String copy_by;// character varying(10) COLLATE pg_catalog."default",
	
	@Column(name="copy_dt")
	private Timestamp copy_dt;

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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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
