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

function editDistrict(district_id,district_name,state_id)
{
	$("#state_id").val(state_id);
	$("#district_name").val(district_name);
	$("#district_id").val(district_id);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteDistrict(district_id,district_name,state_id)
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
	return false;
}

</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="DistrictAddition" method="post" theme="simple">
<table align="center" >
				<tr>
					<td>
						<fieldset style="width: 450px;">
							<legend>Add District</legend>
	<table align="center" border="0" width="74%">
		<tr>
			<td>Select State</td>
			<td><ov:select id="state_id" headerKey="-1" name="state_id"
					headerValue="-------- All -----------" list="state_list"
					listKey="state_id" listValue="state_name" theme="simple"/>
					<br><font color="red"><ov:fielderror fieldName="state_id"/></font></td>
		</tr>

		<tr>
			<td>District Name</td>
			<td><ov:textfield name="district_name" id="district_name" theme="simple"/>
			<ov:hidden name="district_id" id="district_id" theme="simple"/>
			<br><font color="red"><ov:fielderror fieldName="district_name"/></font></td>
		</tr>
		<tr>
							<td>&nbsp;</td>
						</tr>
		<tr><td>&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" />
			<ov:submit action="DistrictSearch" value="Search" theme="simple"/>
			<ov:submit value="Clear" id="clear" onclick="clear1()"/></td>
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
					<legend>List Of District</legend> 
					<br> <br> 
					<input type="submit" value="Export to PDF"> 
					<input type="hidden" name="flag" value="1"> 
					<br> <br>
				<table align="center" width="90%" border-color="black" >

					<tr bgcolor="blue">
					<td align="center" bgcolor="blue"><font color="white">Sl No</font></td>
						<td align="center"><font color="white">District Name</font></td>
						<td align="center"><font color="white">State Name</font></td>
						<td align="center"><font color="white">Edit</font></td>
						<td align="center"><font color="white">Delete</font></td>
					</tr>

					<ov:iterator value="district_list" status="row">
						<ov:if test="#row.even==true">
						<tr>
						<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
									value="#row.count" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
										value="district_name" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
										value="state_name" /></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
									type="button" value="Edit"
									onclick="editDistrict('<ov:property value="district_id"/>','<ov:property value="district_name"/>','<ov:property value="state_id"/>')"></font></td>
							<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
									type="button" value="Delete"
									onclick="deleteDistrict('<ov:property value="district_id"/>','<ov:property value="district_name"/>','<ov:property value="state_id"/>')"></font></td>
						</tr>
						</ov:if>
						<ov:else>
						<tr>
						<td align="center"><font color="Black"><ov:property
									value="#row.count" /></font></td>
							<td align="center"><font color="Black"><ov:property
										value="district_name" /></font></td>
							<td align="center"><font color="Black"><ov:property
										value="state_name" /></font></td>
							<td align="center"><font color="Black"><input
									type="button" value="Edit"
									onclick="editDistrict('<ov:property value="district_id"/>','<ov:property value="district_name"/>','<ov:property value="state_id"/>')"></font></td>
							<td align="center"><font color="Black"><input
									type="button" value="Delete"
									onclick="deleteDistrict('<ov:property value="district_id"/>','<ov:property value="district_name"/>','<ov:property value="state_id"/>')"></font></td>
						</tr>
						
						</ov:else>
					</ov:iterator>



				</table>

				</fieldset>
				</ov:if>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>