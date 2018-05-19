package ebasOlsWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="web_cnt_smry",schema="web")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(WebCntSmryIdGroup.class)
public class WebCntSmry {
	
	@Id
	@Column(name="purpose_cd",columnDefinition="varchar(1) default 'I'")
	private String purpose_cd;
	
	@Id
	@Column(name="vcn",length=14)
	private String vcn;
	
	@Id
	@Column(name="mlo_cd",length=5)
	private String mlo_cd;
	
	@Column(name="ves_name",length=20)
	private String ves_name;
	
	@Column(name="mlo_name",length=20)
	private String mlo_name;
	
	@Column(name="l20_cnt")
    private int l20_cnt;
    
    @Column(name="l40_cnt")
    private int l40_cnt;
    
    @Column(name="l45_cnt")
    private int l45_cnt;
    
    @Column(name="lto_cnt")
    private int lto_cnt;
    
    @Column(name="e20_cnt")
    private int e20_cnt;
    
    @Column(name="e40_cnt")
    private int e40_cnt;
    
    @Column(name="e45_cnt")
    private int e45_cnt;
    
    @Column(name="eto_cnt")
    private int eto_cnt;
    
    @Column(name="tot_cnt")
    private int tot_cnt;
    
    @Column(name="tot_teus")
    private int tot_teus;
    
    @Column(name="tot_grwt")
    private double  tot_grwt;

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

	public String getVes_name() {
		return ves_name;
	}

	public void setVes_name(String ves_name) {
		this.ves_name = ves_name;
	}

	public String getMlo_name() {
		return mlo_name;
	}

	public void setMlo_name(String mlo_name) {
		this.mlo_name = mlo_name;
	}

	public int getL20_cnt() {
		return l20_cnt;
	}

	public void setL20_cnt(int l20_cnt) {
		this.l20_cnt = l20_cnt;
	}

	public int getL40_cnt() {
		return l40_cnt;
	}

	public void setL40_cnt(int l40_cnt) {
		this.l40_cnt = l40_cnt;
	}

	public int getL45_cnt() {
		return l45_cnt;
	}

	public void setL45_cnt(int l45_cnt) {
		this.l45_cnt = l45_cnt;
	}

	public int getLto_cnt() {
		return lto_cnt;
	}

	public void setLto_cnt(int lto_cnt) {
		this.lto_cnt = lto_cnt;
	}

	public int getE20_cnt() {
		return e20_cnt;
	}

	public void setE20_cnt(int e20_cnt) {
		this.e20_cnt = e20_cnt;
	}

	public int getE40_cnt() {
		return e40_cnt;
	}

	public void setE40_cnt(int e40_cnt) {
		this.e40_cnt = e40_cnt;
	}

	public int getE45_cnt() {
		return e45_cnt;
	}

	public void setE45_cnt(int e45_cnt) {
		this.e45_cnt = e45_cnt;
	}

	public int getEto_cnt() {
		return eto_cnt;
	}

	public void setEto_cnt(int eto_cnt) {
		this.eto_cnt = eto_cnt;
	}

	public int getTot_cnt() {
		return tot_cnt;
	}

	public void setTot_cnt(int tot_cnt) {
		this.tot_cnt = tot_cnt;
	}

	public int getTot_teus() {
		return tot_teus;
	}

	public void setTot_teus(int tot_teus) {
		this.tot_teus = tot_teus;
	}

	public double getTot_grwt() {
		return tot_grwt;
	}

	public void setTot_grwt(double tot_grwt) {
		this.tot_grwt = tot_grwt;
	}
    
    

}
