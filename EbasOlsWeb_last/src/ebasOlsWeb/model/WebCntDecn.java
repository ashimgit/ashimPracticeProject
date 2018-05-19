package ebasOlsWeb.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="web_cnt_decn",schema="web")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(WebCntDecnIdGroup.class)
public class WebCntDecn {
	
	@Id
	@Column(name="vcn",length=14)
	private String vcn ;
	
	@Id
	@Column(name="purpose_cd",length=1)
	private String purpose_cd ;
	
	@Id
	@Column(name="mlo_cd",length=5)
	private String mlo_cd ;
	
	@Id
	@Column(name="cnt_no",length=12)
	private String cnt_no ;
	
	@Column(name="ves_name",length=30)
	private String ves_name ;
	
	@Column(name="arr_dt")
    private Date arr_dt ;
	
	@Column(name="dep_dt")
    private Date dep_dt;
	
	@Column(name="mlo_name",length=75)
    private String mlo_name ;
	
	@Column(name="iso_cd",length=4)
    private String iso_cd ;
	
	@Column(name="cnt_size")
    private int cnt_size ;
	
	@Column(name="lndc_status",length=3)
    private String lndc_status ;
	
	@Column(name="tare_wt")
    private double tare_wt ;
	
	@Column(name="gross_wt")
    private double gross_wt ;
	
	@Column(name="oprn_port_cd",length=6)
    private String oprn_port_cd ;
	
	@Column(name="orgn_port_cd",length=6)
    private String orgn_port_cd ;
	
	@Column(name="in_dt")
    private Date in_dt;
	
	@Column(name="out_dt")
    private Date out_dt;
	
	@Column(name="in_mode",length=1)
    private String in_mode ;
	
	@Column(name="out_mode",length=1)
    private String out_mode ;
	
	@Column(name="remarks",length=30)
    private String remarks ;
	
	
	public String getVcn() {
		return vcn;
	}
	public void setVcn(String vcn) {
		this.vcn = vcn;
	}
	public String getPurpose_cd() {
		return purpose_cd;
	}
	public void setPurpose_cd(String purpose_cd) {
		this.purpose_cd = purpose_cd;
	}
	public String getVes_name() {
		return ves_name;
	}
	public void setVes_name(String ves_name) {
		this.ves_name = ves_name;
	}
	public Date getArr_dt() {
		return arr_dt;
	}
	public void setArr_dt(Date arr_dt) {
		this.arr_dt = arr_dt;
	}
	public Date getDep_dt() {
		return dep_dt;
	}
	public void setDep_dt(Date dep_dt) {
		this.dep_dt = dep_dt;
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
	public String getCnt_no() {
		return cnt_no;
	}
	public void setCnt_no(String cnt_no) {
		this.cnt_no = cnt_no;
	}
	public String getIso_cd() {
		return iso_cd;
	}
	public void setIso_cd(String iso_cd) {
		this.iso_cd = iso_cd;
	}
	public int getCnt_size() {
		return cnt_size;
	}
	public void setCnt_size(int cnt_size) {
		this.cnt_size = cnt_size;
	}
	public String getLndc_status() {
		return lndc_status;
	}
	public void setLndc_status(String lndc_status) {
		this.lndc_status = lndc_status;
	}
	public double getTare_wt() {
		return tare_wt;
	}
	public void setTare_wt(double tare_wt) {
		this.tare_wt = tare_wt;
	}
	public double getGross_wt() {
		return gross_wt;
	}
	public void setGross_wt(double gross_wt) {
		this.gross_wt = gross_wt;
	}
	public String getOprn_port_cd() {
		return oprn_port_cd;
	}
	public void setOprn_port_cd(String oprn_port_cd) {
		this.oprn_port_cd = oprn_port_cd;
	}
	public String getOrgn_port_cd() {
		return orgn_port_cd;
	}
	public void setOrgn_port_cd(String orgn_port_cd) {
		this.orgn_port_cd = orgn_port_cd;
	}
	public Date getIn_dt() {
		return in_dt;
	}
	public void setIn_dt(Date in_dt) {
		this.in_dt = in_dt;
	}
	public Date getOut_dt() {
		return out_dt;
	}
	public void setOut_dt(Date out_dt) {
		this.out_dt = out_dt;
	}
	public String getIn_mode() {
		return in_mode;
	}
	public void setIn_mode(String in_mode) {
		this.in_mode = in_mode;
	}
	public String getOut_mode() {
		return out_mode;
	}
	public void setOut_mode(String out_mode) {
		this.out_mode = out_mode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
