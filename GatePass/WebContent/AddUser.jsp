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

function editUser(user_id,mobile_no,user_name,password,name,usertype_id,serviceprovider_id)
{
	//alert(user_id+" "+mobile_no+" "+user_name+" "+password+" "+name+" "+usertype_id+" "+serviceprovider_id);
	$("#name").val(name);
	$("#user_name").val(user_name);
	$("#password").val(password);
	$("#mobile_no").val(mobile_no);
	$("#serviceprovider_id").val(serviceprovider_id);
	$("#user_id").val(user_id);
	$("#usertype_id").val(usertype_id);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteUser(user_id,mobile_no,user_name,password,name,usertype_id,serviceprovider_id)
{
	$("#name").val(name);
	$("#user_name").val(user_name);
	$("#password").val(password);
	$("#mobile_no").val(mobile_no);
	$("#serviceprovider_id").val(serviceprovider_id);
	$("#user_id").val(user_id);
	$("#usertype_id").val(usertype_id);
	$("#act").val("Delete?");
	$("#clear").show();


}

function clear1()
{
	$("#name").val("");
	$("#user_name").val("");
	$("#password").val("");
	$("#mobile_no").val("");
	$("#serviceprovider_id").val("-1");
	$("#user_id").val("");
	$("#usertype_id").val("-1");
	$("#act").val("Add");
	$("#clear").hide();
}
</script>


<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="UserAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width: 500px;">
					<legend>Add User</legend>


					<table align="center" width="80%" border="0">


						<tr valign="middle">
							<td width="34%">Name</td>
							<td width="52%"><ov:textfield name="name" id="name" theme="simple"/>
							<ov:hidden id="user_id" name="user_id" theme="simple"/></td>
						</tr>
<ov:if test="#session.serviceprovider_id==\"70\"">					
						<tr>
						<td>Select User Type</td>
							<td><ov:select id="usertype_id" headerKey="-1"
									name="usertype_id" headerValue="---- Select User Type -----"
									list="usertype_list" listKey="%{#attr.usertype_id}"
									listValue="%{#attr.usertype_name}" theme="simple"/></td>
						</tr>

						<tr>
						<td>Select Service Provider</td>
							<td><ov:select id="serviceprovider_id" headerKey="-1"
									name="serviceprovider_id"
									headerValue="-Select Service Provider-" list="serviceprovider_list"
									listKey="%{#attr.serviceprovider_id}"
									listValue="%{#attr.serviceprovider_name}" theme="simple"/></td>
						</tr>
</ov:if>
<ov:else>
<ov:hidden id="serviceprovider_id" value="%{#session.serviceprovider_id}" name="serviceprovider_id"/>
<input type="hidden" value="5" name="usertype_id">
</ov:else>
						<tr>
							<td>User Name</td>
							<td><ov:textfield  name="user_name" id="user_name" theme="simple"/></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><ov:textfield  name="password" id="password" theme="simple"/></td>
						</tr>
						<tr>
							<td>Mobile No</td>
							<td><ov:textfield  name="mobile_no" id="mobile_no" theme="simple"/></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td>
							<td colspan="2">&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" />
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
					<legend>List Of User</legend> 
					<br> <br> 
					<input type="submit" value="Export to PDF"> 
					<input type="hidden" name="flag" value="1"> 
					<br> <br>
		<table align="center" width="90%" border-color="black" >
			<tr bgcolor="blue">
				<td align="center"><font color="Green">Sl No</font></td>
				<td align="center"><font color="Green">Name</font></td>
				<td align="center"><font color="Green">User Name</font></td>
				<td align="center"><font color="Green">Password</font></td>
				<td align="center"><font color="Green">User Mobile</font></td>
				<td align="center"><font color="Green">User Type</font></td>
				<td align="center"><font color="Green">Service Provider</font></td>
				<td align="center"><font color="Green">Edit</font></td>
				<td align="center"><font color="Green">Delete</font></td>
			
			</tr>

			<ov:iterator value="user_list" status="row">
				<ov:if test="#row.even==true">
				<tr>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="user_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="password" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="mobile_no" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="usertype_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Edit" onclick="editUser('<ov:property value="user_id"/>','<ov:property value="mobile_no"/>','<ov:property value="user_name"/>','<ov:property value="password"/>','<ov:property value="name"/>','<ov:property value="usertype_id"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Delete" onclick="deleteUser('<ov:property value="user_id"/>','<ov:property value="mobile_no"/>','<ov:property value="user_name"/>','<ov:property value="password"/>','<ov:property value="name"/>','<ov:property value="usertype_id"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				</tr>
			</ov:if>
			<ov:else>
			<tr>
				<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center"><font color="Black"><ov:property value="name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="user_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="password" /></font></td>
				<td align="center"><font color="Black"><ov:property value="mobile_no" /></font></td>
				<td align="center"><font color="Black"><ov:property value="usertype_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center"><font color="Black"><input type="button" value="Edit" onclick="editUser('<ov:property value="user_id"/>','<ov:property value="mobile_no"/>','<ov:property value="user_name"/>','<ov:property value="password"/>','<ov:property value="name"/>','<ov:property value="usertype_id"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				<td align="center"><font color="Black"><input type="button" value="Delete" onclick="deleteUser('<ov:property value="user_id"/>','<ov:property value="mobile_no"/>','<ov:property value="user_name"/>','<ov:property value="password"/>','<ov:property value="name"/>','<ov:property value="usertype_id"/>','<ov:property value="serviceprovider_id"/>')"></font></td>
				</tr>
			</ov:else>
			</ov:iterator>
			

				</table>

				</fieldset>	
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>