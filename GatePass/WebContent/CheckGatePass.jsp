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

<ov:form action="CheckGatePass1" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset>
					<legend>Check GatePass</legend>


					<table align="center">


						<tr valign="middle">
							<td>Enter GatePass Number</td>
							<td><ov:textfield name="GatePass" theme="simple"/></td>
						</tr>
						<tr>

							<td><input type="submit" value="Submit" /></td>
							<td><input type="reset" value="Clear" /></td>
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


				<h1><font color="red"><ov:property value="outputtext"/></font></h1>
				
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>