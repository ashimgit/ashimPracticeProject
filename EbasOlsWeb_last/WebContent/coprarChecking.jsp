<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="headerTemplate.jsp"></jsp:include>
<script type="text/javascript">
	function myAgentDrop() {
		var div = document.getElementById('msg1');
		if (($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select Trade");
		} else {
			$("#msg2").text("Press Search");
		}
	}

	function myTradeDrop() {
		var div = document.getElementById('msg1');
		//alert($("#selectTrade").val);
		//console.log($("#selectVessel").val() + ':' + $("#selectTrade").val());
		if (($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')
				&& ($("#selectAgent").val() == 'NONE')) {
			$("#msg2").text("Press Search or Select Container Agent");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select Trade");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectVessel").val() == 'NONE')
				&& ($("#selectTrade").val() != 'N')) {
			$("#msg2").text("Select Vessel From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectVessel").val() == 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select Vessel From List");
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

		$('#selectAgent').find('option').remove().end().append(
				'<option value="NONE">Select Container Agent</option>').val(
				'NONE');

		$.ajax({
			type : "POST",
			contentType : 'application/json',
			dataType : 'json',
			url : "ebasOls/getCntAgent",
			data : JSON.stringify([ $("#selectVessel").val() ]),
			success : function(result) {
				var x = document.getElementById("selectAgent");

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
		var div = document.getElementById('msg1');
		//console.log($("#selectVessel").val()+':'+$("#selectTrade").val());
		if (($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() != 'N')) {
			$("#msg2").text("Press Search or Select Container Agent");
			document.getElementById("search").disabled = false;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectVessel").val() != 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select trade ");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectVessel").val() == 'NONE')
				&& ($("#selectTrade").val() != 'N')) {
			$("#msg2").text("Select Vessel From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = false;
		} else if (($("#selectVessel").val() == 'NONE')
				&& ($("#selectTrade").val() == 'N')) {
			$("#msg2").text("Select Vessel From List");
			document.getElementById("search").disabled = true;
			document.getElementById("resetBtn").disabled = true;
		}

	}
	function myReset() {
		$('#dataTable').hide();
		$('#selectVessel').val('NONE');
		$('#selectTrade').val('N');
		//$('#selectAgent').empty();
		$('#selectAgent').find('option').remove().end().append(
				'<option value="NONE">Select Container Agent</option>').val(
				'NONE');
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
						$
								.ajax({
									type : "GET",
									url : "ebasOls/getVesselCnt",
									success : function(result) {
										var x = document
												.getElementById("selectVessel");

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
											var valueagent = ($('#selectAgent')
													.val());

											if (valueagent == 'NONE') {
												valueagent = '';
											}

											$
													.ajax({
														type : "POST",
														contentType : 'application/json',
														dataType : 'json',
														url : "ebasOls/getContainerCnt",
														data : JSON
																.stringify([
																		$(
																				"#selectVessel")
																				.val(),
																		$(
																				"#selectTrade")
																				.val(),
																		valueagent ]),
														success : function(
																result) {

															$('#dataTable td')
																	.remove();
															$('#dataTable')
																	.hide();
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
						<h1 class="page-header">EBAS online services | Coprar
							Checking</h1>
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
							<div class="col-lg-8">
								<select onchange="myVesselDrop()" id="selectVessel"
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
									id="selectTrade"
									style="display: block; width: 70%; height: 31px; padding: 6px 6px; line-height: 1.42857143; color: #555; border: 1px solid #ccc; border-radius: 4px;">
									<option value="N">Select Trade</option>
									<option value="I">Import</option>
									<option value="E">Export</option>
								</select>
							</div>
						</div>
						<div class="col-lg-12">

							<div class="col-lg-2" style="width: 8.2% !important">
								<label
									style="display: block; width: 50%; height: 10%; padding: 6px 2px;">Agent</label>
							</div>
							<div class="col-lg-4">
								<select onchange="myAgentDrop()" id="selectAgent"
									class="form-control"
									style="display: block; width: 98%; height: 9%; padding: 6px 6px; line-height: 1.42857143; color: #555; border: 1px solid #ccc; border-radius: 4px;">
									<option value="NONE">Select Container Agent</option>

								</select>
							</div>
						</div>


						<div class="col-lg-12">
							<div class="col-lg-1">
								<label
									style="display: block; width: 50%; height: 34px; padding: 6px 2px;">Message
								</label>
							</div>
							<div class="col-lg-4" id="msg1">
								<label id="msg2"
									style="display: block; width: 100%; height: 34px; padding: 6px 3px; color: activeborder; color: fuchsia;">Select
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

			<div class="table-responsive"
				style="margin-top: 2%; overflow: auto; max-height: 55%;">
				<table id="dataTable"
					class="table table-striped table-bordered table-fixed nowrap"
					style="text-align: center;">

					<thead>
						<tr>
							<th style="text-align: center;">Sl No</th>
							<th style="text-align: center;">MLO</th>
							<th style="text-align: center;">Container No</th>
							<th style="text-align: center;">Trade</th>
							<th style="text-align: center;">ISO Code</th>
							<th style="text-align: center;">Size</th>
							<th style="text-align: center;">Status</th>
							<th style="text-align: center;">Tare Wt</th>
							<th style="text-align: center;">Gross Wt</th>
							<th style="text-align: center;">POL/POD</th>
							<th style="text-align: center;">POO/POF</th>
							<th style="text-align: center;">Mode</th>
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
