package gst.resnovae.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//import com.google.gson.Gson;

import gst.resnovae.bean.MasParty;

import gst.resnovae.dao.MasUserDao;

public class MasUserImpl implements MasUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertMasParty(MasParty users) {
		System.out.println("this is MasPartyImpl");
		String party_cd = this.generateUserSeq("PARTYCD", "PARTY");
		String sql = "INSERT INTO mas_party(party_cd,party_name,com_addr1,com_addr2,com_addr3,com_pin, ";
		sql += "com_state,com_phone1,com_phone2,com_email,com_pan,com_gstin,remarks,user_by,entry_ts,role,";
		sql += "type) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?)";
		jdbcTemplate.update(sql,
				new Object[] { new String(party_cd), new String(users.getUsername()), new String(users.getAddr1()),
						users.getAddr2(), users.getAddr3(), users.getPin(), users.getState(), users.getPh1(),
						users.getPh2(), users.getEmail(), users.getPan(), users.getGstin(), users.getRemarks(),
						new String("MAS_USER"), "TEST_ROLE", "TEST_TYPE" });

		// jdbcTemplate.update(sql, new Object[]{new
		// String(users.getUsername()),new String(users.getAddr1())});

		return 0;
	}

	private String generateUserSeq(String type, String group) {
		String userCd = "";
		String seq = "";
		int sl_no = 0;

		String sql = "SELECT seq,sl_no FROM resnovae.mas_seq WHERE type=? AND seq_grp=? AND upto_dt IS NULL";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				new Object[] { new String(type), new String(group) });
		for (Map<String, Object> row : rows) {
			seq = (String) row.get("seq");
			sl_no = (Integer) row.get("sl_no");
			sl_no++;
			System.out.println("Sequence= " + seq + "  and sl no= " + sl_no);
		}
		return userCd = seq + sl_no;
	}

	public List<String> productMaster() {
		List<String> products = new ArrayList<String>();
		String sql = "SELECT parent_pid, parent_pname FROM resnovae.product_header";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] {});
		for (Map<String, Object> row : rows) {
			String pid = (String) row.get("parent_pid");
			String pname = (String) row.get("parent_pname");

			products.add(pname + " ||" + pid);
		}

		return products;
	}

}
