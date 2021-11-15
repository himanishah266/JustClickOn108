<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/Driver/">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../bootstrap.min.css">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">

<!-- App favicon -->
<link rel="shortcut icon" href="assets/images/favicon.ico">
<!-- App title -->
<title>click on 108</title>

<!--Morris Chart CSS -->
<link rel="stylesheet" href="css/morris.css">

<!-- App css -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/core.css" rel="stylesheet" type="text/css" />
<link href="css/components.css" rel="stylesheet" type="text/css" />
<link href="css/icons.css" rel="stylesheet" type="text/css" />
<link href="css/pages.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/responsive.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/switchery.min.css">

<!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

<script src="js/modernizr.min.js"></script>
<script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

          ga('create', 'UA-83057131-1', 'auto');
          ga('send', 'pageview');

       </script>
<script
	src="http://maps.google.com/maps/api/js?key=AIzaSyDGBTc2yRLHSq8TeEJl-80Zl3VPShIbfXU"
	type="text/javascript">
	</script>

<script>
	
			function loadUser()
			{
				
				
				var loginID=document.getElementById("user11");
				alert(loginID.value);
				
				var xmlHttp=new XMLHttpRequest();
				
				xmlHttp.onreadystatechange = function()
				{
					if(xmlHttp.readyState == 4)
					{
						var jsonObj=JSON.parse(xmlHttp.responseText);
						
					}
				}
				
			
				xmlHttp.open("get","<%=request.getContextPath()%>/sendLocationController?flag=loadUserAjax&loginID="+loginID.value,true);
				xmlHttp.send();
			}
			function loadCase()
			{
				
				
				var locationID=document.getElementById("location");
				alert(locationID.value);
				
				var xmlHttp=new XMLHttpRequest();
				
				xmlHttp.onreadystatechange = function()
				{
					if(xmlHttp.readyState == 4)
					{
						var jsonObj=JSON.parse(xmlHttp.responseText);
						
					}
				}
				
			
				xmlHttp.open("get","<%=request.getContextPath()%>/sendLocationController?flag=loadCaseAjax&locationID="+locationID.value,true);
				xmlHttp.send();
			}
		
		</script>

</head>


<body class="fixed-left" onload="fnroute()">

	<!-- Begin page -->
	<div id="wrapper">

		<!-- Top Bar Start -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Top Bar End -->


		<!-- ========== Left Sidebar Start ========== -->
		<jsp:include page="menu.jsp"></jsp:include>
		<!-- Left Sidebar End -->



		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<!-- ============================================================== -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="container">
					<div class="row"></div>
					<!-- end row -->

					<div class="row">

						<div class="col-lg-2 col-md-4 col-sm-6"></div>
						<!-- end col -->

						<div class="col-lg-2 col-md-4 col-sm-6"></div>
						<!-- end col -->




						<!-- end row -->



						<!-- end row -->


						<div class="row" style="width: 1000pt">
							<div class="col-lg-6" style="width: 1200pt">
								<div class="card-box">




									<input type="hidden" name="flag" value="search" />
									<div id="dvdata"></div>

									<table border="1">
									<tr>
										<td> location_latitude</td>
										<td> location_longitude</td>
										<td> ambulance_latitude</td>
										<td>ambulance_longitude </td>
										
										
										</tr>
										<f:forEach items="${sessionScope.DriverAndCaseList}" var="a">
											<input type="text" id="userlat" value="${a.latitude}" /> <input type="text"
																id="userlng" value="${a.longitude}" /> 
																<input type="text" id="amblat" value="${a.ambulanceVO.latitude }" /> <input
																type="text" id="amblng" value="${a.ambulanceVO.longitude }"/>
														
											<tr>
												<td>${a.latitude}</td>
											
											
												<td>${a.longitude}</td>
												<td>${a.ambulanceVO.latitude }</td>
												<td>${a.ambulanceVO.longitude }</td>
											
										</f:forEach>
									</table>




									<%-- <table>
										<f:forEach items="${sessionScope.Ambulancelist}" var="a">
											<tr>
												<td>${a.ambulanceNumber}</td>
												<td>${a.latitude}<input type="hidden"
													value="${a.latitude}" name="hd_latl" />
												</td>
												<td>${a.longitude}<input type="hidden"
													value="${a.longitude}" name="hd_lngl" />
												</td>
											</tr>
										</f:forEach>

										<f:forEach items="${sessionScope.Locationlist}" var="a">
											<tr>
												<td><input name="hd_latl" value="${a.latitude}"
													readonly="readonly"></td>
												<td><input name="hd_lngl" value="${a.longitude}"
													readonly="readonly"></td>
												<td><input name="loginId" value="${a.loginvo.loginID}"
													readonly="readonly"></td>
												<td></td>
											</tr>
										</f:forEach>
									</table>


									
 --%>
									<div id="map" style="width: 1000px; height: 800px;"></div>




									<div class="container">
										<h2>Modal Example</h2>
										<!-- Trigger the modal with a button -->
										<button type="button" class="btn btn-info btn-lg"
											data-toggle="modal" data-target="#myModal">Open
											Modal</button>

										<!-- Modal -->
										<div class="modal fade" id="myModal" role="dialog">
											<div class="modal-dialog">

												<!-- Modal content-->
												<div class="modal-content">
													+
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title"></h4>
														<form
															action="<%=request.getContextPath()%>/sendLocationController"
															method="post">

															<input type="hidden" name="flag" value="updatedrLocation" />
															<table>
																<tr>
																	<td>LoginID:</td>
																	<td><input type="text" id="user11" name="loginID"
																		value="<%=request.getSession().getAttribute("userID")%>"
																		onclick="loadUser()"></td>
																</tr>


																<tr>
																	<td>Case no:</td>
																	<td><input type="text" id="location"
																		name="locationID" onclick="loadCase()"
																		value="${sessionScope.lid}"></td>
																</tr>

																<tr>
																	<td>ambulance No:</td>
																	<td><select class="form-control" id="ambulance"
																		name="ambulanceNumber" width="100pt">

																			<f:forEach items="${sessionScope.Ambulancelist}"
																				var="a">
																				<option value="${a.ambulanceNumber}">${a.ambulanceNumber}</option>
																			</f:forEach>

																	</select></td>
																</tr>
															</table>
															<left>
															<input type="submit" name="submit" value="submit" /></left>

														</form>
													</div>

													<div class="modal-body"></div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal" onclick="fnroute()">OK</button>
														<button type="button" class="btn btn-default"
															data-dismiss="modal">Close</button>
													</div>
												</div>

											</div>
										</div>

									</div>


											<script type="text/javascript">
										
									</script>

								</div>
								<!-- end card -->
							</div>
							<!-- end col -->


							<!-- end col -->

						</div>
						<!-- end row -->




					</div>
					<!-- container -->

				</div>
				<!-- content -->

				<footer class="footer text-right"> 2016 © Zircos. </footer>

			</div>


			<!-- ============================================================== -->
			<!-- End Right content here -->
			<!-- ============================================================== -->


			<!-- Right Sidebar -->
			<div class="side-bar right-bar">
				<a href="javascript:void(0);" class="right-bar-toggle"> <i
					class="mdi mdi-close-circle-outline"></i>
				</a>
				<h4 class="">Settings</h4>
				<div class="setting-list nicescroll">
					<div class="row m-t-20">
						<div class="col-xs-8">
							<h5 class="m-0">Notifications</h5>
							<p class="text-muted m-b-0">
								<small>Do you need them?</small>
							</p>
						</div>
						<div class="col-xs-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#7fc1fc" data-size="small" />
						</div>
					</div>

					<div class="row m-t-20">
						<div class="col-xs-8">
							<h5 class="m-0">API Access</h5>
							<p class="m-b-0 text-muted">
								<small>Enable/Disable access</small>
							</p>
						</div>
						<div class="col-xs-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#7fc1fc" data-size="small" />
						</div>
					</div>

					<div class="row m-t-20">
						<div class="col-xs-8">
							<h5 class="m-0">Auto Updates</h5>
							<p class="m-b-0 text-muted">
								<small>Keep up to date</small>
							</p>
						</div>
						<div class="col-xs-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#7fc1fc" data-size="small" />
						</div>
					</div>

					<div class="row m-t-20">
						<div class="col-xs-8">
							<h5 class="m-0">Online Status</h5>
							<p class="m-b-0 text-muted">
								<small>Show your status to all</small>
							</p>
						</div>
						<div class="col-xs-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#7fc1fc" data-size="small" />
						</div>
					</div>
				</div>
			</div>
			<!-- /Right-bar -->

		</div>
		<!-- END wrapper -->



		<script>
			var resizefunc = [];
		</script>

		<!-- jQuery  -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/detect.js"></script>
		<script src="js/fastclick.js"></script>
		<script src="js/jquery.blockUI.js"></script>
		<script src="js/waves.js"></script>
		<script src="js/jquery.slimscroll.js"></script>
		<script src="js/jquery.scrollTo.min.js"></script>
		<script src="js/switchery.min.js"></script>

		<!-- Counter js  -->
		<script src="js/jquery.waypoints.min.js"></script>
		<script src="js/jquery.counterup.min.js"></script>

		<!--Morris Chart-->
		<!-- <script src="js/morris.min.js"></script> -->
		<script src="js/raphael-min.js"></script>

		<!-- Dashboard init -->
		<script src="js/jquery.dashboard.js"></script>

		<!-- App js -->
		<script src="js/jquery.core.js"></script>
		<script src="js/jquery.app.js"></script>
									<script type="text/javascript">
									function fnroute() {
								        
								var markerArray = [];

								        // Instantiate a directions service.
								        var directionsService = new google.maps.DirectionsService;

								        // Create a map and center it on Manhattan.
								        var map = new google.maps.Map(document.getElementById('map'), {
								          zoom: 13,
								          center: {lat: 40.771, lng: -73.974}
								        });

								        // Create a renderer for directions and bind it to the map.
								        var directionsDisplay = new google.maps.DirectionsRenderer({map: map});

								        // Instantiate an info window to hold step text.
								        var stepDisplay = new google.maps.InfoWindow;

								        // Display the route between the initial start and end selections.
								        calculateAndDisplayRoute(
								            directionsDisplay, directionsService, markerArray, stepDisplay, map);
								        // Listen to change events from the start and end lists.
								        var onChangeHandler = function() {
								          calculateAndDisplayRoute(
								              directionsDisplay, directionsService, markerArray, stepDisplay, map);
								        };
								        
								      }

								      function calculateAndDisplayRoute(directionsDisplay, directionsService,
								          markerArray, stepDisplay, map) {
								        // First, remove any existing markers from the map.
								        for (var i = 0; i < markerArray.length; i++) {
								          markerArray[i].setMap(null);
								        }

										var userlat = document
										.getElementById("userlat");
								var userlng = document
										.getElementById("userlng");
								var amblat = document
										.getElementById("amblat");
								var amblng = document
										.getElementById("amblng");


								        // Retrieve the start and end locations and create a DirectionsRequest using
								        // WALKING directions.
								        directionsService.route({
								        	origin : new google.maps.LatLng(
													parseFloat(userlat.value),
													parseFloat(userlng.value)),
											destination : new google.maps.LatLng(
													parseFloat(amblat.value),
													parseFloat(amblng.value)),

								          travelMode: 'DRIVING'
								        }, function(response, status) {
								          // Route the directions and pass the response to a function to create
								          // markers for each step.
								          if (status === 'OK') {
//								            document.getElementById('warnings-panel').innerHTML =
	//							                '<b>' + response.routes[0].warnings + '</b>';
								            directionsDisplay.setDirections(response);
								            showSteps(response, markerArray, stepDisplay, map);
								          } else {
								            window.alert('Directions request failed due to ' + status);
								          }
								        });
								      }

								      function showSteps(directionResult, markerArray, stepDisplay, map) {
								        // For each step, place a marker, and add the text to the marker's infowindow.
								        // Also attach the marker to an array so we can keep track of it and remove it
								        // when calculating new routes.
								        var myRoute = directionResult.routes[0].legs[0];
								        for (var i = 0; i < myRoute.steps.length; i++) {
								        	if(i==0 ||i==1  || i == myRoute.steps.length-1)
								        		{
								          var marker = markerArray[i] = markerArray[i] || new google.maps.Marker;
								          marker.setMap(map);
								          marker.setPosition(myRoute.steps[i].start_location);
								          attachInstructionText(
								              stepDisplay, marker, myRoute.steps[i].instructions, map);
								        }
								        }
								      }

								      function attachInstructionText(stepDisplay, marker, text, map) {
								        google.maps.event.addListener(marker, 'click', function() {
								          // Open an info window when the marker is clicked on, containing the text
								          // of the step.
								         $('#myModal').modal('show'); 
											 stepDisplay.setContent(text);
								          stepDisplay.open(map, marker);
								        });
								      }

											</script>
		
</body>
</html>