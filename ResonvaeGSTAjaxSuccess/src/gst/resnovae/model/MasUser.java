package gst.resnovae.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mas_user")
public class MasUser {
	String user_cd;
	String party_name;
	String role;
	String password;
	String user_by;
	Timestamp entry_ts;
	
	@Id
	public String getUser_cd() {
		return user_cd;
	}
	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_by() {
		return user_by;
	}
	public void setUser_by(String user_by) {
		this.user_by = user_by;
	}
	public Timestamp getEntry_ts() {
		return entry_ts;
	}
	public void setEntry_ts(Timestamp entry_ts) {
		this.entry_ts = entry_ts;
	}
	

}
