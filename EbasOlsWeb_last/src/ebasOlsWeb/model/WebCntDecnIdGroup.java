package ebasOlsWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(WebCntDecnIdGroup.class)
public class WebCntDecnIdGroup implements Serializable{
	
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
	
	public WebCntDecnIdGroup() {
		super();
		
	}
	
	public WebCntDecnIdGroup(String vcn, String purpose_cd, String mlo_cd, String cnt_no) {
		super();
		this.vcn = vcn;
		this.purpose_cd = purpose_cd;
		this.mlo_cd = mlo_cd;
		this.cnt_no = cnt_no;
	}
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
	public String getMlo_cd() {
		return mlo_cd;
	}
	public void setMlo_cd(String mlo_cd) {
		this.mlo_cd = mlo_cd;
	}
	public String getCnt_no() {
		return cnt_no;
	}
	public void setCnt_no(String cnt_no) {
		this.cnt_no = cnt_no;
	}

}
