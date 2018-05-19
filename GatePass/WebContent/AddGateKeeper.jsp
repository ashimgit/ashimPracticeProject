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

function editGatekeeper(gatekeeper_id,gatekeeper_name,mobile_no,gatekeeper_type,serviceprovider_name)
{
	//alert(gatekeeper_id+" "+gatekeeper_name+" "+mobie_no+" "+gatekeeper_type+" "+serviceprovider_name);
	$("#gatekeeper_id").val(gatekeeper_id);
	$("#gatekeeper_name").val(gatekeeper_name);
	$("#mobile_no").val(mobile_no);
	$("#gatekeeper_type").val(gatekeeper_type);
	$("#serviceprovider_id").val(serviceprovider_name);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteGatekeeper(gatekeeper_id,gatekeeper_name,mobile_no,gatekeeper_type,serviceprovider_name)
{
	$("#gatekeeper_id").val(gatekeeper_id);
	$("#gatekeeper_name").val(gatekeeper_name);
	$("#mobile_no").val(mobile_no);
	$("#gatekeeper_type").val(gatekeeper_type);
	$("#serviceprovider_id").val(serviceprovider_name);
	$("#act").val("Delete?");
	$("#clear").show();

}

function clear1()
{
	$("#gatekeeper_id").val("");
	$("#gatekeeper_name").val("");
	$("#mobie_no").val("");
	$("#gatekeeper_type").val("-1");
	$("#serviceprovider_id").val("-1");
	$("#act").val("Add");
	$("#clear").hide();
}
</script>


<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="gateKeeperAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width:500px;">
					<legend>Add gateKeeper</legend>


					<table align="center"  border="0">


						<tr><td width="10%">&nbsp;</td>
							<td width="25%">GateKeeper Name</td>
							<td width="50%"><ov:textfield id="gatekeeper_name" name="gatekeeper_name" theme="simple"/>
							<ov:hidden id="gatekeeper_id" name="gatekeeper_id" theme="simple"/>
							<br><font color="red"><ov:fielderror fieldName="gatekeeper_name"/></font></td>
							<td width="15%">&nbsp;</td>
						</tr>
						<tr>
							<td width="10%">&nbsp;</td>
							<td>GateKeeper Type</td>
							<td><ov:select id="gatekeeper_type" headerKey="-1"
						name="gatekeeper_type" headerValue="---- Select Category ----"
						list="#{'General':'General', 'Technician':'Technician'}" theme="simple"/>
						<br><font color="red"><ov:fielderror fieldName="gatekeeper_type"/></font>
							</td>
						</tr>
						<tr><td width="10%">&nbsp;</td>
							<td>Service Provider</td>
							<td><ov:select id="serviceprovider_id" headerKey="-1"
									name="serviceprovider_id"
									headerValue="-Select Service Provider-" list="serviceprovider_list"
									listKey="%{#attr.serviceprovider_id}"
									listValue="%{#attr.serviceprovider_name}" theme="simple"/>
									<br><font color="red"><ov:fielderror fieldName="serviceprovider_id"/></font>
							</td>
						</tr>
						<tr><td width="10%">&nbsp;</td>
							<td>Mobile No</td>
							<td><ov:textfield id="mobile_no" name="mobile_no" theme="simple"/>
							<br><font color="red"><ov:fielderror fieldName="mobile_no"/></font></td>
						</tr>
						<tr>	<td>&nbsp;</td>
						</tr>
						
						<tr>
						<td>&nbsp;</td><td width="10%">&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" theme="simple" />
							<ov:submit value="Search" action="gateKeeperSearch" theme="simple" />
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
							
				<fieldset>
		<legend>Modify Gate Keeper</legend>

		<table align="center" width="90%" border-color="black" >
			<tr bgcolor="blue">
				<td align="center"><font color="white">Sl no.</font></td>
				<td align="center"><font color="white">Name</font></td>
				<td align="center"><font color="white">Mobile No</font></td>
				<td align="center"><font color="white">Type</font></td>
				<td align="center"><font color="white">Service Provider</font></td>
				<td align="center"><font color="white">Edit</font></td>
				<td align="center"><font color="white">Delete</font></td>
			</tr>

			<ov:iterator value="gatekeeper_list" status="row">
			<ov:if test="#row.even==true">
				<tr>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="gatekeeper_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="mobile_no" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="gatekeeper_type" /></font></td>				
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Edit" onclick="editGatekeeper('<ov:property value="gatekeeper_id"/>','<ov:property value="gatekeeper_name"/>','<ov:property value="mobile_no"/>','<ov:property value="gatekeeper_type"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Delete" onclick="deleteGatekeeper('<ov:property value="gatekeeper_id"/>','<ov:property value="gatekeeper_name"/>','<ov:property value="mobile_no"/>','<ov:property value="gatekeeper_type"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				</tr>
			</ov:if>
			<ov:else>
				<tr>
				<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center"><font color="Black"><ov:property value="gatekeeper_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="mobile_no" /></font></td>
				<td align="center"><font color="Black"><ov:property value="gatekeeper_type" /></font></td>				
				<td align="center"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center"><font color="Black"><input type="button" value="Edit" onclick="editGatekeeper('<ov:property value="gatekeeper_id"/>','<ov:property value="gatekeeper_name"/>','<ov:property value="mobile_no"/>','<ov:property value="gatekeeper_type"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				<td align="center"><font color="Black"><input type="button" value="Delete" onclick="deleteGatekeeper('<ov:property value="gatekeeper_id"/>','<ov:property value="gatekeeper_name"/>','<ov:property value="mobile_no"/>','<ov:property value="gatekeeper_type"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				</tr>
			</ov:else>
			</ov:iterator>
			
			<tr>
				<input type="hidden" name="flag" value="4">
				<td align="center"><font color="Red"><input type="submit" value="Export to PDF"></font></td>
			</tr>

		</table>
	</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>