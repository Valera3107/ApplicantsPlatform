<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculties</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="home/home.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="home/home.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
						<li class="nav-item"><a class="nav-link"
							href="/createUniversity">Create Faculty</a></li>
					</security:authorize>
					<li class="nav-item active"><a class="nav-link"
						href="/faculties">Faculies</a></li>
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


	<!-- Page Content -->
	<div style="margin-top: 54px;">
		<div class="row" style="padding: 20px;">
			<c:if test="${not empty faculties}">
				<c:forEach items="${faculties}" var="faculty">

					<!--Card-->
					<div class="card col-md-3"
						style="background-color: darkgrey; width: 22%; margin-right: 1%; margin-bottom: 1%; color: aliceblue; box-shadow: 12px 13px 20px #b5b5b5;">

						<security:authorize access="hasRole('ROLE_ADMIN')">
							<a href="faculty?id=${faculty.id}" class="close"></a>
							<a href="facultyEdit?name=${faculty.name}"
								style="font-size: 27px; right: 43px;" class="edit fa fa-edit"></a>
						</security:authorize>

						<!--Card image-->
						<div class="view">
							<img src="data:image/jpg;base64, ${faculty.image}"
								style="border-radius: 10px; margin-top: 18px;"
								class="card-img-top" alt=""> <a href="#">
								<div class="mask rgba-white-slight"></div>
							</a>
						</div>

						<!--Card content-->
						<div class="card-body">
							<!--Title-->
							<h4 class="card-title">${faculty.name}</h4>
							<!--Text-->
							<p class="card-text">Location: ${faculty.location }</p>
							<p class="card-text">Average score: ${faculty.averageScore}</p>
						</div>

						<security:authorize access="hasRole('ROLE_USER')">
							<form:form method="POST" action="${contextPath}/statement"
								enctype="multipart/form-data">
								<input type="hidden" value="${faculty.id}" class="form-control"
									name="facultyId">
								<input type="submit" class="w3-button w3-block w3-dark-gray"
									value="Apply" style="border-radius: 6px; margin-bottom: 8px;">
							</form:form>
						</security:authorize>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
