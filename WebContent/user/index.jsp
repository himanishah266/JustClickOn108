<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta charset="utf-8">
	<base href="${pageContext.request.contextPath }/user/"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Health Line HTML5 template</title>
	<link href="css/font-awesome.css" rel="stylesheet">
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="css/settings.css" rel="stylesheet">
	<link href="css/magnific-popup.css" rel="stylesheet">
	<link href="css/owl.carousel.css" rel="stylesheet">
	<link href="css/owl.transitions.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="css/color.css" rel="stylesheet">
	<link href="css/datepicker.css" rel="stylesheet">
	
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<![endif]-->
</head>

<body class="single-page">

<!--preloader start-->
        <div class="preloading-screen" style=" background:url(images/preloader_img.GIF) #fff no-repeat center fixed;">
            <div class="spinners">
              <div class="bounce1">
                 
              </div>
            </div>
            
        </div>  
<!--preloader end-->
	<!-- page-wraper -->
	<main class="page-wraper">

		<div id="home" class="sticky-menu-trigger">
			<!-- tp-bar -->
			
			<!-- navbar -->
			<jsp:include page="header.jsp"></jsp:include>
			
			<!-- fullscreen-slider -->
			<div class="fullscreen-slider owl-carousel">
				<div class="item">
					<div class="sliderimg" style="background-image:url(imges/sliderbg-1.jpg);"></div>
					<div class="banner-content-outer">
						<div class="banner-content-area">
							<div class="banner-content-inner text-right">
								<div class="banner-content">
									<div class="iconic-large"><img src="imges/logo-banner.png" alt="healthline"></div>
									<h2><b>Just Click On 108<b></h2>
									<ul class="banner-ico-list">
										<li>
											<div class="iconic color-primary"><i class="fa fa-user-md"></i></div>
										</li>
										<li>
											<div class="iconic color-primary"><i class="fa fa-ambulance"></i></div>
										</li>
										<li>
											<div class="iconic color-primary"><i class="fa fa-wheelchair"></i></div>
										</li>
										<li>
											<div class="iconic color-primary"><i class="fa fa-medkit"></i></div>
										</li>
									</ul>
									<p class="visible-med">Through single click on Mobile Application "just click on 108",entire medical management will be done,one can get information 
									regarding our system through this website.</p>
								</div><!-- /banner-content -->
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="sliderimg" style="background-image:url(imges/sliderbg-1.jpg);"></div>
					<div class="banner-content-outer">
						<div class="banner-content-area">
							<div class="banner-content-inner">
								<div class="banner-content">
									<div class="iconic-large"><img src="imges/logo-banner.png" alt="healthline"></div>
									<h2>Our Medical Service</h2>
									<ul class="banner-ico-list">
										<li>
											<div class="iconic color-primary"><i class="fa fa-user-md"></i></div>
										</li>
										<li>
											<div class="iconic color-primary"><i class="fa fa-ambulance"></i></div>
										</li>
										<li>
											<div class="iconic color-primary"><i class="fa fa-wheelchair"></i></div>
										</li>
										<li>
											<div class="iconic color-primary"><i class="fa fa-medkit"></i></div>
										</li>
									</ul>
									<p class="visible-med">Nothing is Important and Pivotal than Life,in this system needy,108 Staff,Hospital Staff,Doctors placed on a single Platform.Through,this
									System,time utilization would be
									done and can survive one's life.</p>
								</div><!-- /banner-content -->
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- quick-contact section -->
			<article class="quick-contact">
				<div class="container">
					<div class="row">
						<div class="col-sm-4">
							<div class="quick-contact-box">
								<header>
									<h4><i class="fa fa-clock-o"></i>Time Utilization</h4>
								</header>
								<div class="text">
									<ul class="timetable">
										<li> <span class="day">Notification</span> </li>
										<li> <span class="day">GPS tracking</span> </li>
										<li> <span class="day">Rapid Management</span> </li>
										<li> <span class="day"> Quick Response</span> </li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="quick-contact-box">
								<header>
									<h4><i class="fa fa-ambulance"></i> emergency cases</h4>
								</header>
								<div class="text">
									<ul class="timetable">
										<li> <span class="day">Monday - Sunday</span> </li>
										<li> <span class="day">Monday - Sunday</span>  </li>
										<li> <span class="day">Monday - Sunday</span>  </li>
										<li> <span class="day">Monday - Sunday</span> </li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="quick-contact-box">
								<header>
									<h4><i class="fa fa-user-md"></i> IMMEDIATE SERVICES</h4>
								</header>
								<div class="text">
									<ul class="timetable">
										<li> <span class="day">Monday - Sunday</span> <span class="time">24 Hours Facility</span> </li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</div><!-- /#home -->

	<div id="services">
		<!-- services section -->
		<article class="section">
			<div class="container">
				<!-- upper-section -->
				<div class="upper-section">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2>Services Of "JUST CLICK ON 108"</h2>
						<p>As citizen click on mobile application,directly incident location sent to control room and they delegate Ambulance nearest from incident Location</p>
					</header>
				</div>
				<!-- content-section -->
				<div class="content-section">
					<div class="row">
						<div class="col-sm-6 col-md-3">
							<div class="service-box">
								<div class="text">
									<div class="iconic"><i class="fa fa-stethoscope color-primary"></i></div>
									<h4>Quick Response</h4>
								</div>
								<a href="#" class="readmore">Read About</a>
							</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="service-box">
									<div class="text">
										<div class="iconic"><i class="fa fa-flask color-primary"></i></div>
										<h4>Information Gain</h4>
									</div>
									<a href="#" class="readmore">Read About</a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="service-box">
									<div class="text">
										<div class="iconic"><i class="fa fa-eyedropper color-primary"></i></div>
										<h4> Rapid Medical Treatment</h4>
									</div>
									<a href="#" class="readmore">Read About</a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="service-box">
									<div class="text">
										<div class="iconic"><i class="fa fa-medkit color-primary"></i></div>
										<h4>Emergency Help</h4>
									</div>
									<a href="#" class="readmore">Read About</a>
								</div>
							</div>
					</div>
				</div>
			</div>
		</article>
		<!-- appointment section -->
		<article class="section">
			<div class="section-image" style="background-image:url(imges/bg-image-1.png);">
				<div class="container">
					<!-- appointment-area -->
					<div class="appointment-area">
						<div class="row">
							<div class="col-sm-10 col-md-6">
								<!-- appointment-box -->
								<div class="appointment-box">
									<header>
										<h4>Register Feedback</h4>
									</header>
									<div class="text">
										<form class="appointment-form" method="post" action="index.html">
											<ul class="row">
												<li class="col-sm-12">
													<label>FIRST NAME &amp; LAST NAME</label>
													<input type="text" placeholder="Enter your Name" class="form-control">
												</li>
												<li class="col-sm-12">
													<label>CONTACT NUMBER</label>
													<input type="text" placeholder="Enter your contact number" class="form-control">
												</li>
												<li class="col-sm-6">
													<label>DATE</label>
													<span class="input-date">
														<input type="text" placeholder="Today's Date" class="form-control datepicker" value="" data-date-format="mm/dd/yy">
													</span>
												</li>
												
												<li class="col-sm-12">
													<label> FEEDBACK MESSAGE</label>
													<textarea placeholder="Type your Feedback" class="form-control"></textarea>
												</li>
												<li class="col-sm-12">
													<label>COMPLAIN MESSAGE</label>
													<ul class="row form-buttons">
														<textarea placeholder="Type your Complaint" class="form-control"></textarea>
							
														
													</ul>
												</li>
											</ul>
											<div class="appintment-form-btm">
												<div class="checkbox">
													<label>
														<input type="checkbox" name="checkbox">
													Send me copy of Message</label>
												</div>
												<input type="submit" class="btn btn-primary" value="Send Message">
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="col-sm-6 appointment-box-snap"> <img src="imges/img-1.png" alt="image doctor"> </div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</div><!-- /#services -->

	<div id="doctors">
		<!-- Department section -->
		<article class="section-parallax bg-primary" style="background-image:url(imges/bg-image-2.png);">
			<div class="container">
				<!-- upper-section -->
				<div class="upper-section">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2>Modules Of System "JUST CLICK ON 108"</h2>
						<p>All modules interconnected with each other,All were placed on a Single Platform.</p>
					</header>
				</div>
				<div class="content-section">
					<div class="row">
						<div class="col-xs-6 col-sm-3 col-md-2">
							<!-- dept-box -->
							<div class="dept-box">
								<div class="iconic"> <i class="icon-tooth"></i> </div>
								<h6>CITIZEN</h6>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3 col-md-2">
							<!-- dept-box -->
							<div class="dept-box">
								<div class="iconic"> <i class="icon-heart"></i> </div>
								<h6>ADMIN</h6>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3 col-md-2">
							<!-- dept-box -->
							<div class="dept-box">
								<div class="iconic"> <i class="icon-kidney"></i> </div>
								<h6>108 STAFF</h6>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3 col-md-2">
							<!-- dept-box -->
							<div class="dept-box">
								<div class="iconic"> <i class="icon-lungs"></i> </div>
								<h6>HOSPITAL MANAGEMENT STAFF</h6>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3 col-md-2">
							<!-- dept-box -->
							<div class="dept-box">
								<div class="iconic"> <i class="icon-brain"></i> </div>
								<h6>DOCTORS</h6>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3 col-md-2">
							<!-- dept-box -->
							<div class="dept-box">
								<div class="iconic"> <i class="icon-ribs"></i> </div>
								<h6>X-Ray</h6>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>

		<!-- Team section -->
		<article class="section">
			<!-- upper-section -->
			<div class="upper-section">
				<div class="container">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2>Meet with entire structure of "just click on 108"</h2>
						<p>As person click on mobile application,management will be like this,</p>
					</header>
				</div>
			</div>
			<!-- content-section -->
			<div class="content-section">
				<!-- team-section -->
				<div class="team-section">
					<div class="team-tabs">
						<div class="container">
							<ul class="team-tabs-list">
								<li role="presentation" class="active">
									<a href="#primary-healthcare" role="tab" data-toggle="tab">Track Route of Hospital</a>
								</li>
								<li role="presentation">
									<a href="#Pediatric-Clinic" role="tab" data-toggle="tab">Notification</a>
								</li>
								<li role="presentation">
									<a href="#detanl-clinic"  role="tab" data-toggle="tab">Response</a>
								</li>
								<li role="presentation">
									<a href="#gastro" role="tab" data-toggle="tab">Hospital Services</a>
								</li>
								<li role="presentation">
									<a href="#op-rehab" role="tab" data-toggle="tab">Patient Registration</a>
								</li>
								<li role="presentation">
									<a href="#op-surgery" role="tab" data-toggle="tab">Feedback/Complaint</a>
								</li>
							</ul>
							<div class="team-tab-contents tab-content">
								<div  role="tabpanel" class="tab-pane fade in active" id="primary-healthcare">
									<ul class="team-list hoverable">
										<li class="active">
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/gps1.png"alt="doctor">
													</figure>
													<div class="text">
														
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p><center>GPS for tracking incident Location and 
													Hospital,GPS also indicate shortest path 
														to reach particular Destination.</center></p>
														<a href="#" class="btn btn-primary"> View profile</a>
													</div>
												</div>
											</div>
										</li>
										<li>
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/staff.jpg" alt="doctor" height="600 px">
													</figure>
													<div class="text">
														<h4><b>Ambulance 108 Staff</b></h4>
														<p class="dept">Immediate Service</p>
														
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>After picking patient,ambulance staff send notification to hospital staff for getting prepared 
														in advance.</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
										<li>
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/snap-6.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Hospital Staff</h4>
														
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>Receive Notification and send positive response to 108 staff and hospital management staff
														will be prepared for further treatment in advance.</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div  role="tabpanel" class="tab-pane fade" id="Pediatric-Clinic">
									<ul class="team-list hoverable">
										<li class="active">
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/notif1.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Notification</h4>
														<p class="dept">Time utilization</p>
														
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p></p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
										<li>
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/snap-5.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Receive Notification</h4>
													
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>Receive Notification and send positive response to 108 staff and hospital management staff
														will be prepared for further treatment in advance..</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div  role="tabpanel" class="tab-pane fade" id="detanl-clinic">
									<ul class="team-list hoverable">
										<li>
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/snap-4.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Quick Response</h4>
														<p class="dept">If not availability</p>
														
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>In case,if there is not availability of doctors or bed,Immediately Hospital
														Staff send Notification to 108 staff as response.</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
										<li class="active">
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/amb1.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Ambulance Staff</h4>
														<p class="dept">Track route of another Hospital</p>

														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>Ambulance Staff obtain response if they get negative response,they transferred to another hospital.</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
										<li>
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/hos2.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Track Route of another hospital</h4>
														<p class="dept">quick treatment</p>
														<p class="exp">36 years Experience</p>
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p> have to choose another alternative,because no availability is present there.due torapid management
														person can survive their life.</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div  role="tabpanel" class="tab-pane fade" id="gastro">
									<ul class="team-list hoverable">
										<li>
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/hos3.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Medical Treatment</h4>
														<p class="dept">immediate service </p>
														<p class="exp"></p>
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>after patient admitted in perticular hospital,patient's details stored in database,and
														patients are given </p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>

										
									
									




									</ul>
								</div>
								<div  role="tabpanel" class="tab-pane fade" id="op-rehab">
									<ul class="team-list hoverable">
										<li class="active">
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/help1.jpg" alt="doctor">
													</figure>
													<div class="text">
														<h4>Patient Registration</h4>
														<p class="dept">Problem Details Of Patient</p>
														<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>Register all details of patient,stored in database for maintain security and for keeping records of all patients.</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
												     												
												
											</div>
										</li>
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
									</ul>
								</div>
												

								
								
								
								<div  role="tabpanel" class="tab-pane fade" id="op-surgery">
									<ul class="team-list hoverable">
										<li class="active">
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/snap-5.jpg" alt="doctor">
													</figure>
													<div class="text">
																										<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
										<li>
											<!-- team-hover-box -->
											<div class="team-hover-box">
												<!-- team-box -->
												<div class="team-box">
													<figure class="image">
														<img src="imges/snap-6.jpg" alt="doctor">
													</figure>
													<div class="text">
																				<ul class="social-links">
															<li><a href="#" class="fa fa-facebook"></a></li>
															<li><a href="#" class="fa fa-twitter"></a></li>
															<li><a href="#" class="fa fa-rss"></a></li>
															<li><a href="#" class="fa fa-linkedin"></a></li>
															<li><a href="#" class="fa fa-skype"></a></li>
														</ul>
														<p>Any mismanagement found in system,user can register their complaint.and if they have experienced our entire rapid system
														structure,one can fill above given feedback form.</p>
														<a href="#" class="btn btn-primary">View profile</a>
													</div>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>

		<!-- tips section -->
		<article class="section">
			<div class="container">
				<!-- upper-section -->
				<div class="upper-section">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2>Tips from Doctors</h2>
						<p>popular doctor's tips for increasing one's awareness for healthy life.</p>
					</header>
				</div>
			</div>
			<!-- section-parallax -->
			<div class="section-parallax" style="background-image:url(imges/bg-image-2.png);">
				<div class="container">
					<div class="comments-section">
						<!-- comment-box -->
						<div class="comment-box">
							<figure><img src="imges/snap-1.jpg" alt="doctor"></figure>
							<div class="text">
								<h6>Dr. Karen Dawson Says</h6>
								<p>They haven't gotten sick since the fifth grade! They skip to the gym every day! They never hit the snooze button! They're so Zen they float to work on a lotus leaf! None of these assumptions about health experts are true, of course. "Doctors struggle just as much as everyone else when trying to stick with healthy lifestyle habits, especially since our schedules are so unpredictable," says May Hsieh </p>
							</div>
						</div>
						<!-- comment-box -->
						<div class="comment-box">
							<figure><img src="imges/snap-2.jpg" alt="doctor"></figure>
							<div class="text">
								<h6>Dr. Karen Dawson Says</h6>
								<p>They haven't gotten sick since the fifth grade! They skip to the gym every day! They never hit the snooze button! They're so Zen they float to work on a lotus leaf! None of these assumptions about health experts are true, of course. "Doctors struggle just as much as everyone else when trying to stick with healthy lifestyle habits, especially since our schedules are so unpredictable," says May Hsieh </p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>

		<!-- focus section -->
		<article class="section-condensed section-image bg-primary" style="background-image:url(imges/resource/bg-image-3.png);">
			<div class="container">
				<div class="focus">
					<div class="row">
						<div class="col-sm-9">
							
						</div>
					</div>
				</div>
			</div>
		</article>
	</div><!--  /#doctors -->

	<div id="news">
		<!-- news section -->
		<article class="section">
			<div class="container">
				<!-- upper-section -->
				<div class="upper-section">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2>The Latest News Of health line</h2>
						
					</header>
				</div>
				<!-- content-section -->
				<div class="content-section">
					<!-- news-area -->
					<div class="news-area">
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<!-- news-box -->
								<div class="news-box">
									
									</div>
									<a class="readmore" href="#">     </a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<!-- news-box -->
								<div class="news-box">
									<figure class="image"> <img src="imges/img-3.jpg" alt="image">
										<div class="date-float"> <span>09</span> Aug </div>
										<a class="image-popup" href="imges/img-3.jpg"></a>
									</figure>
									<div class="text">
										<p>Latest news about medical services will be updated here.</p>
									</div>
									<a class="readmore" href="#"></a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<!-- news-box -->
								<div class="news-box">
									<figure class="image"> <img src="imges/img-4.jpg" alt="image">
										<div class="date-float"> <span>07</span> Jun </div>
										<a class="image-popup" href="imges/img-4.jpg"></a>
									</figure>
									<div class="text">
										<p> Latest news about medical services will be updated here.</p>
									</div>
									<a class="readmore" href="#"></a>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<!-- news-box -->
								<div class="news-box">
									<figure class="image"> <img src="imges/img-5.jpg" alt="image">
										<div class="date-float"> <span>18</span> Jun </div>
										<a class="image-popup" href="imges/img-5.jpg"></a>
									</figure>
									<div class="text">
										<p>Latest news about medical services will be updated here.</p>
									</div>
									<a class="readmore" href="#"></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>

		<!-- Single section -->
		<article class="section-parallax bg-primary" style="background-image:url(imges/bg-image-4.png);">
			<div class="container">
				<div class="section-single">
					<div class="iconic"> <i class="fa fa-twitter"></i> </div>
					<h2 class=" animated out" data-animation="fadeInUp" data-delay="0">Latest From Twitter</h2>
					<p class=" animated out" data-animation="fadeInUp" data-delay="0">Very easy to use. Keep up the excellent work."just click on 108" is the real deal! thanks @medical</p>
					<a href="#" class="btn btn-lg btn-default">Follow Us</a>
				</div>
			</div>
		</article>
	</div><!-- /#news -->

	<div id="gallery">
		<!-- gallery section -->
		<article class="section">
			<div class="container">
				<!-- upper-section -->
				<div class="upper-section">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2>Gallary of Service Provided By "just click on 108"</h2>
					</header>
				</div>
				<!-- content-section -->
				<div class="content-section">
					<div class="slider">
						<div id="sync1" class="owl-carousel">
							<div class="item"><img src="imges/slide-1.jpg" alt="slide" width="1000px" height="800px"></div>
							<div class="item"><img src="imges/g1_IMAGE1.jpg" alt="slide" width="1000px" height="750px"></div>
							<div class="item"><img src="imges/slide-5.jpg" alt="slide"></div>
							<div class="item"><img src="imges/g1_image7.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-7.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-8.jpg" alt="slide"></div>
						</div>
						<div id="sync2" class="owl-carousel">
							<div class="item"><img src="imges/slide-1.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-2.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-3.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-4.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-5.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-6.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-7.jpg" alt="slide"></div>
							<div class="item"><img src="imges/slide-8.jpg" alt="slide"></div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</div><!-- /#gallery -->

	<div id="blog">
		<!-- blog section -->
		<article class="section">
			<div class="container">
				<!-- upper-section -->
				<div class="upper-section">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2><b>Flow Of Our System<b></h2>
					
					</header>
				</div>
				<!-- content-section -->
				<div class="content-section">
					<div class="row">
						<div class="col-sm-6 col-md-4">
							<!-- blog-box -->
							<div class="blog-box">
								<figure class="image"> <img alt="image" src="imges/photo.jpg"/>
									<a href="imges/img-2.jpg" class="image-popup"> </a>
								</figure>
								<h4><b> <center> Flow Of Our System </center> <b></h4>
								<div class="text">
									<p><r>Here, Admin,System,108 Staff,Hospital Staff,Needy,Doctors placed on single platform.For Awareness about system 
									read detais punctiliously for getting familier with this system.</r>
									</p>
								</div>
								<div class="blog-btm">
									<ul class="grid-2">
										<li><a href="#"><i class="fa fa-user"></i>Dr. Mark Leon</a></li>
										<li><a href="#"><i class="fa fa-align-left"></i>Read More</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-4">
							<!-- blog-box -->
							<div class="blog-box">
							
							
							
								<div class="text">
								<div class="blog-btm">
									<ul class="grid-2">
									                               <CENTER> DESCRIPTION </CENTER>
										As Person click on 108(a mobile application) then directly that location where incident happened sent to
										control room and they delegate ambulance which is in nearest location from that incident place. And person 
										also can able to see the ambulance location and how much time it will take to reach its destination.Then
									    find out nearest hospital from that incident place if user wants. Then notification will be sent to 
										hospital management staff to be prepared for emergency case. And if there is no available bed in hospital, 
										they responded them no availability in this hospital .so, they choose another alternative instead of that 
										hospital. Through GPS 108 Staff can track the route of incident location and hospital. User and Hospital
										both have right to make complaint and also feedback.
									</ul>
								</div>
							
							</div>
						</div>
					
				</div>
				<div class="col-sm-6 col-md-4">
							<!-- blog-box -->
							<div class="blog-box">
								<figure class="image"> <img alt="image" src="imges/photo.jpg"/>
									<a href="imges/img-2.jpg" class="image-popup"></a>
								</figure>
								<h4><b> <center> Flow Of Our System </center> <b></h4>
								<div class="text">
									<p><r>Here, Admin,System,108 Staff,Hospital Staff,Needy,Doctors placed on single platform.For Awareness about system 
									read detais punctiliously for getting familier with this system.</r>
									</p>
								</div>
								<div class="blog-btm">
									<ul class="grid-2">
										<li><a href="#"><i class="fa fa-user"></i>Dr. Mark Leon</a></li>
										<li><a href="#"><i class="fa fa-align-left"></i>Read More</a></li>
									</ul>
								</div>
							</div>
						</div>
			
			</div>
		</article>
											
		<!-- testimonials section -->
		<article class="section-testimonials">
			<div class="testimonials">
				<div class="container">
					<div class="testim owl-carousel">
						<div class="item">
							<!-- testimon-box -->
							<div class="testimon-box">
								<div class="row">
									<div class="col-md-8 testim-text">
										<h3>What Our Clients Say</h3>
										<p>nothing is more important then life.</p>
										<blockquote>
											<p> "just click on 108" this system provides security,easeness,reliability to the user.especially 
											when person in critical situation,without consuming time,rapid medical treatment would be done.
											because without life,nothing is here.</p>
										</blockquote>
									</div>
									<div class="col-md-4 testim-picture">
										<figure class="snap"><img src="imges/snap-3.jpg" alt="doctor snap"></figure>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<!-- testimon-box -->
							<div class="testimon-box">
								<div class="row">
									<div class="col-md-8 testim-text">
										<h3>What Our Clients Say</h3>
										<p>nothing is more important then life.</p>
										<blockquote>
											<p>"just click on 108" this system provides security,easeness,reliability to the user.especially 
											when person in critical situation,without consuming time,rapid medical treatment would be done.
											because without life,nothing is here."</p>
										</blockquote>
									</div>
									<div class="col-md-4 testim-picture">
										<figure class="snap"><img src="imges/snap-3.jpg" alt="doctor snap"></figure>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<!-- testimon-box -->
							<div class="testimon-box">
								<div class="row">
									<div class="col-md-8 testim-text">
										<h3>What Our Clients Say</h3>
										<p> nothing is more important then life.       </p>
										<blockquote>
											<p> " "just click on 108" this system provides security,easeness,reliability to the user.especially 
											when person in critical situation,without consuming time,rapid medical treatment would be done.
											because without life,nothing is here.""</p>
										</blockquote>
									</div>
									<div class="col-md-4 testim-picture">
										<figure class="snap"><img src="imges/snap-3.jpg" alt="doctor snap"></figure>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<!-- testimon-box -->
							<div class="testimon-box">
								<div class="row">
									<div class="col-md-8 testim-text">
										<h3>What Our Clients Say</h3>
										<p>nothing is more important then life</p>
										<blockquote>
											<p>" "just click on 108" this system provides security,easeness,reliability to the user.especially 
											when person in critical situation,without consuming time,rapid medical treatment would be done.
											because without life,nothing is here."."</p>
										</blockquote>
									</div>
									<div class="col-md-4 testim-picture">
										<figure class="snap"><img src="imges/snap-3.jpg" alt="doctor snap"></figure>
									</div>
								</div>
							</div>
						</div>
						<div class="item">
							<!-- testimon-box -->
							<div class="testimon-box">
								<div class="row">
									<div class="col-md-8 testim-text">
										<h3>What Our Clients Say</h3>
										<p> nothing is more important then life</p>
										<blockquote>
											<p>""just click on 108" this system provides security,easeness,reliability to the user.especially 
											when person in critical situation,without consuming time,rapid medical treatment would be done.
											because without life,nothing is here.""</p>
										</blockquote>
									</div>
									<div class="col-md-4 testim-picture">
										<figure class="snap"><img src="imges/snap-3.jpg" alt="doctor snap"></figure>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</div><!-- /#blog -->

	<div id="about">
		<!-- about section -->
		<article class="section">
			<div class="container">
				<!-- upper-section -->
				<div class="upper-section">
					<header class="heading animated out" data-animation="fadeInUp" data-delay="0">
						<h2>About Us &amp; What we do</h2>
				
					</header>
				</div>
				<!-- content-section -->
				<div class="content-section">
					<div class="row">
						<div class="col-sm-6">
							
							<ul>
								<li>To provide urgent and effective treatment to the needy patients.</li>
								<li> To provide faster access and response to the user who need. </li>
								<li> To maintain and keeping the track of the location of ambulance.</li>
								<li> Provide faster treatment to the patient at appropriate hospital</li>
								<li>Get feedback from the customer.</li>
								<li>Through notification, if there is not availability in hospital management staff responded 108 Staff about availability through Notification, 
								so in advance they can know hospital current status..</li>
							</ul>
						</div>
						<div class="col-sm-6">
							<!-- accordion -->
							<div class="accordion accordion-1 panel-group">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title active-heading"> <a class="iconic icon-heart" data-toggle="collapse" data-parent=".accordion-1" href="#collapseOne-1"> heart disease </a> </h4>
									</div>
									<div id="collapseOne-1" class="panel-collapse collapse in">
										<div class="panel-body">
											
											
											
											
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title"> <a class="iconic icon-eye" data-toggle="collapse" data-parent=".accordion-1" href="#collapseTwo-2"> eye health </a> </h4>
									</div>
									<div id="collapseTwo-2" class="panel-collapse collapse">
										<div class="panel-body">
											<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</p>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title"> <a class="iconic icon-woman" data-toggle="collapse" data-parent=".accordion-1" href="#collapseThree-3"> pregnancy </a> </h4>
									</div>
									<div id="collapseThree-3" class="panel-collapse collapse">
										<div class="panel-body">
											<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.</p>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title"> <a class="iconic icon-ambulance" data-toggle="collapse" data-parent=".accordion-1" href="#collapseThree-4"> yellow fever </a> </h4>
									</div>
									<div id="collapseThree-4" class="panel-collapse collapse">
										<div class="panel-body">
											<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.</p>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title"> <a class="iconic icon-kit" data-toggle="collapse" data-parent=".accordion-1" href="#collapseThree-5"> diabetes </a> </h4>
									</div>
									<div id="collapseThree-5" class="panel-collapse collapse">
										<div class="panel-body">
											<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="section">
				<div class="container">
					<!-- content-section -->
					<div class="content-section">
						<ul class="thumb-list">
							<li>
								<div class="thumb-box">
									<div class="text">

								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</article>
	</div><!-- /#about -->		

	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Section Social -->
	
	<!-- Site Bottom -->
 </main>

	<!-- JavaScript Files
	================================================== -->
	<script src="js/jquery-1.11.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.appear.js"></script>
	<script src="js/jquery.magnific-popup.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>                          
	<script src="js/script.js"></script>
	<!-- Google Map Script -->
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
	<script>
/*		function initialize() {
		var location = new google.maps.LatLng(42.345573,-71.098326);
		var mapOptions = {
		center: location,
		zoom: 17
		};
		var mapElement = document.getElementById('map-canvas');
		var map = new google.maps.Map(mapElement, mapOptions);
		}
		google.maps.event.addDomListener(window, 'load', initialize);*/
	</script>
</body>
</html>