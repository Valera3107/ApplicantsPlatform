<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bucket</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="home/home.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="statement/statement.css">
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
					<li class="nav-item"><a class="nav-link" href="/faculties">Faculies</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="/statements">Statements</a></li>

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


	<input type="text" id="myInput" onkeyup="myFunction()"
		placeholder="Search for names.." title="Type in a name"
		style="margin: 89px 106px 26px 102px; border-radius: 8px;">

	<div style="margin: auto; width: 86%;">
		<table id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Faculty</th>
					<th scope="col">Average score</th>
					<th scope="col">Name Surname</th>
					<th scope="col">Math score</th>
					<th scope="col">English score</th>
					<th scope="col">Ukraine score</th>
					<th scope="col">Physics score</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="statement" items="${statements}">
					<tr>
						<th scope="row">${statement.id}</th>
						<td>${statement.university.name}</td>
						<td>${statement.university.averageScore}</td>
						<td>${statement.enrollee.name}_${statement.enrollee.surname}</td>
						<td>${statement.enrollee.mathScore}</td>
						<td>${statement.enrollee.englishScore}</td>
						<td>${statement.enrollee.ukraineScore}</td>
						<td>${statement.enrollee.physicsScore}</td>
						<td><a href="statement?id= ${statement.id}">pick up
								documents</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script>
		function myFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[2];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>
</body>
</html>