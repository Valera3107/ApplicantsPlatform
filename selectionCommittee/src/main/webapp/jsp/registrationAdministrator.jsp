<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Create an account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="registration/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="registration/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="registration/css/util.css">
<link rel="stylesheet" type="text/css" href="registration/css/main.css">
</head>

<body>

<!-- 	<div class="container">

		<form:form method="POST" modelAttribute="adminForm"
			class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>

			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="name" class="form-control"
						placeholder="Name" autofocus="true"></form:input>
					<form:errors path="name"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="login">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="login" class="form-control"
						placeholder="Login" autofocus="true"></form:input>
					<form:errors path="login"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

	</div>


-->

	<div class="limiter">
		<div class="container-login100">
			<div class="login100-more"
				style="background-image: url('registration/images/bg-01.jpg');"></div>

			<div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
				<form:form method="POST" modelAttribute="adminForm"
					class="login100-form validate-form">
					<span class="login100-form-title p-b-59"> Sign Up </span>

					<div class="wrap-input100 validate-input">
						<span class="label-input100">Name</span>
						<spring:bind path="name">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="name" class="form-control"
									placeholder="Name" autofocus="true"></form:input>
								<form:errors path="name"></form:errors>
							</div>
						</spring:bind>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input">
						<span class="label-input100">Login</span>
						<spring:bind path="login">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="login" class="form-control"
									placeholder="Login" autofocus="true"></form:input>
								<form:errors path="login"></form:errors>
							</div>
						</spring:bind>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input">
						<span class="label-input100">Password</span>
						<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="password" path="password" class="form-control"
									placeholder="Password"></form:input>
								<form:errors path="password"></form:errors>
							</div>
						</spring:bind>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input">
						<span class="label-input100">Repeat Password</span>
						<spring:bind path="passwordConfirm">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="password" path="passwordConfirm"
									class="form-control" placeholder="Confirm your password"></form:input>
								<form:errors path="passwordConfirm"></form:errors>
							</div>
						</spring:bind>
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">Sign Up
							</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>





	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<!--===============================================================================================-->
	<script src="registration/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="registration/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="registration/vendor/bootstrap/js/popper.js"></script>
	<script src="registration/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="registration/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="registration/vendor/daterangepicker/moment.min.js"></script>
	<script src="registration/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="registration/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="registration/js/main.js"></script>
</body>
</html>