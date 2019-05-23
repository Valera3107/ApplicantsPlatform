<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create University</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="home/home.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="icon" type="image/png"
	href="universityCreate/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="universityCreate/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="universityCreate/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="universityCreate/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="universityCreate/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="universityCreate/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="universityCreate/css/util.css">
<link rel="stylesheet" type="text/css"
	href="universityCreate/css/main.css">
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
					<li class="nav-item"><a class="nav-link" href="/home">Home</a>
					</li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="nav-item active"><a class="nav-link"
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


	<div class="bg-contact100"
		style="margin-top: 54px;">
		<div class="container-contact100">
			<div class="wrap-contact100">
				<div class="contact100-pic js-tilt" data-tilt>
					<img src="https://image.flaticon.com/icons/png/512/91/91848.png" alt="IMG">
				</div>

				<form:form method="POST" action="${contextPath}/createUniversity"
					class="contact100-form validate-form" enctype="multipart/form-data">
					<span class="contact100-form-title"> Get in touch </span>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="name" placeholder="Name">
						<span class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input"">
						<input class="input100" type="text" name="location"
							placeholder="Location">
					</div>

					<div class="wrap-input100 validate-input"">
						<input class="input100" type="text" name="averageScore"
							placeholder="Average Score">
					</div>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="file" name="image"
							style="padding: 11px 30px 0 50px;" placeholder="Average Score">
					</div>

					<div class="container-contact100-form-btn">
						<button type="submit" class="contact100-form-btn">Submit</button>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="universityCreate/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="universityCreate/vendor/bootstrap/js/popper.js"></script>
	<script src="universityCreate/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="universityCreate/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="universityCreate/vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="universityCreate/js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>

</body>
</html>
