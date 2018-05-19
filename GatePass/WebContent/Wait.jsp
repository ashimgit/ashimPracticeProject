<%@ include file="header.jsp"%>
<head>
	<meta http-equiv="refresh" content="1"/>
	<title>Wait</title>
</head>
<style type="text/css">
.welcome {
	background-color:#DDFFDD;
	border:1px solid #009900;
	width:380px;
}
.welcome li{ 
	list-style: none; 
}

.sudip li{ 
	list-style: none; 
}
</style>

<script type="text/javascript" language="javascript">
$(document).ready(function() {
	$("#clear").hide();

});

function editTower(district_id,district_name,state_id)
{
	$("#state_id").val(state_id);
	$("#district_name").val(district_name);
	$("#district_id").val(district_id);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteTower(district_id,district_name,state_id)
{
	$("#state_id").val(state_id);
	$("#district_name").val(district_name);
	$("#district_id").val(district_id);
	$("#act").val("Delete?");
	$("#clear").show();

}

function clear1()
{
	$("#state_id").val(-1);
	$("#district_name").val("");
	$("#district_id").val("");
	$("#act").val("Add");
	$("#clear").hide();
}

</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="TowerAddition" method="post" theme="simple">
<table align="center">
				<tr>
					<td>
						<fieldset style="width:500px;">
							<legend>Add Tower</legend>
					
					<table align="center" border="0" width="80%">
						<tr valign="middle">
							<td>Indus Tower Code</td>
							<td><ov:textfield id="indus_tower_code" name="indus_tower_code" />
							<br><font color="red"><ov:fielderror fieldName="indus_tower_code" /></font></td>
						</tr>
						
						<tr>
							<td>GateKeeper Mobile</td>
							<td><ov:textfield id="gatekeeper_mobile" name="gatekeeper_mobile" />
							<br><font color="red"><ov:fielderror fieldName="gatekeeper_mobile" /></font></td>
						</tr>
						
						<tr>
							<td>ClusterManager Mobile</td>
							<td><ov:textfield id="clustermanager_mobile" name="clustermanager_mobile" />
							<br><font color="red"><ov:fielderror fieldName="clustermanager_mobile" /></font></td>
						</tr>
						<tr>
							<td width="40%">Site Name</td>
							<td width="60%"><ov:textfield nid="site_name" name="site_name"/></td>
						</tr>
						
						<tr>
							<td>Address</td>
							<td><ov:textarea id="address" rows="3" cols="1" name="address" style="resize:none;"/></td>
						</tr>
		
						<tr>
							<td>State & District</td>
							<td><ov:doubleselect headerKey="-1" id="state_id" headerValue="-------Select State------" name="state_id" list="state_list" listKey="state_id" listValue="state_name"
							doubleHeaderKey="-1" doubleHeaderValue="----Select District-----" doubleName="district_id" doubleList="district_list"  doubleListKey="district_id" doubleListValue="district_name"/>
							<br><font color="red"><ov:fielderror fieldName="state_id" /></font>
							<br><font color="red"><ov:fielderror fieldName="district_id" /></font></td>
						</tr>
						
						<tr>
							<td>Tower Type</td>
							<td><ov:select headerKey="-1" headerValue="-------Select Type------" id="tower_type" name="tower_type" list="#{'GBT':'GBT','RTP':'RTP','RTT':'RTT'}"/>
							<br><font color="red"><ov:fielderror fieldName="tower_type" /></font></td>
						</tr>
						
						<tr>
							<td>Height (metre)</td>
							<td><ov:textfield id="height" name="height" /></td>
						</tr>
						<tr>
							<td>Longitude (metre)</td>
							<td><ov:textfield id="longitude" name="longitude" /></td>
						</tr>
						<tr>
							<td>Latitude (metre)</td>
							<td><ov:textfield id="latitude" name="latitude" /></td>
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


			<h3><font color="red">Please Wait While we populate the List</font></h3>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>