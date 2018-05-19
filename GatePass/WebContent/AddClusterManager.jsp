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

<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		$("#clear").hide();

	});

	function editClusterManager(clustermanager_id, clustermanager_name,
			mobile_no) {
		$("#clustermanager_id").val(clustermanager_id);
		$("#clustermanager_name").val(clustermanager_name);
		$("#mobile_no").val(mobile_no);
		$("#act").val("Save");
		$("#clear").show();

	}

	function deleteClusterManager(clustermanager_id, clustermanager_name,
			mobile_no) {
		$("#clustermanager_id").val(clustermanager_id);
		$("#clustermanager_name").val(clustermanager_name);
		$("#mobile_no").val(mobile_no);
		$("#act").val("Delete?");
		$("#clear").show();
	}

	function clear1() {
		$("#clustermanager_id").val("");
		$("#clustermanager_name").val("");
		$("#mobile_no").val("");
		$("#act").val("Add");
		$("#clear").hide();
	}
</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->


<ov:form action="ClusterManagerAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width: 400px;">
					<legend>Add Cluster Manager</legend>


					<table align="center">


						<tr valign="top">
							<td>Name</td>
							<td><ov:textfield id="clustermanager_name"
									name="clustermanager_name" theme="simple" /> <ov:hidden
									id="clustermanager_id" name="clustermanager_id" theme="simple" />
								<br><font color="red"><ov:fielderror fieldName="clustermanager_name" /></font></td>
						</tr>

						<tr>
							<td>Mobile No</td>
							<td><ov:textfield id="mobile_no" name="mobile_no"
									theme="simple" /> 
							<br><font color="red"><ov:fielderror fieldName="mobile_no" /></font></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;<ov:submit id="act" name="act"
									value="Add" theme="simple" /> <ov:submit id="clear"
									value="Clear" onclick="clear1()" theme="simple" /> <ov:submit
									value="Search" action="ClusterManagerSearch" theme="simple" /></td>
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
		<ov:actionmessage />
	</div>
</ov:if>

<fieldset>
	<legend>List Of Cluster Manager</legend>
	<br> <br> <input type="submit" value="Export to PDF">
	<input type="hidden" name="flag" value="4"> <br> <br>

	<table align="center" width="90%" border-color="black" >

		<tr>
			<td align="center" bgcolor="blue"><font color="white">Sl No</font></td>
			<td align="center" bgcolor="blue"><font color="white">Name</font></td>
			<td align="center" bgcolor="blue"><font color="white">Mobile
					No</font></td>
			<td align="center" bgcolor="blue"><font color="white">Edit</font></td>
			<td align="center" bgcolor="blue"><font color="white">Delete</font></td>
		</tr>

		<ov:iterator value="clustermanager_list" status="row">
			<ov:if test="#row.even==true">

				<tr>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
									value="#row.count" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
								value="clustermanager_name" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
								value="mobile_no" /></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
							type="button" value="Edit"
							onclick="editClusterManager('<ov:property value="clustermanager_id"/>','<ov:property value="clustermanager_name"/>','<ov:property value="mobile_no"/>')"></font></td>
					<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
							type="button" value="Delete"
							onclick="deleteClusterManager('<ov:property value="clustermanager_id"/>','<ov:property value="clustermanager_name"/>','<ov:property value="mobile_no"/>')"></font></td>
				</tr>
			</ov:if>
			<ov:else>
			<td align="center"><font color="Black"><ov:property
									value="#row.count" /></font></td>
				<td align="center"><font color="Black"><ov:property
							value="clustermanager_name" /></font></td>
				<td align="center"><font color="Black"><ov:property
							value="mobile_no" /></font></td>
				<td align="center"><font color="Black"><input
						type="button" value="Edit"
						onclick="editClusterManager('<ov:property value="clustermanager_id"/>','<ov:property value="clustermanager_name"/>','<ov:property value="mobile_no"/>')"></font></td>
				<td align="center"><font color="Black"><input
						type="button" value="Delete"
						onclick="deleteClusterManager('<ov:property value="clustermanager_id"/>','<ov:property value="clustermanager_name"/>','<ov:property value="mobile_no"/>')"></font></td>
			</ov:else>
		</ov:iterator>



	</table>

</fieldset>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>