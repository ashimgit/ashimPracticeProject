package ebasOlsWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(PcanBalanceDetIdGroup.class)

public class PcanBalanceDetIdGroup implements Serializable{
	
	@Id
	@Column(name="pcan",length=16)
	private String pcan;
	
	@Id
	@Column(name="srv_cd",length=3)
	private String srv_cd;

	public PcanBalanceDetIdGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PcanBalanceDetIdGroup(String pcan, String srv_cd) {
		super();
		this.pcan = pcan;
		this.srv_cd = srv_cd;
	}

	public String getPcan() {
		return pcan;
	}

	public void setPcan(String pcan) {
		this.pcan = pcan;
	}

	public String getSrv_cd() {
		return srv_cd;
	}

	public void setSrv_cd(String srv_cd) {
		this.srv_cd = srv_cd;
	}
	
	

}
