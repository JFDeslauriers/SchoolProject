<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	width: 25%; border : 29px solid rgb( 105, 54, 29);
	padding: 45px;
	border-radius: 35px;
	background-color: white;
	opacity: 80%;
	border: 29px solid rgb(105, 54, 29);
}
body {
         background-image: url("https://images.rawpixel.com/image_1000/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvbHIvd2s2NTgyOTE5My13aWtpbWVkaWEtaW1hZ2Uta3A2bTU0YmEuanBn.jpg");
            background-repeat: no-repeat;
      background-size: cover;
    }
h1{
text-align:center;
color: white;

}
</style>
</head>
<body>
	<jsp:include page="../view/fragments/navBar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
		<h1>Here you can Update your Settings:</h1>
		<span>${user.firstName}</span>
<spring:url value="/updateUser/save" var="formUrl"></spring:url>
			<form:form action="${formUrl}" method="post"  modelAttribute="user"
				class="login">

				<div class="form-group">
					
				</div>

				<div class="form-group">
					<div class="form-group">
						<label for="User-firstName">First Name : </label> 
					</div>
					<form:input  path="firstName" type="text" id="firstName" placeholder="First Name"
						class="form-control" name="firstName" />
				</div>

				<div class="form-group">
					<div class="form-group">
						<label for="User-lastName">Last Name : </label> 
					</div>
					<input type="text" id="lastName" class="form-control" placeholder="Last Name"
						name="lastName" />
				</div>

				<div class="form-group">
					<div class="form-group">
						<label for="User-email">Email: </label> 
					</div>
					<input type="text" id="email" class="form-control" name="email" placeholder="name@example.com"/>
				</div>

				<div class="form-group">
					<div class="form-group">
						<label for="User-password">Password : </label> 
					</div>
					<input type="text" id="password" class="form-control" placeholder="Password"
						name="password" />
				</div>

				<button type="submit" class="btn btn-warning">submit</button>

			</form:form>

		</div>
	</div>
</body>
</html>