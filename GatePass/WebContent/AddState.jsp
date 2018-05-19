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

function editState(state_id,state_name)
{
	$("#state_id").val(state_id);
	$("#state_name").val(state_name);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteState(state_id,state_name)
{
	$("#state_id").val(state_id);
	$("#state_name").val(state_name);
	$("#act").val("Delete?");
	$("#clear").show();

}

function clear1()
{
	//alert("okk");
	$("#state_id").val("");
	$("#state_name").val("");
	$("#act").val("Add");
	$("#clear").hide();
}
</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


<ov:form action="StateAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width: 400px;">
					<legend>Add State</legend>


					<table align="center">


						<tr valign="middle">
						<td>State Name</td>
						<td><ov:textfield id="state_name" name="state_name" label="State Name" theme="simple"/>
						<ov:hidden id="state_id" name="state_id"/>
						<ov:fielderror fieldName="state_name"/></td>
						
						</tr>
						<tr>
							<td>&nbsp;</td></tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" theme="simple"/>
							<ov:submit id="clear" value="Clear" onclick="clear1()"/>
							<ov:submit value="Search" action="StateSearch" theme="simple"/></td>
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
					<legend>List Of State</legend>
					<br> <br> <input type="submit" value="Export to PDF">
					<input type="hidden" name="flag" value="1"> <br> <br>
					<table align="center" width="90%" border-color="black" >
						<tr bgcolor="blue">
							<td align="center"><font color="white">Sl No</font></td>
							<td align="center"><font color="white">State</font></td>
							<td align="center"><font color="white">Edit</font></td>
							<td align="center"><font color="white">Delete</font></td>
						</tr>

						<ov:iterator value="state_list" status="row">
							<ov:if test="#row.even==true">
							<tr>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
									value="#row.count" /></font></td>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
											value="state_name" /></font></td>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
										type="button" value="Edit"
										onclick="editState('<ov:property value="state_id"/>','<ov:property value="state_name"/>')"></font></td>
								<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
										type="button" value="Delete"
										onclick="deleteState('<ov:property value="state_id"/>','<ov:property value="state_name"/>')"></font></td>
							</tr>
							</ov:if>
							<ov:else>
							<tr>
								<td align="center"><font color="Black"><ov:property
									value="#row.count" /></font></td>
								<td align="center"><font color="Black"><ov:property
											value="state_name" /></font></td>
								<td align="center"><font color="Black"><input
										type="button" value="Edit"
										onclick="editState('<ov:property value="state_id"/>','<ov:property value="state_name"/>')"></font></td>
								<td align="center"><font color="Black"><input
										type="button" value="Delete"
										onclick="deleteState('<ov:property value="state_id"/>','<ov:property value="state_name"/>')"></font></td>
							</tr>
							
							</ov:else>
						</ov:iterator>



					</table>
				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>