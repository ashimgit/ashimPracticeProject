package ebasOlsWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;


@IdClass(WebCntSmryIdGroup.class)
public class WebCntSmryIdGroup implements Serializable{
	
	@Id
	@Column(name="purpose_cd",columnDefinition="varchar(1) default 'I'")
	private String purpose_cd;
	
	@Id
	@Column(name="vcn",length=14)
	private String vcn;
	
	@Id
	@Column(name="mlo_cd",length=5)
	private String mlo_cd;

	public WebCntSmryIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebCntSmryIdGroup(String purpose_cd, String vcn, String mlo_cd) {
		super();
		this.purpose_cd = purpose_cd;
		this.vcn = vcn;
		this.mlo_cd = mlo_cd;
	}

	public String getPurpose_cd() {
		return purpose_cd;
	}

	public void setPurpose_cd(String purpose_cd) {
		this.purpose_cd = purpose_cd;
	}

	public String getVcn() {
		return vcn;
	}

	public void setVcn(String vcn) {
		this.vcn = vcn;
	}

	public String getMlo_cd() {
		return mlo_cd;
	}

	public void setMlo_cd(String mlo_cd) {
		this.mlo_cd = mlo_cd;
	}
	
	

}
