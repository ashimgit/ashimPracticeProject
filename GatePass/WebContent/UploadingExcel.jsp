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

<ov:form action="excelupload" method="post" enctype="multipart/form-data">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width: 500px;">
					<legend>Add Excel Containing Tower and GateKeeper Details</legend>


					<table align="center" >


						<tr valign="middle">
							<td><h4>Select Excel File in <strong>.xlsx </strong>Format</h4></td>
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
		<th><font color="green">Tech No.</font></th>
		<th><font color="green">Tech Name</font></th>
		<th><font color="green">Site Name</font></th>
		<th><font color="green">Site Address</font></th>
		<th><font color="green">Shelter type</font></th>
		<th><font color="green">District</font></th>
		<th><font color="green">LAT</font></th>
		<th><font color="green">LONG</font></th>
		<th><font color="green">Supervisor Name</font></th>
		<th><font color="green">Supervisor No.</font></th>
	</tr>
</h4>
<h5>
	<tr>
		<td align="center">1055555</td>
		<td align="center">7278403639</td>
		<td align="center">Avirup Pal</td>
		<td align="center">Metropolitan</td>
		<td align="center">Kolkata</td>
		<td align="center">GTP</td>
		<td align="center">21</td>
		<td align="center">22.65102</td>
		<td align="center">88.2683</td>
		<td align="center">Rajesh Baidya</td>
		<td align="center">9051677717</td>
	</tr>
	<tr>
		<td align="center">1044444</td>
		<td align="center">8900244895</td>
		<td align="center">Subhajit Kar</td>
		<td align="center">Durgapur</td>
		<td align="center">Bardhaman</td>
		<td align="center">GTP</td>
		<td align="center">5</td>
		<td align="center">22.65102</td>
		<td align="center">88.2683</td>
		<td align="center">Subham Biswas</td>
		<td align="center">9830330111</td>
	</tr>
</h5>
</table>

<h1>
	<font color="red"><ov:property value="outputtext" /></font>
</h1>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->





<%@ include file="footer.jsp"%>