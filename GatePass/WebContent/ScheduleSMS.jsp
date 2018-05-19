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

<ov:form action="ScheduleSMSAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width:500px;">
					<legend>Schedule SMS</legend>


					<table align="center" border="0" width="80%">


						<tr valign="top">
						<td width="10%">&nbsp;</td>
							<td width="20%">Tower Code</td>
							<td width="27%"><ov:textfield name="indus_tower_id" value=""/><br>
							<font color = "red"><ov:fielderror fieldName="indus_tower_id"/></font></td>
						</tr>
						<tr valign="top"><td width="10%">&nbsp;</td>
							<td>Mobile No</td>
							<td><ov:textfield name="mobile_no" value="" /><br><font color = "red"><ov:fielderror fieldName="mobile_no"/></font></td>
						</tr>
						<tr valign="top"><td width="10%">&nbsp;</td>
							<td>Select Purpose</td>
							<td><ov:select label="Select Purpose" headerKey="8"
									name="purpose_id" headerValue="------ Select Purpose ------"
									list="message" listKey="%{#attr.purpose_id}"
									listValue="%{#attr.purpose_name}" value="8" theme="simple"/><br><font color = "red"><ov:fielderror fieldName="purpose_id"/></font></td>
						</tr>
						<tr valign="top"><td width="10%">&nbsp;</td>
							<td>Select DateTime</td>
							<td><input type="text" value="" id="datetimepicker" name="datetimepicker" readonly="readonly"/><br><font color = "red"><ov:fielderror fieldName="datetimepicker"/></font></td>
						<!-- <td>Select DateTime</td>
						<td><ovi:datetimepicker id="datetimepicker" name ="datetimepicker" 
						displayFormat = "yyyy-MM-dd" value="%{'today'}" weekStartsOn="0" 
						staticDisplay="true" startDate="%{'today'}"/></td>-->
						</tr>
						<tr>
							<td><ov:hidden name="action" value="1"/></td>
						</tr>
						<tr><td width="10%">&nbsp;</td></tr>
						<tr>
							<td width="10%">&nbsp;</td>
							<td >&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit  value="Submit" />
							<ov:submit  value="Clear" /></td>
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