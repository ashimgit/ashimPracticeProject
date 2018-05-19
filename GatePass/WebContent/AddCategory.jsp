<%@ include file="header.jsp"%>

<style type="text/css">
.welcome li {
	list-style: url("images/bullet.gif");
}

.sudip li {
	list-style: url("images/bullet1.gif");
}
</style>

<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		$("#clear").hide();

	});

	function editCategory(category_id, category_name) {
		$("#div1").hide();
		$("#div2").hide();
		$("#category_id").val(category_id);
		$("#category_name").val(category_name);
		$("#act").val("Save");
		$("#clear").show();

	}

	function deleteCategory(category_id, category_name) {
		$("#div1").hide();
		$("#div2").hide();
		$("#category_id").val(category_id);
		$("#category_name").val(category_name);
		$("#act").val("Delete?");
		$("#clear").show();

	}

	function clear1() {
		$("#div1").hide();
		$("#div2").hide();
		$("#category_id").val("");
		$("#category_name").val("");
		$("#act").val("Add");
		$("#clear").hide();
	}
</script>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Entry Form Block Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

<ov:form action="CategoryAddition" method="post" theme="simple">
	<table align="center">
		<tr>
			<td>
				<fieldset style="width: 500px;">
					<legend>Add Category</legend>


					<table align="center">


						<tr valign="middle">
							<td>Enter Category</td>
							<td ><ov:textfield id="category_name"
									name="category_name" size="20px" label="Enter Category"
									theme="simple" />
								<br>
									<font color="red"><ov:fielderror
											fieldName="category_name" /></font>
								<ov:hidden id="category_id" name="category_id" theme="simple" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							
							<td colspan="2"> <ov:submit id="act" name="act" value="Add"
									theme="simple" />
							<ov:submit value="Search" action="CategorySearch"
									theme="simple" /> <ov:submit value="Generate Pdf"
									action="CategoryPdf" theme="simple" /> <ov:submit
									value="Show Full List" action="CategoryShowAll" theme="simple" />
							<ov:submit id="clear" value="Clear" onclick="clear1()"
									theme="simple" /></td>
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
		<font color="red" size="5px"><ov:actionmessage /></font>
	</div>
</ov:if>

<fieldset>
	<legend>List Of Category</legend>
	<ov:form action="CategorySort" method="post" theme="simple">
		<table align="center" width="90%" border-color="black" >
			<tr bgcolor="blue">
				<td align="center"><font color="white">Sl No</font></td>
				<td align="center"><!--<ov:submit action="CategoryAsc" value="A" />--><font
					color="white">Category Name</font>
				<!--<ov:submit action="CategoryDsc" value="D" />--></td>
				<td align="center"><font color="white">Edit</font></td>
				<td align="center"><font color="white">Delete</font></td>
			</tr>



			<ov:iterator value="category_list" status="row">
				<ov:if test="#row.even==true">
					<tr>
						<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
									value="#row.count" /></font></td>
						<td align="center" bgcolor="#CCCCCC"><font color="Black"><ov:property
									value="category_name" /></font></td>
						<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
								type="button" value="Edit"
								onclick="editCategory('<ov:property value="category_id"/>','<ov:property value="category_name"/>')"></font></td>
						<td align="center" bgcolor="#CCCCCC"><font color="Black"><input
								type="button" value="Delete"
								onclick="deleteCategory('<ov:property value="category_id"/>','<ov:property value="category_name"/>')"></font></td>
					</tr>
				</ov:if>
				<ov:else>
					<tr>
						<td align="center"><font color="Black"><ov:property
									value="#row.count" /></font></td>
						<td align="center"><font color="Black"><ov:property
									value="category_name" /></font></td>
						<td align="center"><font color="Black"><input
								type="button" value="Edit"
								onclick="editCategory('<ov:property value="category_id"/>','<ov:property value="category_name"/>')"></font></td>
						<td align="center"><font color="Black"><input
								type="button" value="Delete"
								onclick="deleteCategory('<ov:property value="category_id"/>','<ov:property value="category_name"/>')"></font></td>
					</tr>
				</ov:else>

			</ov:iterator>


		</table>
	</ov:form>
</fieldset>

<!--   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Report Block Ends ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->



<%@ include file="footer.jsp"%>