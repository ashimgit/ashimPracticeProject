<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="connection.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Updating GateKeeper Cum Tower</title>
</head>
<body>

<%
connection con=new connection();
Connection con11=con.Connect();

Connection con33=con.Connect();
Connection con44=con.Connect();
Connection con55=con.Connect();
try{
		Statement stmt=con11.createStatement();
		String q="select indus_tower_id,tower_latitude,tower_longitude,tower_site,District,tower_type,gatekeeper_name,gatekeeper_mobile,clustermanager_mobile,tower_address from Sheet1 where indus_tower_id =1289611";
		System.out.println(q);
		ResultSet rs=stmt.executeQuery(q);
		int count = 1;
		while(rs.next())
		{
			String indus_id = rs.getString(1);
			String tower_latitude = rs.getString(2);
			String tower_longitude = rs.getString(3);
			String tower_site = rs.getString(4);
			String District_name = rs.getString(5);
			String tower_type = rs.getString(6);
			String gatekeeper_name = rs.getString(7);
			String gatekeeper_mobile = rs.getString(8);
			String clustermanager_mobile = rs.getString(9);
			String tower_address = rs.getString(10);
			int serviceprovider_id = 70;
			int gatekeeper_type = 2;
			int District = 21;
			
			ResultSet rs110=null;
			String tower_details = "select indus_tower_id from tower_master where indus_tower_id like '%"+indus_id+"%' ";
			System.out.println(tower_details);
			Connection con2220=con.Connect();
			Statement stmt110=con2220.createStatement();
			rs110=stmt110.executeQuery(tower_details);
			boolean b110 = rs110.next();
			if(b110)
			{
				String indus_tower_id = rs110.getString(1);
				System.out.println("indus_tower_id: "+indus_tower_id +" Already Present");
			}
			else
			{
				ResultSet rs10=null;
				String district_details = "select district_id from district_master where district_name like '%"+District_name+"%' ";
				System.out.println(district_details);
				Connection con220=con.Connect();
				Statement stmt10=con220.createStatement();
				rs10=stmt10.executeQuery(district_details);
				boolean b10 = rs10.next();
				if(b10)
				{
					District = Integer.parseInt(rs10.getString(1));
				}
				System.out.println("District: "+District);
				System.out.println("count: "+count++);
				System.out.println("serviceprovider_id: "+serviceprovider_id);
				System.out.println("Gatekeeper Number New: "+gatekeeper_mobile);
				ResultSet rs1=null;
				String q1="select gatekeeper_mobile from gatekeeper_master where gatekeeper_mobile like '%"+gatekeeper_mobile+"%' ";
				System.out.println(q1);
				Connection con22=con.Connect();
				Statement stmt1=con22.createStatement();
				rs1=stmt1.executeQuery(q1);
				boolean b=rs1.next();
				System.out.println("loooooooooooook into b :: "+b);

				if(b)
				{
					String gatekeeper_mobile1 = rs1.getString(1);
					System.out.println("Gatekeeper Number Old : "+gatekeeper_mobile1);
					System.out.println("Gatekeeper Present");
					String q4 = "insert into tower_master(indus_tower_id,tower_latitude,tower_longitude,tower_site,district_id,tower_type,gatekeeper_mobile,clustermanager_mobile,tower_address,serviceprovider_id) values(?,?,?,?,?,?,?,?,?,?) ";
					PreparedStatement pst = con44.prepareStatement(q4);
					pst.setString(1, indus_id);
					pst.setString(2, tower_latitude);
					pst.setString(3, tower_longitude);
					pst.setString(4, tower_site);
					pst.setInt(5, District);
					pst.setString(6, tower_type);
					pst.setString(7, gatekeeper_mobile);
					pst.setString(8, clustermanager_mobile);
					pst.setString(9, tower_address);
					pst.setInt(10, serviceprovider_id);
					int t = pst.executeUpdate();
					if(t > 0)
					{
						System.out.println("Tower ID : "+indus_id+" Inserted Successfully");%><br><%
					}
					else
					{
						System.out.println("Tower ID : "+indus_id+" Not Inserted Successfully");%><br><%
					}
					con44.commit();
					pst.close();
				}
				else// New GateKeeper
				{
					System.out.println("Gatekeeper Not Present");
					String q3 = "insert into gatekeeper_master(gatekeeper_name,gatekeeper_mobile,serviceprovider_id,gatekeeper_type) values(?,?,?,?) ";
					PreparedStatement pst3 = con33.prepareStatement(q3);
					pst3.setString(1, gatekeeper_name);
					pst3.setString(2, gatekeeper_mobile);
					pst3.setInt(3, serviceprovider_id);
					pst3.setInt(4, gatekeeper_type);
					int t3 = pst3.executeUpdate();
					System.out.println("t3 ********** :: "+t3);
					if(t3 > 0)
						t3 = 1;
					else
						t3 = 0;
					con33.commit();
					pst3.close();
			
					String q4 = "insert into tower_master(indus_tower_id,tower_latitude,tower_longitude,tower_site,district_id,tower_type,gatekeeper_mobile,clustermanager_mobile,tower_address,serviceprovider_id) values(?,?,?,?,?,?,?,?,?,?) ";
					PreparedStatement pst55 = con55.prepareStatement(q4);
					pst55.setString(1, indus_id);
					pst55.setString(2, tower_latitude);
					pst55.setString(3, tower_longitude);
					pst55.setString(4, tower_site);
					pst55.setInt(5, District);
					pst55.setString(6, tower_type);
					pst55.setString(7, gatekeeper_mobile);
					pst55.setString(8, clustermanager_mobile);
					pst55.setString(9, tower_address);
					pst55.setInt(10, serviceprovider_id);
					int t1 = pst55.executeUpdate();
					System.out.println("t1 ********** :: "+t1);
					if(t1 > 0)
					{
						System.out.println("Tower ID : "+indus_id+" Inserted Successfully");%><br><%
					}
					else
					{
						System.out.println("Tower ID : "+indus_id+" Not Inserted Successfully");%><br><%
					}
					con55.commit();
					pst55.close();
				}
			
				stmt1.close();	
				con22.close();
			}
		
			con55.close();
			con44.close();
			con33.close();
		}
			con11.close();
		
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		out.println(e);
	} 



%>
</body>
</html>