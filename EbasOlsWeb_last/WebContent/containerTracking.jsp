<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="headerTemplate.jsp"></jsp:include>

<script type="text/javascript">


	function myAgentDrop() {
		var div = document.getElementById('msg1');

		$('#selectVessel').find('option').remove().end().append(
				'<option value="NONE">Select Vessel</option>').val('NONE');

		$.ajax({
			type : "POST",
			contentType : 'application/json',
			dataType : 'json',
			url : "ebasOls/getVesselTrack",
			data : JSON.stringify([ $("#selectAgent").val() ]),
			success : function(result) {
				var x = document.getElementById("selectVessel");

				for (var j = 0; j < result.length; j++) {
					var option = document.createElement("option");
					option.text = result[j];
					x.add(option);
				}
			},
			error : function() {
				console.log();
				alert('error in Agent');

			}
		});
		if (($("#selectAgent").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')
				&& ($("#selectVessel").val() == 'NONE')) {
			$("#msg2").text("Press Search or Select Vessel");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectAgent").val() != 'NONE')
				&& ($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Press Search or Select Trade");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectAgent").val() == 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select Agent From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = true;
		} else if (($("#selectAgent").val() != 'NONE')
				&& ($("#selectVessel").val() == 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Press Search or Select Vessel and Trade");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')
				&& ($("#selectAgent").val() != 'NONE')) {
			$("#msg2").text("Press Search");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		}
		document.getElementById("search").disabled = false;
		document.getElementById("resetBtn").disabled = false;

	}

	function myTradeDrop() {
		var div = document.getElementById('msg1');
		//console.log($("#selectVessel").val() + ':' + $("#selectTrade").val());
		if (($("#selectAgent").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')
				&& ($("#selectVessel").val() == 'NONE')) {
			$("#msg2").text("Press Search or Select Vessel");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectAgent").val() != 'NONE')
				&& ($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Press Search or Select Trade");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectAgent").val() == 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select Agent From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = true;
		} else if (($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')
				&& ($("#selectAgent").val() != 'NONE')) {
			$("#msg2").text("Press Search");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		}
	}
	function myVesselDrop() {

		var div = document.getElementById('msg1');
		//console.log($("#selectVessel").val()+':'+$("#selectTrade").val());
		if (($("#selectAgent").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')
				&& ($("#selectVessel").val() == 'NONE')) {
			$("#msg2").text("Press Search or Select Vessel");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectAgent").val() != 'NONE')
				&& ($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Press Search or Select Trade");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectAgent").val() == 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select Agent From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = true;
		} else if (($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')
				&& ($("#selectAgent").val() != 'NONE')) {
			$("#msg2").text("Press Search");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		}

	}
	function myReset() {
		$('#dataTable').hide();
		//$('#selectVessel').val('NONE');
		$('#selectTrade').val('N');
		$('#selectAgent').val('NONE');
		$('#myInput').hide();
		$('#selectVessel').find('option').remove().end().append(
				'<option value="NONE">Select Vessel</option>').val('NONE');

		$("#msg2").text("Select Agent From List");
		document.getElementById("search").disabled = true;
		document.getElementById("resetBtn").disabled = true;

	}
	
	function myFunction() {
		  var input, filter, table, tr, td, i, td2;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("dataTable");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[4];
		    td2 = tr[i].getElementsByTagName("td")[2];
		    if (td || td2) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1 || td2.innerHTML.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
	
	$(document)
			.ready(
					function() {

						$('#dataTable').hide();
						$('#myInput').hide();
						$('#selectTrade').val('N');
						document.getElementById("search").disabled = true;
						document.getElementById("resetBtn").disabled = true;
						$.ajax({
							type : "GET",
							url : "ebasOls/getCntTrack",
							success : function(result) {
								var x = document.getElementById("selectAgent");
								//alert(result.length);
								for (var j = 0; j < result.length; j++) {
									var option = document
											.createElement("option");
									option.text = result[j];
									x.add(option);
								}
							},
							error : function() {
								console.log();
								alert('error');

							}
						});
						$("#search")
								.click(
										function() {
											var counterMsg = 0;
											var valuevessel = ($('#selectVessel')
													.val());

											if (valuevessel == 'NONE') {
												valuevessel = '';
											}

											var valuetrade = ($('#selectTrade')
													.val());

											if (valuetrade == 'N') {
												valuetrade = '';
											}

											$
													.ajax({
														type : "POST",
														contentType : 'application/json',
														dataType : 'json',
														url : "ebasOls/getContainerTrack",
														data : JSON
																.stringify([
																		$(
																				"#selectAgent")
																				.val(),
																		valuevessel,
																		valuetrade ]),
														success : function(
																result) {

															$('#dataTable td')
																	.remove();
															$('#dataTable')
																	.hide();
															
															if (result.length > 0) {
																$('#dataTable')
																		.show();
																$('#myInput')
																.show();

																for (var j = 0; j < result.length; j++) {
																	i = 0;
																	counterMsg++;
																	$(
																			'#dataTable')
																			.append(
																					'<tr><td>'
																							+ (j + 1)
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td><td>'
																							+ (result[j][i++])
																							+ '</td></tr>')
																}
																$("#msg2")
																		.text(
																				"No. Of records found "
																						+ result.length);
															} else
																$("#msg2")
																		.text(
																				"No record found ");
														}
													});

										});
					});
</script>

</head>

<body>

	<div id="wrapper">

		<jsp:include page="sideTemplate.jsp"></jsp:include>

		<div id="page-wrapper" style="height: 100%; !important">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div id="posQry">
					<div class="col-lg-12">
						<h1 class="page-header">EBAS online services | Container
							Tracking</h1>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">

					<div class="col-lg-12">
						<div class="col-lg-1" style="width: 8% !important">
							<div class="col-lg-2" style="width: 8.2% !important">
								<label
									style="display: block; width: 50%; height: 10%; padding: 6px 2px;">Agent</label>
							</div>
						</div>
						<div class="col-lg-11">
							<div class="col-lg-7">
								<select onchange="myAgentDrop()" id="selectAgent"
									class="form-control"
									style="display: block; width: 100%; height: 9%; padding: 6px 6px; line-height: 1.42857143; color: #555; border: 1px solid #ccc; border-radius: 4px;">
									<option value="NONE">Select Container Agent</option>

								</select>
							</div>
						</div>
					</div>


					<div class="col-lg-12">
						<!-- <div class="col-lg-8"> -->
						<div class="col-lg-1" style="width: 8% !important">
							<div class="col-lg-2" style="width: 8.2% !important">
								<label
									style="display: block; width: 170%; height: 10%; padding: 6px 2px;">Vessel</label>
							</div>
							</div>
							<div class="col-lg-3" style="margin-left: 1%;">
								<select onchange="myVesselDrop()" id="selectVessel"
									class="form-control"
									style="display: block; width: 100%; height: 9%; padding: 6px 6px; line-height: 1.42857143; color: #555; border: 1px solid #ccc; border-radius: 4px;">
									<option value="NONE">Select Vessel</option>

								</select>
							</div>
						<!-- </div> -->
						<!-- <div class="col-lg-3"> -->
							<div class="col-lg-1">
								<label
									style="display: block; width: 180%; height: 34px; padding: 6px 12px;">Trade
								</label>
							</div>
							<div class="col-lg-3">
								<select onchange="myTradeDrop()" class="form-control"
									id="selectTrade"
									style="display: block; width: 73%; height: 31px; padding: 6px 6px; line-height: 1.42857143; color: #555; border: 1px solid #ccc; border-radius: 4px;">
									<option value="N">Select Trade</option>
									<option value="I">Import</option>
									<option value="E">Export</option>
									<option value="S">Stock</option>
								</select>
							</div>
						<!-- </div> -->



						<div class="col-lg-12">
							<div class="col-lg-1">
								<label
									style="display: block; width: 50%; height: 34px; padding: 6px 2px;">Message
								</label>
							</div>
							<div class="col-lg-4" id="msg1">
								<label id="msg2"
									style="display: block; width: 100%; height: 34px; padding: 6px 3px; color: activeborder; color: fuchsia;">Select
									Agent From List</label>

							</div>
							
						</div>

						<div class="col-lg-6 ">
							<div class="col-lg-2">
								<button class="btn btn-primary" type="button" id="search">
									<i class="fa fa-search"></i>&nbsp; Search
								</button>
							</div>
							<div class="col-lg-3">
								<button class="btn btn-danger" type="reset" id="resetBtn"
									onclick="myReset()">
									<i class="fa fa-repeat"></i>&nbsp; Reset
								</button>
							</div>
						</div>
						<div class="col-lg-12">
						
								<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
							
						</div>
					</div>
				</div>
			</div>

			<div class="table-responsive"
				style="margin-top: 2%; max-height: 55%;width:100% !important;">
				<table id="dataTable"
					class="table table-striped table-bordered table-fixed nowrap"
					style="text-align: center;width:100% !important;">

					<thead>
						<tr>
							<th style="text-align: center;">Sl No</th>
							<th style="text-align: center;">VCN</th>
							<th style="text-align: center;">Vessel Name</th>
							<th style="text-align: center;">Trade</th>
							<th style="text-align: center;">Container No</th>
							<th style="text-align: center;">Size</th>
							<th style="text-align: center;">Status</th>
							<th style="text-align: center;">Entry Date</th>
							<th style="text-align: center;">Exit Date</th>
							<th style="text-align: center;">Remark</th>
						</tr>
					</thead>

					<tbody>

					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>

</html>
