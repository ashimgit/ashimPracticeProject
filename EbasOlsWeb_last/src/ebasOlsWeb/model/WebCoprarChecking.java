package ebasOlsWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="web_coprar_checking")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class WebCoprarChecking {

	
	@Column(name="cargo_cd",length=50,nullable=false)
	private String	vcn;// character varying(50) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="ves_name",length=50,nullable=false)
	private String ves_name;// character varying(50) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="comm_ref_no",length=50,nullable=false)
	private String comm_ref_no;// character varying(50) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="doc_srl",length=50,nullable=false)
	private String doc_srl;// character varying(50) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="cont_no",length=50,nullable=false)
	private String cont_no;// character varying(50) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="equip_status_cd",length=10,nullable=false)
	private String equip_status_cd;// character varying(10) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="cont_type_cd",length=20,nullable=false)
	private String cont_type_cd;// character varying(20) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="iso_cd",length=20,nullable=false)
	private String iso_cd;// character varying(20) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="cont_tare_wt",nullable=false)
	private double cont_tare_wt;// numeric(6, 2) NOT NULL,
	
	@Column(name="cont_gross_wt",nullable=false)
	private double cont_gross_wt;// numeric(6, 2) NOT NULL,
	
	@Column(name="arr_cd",length=10,nullable=false)
	private String arr_cd;// character varying(10) COLLATE pg_catalog."default" NOT NULL DEFAULT '0'::character varying,
	
	@Column(name="dep_cd",length=10,nullable=false)
	private String dep_cd;// character varying(10) COLLATE pg_catalog."default" NOT NULL DEFAULT '0'::character varying,
	
	@Column(name="poo_cd",length=10,nullable=false)
	private String poo_cd;// character varying(10) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="pol_cd",length=10,nullable=false)
	private String pol_cd;// character varying(10) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="cargo_cd",length=50,nullable=false)
	private String pod_cd ;//character varying(10) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="pof_cd",length=10,nullable=false)
	private String pof_cd;// character varying(10) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="sender_id",length=10,nullable=false)
	private String sender_id;// character varying(10) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="mlo_cd",length=6,nullable=false)
	private String mlo_cd;// character varying(6) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="mlo_name",length=100,nullable=false)
	private String mlo_name;// character varying(100) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="action_yn",length=1,nullable=false)
	private String action_yn;// character varying(1) COLLATE pg_catalog."default" NOT NULL

	public String getVcn() {
		return vcn;
	}

	public void setVcn(String vcn) {
		this.vcn = vcn;
	}

	public String getVes_name() {
		return ves_name;
	}

	public void setVes_name(String ves_name) {
		this.ves_name = ves_name;
	}

	public String getComm_ref_no() {
		return comm_ref_no;
	}

	public void setComm_ref_no(String comm_ref_no) {
		this.comm_ref_no = comm_ref_no;
	}

	public String getDoc_srl() {
		return doc_srl;
	}

	public void setDoc_srl(String doc_srl) {
		this.doc_srl = doc_srl;
	}

	public String getCont_no() {
		return cont_no;
	}

	public void setCont_no(String cont_no) {
		this.cont_no = cont_no;
	}

	public String getEquip_status_cd() {
		return equip_status_cd;
	}

	public void setEquip_status_cd(String equip_status_cd) {
		this.equip_status_cd = equip_status_cd;
	}

	public String getCont_type_cd() {
		return cont_type_cd;
	}

	public void setCont_type_cd(String cont_type_cd) {
		this.cont_type_cd = cont_type_cd;
	}

	public String getIso_cd() {
		return iso_cd;
	}

	public void setIso_cd(String iso_cd) {
		this.iso_cd = iso_cd;
	}

	public double getCont_tare_wt() {
		return cont_tare_wt;
	}

	public void setCont_tare_wt(double cont_tare_wt) {
		this.cont_tare_wt = cont_tare_wt;
	}

	public double getCont_gross_wt() {
		return cont_gross_wt;
	}

	public void setCont_gross_wt(double cont_gross_wt) {
		this.cont_gross_wt = cont_gross_wt;
	}

	public String getArr_cd() {
		return arr_cd;
	}

	public void setArr_cd(String arr_cd) {
		this.arr_cd = arr_cd;
	}

	public String getDep_cd() {
		return dep_cd;
	}

	public void setDep_cd(String dep_cd) {
		this.dep_cd = dep_cd;
	}

	public String getPoo_cd() {
		return poo_cd;
	}

	public void setPoo_cd(String poo_cd) {
		this.poo_cd = poo_cd;
	}

	public String getPol_cd() {
		return pol_cd;
	}

	public void setPol_cd(String pol_cd) {
		this.pol_cd = pol_cd;
	}

	public String getPod_cd() {
		return pod_cd;
	}

	public void setPod_cd(String pod_cd) {
		this.pod_cd = pod_cd;
	}

	public String getPof_cd() {
		return pof_cd;
	}

	public void setPof_cd(String pof_cd) {
		this.pof_cd = pof_cd;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getMlo_cd() {
		return mlo_cd;
	}

	public void setMlo_cd(String mlo_cd) {
		this.mlo_cd = mlo_cd;
	}

	public String getMlo_name() {
		return mlo_name;
	}

	public void setMlo_name(String mlo_name) {
		this.mlo_name = mlo_name;
	}

	public String getAction_yn() {
		return action_yn;
	}

	public void setAction_yn(String action_yn) {
		this.action_yn = action_yn;
	}
	
	
}
