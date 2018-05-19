package ebasOlsWeb.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="fin_ves_ber_cargo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(FinVesBerCargoIdGroup.class)

public class FinVesBerCargo {
	
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

	@Column(name="berth_from",length=20)
	private String berth_from;
	
	@Column(name="berth_from",length=20)
	private String berth_nm;
	
	@Column(name="berth_from",length=20)
	private String ves_name;
	
	@Column(name="berth_from",length=20)
    private Date haul_in_dt;
	
	@Column(name="berth_from",length=20)
    private Timestamp haul_in_tm;
	
	@Column(name="berth_from",length=20)
    private Date com_wk_dt;
	
	@Column(name="berth_from")
    private Timestamp com_wk_tm;
    
    @Column(name="cargo_wt",columnDefinition="Decimal(13,3) default 0.0")
    private double cargo_wt;
    
    @Column(name="cargo_num",columnDefinition="int default 0")
    private int cargo_num;
    
    @Column(name="hook_num",columnDefinition="int default 0")
    private int hook_num;
    
    @Column(name="cnt_20_ld",columnDefinition="int default 0")
    private int cnt_20_ld;
    
    @Column(name="cnt_40_ld",columnDefinition="int default 0")
    private int cnt_40_ld;
    
    @Column(name="cnt_av_ld",columnDefinition="int default 0")
    private int cnt_av_ld;
    
    @Column(name="cnt_20_emt",columnDefinition="int default 0")
    private int cnt_20_emt;
    
    @Column(name="cnt_40_emt",columnDefinition="int default 0")
    private int cnt_40_emt;
    
    @Column(name="cnt_av_emt",columnDefinition="int default 0")
    private int cnt_av_emt;
    
    @Column(name="fin_wk_dt")
    private Date fin_wk_dt;
    
    @Column(name="fin_wk_tm")
    private Timestamp fin_wk_tm;
    
    @Column(name="t_o_b")
    private int t_o_b;
    
    @Column(name="t_cnt_20_ld")
    private int t_cnt_20_ld;
    
    @Column(name="t_cnt_40_ld")
    private int t_cnt_40_ld;
    
    @Column(name="t_cnt_av_ld")
    private int t_cnt_av_ld;
    
    @Column(name="t_cnt_20_emt")
    private int t_cnt_20_emt;
    
    @Column(name="t_cnt_40_emt")
    private int t_cnt_40_emt;
    
    @Column(name="t_cnt_av_emt")
    private int t_cnt_av_emt;
    
    @Column(name="car_to_load",length=20)
    private int car_to_load;
    
    @Column(name="haul_out_dt")
    private Date haul_out_dt;
    
    @Column(name="haul_out_tm")
    private Timestamp haul_out_tm;
    
    @Column(name="to_cnt_20_ld",length=20)
    private int to_cnt_20_ld;
    
    @Column(name="to_cnt_40_ld")
    private int to_cnt_40_ld;
    
    @Column(name="to_cnt_av_ld")
    private int to_cnt_av_ld;
    
    @Column(name="to_cnt_20_emt")
    private int  to_cnt_20_emt;
    
    @Column(name="to_cnt_40_emt")
    private int to_cnt_40_emt;
    
    @Column(name="to_cnt_av_emt")
    private int to_cnt_av_emt;
    
    @Column(name="arr_ves",length=50)
    private String arr_ves;
    
    @Column(name="sft_ves",length=50)
    private String sft_ves;
    
    @Column(name="berth_ord")
    private int berth_ord;// integer,
    
    @Column(name="copy_dt")
    private Timestamp copy_dt;
    
    @Column(name="copy_by",length=10)
    private String copy_by;

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

	public String getBerth_from() {
		return berth_from;
	}

	public void setBerth_from(String berth_from) {
		this.berth_from = berth_from;
	}

	public String getBerth_nm() {
		return berth_nm;
	}

	public void setBerth_nm(String berth_nm) {
		this.berth_nm = berth_nm;
	}

	public String getVes_name() {
		return ves_name;
	}

	public void setVes_name(String ves_name) {
		this.ves_name = ves_name;
	}

	public Date getHaul_in_dt() {
		return haul_in_dt;
	}

	public void setHaul_in_dt(Date haul_in_dt) {
		this.haul_in_dt = haul_in_dt;
	}

	public Timestamp getHaul_in_tm() {
		return haul_in_tm;
	}

	public void setHaul_in_tm(Timestamp haul_in_tm) {
		this.haul_in_tm = haul_in_tm;
	}

	public Date getCom_wk_dt() {
		return com_wk_dt;
	}

	public void setCom_wk_dt(Date com_wk_dt) {
		this.com_wk_dt = com_wk_dt;
	}

	public Timestamp getCom_wk_tm() {
		return com_wk_tm;
	}

	public void setCom_wk_tm(Timestamp com_wk_tm) {
		this.com_wk_tm = com_wk_tm;
	}

	public double getCargo_wt() {
		return cargo_wt;
	}

	public void setCargo_wt(double cargo_wt) {
		this.cargo_wt = cargo_wt;
	}

	public int getCargo_num() {
		return cargo_num;
	}

	public void setCargo_num(int cargo_num) {
		this.cargo_num = cargo_num;
	}

	public int getHook_num() {
		return hook_num;
	}

	public void setHook_num(int hook_num) {
		this.hook_num = hook_num;
	}

	public int getCnt_20_ld() {
		return cnt_20_ld;
	}

	public void setCnt_20_ld(int cnt_20_ld) {
		this.cnt_20_ld = cnt_20_ld;
	}

	public int getCnt_40_ld() {
		return cnt_40_ld;
	}

	public void setCnt_40_ld(int cnt_40_ld) {
		this.cnt_40_ld = cnt_40_ld;
	}

	public int getCnt_av_ld() {
		return cnt_av_ld;
	}

	public void setCnt_av_ld(int cnt_av_ld) {
		this.cnt_av_ld = cnt_av_ld;
	}

	public int getCnt_20_emt() {
		return cnt_20_emt;
	}

	public void setCnt_20_emt(int cnt_20_emt) {
		this.cnt_20_emt = cnt_20_emt;
	}

	public int getCnt_40_emt() {
		return cnt_40_emt;
	}

	public void setCnt_40_emt(int cnt_40_emt) {
		this.cnt_40_emt = cnt_40_emt;
	}

	public int getCnt_av_emt() {
		return cnt_av_emt;
	}

	public void setCnt_av_emt(int cnt_av_emt) {
		this.cnt_av_emt = cnt_av_emt;
	}

	public Date getFin_wk_dt() {
		return fin_wk_dt;
	}

	public void setFin_wk_dt(Date fin_wk_dt) {
		this.fin_wk_dt = fin_wk_dt;
	}

	public Timestamp getFin_wk_tm() {
		return fin_wk_tm;
	}

	public void setFin_wk_tm(Timestamp fin_wk_tm) {
		this.fin_wk_tm = fin_wk_tm;
	}

	public int getT_o_b() {
		return t_o_b;
	}

	public void setT_o_b(int t_o_b) {
		this.t_o_b = t_o_b;
	}

	public int getT_cnt_20_ld() {
		return t_cnt_20_ld;
	}

	public void setT_cnt_20_ld(int t_cnt_20_ld) {
		this.t_cnt_20_ld = t_cnt_20_ld;
	}

	public int getT_cnt_40_ld() {
		return t_cnt_40_ld;
	}

	public void setT_cnt_40_ld(int t_cnt_40_ld) {
		this.t_cnt_40_ld = t_cnt_40_ld;
	}

	public int getT_cnt_av_ld() {
		return t_cnt_av_ld;
	}

	public void setT_cnt_av_ld(int t_cnt_av_ld) {
		this.t_cnt_av_ld = t_cnt_av_ld;
	}

	public int getT_cnt_20_emt() {
		return t_cnt_20_emt;
	}

	public void setT_cnt_20_emt(int t_cnt_20_emt) {
		this.t_cnt_20_emt = t_cnt_20_emt;
	}

	public int getT_cnt_40_emt() {
		return t_cnt_40_emt;
	}

	public void setT_cnt_40_emt(int t_cnt_40_emt) {
		this.t_cnt_40_emt = t_cnt_40_emt;
	}

	public int getT_cnt_av_emt() {
		return t_cnt_av_emt;
	}

	public void setT_cnt_av_emt(int t_cnt_av_emt) {
		this.t_cnt_av_emt = t_cnt_av_emt;
	}

	public int getCar_to_load() {
		return car_to_load;
	}

	public void setCar_to_load(int car_to_load) {
		this.car_to_load = car_to_load;
	}

	public Date getHaul_out_dt() {
		return haul_out_dt;
	}

	public void setHaul_out_dt(Date haul_out_dt) {
		this.haul_out_dt = haul_out_dt;
	}

	public Timestamp getHaul_out_tm() {
		return haul_out_tm;
	}

	public void setHaul_out_tm(Timestamp haul_out_tm) {
		this.haul_out_tm = haul_out_tm;
	}

	public int getTo_cnt_20_ld() {
		return to_cnt_20_ld;
	}

	public void setTo_cnt_20_ld(int to_cnt_20_ld) {
		this.to_cnt_20_ld = to_cnt_20_ld;
	}

	public int getTo_cnt_40_ld() {
		return to_cnt_40_ld;
	}

	public void setTo_cnt_40_ld(int to_cnt_40_ld) {
		this.to_cnt_40_ld = to_cnt_40_ld;
	}

	public int getTo_cnt_av_ld() {
		return to_cnt_av_ld;
	}

	public void setTo_cnt_av_ld(int to_cnt_av_ld) {
		this.to_cnt_av_ld = to_cnt_av_ld;
	}

	public int getTo_cnt_20_emt() {
		return to_cnt_20_emt;
	}

	public void setTo_cnt_20_emt(int to_cnt_20_emt) {
		this.to_cnt_20_emt = to_cnt_20_emt;
	}

	public int getTo_cnt_40_emt() {
		return to_cnt_40_emt;
	}

	public void setTo_cnt_40_emt(int to_cnt_40_emt) {
		this.to_cnt_40_emt = to_cnt_40_emt;
	}

	public int getTo_cnt_av_emt() {
		return to_cnt_av_emt;
	}

	public void setTo_cnt_av_emt(int to_cnt_av_emt) {
		this.to_cnt_av_emt = to_cnt_av_emt;
	}

	public String getArr_ves() {
		return arr_ves;
	}

	public void setArr_ves(String arr_ves) {
		this.arr_ves = arr_ves;
	}

	public String getSft_ves() {
		return sft_ves;
	}

	public void setSft_ves(String sft_ves) {
		this.sft_ves = sft_ves;
	}

	public int getBerth_ord() {
		return berth_ord;
	}

	public void setBerth_ord(int berth_ord) {
		this.berth_ord = berth_ord;
	}

	public Timestamp getCopy_dt() {
		return copy_dt;
	}

	public void setCopy_dt(Timestamp copy_dt) {
		this.copy_dt = copy_dt;
	}

	public String getCopy_by() {
		return copy_by;
	}

	public void setCopy_by(String copy_by) {
		this.copy_by = copy_by;
	}

    
    
}
