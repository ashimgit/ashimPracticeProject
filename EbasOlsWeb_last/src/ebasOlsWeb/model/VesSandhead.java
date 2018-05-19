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
@Table(name="ves_sandhead")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(VesSandheadIdGroup.class)

public class VesSandhead {

	@Id
	@Column(name="opr_dt")
	private Date opr_dt;
	
	@Id
	@Column(name="ves_opr_no",length=12)
	private String ves_opr_no;
	
	@Column(name="ves_name",length=30)
	private String ves_name;
	
	@Column(name="opr_dt")
	private Date eta_dt;
	
	@Column(name="opr_dt")
    private Timestamp eta_tm;
	
	@Column(name="anc_dt")
    private Date anc_dt; 
	
	@Column(name="anc_tm")
    private Timestamp anc_tm; 
    
    @Column(name="loa")
    private double loa;
    
    @Column(name="draft_fwd")
    private double draft_fwd; 
    
    @Column(name="receiver_nm",length=20)
    private String receiver_nm;
    
    @Column(name="shipper_nm",length=20)
    private String shipper_nm;
    
    @Column(name="reason_cd",length=2)
    private String reason_cd;
    
    @Column(name="reason_desc",length=100)
    private String reason_desc;
    
    @Column(name="copy_by",length=10)
    private String copy_by;
    
    @Column(name="copy_dt")
    private Timestamp copy_dt; 
}
