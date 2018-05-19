<%@ include file="header.jsp"%>
<style type="text/css">
.welcome {
	background-color: #DDFFDD;
	border: 1px solid #009900;
	width: 380px;
}

.welcome li {
	list-style: none;
}

.sudip li {
	list-style: none;
}
</style>


<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="additionalexcelupload" method="post" enctype="multipart/form-data">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width: 500px;">
					<legend>Add Excel Containing Tower ID </legend>


					<table align="center" >


						<tr>
							
							<td width="40%">Supervisor Name</td>
							<td width="60%"><ov:textfield id="supervisor_name" name="supervisor_name" theme="simple"/></td>
						</tr>
						<tr>
							<td>Supervisor Mobile</td>
							<td><ov:textfield id="supervisor_mobile" name="supervisor_mobile" theme="simple"/>
							<br><font color="red"><ov:fielderror fieldName="supervisor_mobile" /></font></td>
						</tr>
						<tr>
							<td width="40%">Supervisor Designation</td>
							<td width="60%"><ov:textfield id="designation" name="designation" theme="simple"/></td>
						</tr>
						<tr>
							<td>Reason</td>
							<td><ov:textarea id="reason" rows="3" cols="1" name="reason" style="resize:none;" theme="simple"/></td>
						</tr>
						<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
						<tr>
						<td>Select Excel File in <strong>.xlsx </strong>Format</td>
							<td><input type="file" name="excel"></td>
						</tr>
						<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
						<tr>
							<td>&nbsp;</td>
							<td><ov:submit value="Upload Excel" theme="simple"/></td>
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
<center>
	<h1>
		<font color="red">Format of The Excel File should be like </font>
	</h1>
</center>
<h4>
<table align="center" border="1">
	<tr>
		<th><font color="green">Indus Site ID</font></th>
	</tr>
</h4>
<h5>
	<tr>
		<td align="center">1055555</td>
	</tr>
	<tr>
		<td align="center">1044444</td>
	</tr>
</h5>
</table>

<h1>
	<font color="red"><ov:property value="outputtext" /></font>
</h1>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->





<%@ include file="footer.jsp"%>