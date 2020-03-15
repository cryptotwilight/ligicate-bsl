<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Ligicate | Money Manager | Dashboard </title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<h1><a href="index.html">Ligicate</a></h1>
						<nav>
							<a href="#menu">Menu</a>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<div class="inner">
							<h2>Menu</h2>
							<ul class="links">
								<li><a href="index.html">Home</a></li>
								<li><a href="Dashboard">Dashboard</a></li>
								<li><a href="Login?logout=true">Log Out</a></li>
								
							</ul>
							<a href="#" class="close">Close</a>
						</div>
					</nav>

				<!-- Wrapper -->
					<section id="wrapper">
					
						<!-- Three -->
							<section id="three" class="wrapper spotlight style3">
								<div class="inner">
									
									<div class="content">
										<h2 class="major">Custodian Registration Requests</h2>
										<div class="table-wrapper">
										<table style="width: 100%">
											<tr>
												<td>Custody Registrant Name</td>
												<td>Operating Location</td>
												<td>Asset Types</td>
												<td>Asset Limit</td>
											</tr>
											<s:iterator value="dashboard.custodianRegistrationRequests">	
												<tr>
													<td><s:property value="name"/></td>
													<td><s:property value="location"/><class style="font-size:15px"><br/><s:property value="custodianAddress"/></class>
													<br><a href="Decline" style="font-size:10px">Decline Registration</a> &nbsp;<a href="Accept" style="font-size:10px">Accept Registration</a></td>
													<td><s:property value="custodialAssetTypes"/></td>
													<td><s:property value="custodialAssetLimit"/></td>
												</tr>
											
											</s:iterator>
										
										</table>
										</div>
									</div>
								</div>
							</section>
							<!-- Three -->
							<section id="three" class="wrapper spotlight style3">
								<div class="inner">
									
									<div class="content">
										<h2 class="major">Custodian Opt-In Notifications</h2>
										<div class="table-wrapper">
										<table>
											<tr>
												<td>Custodian Id</td>
												<td>Ligature Id </td>
												<td></td>
										
											</tr>
											
												<s:iterator value="dashboard.custodianOptInNotifications">
													<tr>
													<td><s:property value="custodianId"/></td>
													<td><s:property value="ligatureId"/></td>
													<td>
														<form method="post" action="IssueLigature">
															<input type="hidden" name="custodianId" value="<s:property value="custodianId"/>"/>
															<input type="hidden" name="ligatureId" value="<s:property value="ligatureId"/>"/>
															<input name="issue" type="button" class="button small" value="Issue Ligature"/>
														</form>
													</td>
													</tr>
												</s:iterator>
											
										
										</table>
										</div>
									</div>
								</div>
							</section>
					

				<!-- Footer -->
				<!-- Footer -->
					<section id="footer">
						<div class="inner">
							<h2 class="major">Get in touch</h2>
							To contact our founder - Tony Kunz<a href="https://uk.linkedin.com/in/tony-kunz-358a78166">Click Here</a>
							<ul class="copyright">
								<li>&copy; Tony Kunz - Ligicate - Future of Blockchain - Hackathon Project . All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</section>
			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>


</html>