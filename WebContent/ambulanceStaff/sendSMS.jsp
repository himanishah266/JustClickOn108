<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body onload="sendsms()">
<script>
function sendsms()
{
		var username="917405969364";
		var password = "AFEA";
		var msg = "Ambulance is on the way... it will arrive soon... plz get prepared...";
		var sendto = "91"+"${sessionScope.contact}";//number fromat : 919898989898
		var smslink = "http://www.smszone.in/sendsms.asp?page=SendSmsBulk&username="+username+"&password="+password+"&number="+sendto+"&message="+msg+"&SenderId=SMSZON";
		
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4) {
			
			}
		}
		xmlhttp.open("get",smslink, true);
		xmlhttp.send();
		window.location="index.jsp";
}
</script>
</body>
</html>