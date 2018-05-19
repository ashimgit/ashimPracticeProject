package testPac;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.connection.DBConnection;

public class Test {

	public static void main(String[] args) {
		
		try{
			
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String q1=null;
			
			con=DBConnection.getConnection();
			
			q1="select * from box_master";
			ps=con.prepareStatement(q1);
			rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("2= "+rs.getString(2));
				System.out.println("1= "+rs.getString(1));
			}
			
		}catch(Exception e){}

	}

}
