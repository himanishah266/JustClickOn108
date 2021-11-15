<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <!-- App favicon -->
        <link rel="shortcut icon" href="assets/images/favicon.ico">
        <!-- App title -->
        <title>Zircos - Responsive Admin Dashboard Template</title>

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
        
        <script>
	
			function loadCity()
			{
				
				
				var stateID=document.getElementById("state");
				alert(stateID.value);
				removeAllcity();
				removeAllarea();
				
				
				
				var xmlHttp=new XMLHttpRequest();
				
				xmlHttp.onreadystatechange = function()
				{
					if(xmlHttp.readyState == 4)
					{
						var jsonObj=JSON.parse(xmlHttp.responseText);
						
						for(i=0; i<jsonObj.length; i++)
						{
							var createOption=document.createElement("option");
							
							createOption.value=jsonObj[i].cityID;
							createOption.text=jsonObj[i].cityName;
							
							document.getElementById("city").options.add(createOption);
						}
					}
				}
				
			
				xmlHttp.open("get","<%=request.getContextPath()%>/AreaController?flag=loadCityAjax&stateID="+stateID.value,true);
				xmlHttp.send();
			}
			
			
			function removeAllcity()
			{
				var removeState=document.getElementById("city").options.length;
				
				for(i=removeState; i>0;i--)
				{
					document.getElementById("city").remove(i);
					
				}
			}
		
		
			function loadArea()
			{
				
				
				var cityID=document.getElementById("city");
				alert(cityID.value);
				removeAllarea();
				
				
				var xmlHttp=new XMLHttpRequest();
				
				xmlHttp.onreadystatechange = function()
				{
					if(xmlHttp.readyState == 4)
					{
						var jsonObj=JSON.parse(xmlHttp.responseText);
						
						for(i=0; i<jsonObj.length; i++)
						{
							var createOption=document.createElement("option");
							
							createOption.value=jsonObj[i].areaID;
							createOption.text=jsonObj[i].areaName;
							
							document.getElementById("area11").options.add(createOption);
						}
					}
				}
				
			
				xmlHttp.open("get","<%=request.getContextPath()%>/AmbulanceController?flag=loadAreaAjax&cityID="+cityID.value, true);
				xmlHttp.send();
	}

	function removeAllarea() {
		var removeState1 = document.getElementById("area11").options.length;

		for (i = removeState1; i>0; i--) {
			document.getElementById("area11").remove(i);

		}
	}
</script>
		
		
		
        

    </head>


    <body class="fixed-left">

        <!-- Begin page -->
        <div id="wrapper">

            <!-- Top Bar Start -->
            <jsp:include page="header.jsp"></jsp:include>
                        <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->
                  <jsp:include page = "menu.jsp"></jsp:include>
                        <!-- Left Sidebar End -->



            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container">


                        <div class="row">
							<div class="col-xs-12">
								<div class="page-title-box">
                                    <h4 class="page-title">Form Validation </h4>
                                    <ol class="breadcrumb p-0 m-0">
                                        <li>
                                            <a href="#">Zircos</a>
                                        </li>
                                        <li>
                                            <a href="#">Forms </a>
                                        </li>
                                        <li class="active">
                                            Form Validation
                                        </li>
                                    </ol>
                                    <div class="clearfix"></div>
                                </div>
							</div>
						</div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-xs-12">
                                <div class="card-box">

                                    <div class="row">
                                        <div class="col-sm-12 col-xs-12 col-md-6">

                                            <h4 class="header-title m-t-0">Manage Ambulance</h4>
                                            <p class="text-muted font-13 m-b-10">
                                                Parsley is a javascript form validation library. It helps you provide your users with feedback on their form submission before sending it to your server.
                                            </p>

                                            <div class="p-20">
                                            
                                            
                                            
                                             <form action="<%=request.getContextPath()%>/AmbulanceController" method="post">
                                                  data-parsley-validate novalidate>
                                            
                                                <input type="hidden" name="flag" value="insert"/>
                                                
                                                
                                                
                                                <div class="p-20">
                                            
                                                  data-parsley-validate novalidate>
                                                  
                                                  
                                                    <div class="form-group">
                                                        <label for="StateName">State Name<span class="text-danger">*</span></label>
													<select id="state" class="form-control" name="stateID" onchange="loadCity()">
																		<option value="">---SELECT---</option>
													
													
														<f:forEach items="${sessionScope.statelist}" var="s" >
														
                                                        
                                                        <option value="${s.stateID}">${s.stateName}</option>
                                                        
                                                        </f:forEach>
                                                        
                                                    </select>                                                   
                                                     </div>
                                                     <div class="form-group">
                                                        <label for="CityName">City Name<span class="text-danger">*</span></label>
													<select id="city" class="form-control" name="cityID" onchange="loadArea()">
																	<option value="">---SELECT---</option>
													
														
														<f:forEach items="${sessionScope.citylist}" var="c" >
                                                        
                                                        <option value="${c.cityID}">${c.cityName}</option>
                                                        </f:forEach>
                                                        
                                                    </select>     
                                                    </div>
                                                    
                                                    
                                                    <div class="form-group">
                                                        <label for="StateName">area Name<span class="text-danger">*</span></label>
													<select id="area11" class="form-control" name="areaID">
													
																	<option value="">---SELECT---</option>
										
                                                        
                                                    </select>                                                   
                                                     </div>
                                                     
                                                      <div class="form-group">
                                                        <label for="AmbulanceNumber">Ambulance Number.<span class="text-danger">*</span></label>
                                                        <input type="text"  parsley-trigger="change" required
                                                               placeholder="Enter Number" class="form-control" id="AmbulanceNumber" name="ambulanceNumber">
                                                    </div>
                                                    
                                                    
                                                    <div class="form-group">
                                                        <label for="Model">Model Number<span class="text-danger">*</span></label>
                                                        <input type="text" parsley-trigger="change" required
                                                               placeholder="Enter Number" class="form-control" id="ModelNumber" name="modelNumber">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="StateName">Passing Year<span class="text-danger">*</span></label>
                                                        <input type="text" name="passingYear" parsley-trigger="change" required
                                                               placeholder="Enter Year of Passing" class="form-control" id="Passing" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="allocation">Allocation Details<span class="text-danger">*</span></label>
                                                        <input type="text" name="allocation" parsley-trigger="change" required
                                                               placeholder="Enter Details" class="form-control" id="Allocation">
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label for="allocation">Latitude<span class="text-danger">*</span></label>
                                                        <input type="text"  parsley-trigger="change" required
                                                               placeholder="Enter Details" class="form-control" id="Allocation" name="latitude">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="allocation">Longitude<span class="text-danger">*</span></label>
                                                        <input type="text" name="longitude" parsley-trigger="change" required
                                                               placeholder="Enter Details" class="form-control" id="Allocation">
                                                    </div>
                                                       
                                                    <div class="form-group text-right m-b-0">
                                                        <button class="btn btn-primary waves-effect waves-light" type="submit">
                                                            Add Ambulance
                                                        </button>
                                                        <button type="reset" class="btn btn-default waves-effect m-l-5">
                                                            Cancel
                                                        </button>
                                                    </div>
                                                    
                                                     
                                                  
                                                   
                                                    
                                                </form>
                                            </div>
                                                
                                       
                                                    
                                                    
                                                                                           </div>

                                        </div>

                                                                            </div>
                                    <!-- end row -->

                                                                        <!-- end row -->


                                    
                        		</div> <!-- end ard-box -->
                            </div><!-- end col-->

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

        <script type="text/javascript" src="js/parsley.min.js"></script>

        <!-- App js -->
        <script src="js/jquery.core.js"></script>
        <script src="js/jquery.app.js"></script>

        <script type="text/javascript">
			$(document).ready(function() {
				$('form').parsley();
			});
            $(function () {
                $('#demo-form').parsley().on('field:validated', function () {
                    var ok = $('.parsley-error').length === 0;
                    $('.alert-info').toggleClass('hidden', !ok);
                    $('.alert-warning').toggleClass('hidden', ok);
                })
                .on('form:submit', function () {
                    return false; // Don't submit form for this demo
                });
            });
		</script>

    </body>
</html>