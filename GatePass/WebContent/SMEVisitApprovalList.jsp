<%@ include file="header.jsp"%>

<style type="text/css">

.welcome li{ 
	list-style: url("images/bullet.gif"); 
}

.sudip li{ 
	list-style: url("images/bullet1.gif"); 
}
</style>



<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="SMEVisitConfirm" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset>
					<legend>Search</legend>
					<br>
					<table align="center" width="90%" border-color="black">
						<tr>
							<td>Enter Tower ID</td>
							<td><input type="text" name="indus_tower_id"></td>
						</tr>
						<tr>
							<td>Enter SME Mobile No</td>
							<td><input type="text" name="unsme_mobile"></td>
						</tr>
						
						<tr>
						<td>
						</td>
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
      				<div class="welcome" id="div2">
      					<font color="red" size="5px"><ov:actionmessage/></font>
   					</div>
				</ov:if>
				
				<fieldset>
					<legend>List Of SME Visit Approved</legend> 
					<br> <br> 
					<input type="submit" value="Export to PDF"> 
					<input type="hidden" name="flag" value="4"> 
					<br> <br>
		
			
		<table align="center" width="90%" border-color="black" border="1px">
			<tr>
				<td align="center"><font color="Green">Tower Id</font></td>
				<td align="center"><font color="Green">SME Mobile</font></td>
				<td align="center"><font color="Green">Date Time</font></td>
				<td align="center"><font color="Green">Request From</font></td>
				<td align="center"><font color="Green">Name</font></td>
				<td align="center"><font color="Green">Company Name</font></td>
				<td align="center"><font color="Green">Purpose Name</font></td>
				<td align="center"><font color="Green">Approved By</font></td>
				<td align="center"><font color="Green">Approved Date/Time</font></td>
			</tr>
			<ov:iterator value="message1" status="row">

				<tr valign="middle">
					<ov:hidden value="%{#attr.unscheduled_req_id}" id="unscheduled_req_id" />
					<td width="15%" align="center"><ov:property value="indus_tower_id" /></td>
					<td width="15%" align="center"><ov:property	value="unsme_mobile" /></td>
					<td width="15%" align="center"><ov:property	value="datetime" /></td>
					<td width="5%" align="center"><ov:property value="interface_type" /></td>
					<td width="15%" align="center"><ov:property value="name" /></td>
					<td width="15%" align="center"><ov:property	value="company_name" /></td>
					<td width="5%" align="center"><ov:property	value="purpose_name" /></td>
					<td width="15%" align="center"><ov:property value="modified_by" /></td>
					<td width="40%" align="center"><ov:property value="modified_time" /></td>
				</tr>
			</ov:iterator>

		</table>

				</fieldset>
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>