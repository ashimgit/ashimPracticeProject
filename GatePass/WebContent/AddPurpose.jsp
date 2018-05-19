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

function editPurpose(purpose_id,purpose_name,purpose_code)
{
	$("#purpose_id").val(purpose_id);
	$("#purpose_name").val(purpose_name);
	$("#purpose_code").val(purpose_code);
	$("#act").val("Save");
	$("#clear").show();

}

function deletePurpose(purpose_id,purpose_name,purpose_code)
{
	$("#purpose_id").val(purpose_id);
	$("#purpose_name").val(purpose_name);
	$("#purpose_code").val(purpose_code);
	$("#act").val("Delete?");
	$("#clear").show();
}

function clear1()
{
	$("#purpose_id").val("");
	$("#purpose_name").val("");
	$("#purpose_code").val("");
	$("#act").val("Add");
	$("#clear").hide();
}

</script>


<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


<ov:form action="PurposeAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset>
		<legend>Add Purpose</legend>


		<table align="center" border="0" width="400px" >


			<tr valign="middle">
				<td width="10%">&nbsp;</td>
				<td width="25%">Purpose Name</td>
				<td width="65%"><ov:textfield id="purpose_name" name="purpose_name" theme="simple"/>
				<ov:hidden id="purpose_id" name="purpose_id" /></td>
				<td width="5%">&nbsp;</td>
			</tr>
			<tr><td width="10%">&nbsp;</td>
				<td>Purpose Code</td>
				<td><ov:textfield id="purpose_code" name="purpose_code" theme="simple"/></td>
			</tr>
			<tr>
			<tr>	<td>&nbsp;</td>
						</tr>
						
						<tr>
						<td>&nbsp;</td><td width="10%">&nbsp;</td>
							<td colspan="2">&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" theme="simple"/>
				<ov:submit value="Clear" id="clear" onclick="clear1()"/>
				<ov:submit value="Search" action="PurposeSearch" theme="simple"/></td>
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
					<legend>List Of Purpose</legend>
					<br> <br> <input type="submit" value="Export to PDF">
					<input type="hidden" name="flag" value="1"> <br> <br>
		<table align="center" width="90%" border-color="black" >
			<tr>
				<td align="center" bgcolor="blue"><font color="white">Sl No</font></td>
				<td align="center" bgcolor="blue"><font color="white">Purpose Name</font></td>
				<td align="center" bgcolor="blue"><font color="white">Purpose Code</font></td>
				<td align="center" bgcolor="blue"><font color="white">Edit</font></td>
				<td align="center" bgcolor="blue"><font color="white">Delete</font></td>
			</tr>

			<ov:iterator value="purpose_list" status="row">
			<ov:if test="#row.even==true">
				<tr>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="purpose_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="purpose_code" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Edit" onclick="editPurpose('<ov:property value="purpose_id"/>','<ov:property value="purpose_name"/>','<ov:property value="purpose_code"/>')"></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Delete" onclick="deletePurpose('<ov:property value="purpose_id"/>','<ov:property value="purpose_name"/>','<ov:property value="purpose_code"/>')"></font></td>
				</tr>
			</ov:if>
			<ov:else>
				<tr>
				<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center"><font color="Black"><ov:property value="purpose_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="purpose_code" /></font></td>
				<td align="center"><font color="Black"><input type="button" value="Edit" onclick="editPurpose('<ov:property value="purpose_id"/>','<ov:property value="purpose_name"/>','<ov:property value="purpose_code"/>')"></font></td>
				<td align="center"><font color="Black"><input type="button" value="Delete" onclick="deletePurpose('<ov:property value="purpose_id"/>','<ov:property value="purpose_name"/>','<ov:property value="purpose_code"/>')"></font></td>
				</tr>
			</ov:else>
			</ov:iterator>
			
			

					</table>
				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>