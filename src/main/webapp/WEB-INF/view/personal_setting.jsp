<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>book club</title>
<link rel="stylesheet"href="<spring:url value="/resources/css/navBar.css"/>"type="text/css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
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
	width: 35%; border : 29px solid rgb( 105, 54, 29);
	padding: 45px;
	border-radius: 35px;
	background-color: white;
	opacity: 80%;
	border: 29px solid rgb(105, 54, 29);
}

body {
	background-image:
		url("https://images.rawpixel.com/image_1000/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvbHIvdXB3azU4Nzg2Nzk5LXdpa2ltZWRpYS1pbWFnZS1qb2I1NzItMS5qcGc.jpg");
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
<h1>Thank you for registering! Here's the review of your
					details:</h1>
	<div class="container">
		<div class="row">
		<div class="login">
			<div class="form-group">
				
			</div>
			<div class="form-group">
				<label for="User-firstName">First Name : </label> <span>${user.firstName}</span>
			</div>

			<div class="form-group">
				<label for="User-lastName">Last Name : </label> <span>${user.lastName}</span>
			</div>

			<div class="form-group">
				<label for="User-email">Email: </label> <span>${user.email}</span>
			</div>

			<div class="form-group">
				<label for="User-password">Password : </label> <span>${user.password}</span>
			</div>

			<div class="form-group">
				<label for="User-password">You are Following : </label>
			</div>

			<c:forEach var="User" items="${followingList}">
				<div class="form-group">
					<label for="User-password">you are following : </label> <span><c:out
							value="${User.firstName}" />
						<c:out value="${User.lastName}" /></span>
				</div>
			</c:forEach>
			
		</div>
		</div>
	</div>

</body>
</html>