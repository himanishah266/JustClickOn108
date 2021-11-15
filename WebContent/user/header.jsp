<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="tp-bar">
				<div class="container">
					<div class="logo"><a href="index.html"><img src="imges/logo.png" alt="health line"></a></div>
				</div>
</div>
		

<div class="navbar">
				<div class="container">
					<div class="navbar-header">
						<button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button"> <span class="icon-bar"></span><span class="icon-bar"></span> <span class="icon-bar"></span></button>
					</div>
					<!--nav-collapse -->
					<nav class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="#home" class="on">Home</a></li>
							<li><a href="#services" class="on">Services</a></li>
							<li><a href="#doctors" class="on">Modules</a></li>
							<li><a href="#news" class="on">News</a></li>
							<li><a href="#gallery" class="on">Gallery</a></li>
							<li><a href="#blog" class="on">Flow </a></li>
							<li><a href="#about" class="on">About Us</a></li>
							<li>
								<a href="#">Pages</a>
								<ul>
									<li><a href="about.html">about</a></li>
									<li><a href="services.html">services</a></li>
									<li><a href="doctors.html">Doctors</a></li>
									<li><a href="blog.html">Blog</a></li>
									<li><a href="blog-detail.html">Single Blog</a></li>
									<li><a href="departments.html">Departments</a></li>
									<li><a href="gallery.html">Gallery</a></li>
									<li><a href="gallery-with-sidebar.html">Gallery Sidebar</a></li>
									<li><a href="contact.html">Contact</a></li>
								</ul>
							</li>
							<li>
							
							
							<a href="<%=request.getContextPath() %>/UmapController?flag=search">map</a>
							</li>
							<li>
								<a href="complaint.jsp">Complaint</a>
							</li>
							
							<li>
								<a href="feedback.jsp">feedback</a>
							</li>
							<li>
									<a href="sendLocation.jsp">sendLocation</a>
								
							</li>
							
							<li>
							
								<a href="?flag=logout">logout</a>
							
														
							
							</li>
							
						</ul>
					</nav>
				</div>
				<div class="site-search">
					<div class="container">
						<button type="button" class="search-init-btn"> Search Hospital nearest to Incident Location</button>
						<form class="site-search-form collapse" action="index.html" method="post">
							<ul class="row">
								<li class="col-sm-4">
									<label>Search By Name</label>
									<input type="text" class="form-control" placeholder="Enter Hospital Name">
								</li>
								<li class="col-sm-4">
									<label>Search By GPS_tracking</label>
									<input type="text" class="form-control" placeholder="Obtain Incident Location">
								</li>
								<li class="col-sm-4">
									<label>Search By Location</label>
									<input type="text" class="form-control" placeholder="Enter Hospital Location">
								</li>
							</ul>
							<input type="submit" class="btn btn-primary" value="Search">
						</form>
					</div>
				</div>
			</div>