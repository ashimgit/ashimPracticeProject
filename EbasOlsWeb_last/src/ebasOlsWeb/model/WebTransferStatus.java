package ebasOlsWeb.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@Table(name="web_transfer_status")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class WebTransferStatus {

	@Column(name="tab_nm",length=20,nullable=false)
	private String	tab_nm;// character varying(20) COLLATE pg_catalog."default" NOT NULL,
	
	@Column(name="update_dttm")
    private Timestamp update_dttm;// timestamp without time zone,
	
	@Column(name="update_status",length=5)
	private String update_status;// character varying(10) COLLATE pg_catalog."default"

	public String getTab_nm() {
		return tab_nm;
	}

	public void setTab_nm(String tab_nm) {
		this.tab_nm = tab_nm;
	}

	public Timestamp getUpdate_dttm() {
		return update_dttm;
	}

	public void setUpdate_dttm(Timestamp update_dttm) {
		this.update_dttm = update_dttm;
	}

	public String getUpdate_status() {
		return update_status;
	}

	public void setUpdate_status(String update_status) {
		this.update_status = update_status;
	}
	
	
    
}
