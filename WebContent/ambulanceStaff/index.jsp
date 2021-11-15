



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        	<base href="${pageContext.request.contextPath}/ambulanceStaff/"> 
        	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../bootstrap.min.css">
    
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <!-- App favicon -->
        <link rel="shortcut icon" href="assets/images/favicon.ico">
        <!-- App title -->
        <title>Zircos - Responsive Admin Dashboard Template</title>

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


    <body class="fixed-left"  onload="loadAmbulanceAndLocation()">

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
                        <div class="row">
							
						</div>
                        <!-- end row -->

                        <div class="row">

                            <div class="col-lg-2 col-md-4 col-sm-6">
                                
                            </div><!-- end col -->

                            <div class="col-lg-2 col-md-4 col-sm-6">
                               
                            </div><!-- end col -->
                            

                            
                           

                           
                        <!-- end row -->


                        
                        <!-- end row -->


                        <div class="row" style="width: 1000pt">
                            <div class="col-lg-6" style="width: 1200pt">
                                <div class="card-box" >
                                    



<input type="hidden" name="flag" value="search" />
	<div id="dvdata"></div>

	 <table style="display:none">
		 <f:forEach items="${sessionScope.Ambulancelist}" var="a">
			<tr>
				<td>${a.ambulanceNumber}</td>
				<td>${a.latitude}<input type="hidden" value="${a.latitude}"
					name="hd_latl" />
				</td>
				<td>${a.longitude}<input type="hidden" value="${a.longitude}"
					name="hd_lngl" />
				</td>
			</tr>
		</f:forEach> 

		<%-- <f:forEach items="${sessionScope.Locationlist}"  var="a">
			<tr>
				<td><input name="hd_latl" value="${a.latitude}"
					readonly="readonly"></td>
				<td><input name="hd_lngl" value="${a.longitude}"
					readonly="readonly"></td>
				<td><input name="loginId" value="${a.loginvo.loginID}"
					readonly="readonly"></td>
				<td></td>
			</tr>
		</f:forEach> --%>
	</table> 
	
	
	<div id="map" style="width: 1000px; height: 800px;"></div>


	  

	<div class="container">
		<h2>Modal Example</h2>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#myModal">Open Modal</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">          </h4>
						<form
							action="<%=request.getContextPath()%>/sendLocationController"
							method="post">
m
							<input type="hidden" name="flag" value="updateLocation"/>

							<table>
							<tr>
							<td>
							LoginID:</td>
							<td> <input type="text" id="user11" name="loginID"
								value="<%=request.getSession().getAttribute("userID")%>"
								onclick="loadUser()"> 
								</td>
								</tr>
								
								
								<tr>
								<td>
								Case no:
								</td>
								<td>
								<input type="text" id="location" name="locationID" onclick="loadCase()" value="${sessionScope.lid}">
									</td>	
									</tr>
								
									<tr>
									<td>						
								ambulance No:
								</td>
								<td>
								<select class="form-control" id="ambulance" name="ambulanceNumber" width="100pt">
								
								<f:forEach items="${sessionScope.Ambulancelist}" var="a">
								<option value="${a.ambulanceNumber}">${a.ambulanceNumber}</option>
								</f:forEach>
								
							</select>
							</td>
							
							
							<td>Hospital number:</td>
							<td>
								<select class="form-control" id="hospital" name="hospitalName" width="100pt">
								<f:forEach items="${sessionScope.searchlist}" var="a">
								<option value="${a.hospitalID}">${a.hospitalName}</option>
								</f:forEach>
								
							</select>
							</td>
							
							</tr>
							</table> 
							<left><input type="submit" name="submit" value="submit" /></left>

						</form>
					</div>

					<div class="modal-body">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>

	
	<script type="text/javascript">
	

	function loadAmbulanceAndLocation()
	{
		var xmlHttp=new XMLHttpRequest();
		xmlHttp.onreadystatechange = function()
		{
			if(xmlHttp.readyState == 4)
			{
				var jsonObj=JSON.parse(xmlHttp.responseText);
				var tag = "";
				for(var ii=0; ii<jsonObj.Locationlist.length; ii++)
				{
					
					tag = tag+"<input type='text' value='"+jsonObj.Locationlist[ii].latitude+"' name='hd_lat' ><input type='text' value='"+jsonObj.Locationlist[ii].longitude+"' name='hd_lng' ><input type='text' value='"+jsonObj.Locationlist[ii].locationID+"' name='locId' >";
					
				}
				document.getElementById("dvdata").innerHTML = tag;
				
				var lat = document.getElementsByName("hd_lat");
				var lng = document.getElementsByName("hd_lng");

				var latl = document.getElementsByName("hd_latl");
				var lngl = document.getElementsByName("hd_lngl");
				
				var locId = document.getElementsByName("locId");
				
				var map = new google.maps.Map(document.getElementById('map'), {
					zoom : 6,
					center : new google.maps.LatLng(parseFloat(lat[0].value),
							parseFloat(lng[0].value)),
							
					mapTypeId : google.maps.MapTypeId.ROADMAP
				});

				var infowindow = new google.maps.InfoWindow();


				var marker, i;
				for (i = 0; i < lat.length; i++) {
					//alert(lng[i].value);
					marker = new google.maps.Marker({
						position : new google.maps.LatLng(parseFloat(lat[i].value),
								parseFloat(lng[i].value)),
								icon: {
								      url: 'http://maps.google.com/mapfiles/ms/icons/green.png',
								    },
						map : map
					});

					google.maps.event.addListener(marker, 'click',
							(function(marker, i) {
								return function() {
									$('#myModal').modal('show'); 
									document.getElementById("location").value = locId[i].value;
									infowindow.setContent("");
									infowindow.open(map, marker);
								}
							})(marker, i));
				}
				
				for (i = 0; i < latl.length; i++) {
					//	alert(lngl[i].value);
						marker = new google.maps.Marker({
							position : new google.maps.LatLng(parseFloat(latl[i].value),
									parseFloat(lngl[i].value)),
									icon: {
									      url: 'http://maps.google.com/mapfiles/ms/icons/red.png',
									    },
							map : map
						});
			
						google.maps.event.addListener(marker, 'click',
								(function(marker, i) {
									return function() {
										$('#myModal').modal('show'); 
										document.getElementById("location").value = locId[i].value;
										infowindow.setContent("");
										infowindow.open(map, marker);
									}
								})(marker, i));
					}
				
					/* var locations = [ [ 'Bondi Beach', -33.890542, 151.274856, 4 ],
					[ 'Coogee Beach', -33.923036, 151.259052, 5 ],
					[ 'Cronulla Beach', -34.028249, 151.157507, 3 ],
					[ 'Manly Beach', -33.80010128657071, 151.28747820854187, 2 ],
					[ 'Maroubra Beach', -33.950198, 151.259302, 1 ] ];

					var lat = document.getElementsByName("hd_lat");
					var lng = document.getElementsByName("hd_lng");
					alert(lat[0].value);
					var latl = document.getElementsByName("hd_latl");
					var lngl = document.getElementsByName("hd_lngl");
			
					var map = new google.maps.Map(document.getElementById('map'), {
						zoom : 6,
						center : new google.maps.LatLng(parseFloat(lat[0].value),
								parseFloat(lng[0].value)),
								center : new google.maps.LatLng(parseFloat(latl[0].value),
										parseFloat(lngl[0].value)),
						mapTypeId : google.maps.MapTypeId.ROADMAP
					});

					var infowindow = new google.maps.InfoWindow();

					var marker, i;
					for (i = 0; i < 3; i++) {
						alert(lng[i].value);
						marker = new google.maps.Marker({
							position : new google.maps.LatLng(parseFloat(lat[i].value),
									parseFloat(lng[i].value)),
									icon: {
									      url: 'http://maps.google.com/mapfiles/ms/icons/blue.png',
									    },
							map : map
						});
			
						google.maps.event.addListener(marker, 'click',
								(function(marker, i) {
									return function() {
										$('#myModal').modal('show'); 
										infowindow.setContent("");
										infowindow.open(map, marker);
									}
								})(marker, i));
					}
					for (i = 0; i < latl.length; i++) {
					//	alert(lngl[i].value);
						marker = new google.maps.Marker({
							position : new google.maps.LatLng(parseFloat(latl[i].value),
									parseFloat(lngl[i].value)),
									icon: {
									      url: 'http://maps.google.com/mapfiles/ms/icons/red.png',
									    },
							map : map
						});
			
						google.maps.event.addListener(marker, 'click',
								(function(marker, i) {
									return function() {
										$('#myModal').modal('show'); 
										infowindow.setContent("");
										infowindow.open(map, marker);
									}
								})(marker, i));
					}
	
				
				 */
				
				
			}
		}
		xmlHttp.open("get","<%=request.getContextPath()%>/sendLocationController?flag=searchLocation",
							true);
			xmlHttp.send();

			//setTimeout("loadAmbulanceAndLocation()", 5000);
		}
	</script>
<script type="text/javascript">
		
	</script>
                                   
                                </div> <!-- end card -->
                            </div>
                            <!-- end col -->

                          
                            <!-- end col -->

                        </div>
                        <!-- end row -->




                    </div> <!-- container -->

                </div> <!-- content -->

                <footer class="footer text-right">
                    2016 © Zircos.
                </footer>

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


            <!-- Right Sidebar -->
            <div class="side-bar right-bar">
                <a href="javascript:void(0);" class="right-bar-toggle">
                    <i class="mdi mdi-close-circle-outline"></i>
                </a>
                <h4 class="">Settings</h4>
                <div class="setting-list nicescroll">
                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">Notifications</h5>
                            <p class="text-muted m-b-0"><small>Do you need them?</small></p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#7fc1fc" data-size="small"/>
                        </div>
                    </div>

                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">API Access</h5>
                            <p class="m-b-0 text-muted"><small>Enable/Disable access</small></p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#7fc1fc" data-size="small"/>
                        </div>
                    </div>

                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">Auto Updates</h5>
                            <p class="m-b-0 text-muted"><small>Keep up to date</small></p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#7fc1fc" data-size="small"/>
                        </div>
                    </div>

                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">Online Status</h5>
                            <p class="m-b-0 text-muted"><small>Show your status to all</small></p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#7fc1fc" data-size="small"/>
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

    </body>
</html>