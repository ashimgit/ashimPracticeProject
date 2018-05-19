<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>
<%@ page import="connection.*"%>
<%@ page import="sms.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="#" method="post">
<table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="35%">Mobile</td>
    <td width="65%"><input type="text" size="35" name="mobile" id="mobile"/></td>
  </tr>
  <tr>
    <td>Text</td>
    <td><input type="text" size="35" name="textmsg" id="textmsg"/></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="sumbit" value="SUBMIT"/></td>
  </tr>
  </table>
<%

		
		ArrayList toList = new ArrayList();
		String mobile_no="";
		String msg_txt="";
		String gatepassno="";
		String site_info="";		
		String txt="";
		String keyword="";
		int VitorType=1;//Schedule or Unschedule
		int begin=0;
		int end=0;
		int tm_id=0;
		int count=0;
		int flag=0;
		int visito_id=0;
		
		
/*---------------------------- Example Of Scheduled Visitor SMS Format Starts -----------------------------

http://184.106.63.136:8080/indus/JSPS/sms_INIDVC.jsp?mob=919758328346&text=INIDCN 12345678910562 

---------------------------- Example Of Scheduled Visitor SMS Format Ends --------------------------------- */

				
/* -------------------------- Getting Message From SMS URL Starts ------------------------------------------*/
		
		
		mobile_no=request.getParameter("mob");
		mobile_no=mobile_no.substring(2,12);
		//mobile_no="7278403639";
		//msg_txt="INIDCN 5552e0fa2d07c";
		//msg_txt="INIDCN 555309a845f98";
        msg_txt=request.getParameter("text").trim();
		System.out.println("msg_txt"+msg_txt);
		
		

        for(int i=0;i<msg_txt.length();i++)
		{
			if(msg_txt.charAt(i)==' ')
			{
		  		count++;	 						System.out.println("count"+count);
		  		end=i;								System.out.println("end"+end);
		  		txt=msg_txt.substring(begin,end);	System.out.println("msg_txt"+txt);
			}
			if(count==1)
			{
		 		keyword=txt.trim();					System.out.println("keyword"+keyword);
		 		begin=end;							System.out.println("begin"+begin);
		 		flag=1;								System.out.println("flag"+flag);
			}
			if(count==2)
			{
				gatepassno=txt.trim();				System.out.println("gatepassno"+gatepassno);
				begin=end;							System.out.println("begin"+begin);
				flag=1;								System.out.println("flag"+flag);
			}
				
			if(flag==1)
			{
				site_info=msg_txt.substring(begin,msg_txt.length()).trim();
				System.out.println("<br><br>site_info=="+site_info);
			}
		}
        gatepassno = site_info;
		System.out.println("<br>keyword=="+keyword);
		System.out.println("<br>gatepassno=="+gatepassno);
		System.out.println("<br>visit_conf_txt=="+site_info);
		System.out.println("<br>VitorType=="+VitorType);
		
		
		//check schedule or unschedule and find gatepass no
		
		String gatepassindecimal=""+Long.parseLong(gatepassno, 16);
		System.out.println("gatepassindecimal"+gatepassindecimal);
		
		VitorType=Integer.parseInt(gatepassindecimal.substring(6,7));
		System.out.println("VitorType===>"+VitorType);
		//VitorType=Gatepass_No;
		//VitorType
		//end checking
/* -------------------------- Getting Message From SMS URL Ends -------------------------------------------*/
		
/* ----------------------- Checking & Insertion Into Database Starts ------------------------------------*/
		
		SMSEngine vd = new SMSEngine();
		LinkedList check_tower_sp;
		SMSInterface obj1 = new SMSPojo();
		check_tower_sp = obj1.check_gatepass_no(gatepassno, VitorType);
		int size = check_tower_sp.size();
		if (size == 0)
			response.sendRedirect(basePath+"Invalid.jsp");
		else 
		{
			String sme_mobile = (String) check_tower_sp.get(0);
			String gatekeeper_mobile = (String) check_tower_sp.get(1);
			String clustermanager_mobile = (String) check_tower_sp.get(2);
			int scheduled_id = (Integer) check_tower_sp.get(3);
			int addcancelSMS = obj1.addcancelSMS(scheduled_id, VitorType);
			if (addcancelSMS > 0)
			{
				toList.add(sme_mobile);
				toList.add(gatekeeper_mobile);
				toList.add(clustermanager_mobile);
						
/* -------------------------- Sending Confirmation SMS Starts -------------------------------------------*/
				String TextMsg="Gatepass:"+" "+gatepassno+" "+"is Cancelled";
				if(toList.size()>1)
				{
					System.out.println("message sent");
					vd.sendSMS("Indus", toList, vd.encodeHTML(TextMsg));
					//return "success";
				}
				else
				{
				    System.out.println("message not sent");
				    response.sendRedirect(basePath+"Invalid.jsp");
				   /*reply to message sender if he has put a wrong tower code*/
				   //vd.sendSMS("Indus", toList, vd.encodeHTML("Wrong Message sent"));
				}

/* -------------------------- Sending Confirmation SMS Ends -------------------------------------------*/
			}
			else
				response.sendRedirect(basePath+"Invalid.jsp");
		}



		

/* ----------------------- Checking & Insertion Into Database Ends ------------------------------------*/


  %>
 
</form>

	
</body>
</html>
</body>
</html>