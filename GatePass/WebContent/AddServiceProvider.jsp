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

function editServiceProvider(serviceprovider_id,category_id,serviceprovider_name)
{
	//alert(category_id+"  "+serviceprovider_id+" "+serviceprovider_name);
	$("#category").val(category_id);
	$("#service_provider").val(serviceprovider_name);
	$("#serviceprovider_id").val(serviceprovider_id);
	$("#act").val("Save");
	$("#clear").show();

}

function deleteServiceProvider(serviceprovider_id,category_id,serviceprovider_name)
{
	//alert(category_id+"  "+serviceprovider_id+" "+serviceprovider_name);
	$("#category").val(category_id);
	$("#service_provider").val(serviceprovider_name);
	$("#serviceprovider_id").val(serviceprovider_id);
	$("#act").val("Delete?");
	$("#clear").show();

}

function clear1()
{
	//alert("here");
	$("#category").val("-1");
	$("#service_provider").val("");
	$("#serviceprovider_id").val("");
	$("#act").val("Add");
	$("#clear").hide();
}

</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="ServiceProviderAddition" method="post" theme="simple">
	<table align="center">
				<tr>
					<td>
						<fieldset style="width:470px">
		<legend>Add Service Provider</legend>


		<table align="center">

			<tr>
			
			<td>Select Category</td>
				<td><ov:select id="category" label="Select Category" headerKey="-1"
						name="category_id" headerValue="--------- Select Category ---------"
						list="category_details" listKey="%{category_id}"
						listValue="%{category_name}" theme="simple"/></td>
			</tr>
			<tr><td></td><td class="sudip"><ov:fielderror fieldName="category_id"/></td></tr>
			
			<tr valign="middle">
				<td>Enter Service Provider Name</td>
				<td><ov:textfield id="service_provider" name="serviceprovider_name"
						label="Enter Service
						Provider Name" theme="simple" value="%{#action.serviceprovider_name}"/>
						<ov:hidden name="serviceprovider_id" id="serviceprovider_id" /></td>
			</tr>
			<tr><td></td><td class="sudip"><ov:fielderror fieldName="serviceprovider_name"/></td></tr>
			<tr>
			<td >&nbsp;</td>
			<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act" value="Add" theme="simple"/>
			<ov:submit action="ServiceProviderSearch" value="Search" theme="simple"/>
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
		<ov:if test="message_vs_table==\"1\"">
				<fieldset>
		<legend>List Of Service Provider</legend>
		<br> <br> 
					<input type="submit" value="Export to PDF"> 
					<input type="hidden" name="flag" value="1"> 
					<br> <br>
					
				
		<table align="center" width="90%" border-color="black" >
			<tr bgcolor="blue">
				<td align="center" bgcolor="blue"><font color="white">Sl No</font></td>
				<td align="center"><font color="white">Service Provider</font></td>
				<td align="center"><font color="white">Category</font></td>
				<td align="center"><font color="white">Edit</font></td>
				<td align="center"><font color="white">Delete</font></td>
			</tr>

			<ov:iterator value="serviceprovider_list" status="row">
				<ov:if test="#row.even==true">
				<tr>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property value="category_name" /></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Edit" onclick="editServiceProvider('<ov:property value="serviceprovider_id"/>','<ov:property value="category_id"/>','<ov:property value="serviceprovider_name"/>')"></font></td>
				<td align="center" bgcolor="#CCCCCC"><font color="Black"><input type="button" value="Delete" onclick="deleteServiceProvider('<ov:property value="serviceprovider_id"/>','<ov:property value="category_id"/>','<ov:property value="serviceprovider_name"/>')"></font></td>
				</tr>
				</ov:if>
				<ov:else>
				<tr>
				<td align="center"><font color="Black"><ov:property value="#row.count" /></font></td>
				<td align="center"><font color="Black"><ov:property value="serviceprovider_name" /></font></td>
				<td align="center"><font color="Black"><ov:property value="category_name" /></font></td>
				<td align="center"><font color="Black"><input type="button" value="Edit" onclick="editServiceProvider('<ov:property value="serviceprovider_id"/>','<ov:property value="category_id"/>','<ov:property value="serviceprovider_name"/>')"></font></td>
				<td align="center"><font color="Black"><input type="button" value="Delete" onclick="deleteServiceProvider('<ov:property value="serviceprovider_id"/>','<ov:property value="category_id"/>','<ov:property value="serviceprovider_name"/>')"></font></td>
				</tr>
				</ov:else>
			</ov:iterator>



				</table>

				</fieldset>
				</ov:if>
				
				
<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>