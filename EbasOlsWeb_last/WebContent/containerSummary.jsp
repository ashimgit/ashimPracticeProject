<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="headerTemplate.jsp"></jsp:include>

<script type="text/javascript">
	function myTradeDrop() {
		var div = document.getElementById('msg1');
		//alert($("#btnTrade").val);
		//console.log($("#mySelect").val()+':'+$("#btnTrade").val());
		if (($("#mySelect").val() != 'NONE') && ($("#btnTrade").val() != 'N')) {
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
			$("#msg2").text("Press Search");
		} else if (($("#mySelect").val() != 'NONE')
				&& ($("#btnTrade").val() == 'N')) {
			$("#msg2").text("Select trade ");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#mySelect").val() == 'NONE')
				&& ($("#btnTrade").val() != 'N')) {
			$("#msg2").text("Select Vessel From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#mySelect").val() == 'NONE')
				&& ($("#btnTrade").val() == 'N')) {
			$("#msg2").text("Select Vessel From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = true;
		}
	}
	function myVesselDrop() {
		var div = document.getElementById('msg1');
		//console.log($("#mySelect").val()+':'+$("#btnTrade").val());
		if (($("#mySelect").val() != 'NONE') && ($("#btnTrade").val() != 'N')) {
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
			$("#msg2").text("Press Search");

		} else if (($("#mySelect").val() != 'NONE')
				&& ($("#btnTrade").val() == 'N')) {
			$("#msg2").text("Select trade ");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#mySelect").val() == 'NONE')
				&& ($("#btnTrade").val() != 'N')) {
			$("#msg2").text("Select Vessel From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#mySelect").val() == 'NONE')
				&& ($("#btnTrade").val() == 'N')) {
			$("#msg2").text("Select Vessel From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = true;
		}
	}
	function myReset() {
		$('#dataTable').hide();
		$('#mySelect').val('NONE');
		$('#btnTrade').val('N');
		$("#msg2").text("Select Vessel From List");
		document.getElementById("search").disabled = true;
		document.getElementById("resetBtn").disabled = true;

	}
	$(document)
			.ready(
					function() {

						$('#dataTable').hide();
						$('#selectTrade').val('N');
						document.getElementById("search").disabled = true;
						document.getElementById("resetBtn").disabled = true;
						$.ajax({
							type : "GET",
							url : "ebasOls/getVessel",
							success : function(result) {
								var x = document.getElementById("mySelect");

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
											$
													.ajax({
														type : "POST",
														contentType : 'application/json',
														dataType : 'json',
														url : "ebasOls/getContainer",
														data : JSON
																.stringify([
																		$(
																				"#mySelect")
																				.val(),
																		$(
																				"#btnTrade")
																				.val() ]),
														success : function(
																result) {

															$('#dataTable td')
																	.remove();
															$('#dataTable')
																	.hide();
															document
																	.getElementById("search").disabled = true;
															if (result.length > 0) {
																$('#dataTable')
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
							Summary</h1>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="col-lg-6">
							<div class="col-lg-2">
								<label
									style="display: block; width: 180%; height: 10%; padding: 6px 2px;">Vessel</label>
							</div>
							<div class="col-lg-7">
								<select onchange="myVesselDrop()" id="mySelect"
									class="form-control"
									style="display: block; width: 100%; height: 9%; padding: 6px 6px; line-height: 1.42857143; color: #555; border: 1px solid #ccc; border-radius: 4px;">
									<option value="NONE">Select Vessel</option>

								</select>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="col-lg-2">
								<label
									style="display: block; width: 180%; height: 34px; padding: 6px 12px;">Trade
								</label>
							</div>
							<div class="col-lg-4">
								<select onchange="myTradeDrop()" class="form-control"
									id="btnTrade"
									style="display: block; width: 70%; height: 31px; padding: 6px 6px; line-height: 1.42857143; color: #555; border: 1px solid #ccc; border-radius: 4px;">
									<option value="N">Select Trade</option>
									<option value="I">Import</option>
									<option value="E">Export</option>
								</select>
							</div>
						</div>
						<div class="col-lg-12">
							<div class="col-lg-1">
								<label
									style="display: block; width: 180%; height: 34px; padding: 6px 2px;">Message
								</label>
							</div>
							<div class="col-lg-4" id="msg1">
								<label id="msg2"
									style="display: block; width: 180%; height: 34px; padding: 6px 3px; color: activeborder; color: fuchsia;">Select
									Vessel From List</label>

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

					</div>
				</div>
			</div>

			<div style="margin-top: 5%; overflow: auto; max-height: 55%;">
				<table id="dataTable"
					class="table table-striped table-bordered nowrap"
					style="text-align: center;">
					<thead>
						<tr>
							<th rowspan="2" style="text-align: center;">Sl No</th>
							<th rowspan="2" style="text-align: center;">MLO Code</th>
							<th colspan="4" style="text-align: center;">Load</th>
							<th colspan="4" style="text-align: center;">Empty</th>
							<th colspan="3" style="text-align: center;">Total</th>
						</tr>
						<tr>
							<th style="text-align: center;">20'</th>
							<th style="text-align: center;">40'</th>
							<th style="text-align: center;">45'</th>
							<th style="text-align: center;">Total</th>
							<th style="text-align: center;">20'</th>
							<th style="text-align: center;">40'</th>
							<th style="text-align: center;">45'</th>
							<th style="text-align: center;">Total</th>
							<th style="text-align: center;">Count</th>
							<th style="text-align: center;">TEUs</th>
							<th style="text-align: center;">Gross Weight</th>
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
