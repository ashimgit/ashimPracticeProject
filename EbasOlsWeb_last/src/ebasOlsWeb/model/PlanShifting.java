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
@Table(name="plan_departure")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(PlanShiftingIdGroup.class)

public class PlanShifting {

	@Id
	@Column(name="opr_dt")
	private Date opr_dt;
	
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;

	@Id
	@Column(name="from_dt")
	private Date from_dt;
	
	@Id
	@Column(name="from_tm")
	private Timestamp from_tm;
	
	@Column(name="fr_berth_cd",length=5)
	private String fr_berth_cd;
	
	@Column(name="to_berth_cd",length=5)
	private String to_berth_cd;
	
	@Column(name="ves_name",length=30)
	private String ves_name;
	
	@Column(name="remark",length=30)
	private String remark;
	
	@Column(name="fr_berth_nm",length=30)
	private String fr_berth_nm;
	
	@Column(name="to_berth_nm",length=30)
	private String to_berth_nm;
	
	@Column(name="berth_ord")
	private int berth_ord;
	
	@Column(name="copy_by",length=10)
    private String copy_by;
	
	@Column(name="copy_dt")
    private Timestamp copy_dt;
}
