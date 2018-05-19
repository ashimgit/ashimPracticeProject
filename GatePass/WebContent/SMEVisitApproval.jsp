<%@ include file="header.jsp"%>

<script type="text/javascript" language="javascript">
$(document).ready(function() {
	$("#f").hide();

});

function approval(unscheduled_req_id,indus_tower_id,unsme_mobile,datetime,interface_type,name,company_name,purpose_name)
{
	$("#f").show();
	$("#unscheduled_req_id").val(unscheduled_req_id);
	$("#indus_tower_id").val(indus_tower_id);
	$("#unsme_mobile").val(unscheduled_req_id);
	$("#datetime").val(datetime);
	$("#interface_type").val(interface_type);
	$("#name").val(name);
	$("#company_name").val(company_name);
	$("#purpose_name").val(purpose_name);

}

function clear1()
{
	$("#unscheduled_req_id").val("");
	$("#indus_tower_id").val("");
	$("#unsme_mobile").val("");
	$("#datetime").val("");
	$("#interface_type").val("");
	$("#name").val("");
	$("#company_name").val("");
	$("#purpose_name").val("");
	$("#f").hide();

}

</script>


<ov:form id="f" action="SMEVisitConfirm" method="post">
<table align="center">
<tr>
	<td>Tower Id</td><td><ov:textfield id="indus_tower_id" value="" readonly="true" theme="simple"/>
	<ov:hidden id="unscheduled_req_id" name="unscheduled_req_id" value="" readonly="true" theme="simple"/></td></tr>
	
	<tr><td>SME Mobile</td><td><ov:textfield id="unsme_mobile" value="" readonly="true" theme="simple"/></td></tr>
	<tr><td>Date Time</td><td><ov:textfield id="datetime" value="" readonly="true" theme="simple"/></td></tr>
	<tr><td>Request From</td><td><ov:textfield id="interface_type" value="" readonly="true" theme="simple"/></td></tr>
	<tr><td>Name</td><td><ov:textfield id="name" value="" readonly="true" theme="simple"/></td></tr>
	<tr><td>Company</td><td><ov:textfield id="company_name" value="" readonly="true" theme="simple"/></td></tr>
	<tr><td>Purpose</td><td><ov:textfield id="purpose_name" value="" readonly="true" theme="simple"/></td></tr>

	<tr><td></td><td><ov:submit value="Confirm Approval?" name="act" theme="simple"/>
	<input type="button" value="Clear" onclick="clear1()"></td></tr>
</table>
</ov:form>



<%@ include file="middle.jsp"%>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Starts ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


				<ov:if test="hasActionMessages()">
      				<div id="d" class="welcome">
      					<ov:actionmessage/>
   					</div>
				</ov:if>	
				
				<ov:form action="SMEVisitConfirmall" method="post">
				<ov:submit value="Approve All"/>
				</ov:form>
				
							
				<fieldset>
					<legend>List Of SME Visit Approval</legend> 
					<br> <br> 
					<br> <br>
		
		<table align="center" width="90%">
			<tr bgcolor="blue">
				<td align="center"><font color="white">Sl no.</font></td>
				<td align="center"><font color="white">Tower Id</font></td>
				<td align="center"><font color="white">SME Mobile</font></td>
				<td align="center"><font color="white">Date Time</font></td>
				<td align="center"><font color="white">Request From</font></td>
				<td align="center"><font color="white">Name</font></td>
				<td align="center"><font color="white">Company Name</font></td>
				<td align="center"><font color="white">Purpose Name</font></td>
				<td align="center"><font color="white">Approve</font></td>
			</tr>
			<ov:iterator value="message" status="row">
				<ov:if test="#row.even==true">
				<tr valign="middle">
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="indus_tower_id" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property	value="unsme_mobile" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property	value="datetime" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="interface_type" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="name" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property	value="company_name" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property	value="purpose_name" /></font></td>
					
					<td align="center" bgcolor="#CCCCCC"><font color="Black">
					<input type="button" value="Approve" onclick="approval('<ov:property value="unscheduled_req_id" />','<ov:property value="indus_tower_id" />','<ov:property value="unsme_mobile" />','<ov:property value="datetime" />','<ov:property value="interface_type" />','<ov:property value="name" />','<ov:property value="company_name" />','<ov:property value="purpose_name" />')"></font></td>
				</tr>
				</ov:if>
				<ov:else>
				<tr valign="middle">
					<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
					<td align="center"><font color="Black"><ov:property value="indus_tower_id" /></font></td>
					<td align="center"><font color="Black"><ov:property	value="unsme_mobile" /></font></td>
					<td align="center"><font color="Black"><ov:property	value="datetime" /></font></td>
					<td align="center"><font color="Black"><ov:property value="interface_type" /></font></td>
					<td align="center"><font color="Black"><ov:property value="name" /></font></td>
					<td align="center"><font color="Black"><ov:property	value="company_name" /></font></td>
					<td align="center"><font color="Black"><ov:property	value="purpose_name" /></font></td>
					
					<td align="center"><font color="Black">
					<input type="button" value="Approve" onclick="approval('<ov:property value="unscheduled_req_id" />','<ov:property value="indus_tower_id" />','<ov:property value="unsme_mobile" />','<ov:property value="datetime" />','<ov:property value="interface_type" />','<ov:property value="name" />','<ov:property value="company_name" />','<ov:property value="purpose_name" />')"></font></td>
				
				</tr>
				</ov:else>
			</ov:iterator>

		</table>

				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>