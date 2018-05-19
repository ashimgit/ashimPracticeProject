<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*;"%>
<%@ taglib prefix="ov" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title>Indus GatePass Admin Panel</title>
	<link rel="stylesheet" type="text/css" href="./js/jquery.datetimepicker.css" />
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="./js/jquery.js"></script>
	<script src="./js/jquery.datetimepicker.js"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>

</head>


<body>

	<header id="header">
		<hgroup>
			<a href="#"><img src="<%=basePath%>/images/header_bg.png" align='center' width="100%" height="100px"></a>
			<!-- <h2 class="section_title">Dashboard</h2><div class="btn_view_site"><a href="">View Site</a></div> -->
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>Welcome &nbsp;<ov:property value="#session.name"/>&nbsp;( Last Login Time:&nbsp;<ov:property value="#session.login_time"/>&nbsp; From:&nbsp;<ov:property value="#session.ip"/>) </p>
			
		</div>
		
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		
		<!-- <h3>Master Record Entry/Edit</h3>
		<ul class="toggle">
		
			<li class="icn_new_article"><a href="<%=basePath%>./AddCategory">Category</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddClusterManager">ClusterManager</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddDistrict">District</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddGateKeeper">GateKeeper</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddPurpose">Purpose</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddServiceProvider">Service Provider</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddSME">SME</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddSMEType">SMEType</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddState">State</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddTower">Tower</a></li>
			<li class="icn_new_article"><a href="<%=basePath%>./AddUser">User</a></li>
			
			
		</ul>
		<h3>Approval</h3>
		<ul class="toggle">
		
			<li class="icn_add_user"><a href="<%=basePath%>./SMEJoiningApproval">SME Joining </a></li>
			<li class="icn_security"><a href="<%=basePath%>./SMEVisitApproval">SME Visit</a></li>
			
		</ul>
		<h3>SMS Sending</h3>
		<ul class="toggle">
		
			<li class="icn_photo"><a href="<%=basePath%>./ScheduleSMS">Send Schedule SMS</a></li>
			<li class="icn_photo"><a href="<%=basePath%>./UnscheduleSMS">Send Unschedule SMS</a></li>
			<li class="icn_photo"><a href="<%=basePath%>./CancelSMS">Cancel SMS Already Send</a></li>
			<li class="icn_photo"><a href="<%=basePath%>./ConfirmSMS">Send Visit Confirm SMS</a></li>
			
		</ul>
		<h3>Report</h3>
		<ul class="toggle">
		
			<li class="icn_categories"><a href="<%=basePath%>./SMSSendReport">GatePass SMS Details</a></li>
			<li class="icn_categories"><a href="<%=basePath%>./SMEVisitApprovalList">SME Visit Confirmation Details</a></li>
			<li class="icn_categories"><a href="<%=basePath%>./CheckGatePass">Check GatePass</a></li>
		
		</ul>
		<h3>Admin</h3>
		<ul class="toggle">
			
			<li class="icn_settings"><a href="<%=basePath%>./Help">Help</a></li>
			<li class="icn_jump_back"><a href="<%=basePath%>./Logout">Logout</a></li>
		</ul> -->
		
		<ov:iterator value="#session.dynamic_menu" var="row">
			<h3><ov:property value="head"/></h3>
					<ul class="toggle">
					<ov:iterator value="al1" var="row1">
					<li class="<ov:property value="image"/>"><a href="./<ov:property value="links"/>"><ov:property value="sub"/></a></li>					
					</ov:iterator>
					</ul>
			
				
		</ov:iterator>
		
		<footer>
			<hr />
			<p><strong>Copyright &copy; 2011  AAR Technologies & Software solution Pvt. Ltd.</strong></p>
			<p>Theme by <a href="http://www.rtizen.com">AARTSSPL</a></p>
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<article class="module width_full">
			<header><h3>Input Forms</h3></header>
				<div class="module_content">