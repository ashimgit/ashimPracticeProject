<%@ include file="header.jsp"%>
<%
String flag=request.getParameter("flag");
String interface_type=request.getParameter("interface_type");
String sme_schedule_type=request.getParameter("sme_schedule_type");
String sme_name=request.getParameter("sme_name");
String company_name=request.getParameter("company_name");
String from=request.getParameter("from");
String to=request.getParameter("to");
%> 
<style type="text/css">

.welcome li{ 
	list-style: url("images/bullet.gif"); 
}

.sudip li{ 
	list-style: url("images/bullet1.gif"); 
}
</style>
<script src="./jquery.js"></script>
<script src="./jquery.datetimepicker.js"></script>
<script>
	$(document).ready(function() 
	{
		$('input[name=interface_type][value=<%=interface_type%>]').attr('checked', true); 
		$('input[name=sme_schedule_type][value=<%=sme_schedule_type%>]').attr('checked', true); 

		if('<%=sme_schedule_type%>'=="S"){
			$('#sme_company').prop('disabled',false);
			$('#sme_company').val(<%=company_name%>);
		}
		
		else
			$('#sme_company').prop('disabled',true);
		
		
		$("input[type='radio'][name='sme_schedule_type']").click(function()
		{	//alert($("input[type='radio'][name='sme_schedule_type']:checked").val());
		
			if($("input[type='radio'][name='sme_schedule_type']:checked").val() == 'S')
				$('#sme_company').prop('disabled',false);
			else
				{
				$('#sme_company').prop('disabled',true);
				$('#sme_company').val("0");
				}
		});
		
		$('#from').datetimepicker({
			startDate : "%{'today'}",
			step : 10
		});
		
		$('#to').datetimepicker({
			startDate : "%{'today'}",
			step : 10
		});
		
		
		$("#searchall").click(function(){
			//alert($("#sme_company").val());
			//alert($("input[type='radio'][name='sme_schedule_type']:checked").val());
			window.location.href = "./MegaHuntSendSMS?indus_tower_id="+$("#indus_tower_id").val()+"&sme_mobile="+$("#sme_mobile").val()+"&interface_type="+$("input[type='radio'][name='interface_type']:checked").val()+"&sme_schedule_type="+$("input[type='radio'][name='sme_schedule_type']:checked").val()+"&sme_name="+$("#sme_name").val()+"&company_name="+$("#sme_company").val()+"&from="+$("#from").val()+"&to="+$("#to").val();
		});
		
		$("#pdf").click(function(){
			//alert($("#sme_company").val());
			//alert($("input[type='radio'][name='sme_schedule_type']:checked").val());
			window.location.href = "./MegaHuntReport?indus_tower_id="+$("#indus_tower_id").val()+"&sme_mobile="+$("#sme_mobile").val()+"&interface_type="+$("input[type='radio'][name='interface_type']:checked").val()+"&sme_schedule_type="+$("input[type='radio'][name='sme_schedule_type']:checked").val()+"&sme_name="+$("#sme_name").val()+"&company_name="+$("#sme_company").val()+"&from="+$("#from").val()+"&to="+$("#to").val()+"&flag=1&bp=<%=basePath%>";
		});
		
		$("#excell").click(function(){
			//alert($("#sme_company").val());
			//alert($("input[type='radio'][name='sme_schedule_type']:checked").val());
			window.location.href = "./MegaHuntReport?indus_tower_id="+$("#indus_tower_id").val()+"&sme_mobile="+$("#sme_mobile").val()+"&interface_type="+$("input[type='radio'][name='interface_type']:checked").val()+"&sme_schedule_type="+$("input[type='radio'][name='sme_schedule_type']:checked").val()+"&sme_name="+$("#sme_name").val()+"&company_name="+$("#sme_company").val()+"&from="+$("#from").val()+"&to="+$("#to").val()+"&flag=2";
		});
		
	});
</script>


<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="MegaHuntReport" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width:500px;">
					<legend>Search</legend>
					<br>
					<table align="center" width="90%" border-color="black" border="0">
						<tr><td width="40%">Indus Tower ID</td>
							<td width="48%"><ov:textfield name="indus_tower_id" id="indus_tower_id" value="%{#attr.indus_tower_id}" label="Enter Tower Id" /></td>
						</tr>
						<tr><td>SME Mobile</td>
							<td><ov:textfield name="sme_mobile" id="sme_mobile" value="%{#attr.sme_mobile}" label="Enter SME Mobile No"/></td>
						</tr>
						
						<tr>
							<td>Enter Request Interface</td>
							<td>&nbsp;&nbsp;<input type="radio" id="request_interface" name="interface_type" value="WEB">WEB
							<input type="radio" id="request_interface" name="interface_type" value="Mobile">Mobile</td>
						</tr>
						
						<tr>
							<td>Enter SME Type</td>
							<td>&nbsp;&nbsp;<input type="radio" id="sme_schedule_type" name="sme_schedule_type" value="S">Scheduled
							<input type="radio" id="sme_schedule_type" name="sme_schedule_type" value="U">Unscheduled</td>
						</tr>
						
						<tr>
							<td>Enter SME Name</td>
							<td><ov:textfield id="sme_name" name="sme_name" value="%{#attr.sme_name}" label="Enter SME Name"/></td>
						</tr>
						
						<tr>
							<td>Select Service Provider</td>
							<td><ov:select label="Select Service Provider" headerKey="0" name="sme_company"
					headerValue="-Select Service Provider-" list="message11" id="sme_company"
					listKey="%{#attr.serviceprovider_id}" listValue="%{#attr.serviceprovider_name}" /></td>
							
						</tr>
						
						
						<tr>
						<td>From Date</td>
							<td><ov:textfield id="from" name="from" value="%{#attr.from}" label="From"/></td>
						</tr>
						
						<tr>
						<td>To Date</td>
							<td><ov:textfield id="to" name="to" value="%{#attr.to}" label="To"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td></tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<input type="button" value="Search" id="searchall">
							<input type="reset" value="Reset" id="reset"></td>
						</tr>
						
						
						<tr>
						<td>
						</td>
						</tr>
					</table>
				</fieldset> 
			</td>
		</tr>
	</table>
</ov:form>
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


<%@ include file="middle.jsp"%>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Starts ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


				<!-- <h1><font color="red"><ov:property value="outputtext"/></font></h1>-->
				<ov:if test="hasActionMessages()">
      				<div class="welcome" id="div2">
      					<font color="red" size="5px"><ov:actionmessage/></font>
   					</div>
				</ov:if>
				
				<fieldset>
					<legend>List Of SMS Send List <%if (flag!=null) out.println("(Last 20 SME Visits)");%></legend> 
					<br> <br> 
					<input type="button" id="pdf" value="Export to PDF"> 
					<input type="button" id="excell" value="Export to Excel"> 
					<input type="hidden" name="flag" value="4"> 
					<br> <br>
		
		<table align="center" width="90%" border-color="black" border="1px">
			<tr>
				<td align="center"><font color="Green">Tower Id</font></td>
				<td align="center"><font color="Green">SME Mobile</font></td>
				<td align="center"><font color="Green">Date Time</font></td>
				<td align="center"><font color="Green">Request From</font></td>
				<td align="center"><font color="Green">Name</font></td>
				<td align="center"><font color="Green">Company Name</font></td>
				<td align="center"><font color="Green">Purpose Name</font></td>
				<td align="center"><font color="Green">Schedule/UnSchedule</font></td>
			</tr>
			<ov:iterator value="message2" status="row">

				<tr valign="middle">
					<ov:hidden value="%{#attr.unscheduled_req_id}" id="unscheduled_req_id" />
					<td width="15%" align="center"><ov:property value="indus_tower_id" /></td>
					<td width="15%" align="center"><ov:property	value="unsme_mobile" /></td>
					<td width="15%" align="center"><ov:property	value="datetime" /></td>
					<td width="5%" align="center"><ov:property value="interface_type" /></td>
					<td width="15%" align="center"><ov:property value="name" /></td>
					<td width="15%" align="center"><ov:property	value="company_name" /></td>
					<td width="5%" align="center"><ov:property	value="purpose_name" /></td>
					<td width="15%" align="center"><ov:property value="sme_type" /></td>
				</tr>
			</ov:iterator>

		</table>

				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>