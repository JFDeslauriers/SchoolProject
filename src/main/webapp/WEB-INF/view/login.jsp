<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>book club</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
<style>
[class="collapse navbar-collapse"] {
	padding: 1rem;
	background-color: rgb(105, 54, 29);
	border: 2px solid rgba(240, 234, 234, 0.925);
}

.login {
	margin-left: auto;
	margin-right: auto;
	margin-top: 200px;
	width: 25%; border : 29px solid rgb( 105, 54, 29);
	padding: 45px;
	border-radius: 35px;
	background-color: white;
	opacity: 80%;
	border: 29px solid rgb(105, 54, 29);
}

body {
	background-image:
		url("https://images.rawpixel.com/image_1000/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA1L3Vwd2s2MTc3NzM3Mi13aWtpbWVkaWEtaW1hZ2Uta293Ym02eG8uanBn.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

h1 {
	text-align: center;
	color: white;
}
</style>
</head>
<body>

	<jsp:include page="../view/fragments/navBar.jsp"></jsp:include>
	<h1>Welcome to your BookClub</h1>
	<div class="container">
		<div class="row">
			<div class="col">

				<form class="login" action="<spring:url value="/loginForm"/>"
					method="post">

					<div class="form-group">
						<label for="project-name">Email</label>
						<input type="text" placeholder="name@example.com" id="email" class="form-control" name="email" />
					</div>

					<div class="form-group">
						<label for="project-name">Password</label> 
						<input type="text" placeholder="Password" id="password" class="form-control" name="password" />
					</div>
					<button type="submit" class="btn btn-warning">submit</button>



				</form>

			</div>
		</div>
	</div>
</body>
</html>