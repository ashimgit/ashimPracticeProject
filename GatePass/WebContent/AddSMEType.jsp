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

function editSmeType(smetype_id,smetype_name)
{
	$("#smetype_id").val(smetype_id);
	$("#smetype_name").val(smetype_name);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteSmeType(smetype_id,smetype_name)
{
	$("#smetype_id").val(smetype_id);
	$("#smetype_name").val(smetype_name);
	$("#act").val("Delete?");
	$("#clear").show();

}

function clear1()
{
	$("#smetype_id").val("");
	$("#smetype_name").val("");
	$("#act").val("Add");
	$("#clear").hide();
}
</script>


<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="STypeAddition" method="post" theme="simple">
<table align="center">
				<tr>
					<td>
						<fieldset style="width: 400px;">
					<legend>Add SME Type</legend>


					<table align="center">


						<tr valign="middle">
							<td>SME Type Name</td>
							<td><ov:textfield id="smetype_name" name="smetype_name" />
							<ov:hidden id="smetype_id" name="smetype_id" />
							<br><font color="red"><ov:fielderror fieldName="smetype_name"/></font></td>
						</tr>
						<tr>
								<td>&nbsp;</td></tr>
						<tr>
								<td>&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" />
							<ov:submit value="Clear" id="clear" onclick="clear1()"/>
							<ov:submit value="Search" action="STypeSearch" theme="simple"/></td>
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
								
				<fieldset>
					<legend>List Of SME Type</legend>
					<br> <br> <input type="submit" value="Export to PDF">
					<input type="hidden" name="flag" value="1"> <br> <br>
					<table align="center" width="90%" border-color="black" >
						<tr bgcolor="blue">
							<td align="center"><font color="white">Sl No</font></td>
							<td align="center"><font color="white">SME Type Name</font></td>
							<td align="center"><font color="white">Edit</font></td>
							<td align="center"><font color="white">Delete</font></td>
						</tr>

						<ov:iterator value="smetype_list" status="row">
							<ov:if test="#row.even==true">
							<tr>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
									value="#row.count" /></font></td>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
											value="smetype_name" /></font></td>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
										type="button" value="Edit"
										onclick="editSmeType('<ov:property value="smetype_id"/>','<ov:property value="smetype_name"/>')"></font></td>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
										type="button" value="Delete"
										onclick="deleteSmeType('<ov:property value="smetype_id"/>','<ov:property value="smetype_name"/>')"></font></td>
							</tr>
							</ov:if>
							<ov:else>
								<td align="center"><font color="Black"><ov:property
									value="#row.count" /></font></td>
								<td align="center"><font color="Black"><ov:property
											value="smetype_name" /></font></td>
								<td align="center"><font color="Black"><input
										type="button" value="Edit"
										onclick="editSmeType('<ov:property value="smetype_id"/>','<ov:property value="smetype_name"/>')"></font></td>
								<td align="center"><font color="Black"><input
										type="button" value="Delete"
										onclick="deleteSmeType('<ov:property value="smetype_id"/>','<ov:property value="smetype_name"/>')"></font></td>
							
							</ov:else>
						</ov:iterator>


					</table>
				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>