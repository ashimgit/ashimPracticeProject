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
		String q="select indus_tower_id,gatekeeper_mobile,clustermanager_mobile,gatekeeper_name from Sheet1 ";
		System.out.println(q);
		ResultSet rs=stmt.executeQuery(q);
		int count = 1;
		while(rs.next())
		{
			String indus_id = rs.getString(1);
			String number = rs.getString(2);
			String s_number = rs.getString(3);
			String t_name = rs.getString(4);
			int gatekeeper_type = 2;
			int serviceprovider_id = 70;
			out.println("count: "+count++);
			System.out.println("serviceprovider_id: "+serviceprovider_id);
			System.out.println("Gatekeeper Number New: "+number);
			ResultSet rs1=null;
			String q1="select gatekeeper_mobile from gatekeeper_master where gatekeeper_mobile like '%"+number+"%' ";
			System.out.println(q1);
			Connection con22=con.Connect();
			Statement stmt1=con22.createStatement();
			rs1=stmt1.executeQuery(q1);
			boolean b=rs1.next();
			System.out.println("loooooooooooook into b :: "+b);

			if(b)
			{
				String gatekeeper_mobile = rs1.getString(1);
				System.out.println("Gatekeeper Number Old : "+gatekeeper_mobile);
				System.out.println("Gatekeeper Present");
				String q4 = "update tower_master set gatekeeper_mobile ='"+number+"',clustermanager_mobile = '"+s_number+"' where indus_tower_id = '"+indus_id+"'";
				PreparedStatement pst = con44.prepareStatement(q4);
				int t = pst.executeUpdate();
				if(t > 0)
				{
						out.println("Tower ID : "+indus_id+" Updated Successfully");%><br><%
				}
				else
				{
						out.println("Tower ID : "+indus_id+" Not Updated Successfully");%><br><%
				}
				con44.commit();
				pst.close();
			}
			else// New GateKeeper
			{
				System.out.println("loooook 2 :: ");
				System.out.println("Gatekeeper Not Present");
				String q3 = "insert into gatekeeper_master(gatekeeper_name,gatekeeper_mobile,serviceprovider_id,gatekeeper_type) values(?,?,?,?) ";
				PreparedStatement pst3 = con33.prepareStatement(q3);
				pst3.setString(1, t_name);
				pst3.setString(2, number);
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
			
				String q4 = "update tower_master set gatekeeper_mobile ='"+number+"',clustermanager_mobile = '"+s_number+"' where indus_tower_id = '"+indus_id+"'";
				PreparedStatement pst55 = con55.prepareStatement(q4);
				int t1 = pst55.executeUpdate();
				System.out.println("t1 ********** :: "+t1);
				if(t1 > 0)
				{
					out.println("Tower ID : "+indus_id+" Updated Successfully");%><br><%
				}
				else
				{
					out.println("Tower ID : "+indus_id+" Not Updated Successfully");%><br><%
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
		
		con11.close();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	} 



%>
</body>
</html>