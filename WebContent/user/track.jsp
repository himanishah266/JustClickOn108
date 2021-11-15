<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
<title>Google Maps Multiple Markers</title>
<script
	src="http://maps.google.com/maps/api/js?key=AIzaSyDGBTc2yRLHSq8TeEJl-80Zl3VPShIbfXU&sensor=false"
	type="text/javascript">
	</script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../bootstrap.min.css">

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
		
		
		<style>
      #right-panel {
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }

      #right-panel select, #right-panel input {
        font-size: 15px;
      }

      #right-panel select {
        width: 100%;
      }

      #right-panel i {
        font-size: 12px;
      }
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
        float: left;
        width: 70%;
        height: 100%;
      }
      #right-panel {
        margin: 20px;
        border-width: 2px;
        width: 20%;
        height: 400px;
        float: left;
        text-align: left;
        padding-top: 0;
      }
      #directions-panel {
        margin-top: 10px;
        background-color: #FFEE77;
        padding: 10px;
        }
        </style>


</head>
<body onload="loadAmbulanceAndLocation()">
	<input type="hidden" name="flag" value="search" />
	<div id="dvdata"></div>

	 <table style="display:none">
		 <f:forEach items="${sessionScope.Ambulancelist}" var="a">
			<tr>
				<td>${a.ambulanceNumber}</td>
				<td>${a.latitude}<input type="hidden" value="${a.latitude}"
					name="hd_lat" />
				</td>
				<td>${a.longitude}<input type="hidden" value="${a.longitude}"
					name="hd_lng" />
				</td>
			</tr>
		</f:forEach> 

		<f:forEach items="${sessionScope.Locationlist}"  var="a">
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
	<div id="map" style="width: 700px; height: 500px;"></div>


	<!-- <script type="text/javascript">
		var lat = document.getElementsByName("hd_lat");
		var lng = document.getElementsByName("hd_lng");

		var infowindow = new google.maps.InfoWindow();

		var marker, i;
		for (i = 0; i < lat.length; i++) {
			alert(lng[i].value);
			marker = new google.maps.Marker({
				position : new google.maps.LatLng(parseFloat(lat[i].value),
						parseFloat(lng[i].value)),
				map : map
			});

			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infowindow.setContent("");
							infowindow.open(map, marker);
						}
					})(marker, i));
		}
	</script> -->

	<div class="container">
		<h2>Modal Example</h2>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#myModal">Open Modal</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">+
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">          </h4>
						<form
							action="<%=request.getContextPath()%>/sendLocationController"
							method="post">

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

	<script src="../jquery.min.js"></script>
	<script src="../bootstrap.min.js"></script>

	<script type="text/javascript">
	

	function loadAmbulanceAndLocation()
	{
		var xmlHttp=new XMLHttpRequest();
		xmlHttp.onreadystatechange = function()
		{
			if(xmlHttp.readyState == 4)
			{
				alert(xmlHttp.responseText);
				console.log(xmlHttp.responseText);
				var jsonObj=JSON.parse(xmlHttp.responseText);
				var tag = "";
				alert(jsonObj.Locationlist.length);
				for(var ii=0; ii<jsonObj.Locationlist.length; ii++)
				{
					
					tag = tag+"<input type='hidden' value='"+jsonObj.Locationlist[ii].latitude+"' name='hd_lat' ><input type='hidden' value='"+jsonObj.Locationlist[ii].longitude+"' name='hd_lng' >";
					
				}
				var dv = document.getElementById("dvdata").innerHTML = tag;
				
				
				
					var locations = [ [ 'Bondi Beach', -33.890542, 151.274856, 4 ],
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
					for (i = 0; i < lat.length; i++) {
					//	alert(lng[i].value);
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
	
				
				
				
				
			}
		}
		xmlHttp.open("get","<%=request.getContextPath()%>/sendLocationController?flag=searchLocation",
							true);
			xmlHttp.send();

			//setTimeout("loadAmbulanceAndLocation()", 5000);
		}
	</script>
	
	<div id="map"></div>
    <div id="right-panel">
    <div>
    <b>Start:</b>
   <select class="form-control" id="ambulance" name="ambulanceNumber" width="100pt">
								
								<f:forEach items="${sessionScope.Ambulancelist}" var="a">
								<option value="${a.ambulanceNumber}">${a.ambulanceNumber}</option>
								</f:forEach>
								
	</select>
    <br>
    <b>Waypoints:</b> <br>
    <i>(Ctrl+Click or Cmd+Click for multiple selection)</i> <br>
    <select multiple id="waypoints">
      <option value="montreal, quebec">Montreal, QBC</option>
      <option value="toronto, ont">Toronto, ONT</option>
      <option value="chicago, il">Chicago</option>
      <option value="winnipeg, mb">Winnipeg</option>
      <option value="fargo, nd">Fargo</option>
      <option value="calgary, ab">Calgary</option>
      <option value="spokane, wa">Spokane</option>
    </select>
    <br>
    <b>End:</b>
    <select id="end">
      <option value="Vancouver, BC">Vancouver, BC</option>
      <option value="Seattle, WA">Seattle, WA</option>
      <option value="San Francisco, CA">San Francisco, CA</option>
      <option value="Los Angeles, CA">Los Angeles, CA</option>
    </select>
    <br>
      <input type="submit" id="submit">
    </div>
    <div id="directions-panel"></div>
    </div>
    <script>
      function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 6,
          center: {lat: 41.85, lng: -87.65}
        });
        directionsDisplay.setMap(map);

        document.getElementById('submit').addEventListener('click', function() {
          calculateAndDisplayRoute(directionsService, directionsDisplay);
        });
      }

      function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var waypts = [];
        var checkboxArray = document.getElementById('waypoints');
        for (var i = 0; i < checkboxArray.length; i++) {
          if (checkboxArray.options[i].selected) {
            waypts.push({
              location: checkboxArray[i].value,
              stopover: true
            });
          }
        }

        directionsService.route({
          origin: document.getElementById('start').value,
          destination: document.getElementById('end').value,
          waypoints: waypts,
          optimizeWaypoints: true,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
            var route = response.routes[0];
            var summaryPanel = document.getElementById('directions-panel');
            summaryPanel.innerHTML = '';
            // For each route, display summary information.
            for (var i = 0; i < route.legs.length; i++) {
              var routeSegment = i + 1;
              summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                  '</b><br>';
              summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
              summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
              summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
            }
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGBTc2yRLHSq8TeEJl-80Zl3VPShIbfXU&callback=initMap">
    </script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>