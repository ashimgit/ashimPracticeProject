<%@ include file="header.jsp"%>

<style type="text/css">

.welcome li{ 
	list-style: url("images/bullet.gif"); 
}

.sudip li{ 
	list-style: url("images/bullet1.gif"); 
}
</style>
<script>
	$(document).ready(function() {
		$('#datetimepicker').datetimepicker({
			minDate: 0,
			minTime: 0,
			startDate : "%{'today'}",
			step : 10
		});
		
	});
</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="UnScheduleSMSAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width:500px;">
					<legend>UnSchedule SMS</legend>


					<table align="center">


						<tr valign="top">
							<td>Tower Code</td>
							<td><ov:textfield name="indus_tower_id" value=""/><br>
							<font color = "red"><ov:fielderror fieldName="indus_tower_id"/></font></td>
						</tr>
						<tr valign="top">
							<td>Mobile No</td>
							<td><ov:textfield name="mobile_no" value="" />
							<br><font color = "red"><ov:fielderror fieldName="mobile_no"/></font></td>
						</tr>
					
						<tr valign="top">
							<td>Name</td>
							<td><ov:textfield name="name" value=""/>
							<br><font color = "red"><ov:fielderror fieldName="name"/></font></td>
						</tr>
						<tr valign="top">
							<td>Company Name</td>
							<td><ov:textfield name="company_name" value=""/>
							<br><font color = "red"><ov:fielderror fieldName="company_name"/></font></td>
						</tr>
						<tr valign="top">
							<td>Select DateTime</td>
							<td><input type="text" value="" id="datetimepicker" name="datetimepicker" />
							<br><font color = "red"><ov:fielderror fieldName="datetimepicker"/></font></td>
						</tr>
						<tr valign="top">
							<td>Select Purpose</td>
							<td><ov:select label="Select Purpose" headerKey="8"
									name="purpose_id" headerValue="------ Select Purpose ------"
									list="message" listKey="%{#attr.purpose_id}"
									listValue="%{#attr.purpose_name}" value="8" theme="simple"/><br><font color = "red"><ov:fielderror fieldName="purpose_id"/></font></td>
						</tr>
						<tr>
							<td><ov:hidden name="action" value="2"/></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit value="Submit" /><ov:submit value="Clear" /></td>
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


				<h1><font color="red"><ov:property value="outputtext"/></font></h1>
				
				
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>