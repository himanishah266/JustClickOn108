<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
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
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
						<form
							action="<%=request.getContextPath()%>/sendLocationController"
							method="post">

							<input type="hidden" name="flag" value="updatedrLocation"/>


							LoginID: <input type="text" id="user11" name="loginID"
								value="<%=request.getSession().getAttribute("userID")%>"
								onclick="loadUser()"> 
								
								
								Case no:<input type="text" id="location" name="locationID" onclick="loadCase()" value="${sessionScope.lid}">
																
								<select class="form-control" id="ambulance" name="ambulanceNumber" width="100pt">
								
								<f:forEach items="${sessionScope.Ambulancelist}" var="a">
								<option value="${a.ambulanceNumber}">${a.ambulanceNumber}</option>
								</f:forEach>
								
							</select> 
							<input type="submit" name="submit" value="submit" />

						</form>
					</div>

					<div class="modal-body">
						<p>Some text in the modal.</p>
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
		xmlHttp.open("get","<%=request.getContextPath()%>/sendLocationController?flag=inLocation",
							true);
			xmlHttp.send();

			//setTimeout("loadAmbulanceAndLocation()", 5000);
		}
	</script>
</body>
</html>