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

function editSme(sme_id,mobile,sme_name,serviceprovider_id,smetype_name)
{
	//alert(sme_id+" "+mobile+" "+sme_name+" "+serviceprovider_id+" "+smetype_name);
	$("#sme_id").val(sme_id);
	$("#sme_name").val(sme_name);
	$("#mobile").val(mobile);
	$("#smetype_id").val(smetype_name);
	$("#serviceprovider_id").val(serviceprovider_id);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteSme(sme_id,mobile,sme_name,serviceprovider_id,smetype_name)
{
	$("#sme_id").val(sme_id);
	$("#sme_name").val(sme_name);
	$("#mobile").val(mobile);
	$("#smetype_id").val(smetype_name);
	$("#serviceprovider_id").val(serviceprovider_id);
	$("#act").val("Delete?");
	$("#clear").show();


}

function clear1()
{
	$("#sme_id").val("");
	$("#sme_name").val("");
	$("#mobile").val("");
	$("#smetype_id").val("-1");
	$("#serviceprovider_id").val("-1");
	$("#act").val("Add");
	$("#clear").hide();
}
</script>


<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="SMEAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width:500px;">
					<legend>Add SME</legend>


					<table align="center" border="0">


						<tr  >
						<td width=11%>&nbsp;</td>
							<td width=30%>SME Name</td>
							<td width=49%><ov:textfield id="sme_name" name="sme_name" theme="simple"/>
							<ov:hidden id="sme_id" name="sme_id" theme="simple"/>
							<br>
									<font color="red"><ov:fielderror
											fieldName="sme_name" /></font></td>
							<td width=10%>&nbsp;</td>
						</tr>
						<ov:if test="#session.serviceprovider_id==\"70\"">
						<tr><td>&nbsp;</td>
						<td>Select Service Provider</td>
							<td><ov:select id="serviceprovider_id" headerKey="-1"
									name="serviceprovider_id"
									headerValue="-Select Service Provider-" list="serviceprovider_list"
									listKey="%{#attr.serviceprovider_id}"
									listValue="%{#attr.serviceprovider_name}" theme="simple"/>
									<br>
									<font color="red"><ov:fielderror
											fieldName="serviceprovider_id" /></font></td>
						</tr>
						</ov:if>
<ov:else>
							<ov:hidden id="serviceprovider_id" value="%{#session.serviceprovider_id}" name="serviceprovider_id"/>

</ov:else>
						<tr><td>&nbsp;</td>
						<td>Select SME Type</td>
							<td><ov:select id="smetype_id" headerKey="-1"
									name="smetype_id" headerValue="---- Select SME Type -----"
									list="sme_type_list" listKey="%{#attr.smetype_id}"
									listValue="%{#attr.smetype_name}" theme="simple"/>
									<br>
									<font color="red"><ov:fielderror
											fieldName="smetype_name" /></font></td>
						</tr>
						<tr><td>&nbsp;</td>
							<td>Mobile No</td>
							<td><ov:textfield id="mobile" name="mobile" theme="simple"/>
							<br>
									<font color="red"><ov:fielderror
											fieldName="mobile" /></font></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" />
							<ov:submit value="Search" action="SMESearch"/>
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
					<legend>List Of SME</legend> 
					<br> <br> 
					<input type="submit" value="Export to PDF"> 
					<input type="hidden" name="flag" value="4"> 
					<br> <br>
		<table align="center" width="90%" border-color="black" >
			<tr bgcolor="blue">
				<td align="center"><font color="white">Sl No.</font></td>
				<td align="center"><font color="white">SME Mobile</font></td>
				<td align="center"><font color="white">SME Name</font></td>
				<td align="center"><font color="white">Service Provider</font></td>
				<td align="center"><font color="white">SME Type</font></td>
				<td align="center"><font color="white">Status</font></td>
				<td align="center"><font color="white">Edit</font></td>
				<td align="center"><font color="white">Delete</font></td>
			</tr>

			<ov:iterator value="sme_list" status="row">
				<ov:if test="#row.even==true">
				<tr>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="mobile" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="sme_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="smetype_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="status" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Edit" onclick="editSme('<ov:property value="sme_id"/>','<ov:property value="mobile"/>','<ov:property value="sme_name"/>','<ov:property value="serviceprovider_id"/>','<ov:property value="smetype_id"/>')"></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Delete" onclick="deleteSme('<ov:property value="sme_id"/>','<ov:property value="mobile"/>','<ov:property value="sme_name"/>','<ov:property value="serviceprovider_id"/>','<ov:property value="smetype_id"/>')"></font></td>
				</tr>
			</ov:if>
			<ov:else>
			<tr>
				<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center"><font color="Black"><ov:property value="mobile" /></font></td>
				<td align="center"><font color="Black"><ov:property value="sme_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="smetype_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="status" /></font></td>
				<td align="center"><font color="Black"><input type="button" value="Edit" onclick="editSme('<ov:property value="sme_id"/>','<ov:property value="mobile"/>','<ov:property value="sme_name"/>','<ov:property value="serviceprovider_id"/>','<ov:property value="smetype_id"/>')"></font></td>
				<td align="center"><font color="Black"><input type="button" value="Delete" onclick="deleteSme('<ov:property value="sme_id"/>','<ov:property value="mobile"/>','<ov:property value="sme_name"/>','<ov:property value="serviceprovider_id"/>','<ov:property value="smetype_id"/>')"></font></td>
			</tr>
			</ov:else>
			</ov:iterator>
			

				</table>

				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>