package gst.test;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDaoImpl implements TestDao{
	private JdbcTemplate jdbcTemplate;
	
	
	/*public void setDataSource(DataSource ds){
		this.jdbcTemplate=new JdbcTemplate(ds);
	}*/
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(String a, String b) {
		String query="INSERT INTO test(tid,tname) VALUES(?,?)";
		jdbcTemplate.update(query, new Object[]{Integer.valueOf(10),new String("asdfg")});
		return 0;
	}

	public int update(String a, String b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	 
	 public Forum selectForum(int forumId) {
		
		 //* Specify the statement
		 
		String query = "SELECT * FROM FORUMS WHERE FORUM_ID=?";
		
		 //* Implement the RowMapper callback interface
		 
		return (Forum) jdbcTemplate.queryForObject(query, new Object[] { Integer.valueOf(forumId) }, 
				new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
						return new Forum(resultSet.getInt("FORUM_ID"), resultSet.getString("FORUM_NAME"), 
								resultSet.getString("FORUM_DESC"));
					}
				});
	}
	 
	 */
	
}
