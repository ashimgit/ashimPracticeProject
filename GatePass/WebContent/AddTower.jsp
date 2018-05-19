<%@ include file="header.jsp"%>
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

function editTower(tower_id,indus_tower_code,gatekeeper_mobile,clustermanager_mobile,site_name,address,state_id,district_id,tower_type,height,longitude,latitude)
{
	//alert("district_id"+district_id);
	$("#tower_id").val(tower_id);
	$("#indus_tower_code").val(indus_tower_code);
	$("#gatekeeper_mobile").val(gatekeeper_mobile);
	$("#clustermanager_mobile").val(clustermanager_mobile);
	$("#site_name").val(site_name);
	$("#address").val(address);
	$("#state_id").val(state_id);
	//$("#district_id").val(district_id);
	document.tower.district_id.value=district_id;
	$("#tower_type").val(tower_type);
	$("#height").val(height);
	$("#longitude").val(longitude);
	$("#latitude").val(latitude);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteTower(tower_id,indus_tower_code,gatekeeper_mobile,clustermanager_mobile,site_name,address,state_id,district_id,tower_type,height,longitude,latitude)
{
	$("#tower_id").val(tower_id);
	$("#indus_tower_code").val(indus_tower_code);
	$("#gatekeeper_mobile").val(gatekeeper_mobile);
	$("#clustermanager_mobile").val(clustermanager_mobile);
	$("#site_name").val(site_name);
	$("#address").val(address);
	$("#state_id").val(state_id);
	$("#district_id").val(district_id);
	$("#tower_type").val(tower_type);
	$("#height").val(height);
	$("#longitude").val(longitude);
	$("#latitude").val(latitude);
	$("#act").val("Delete?");
	$("#clear").show();

}

function clear1()
{
	$("#tower_id").val("");
	$("#indus_tower_code").val("");
	$("#gatekeeper_mobile").val("");
	$("#clustermanager_mobile").val("");
	$("#site_name").val("");
	$("#address").val("");
	$("#state_id").val(-1);
	//$("#district_id").val(-1);
	$("#tower_type").val(-1);
	$("#height").val("");
	$("#longitude").val("");
	$("#latitude").val("");
	$("#act").val("Add");
	$("#clear").hide();
	return false;
}

</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="TowerAddition" method="post" theme="simple" name="tower">
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
							<td width="60%"><ov:textfield id="site_name" name="site_name"/></td>
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
						
						
						
						<tr>
							<td>&nbsp;<ov:hidden id="tower_id" name="tower_id" /></td></tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" theme="simple" /> 
							<ov:submit id="clear" value="Clear" onclick="clear1()" theme="simple" /> 
							<ov:submit value="Search" action="TowerSearch" theme="simple" /></td>
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
      				<div class="welcome">
      					<ov:actionmessage/>
   					</div>
				</ov:if>
				
				<ov:if test="message_vs_table==\"1\"">				
				<fieldset>
					<legend>List Of Towers</legend> 
					<br> <br> 
					<br> <br>
				<table align="center" width="90%" border-color="black" >

					<tr bgcolor="blue">
						<td align="center"><font color="white">Sl No</font></td>
						<td align="center"><font color="white">Tower Id</font></td>
						<td align="center"><font color="white">GateKeeper Mobile</font></td>
						<td align="center"><font color="white">ClusterManager Mobile</font></td>
						<td align="center"><font color="white">District</font></td>
						<td align="center"><font color="white">Edit</font></td>
						<td align="center"><font color="white">Delete</font></td>
					</tr>

					<ov:iterator value="tower_list" status="row">
						<ov:if test="#row.even==true">
						<tr>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="indus_tower_code" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="gatekeeper_mobile" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="clustermanager_mobile" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="district_name" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Edit" onclick="editTower('<ov:property value="tower_id"/>','<ov:property value="indus_tower_code"/>','<ov:property value="gatekeeper_mobile"/>','<ov:property value="clustermanager_mobile"/>','<ov:property value="site_name"/>','<ov:property value="address"/>','<ov:property value="state_id"/>','<ov:property value="district_id"/>','<ov:property value="tower_type"/>','<ov:property value="height"/>','<ov:property value="longitude"/>','<ov:property value="latitude"/>')"></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Delete" onclick="deleteTower('<ov:property value="tower_id"/>','<ov:property value="indus_tower_code"/>','<ov:property value="gatekeeper_mobile"/>','<ov:property value="clustermanager_mobile"/>','<ov:property value="site_name"/>','<ov:property value="address"/>','<ov:property value="state_id"/>','<ov:property value="district_id"/>','<ov:property value="tower_type"/>','<ov:property value="height"/>','<ov:property value="longitude"/>','<ov:property value="latitude"/>')"></font></td>
						</tr>
						</ov:if>
						<ov:else>
						<tr>
						<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
							<td align="center"><font color="Black"><ov:property value="indus_tower_code" /></font></td>
							<td align="center"><font color="Black"><ov:property value="gatekeeper_mobile" /></font></td>
							<td align="center"><font color="Black"><ov:property value="clustermanager_mobile" /></font></td>
							<td align="center"><font color="Black"><ov:property value="district_name" /></font></td>
							<td align="center"><font color="Black"><input type="button" value="Edit" onclick="editTower('<ov:property value="tower_id"/>','<ov:property value="indus_tower_code"/>','<ov:property value="gatekeeper_mobile"/>','<ov:property value="clustermanager_mobile"/>','<ov:property value="site_name"/>','<ov:property value="address"/>','<ov:property value="state_id"/>','<ov:property value="district_id"/>','<ov:property value="tower_type"/>','<ov:property value="height"/>','<ov:property value="longitude"/>','<ov:property value="latitude"/>')"></font></td>
							<td align="center"><font color="Black"><input type="button" value="Delete" onclick="deleteTower('<ov:property value="tower_id"/>','<ov:property value="indus_tower_code"/>','<ov:property value="gatekeeper_mobile"/>','<ov:property value="clustermanager_mobile"/>','<ov:property value="site_name"/>','<ov:property value="address"/>','<ov:property value="state_id"/>','<ov:property value="district_id"/>','<ov:property value="tower_type"/>','<ov:property value="height"/>','<ov:property value="longitude"/>','<ov:property value="latitude"/>')"></font></td>
						</tr>
						
						</ov:else>
					</ov:iterator>



				</table>

				</fieldset>
				</ov:if>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>