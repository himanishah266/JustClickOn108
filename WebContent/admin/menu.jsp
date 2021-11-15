<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
            <div class="left side-menu">
                <div class="sidebar-inner slimscrollleft">

                    <!--- Sidemenu -->
                    <div id="sidebar-menu">
                        <ul>
                        	<li class="menu-title">Navigation</li>

                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-view-dashboard"></i><span class="label label-success pull-right">2</span> <span> Dashboard </span> </a>
                                <ul class="list-unstyled">
                                    
                                </ul>
                            </li>

                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-invert-colors"></i> <span> Manage State </span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="addState.jsp">Add State</a></li>
                                    <li><a href="<%=request.getContextPath()%>/StateController?flag=search">view state</a>
                          			</li>
							</ul>
                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-layers"></i><span> Manage City </span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<%=request.getContextPath()%>/CityController?flag=loadstate">Add City</a></li>
                                    <li><a href="<%=request.getContextPath()%>/CityController?flag=search">View City</a></li>
                                </ul>
                            </li>

                            

                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-email"></i><span> Manage Area </span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<%=request.getContextPath()%>/AreaController?flag=loadcity">Add Area</a></li>
                                    <li><a href="<%=request.getContextPath()%>/AreaController?flag=search">View Area</a></li>
                                </ul>
                            </li>
                            
                              <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-heart-outline"></i><span> Manage Hospital </span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<%=request.getContextPath()%>/HospitalController?flag=loadarea1">Add Hospital</a></li>
                                    <li><a href="<%=request.getContextPath()%>/HospitalController?flag=search">View Hospital</a></li>
                                </ul>
                            </li>

                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-heart-outline"></i><span> Ambulance Details </span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<%=request.getContextPath()%>/AmbulanceController?flag=loadarea">Add Ambulance</a></li>
                                    <li><a href="<%=request.getContextPath()%>/AmbulanceController?flag=search">View Ambulance</a></li>
                                </ul>
                            </li>
                            
                             <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-heart-outline"></i><span> Manage 108 Staff </span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<%=request.getContextPath()%>/StaffController?flag=loadAmbulance">add 108Staff</a></li>
                                    <li><a href="<%=request.getContextPath()%>/StaffController?flag=search">View 108Staff</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-heart-outline"></i><span> Manage Complaint </span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<%=request.getContextPath()%>/ComplaintController?flag=searchComplaint">View Complaint</a></li>
                                </ul>
                            </li>
                            
                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><i class="mdi mdi-heart-outline"></i><span> Manage Feedback</span> <span class="menu-arrow"></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<%=request.getContextPath()%>/FeedbackController?flag=searchFeedback">View Feedback</a></li>
                                </ul>
                            </li>
                            
                           

                           

                           

                           
                    </div>
                    <!-- Sidebar -->
                    <div class="clearfix"></div>

                    <div class="help-box">
                        <h5 class="text-muted m-t-0">For Help ?</h5>
                        <p class=""><span class="text-custom">Email:</span> <br/> support@support.com</p>
                        <p class="m-b-0"><span class="text-custom">Call:</span> <br/> (+123) 123 456 789</p>
                    </div>

                </div>
                <!-- Sidebar -left -->

            </div>
            

</body>
</html>