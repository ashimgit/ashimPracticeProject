<%@ include file="header.jsp"%>

<script type="text/javascript" language="javascript">
$(document).ready(function() {
	$("#f").hide();

});

function approval(sme_id,sme_name,smetype_name,serviceprovider_name)
{
	$("#d").hide();
	$("#f").show();
	$("#sme_id").val(sme_id);
	$("#sme_name").val(sme_name);
	$("#smetype_name").val(smetype_name);
	$("#serviceprovider_name").val(serviceprovider_name);

}

function clear1()
{
	$("#sme_id").val("");
	$("#sme_name").val("");
	$("#smetype_name").val("");
	$("#serviceprovider_name").val("");
	$("#f").hide();
	$("#d").hide();

}

</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
<ov:form id="f" action="ApprovalSME" method="post" theme="simple">
<table align="center">
<tr>
	<td>Name</td><td><ov:textfield id="sme_name" value="" readonly="true" theme="simple"/>
	<ov:hidden id="sme_id" name="sme_id" value="" readonly="true" theme="simple"/></td></tr>
	
	<tr><td>Type</td><td><ov:textfield id="smetype_name" value="" readonly="true" theme="simple"/></td></tr>
	<tr><td>Service Provider</td><td><ov:textfield id="serviceprovider_name" value="" readonly="true" theme="simple"/></td></tr>
	<tr><td></td><td><ov:submit value="Confirm Approval?" name="act" theme="simple"/>
	<input type="button" value="Clear" onclick="clear1()"></td></tr>
</table>
</ov:form>



<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


<%@ include file="middle.jsp"%>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Starts ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


				<ov:if test="hasActionMessages()">
      				<div id="d" class="welcome">
      					<ov:actionmessage/>
   					</div>
				</ov:if>
				<ov:form action="ApproveAllSME"	method="post">
				<ov:submit value="Approve All"/>
				</ov:form>
							
				<fieldset>
					<legend>List Of SME Joining Approval</legend> 
					<br> <br> 
					<br> <br>
		
		<table align="center" width="90%" border-color="black">
			<tr bgcolor="blue">
				<td align="center"><font color="white">Sl no.</font></td>
				<td align="center"><font color="white">Name</font></td>
				<td align="center"><font color="white">SME Type</font></td>
				<td align="center"><font color="white">Service Provider Name</font></td>
				<td align="center"><font color="white">Approve</font></td>
			</tr>
			<ov:iterator value="message" status="row">
			<ov:if test="#row.even==true">
				<tr valign="middle">
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="sme_name" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="smetype_name" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Approve" onclick="approval('<ov:property value="sme_id" />','<ov:property value="sme_name" />','<ov:property value="smetype_name" />','<ov:property value="serviceprovider_name" />')"></font></td>
				</tr>
			</ov:if>
			<ov:else>
				<tr valign="middle">
					<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
					<td align="center"><font color="Black"><ov:property value="sme_name" /></font></td>
					<td align="center"><font color="Black"><ov:property value="smetype_name" /></font></td>
					<td align="center"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
					<td align="center"><font color="Black"><input type="button" value="Approve" onclick="approval('<ov:property value="sme_id" />','<ov:property value="sme_name" />','<ov:property value="smetype_name" />','<ov:property value="serviceprovider_name" />')"></font></td>
				</tr>
			</ov:else>
			</ov:iterator>

		</table>

				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>