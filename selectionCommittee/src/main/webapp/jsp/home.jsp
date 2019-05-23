<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="home/home.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Future Finder</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="/home">Home</a>
					</li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="nav-item"><a class="nav-link"
							href="/createUniversity">Create Faculty</a></li>
					</security:authorize>
					<li class="nav-item"><a class="nav-link" href="/faculties">Faculies</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/statements">Statements</a>
					</li>

					<li class="nav-item"><c:if
							test="${pageContext.request.userPrincipal.name != null}">
							<p class="user-item">User:
								${pageContext.request.userPrincipal.name}</p>
						</c:if></li>

					<li class="nav-item" style="margin-left: 10px;"><c:if
							test="${pageContext.request.userPrincipal.name != null}">
							<form id="logoutForm" method="POST"
								action="${contextPath}/logout">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>

							<button class="logout">
								<a onclick="document.forms['logoutForm'].submit()">Logout</a>
							</button>

						</c:if></li>
				</ul>
			</div>
		</div>
	</nav>

	<header class="masthead">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12 text-center">
					<h1 class="poster-title">Find your future education with us!</h1>
					<p class="poster-text">This platform can help you to find
						faculty and apply documents. Good luck!</p>
				</div>
			</div>
		</div>
	</header>

	<!-- Page Content -->
	<div class="page-content">
		<h1 class="main-title">Our enrollees and future students</h1>

		<!--Grid row-->
		<div class="row" style="padding: 20px;">

			<!--Grid column-->


			<c:if test="${not empty enrollees}">
				<c:forEach items="${enrollees}" var="enrollee">
					<div class="col-md-3">
						<!--Card group-->
						<div class="card-group">

							<!--Card-->
							<div class="card card-personal mb-3">

								<security:authorize access="hasRole('ROLE_ADMIN')">
									<a href="enrollee?id= ${enrollee.id}" class="close"></a>
								</security:authorize>

								<security:authorize access="hasRole('ROLE_USER')">
									<a href="enrolleeEdit?login= ${enrollee.login}" style="font-size:25px;" class="edit fa fa-edit"></a>
								</security:authorize>
								<!--Card image-->
								<div class="view">
									<img class="card-img-top" style="height: 174px;"
										src="data:image/jpg;base64, ${enrollee.image }"
										alt="Card image cap"> <a href="#!">
										<div class="mask rgba-white-slight"></div>
									</a>
								</div>
								<!--Card image-->
								<!--Card content-->
								<div class="card-body"
									style="background-color: #3b3b3b; color: white;">
									<!--Title-->
									<a>
										<h4 class="card-title">${enrollee.name}
											${enrollee.surname}</h4>
									</a> <a class="card-meta">Scores:</a>

									<!--Text-->
									<p class="card-text">Math: ${enrollee.mathScore }</p>
									<p class="card-text">Ukraine: ${enrollee.ukraineScore }</p>
									<p class="card-text">Physics: ${enrollee.physicsScore }</p>
									<p class="card-text">English: ${enrollee.englishScore }</p>
									<hr>
									<a class="card-meta"><span><i class="fas fa-user"></i>
											Status: ${enrollee.status }</span></a>
								</div>
								<!--Card content-->
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
	<!-- Footer -->
	<footer class="page-footer font-small unique-color-dark"
		style="background-color: #484848; color: white;">

		<div style="background-color: #212121;">
			<div class="container">

				<!-- Grid row-->
				<div class="row py-4 d-flex align-items-center">

					<!-- Grid column -->
					<div
						class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
						<h6 class="mb-0">Get connected with us on social networks!</h6>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-6 col-lg-7 text-center text-md-right">

						<!-- Facebook -->
						<a class="fb-ic"> <i class="fab fa-facebook-f white-text mr-4">
						</i>
						</a>
						<!-- Twitter -->
						<a class="tw-ic"> <i class="fab fa-twitter white-text mr-4">
						</i>
						</a>
						<!-- Google +-->
						<a class="gplus-ic"> <i
							class="fab fa-google-plus-g white-text mr-4"> </i>
						</a>
						<!--Linkedin -->
						<a class="li-ic"> <i
							class="fab fa-linkedin-in white-text mr-4"> </i>
						</a>
						<!--Instagram-->
						<a class="ins-ic"> <i class="fab fa-instagram white-text">
						</i>
						</a>

					</div>
					<!-- Grid column -->

				</div>
				<!-- Grid row-->

			</div>
		</div>

		<!-- Footer Links -->
		<div class="container text-center text-md-left mt-5">

			<!-- Grid row -->
			<div class="row mt-3">

				<!-- Grid column -->
				<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

					<!-- Content -->
					<h6 class="text-uppercase font-weight-bold">Company name</h6>
					<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto"
						style="width: 60px; width: 60px; background-color: #e0e0e0;">
					<p>Here you can use rows and columns to organize your footer
						content. Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

					<!-- Links -->
					<h6 class="text-uppercase font-weight-bold">Products</h6>
					<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto"
						style="width: 60px; width: 60px; background-color: #e0e0e0;">
					<p>
						<a href="#!">MDBootstrap</a>
					</p>
					<p>
						<a href="#!">MDWordPress</a>
					</p>
					<p>
						<a href="#!">BrandFlow</a>
					</p>
					<p>
						<a href="#!">Bootstrap Angular</a>
					</p>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

					<!-- Links -->
					<h6 class="text-uppercase font-weight-bold">Useful links</h6>
					<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto"
						style="width: 60px; width: 60px; background-color: #e0e0e0;">
					<p>
						<a href="#!">Your Account</a>
					</p>
					<p>
						<a href="#!">Become an Affiliate</a>
					</p>
					<p>
						<a href="#!">Shipping Rates</a>
					</p>
					<p>
						<a href="#!">Help</a>
					</p>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

					<!-- Links -->
					<h6 class="text-uppercase font-weight-bold">Contact</h6>
					<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto"
						style="width: 60px; width: 60px; background-color: #e0e0e0;">
					<p>
						<i class="fas fa-home mr-3"></i> New York, NY 10012, US
					</p>
					<p>
						<i class="fas fa-envelope mr-3"></i> info@example.com
					</p>
					<p>
						<i class="fas fa-phone mr-3"></i> + 01 234 567 88
					</p>
					<p>
						<i class="fas fa-print mr-3"></i> + 01 234 567 89
					</p>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Links -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2018 Copyright: <a
				href="https://mdbootstrap.com/education/bootstrap/">
				MDBootstrap.com</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
