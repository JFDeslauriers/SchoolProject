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
	      background-image: url("https://images.rawpixel.com/image_1000/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA1L3B4MTQwOTA0My1pbWFnZS1rd3Z4endkei5qcGc.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

h1 {
	text-align: center;
	color: white;
}
      background-image: url("https://images.rawpixel.com/image_1000/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA1L3B4MTQwOTA0My1pbWFnZS1rd3Z4endkei5qcGc.jpg");

</style>
</head>
<body>
	<jsp:include page="../view/fragments/navBar.jsp"></jsp:include>
 <h1>Registration</h1>
    <div class="container">
        <div class="row">
          
          <div class="col">
            
           
            		<spring:url value="/registration/save" var="formUrl"></spring:url>
 <form:form class="login"  action="${formUrl}" method="POST"   modelAttribute="user">
 
<div class="mb-3"> 
   <form:label path="firstName" class="form-label">First Name</form:label>
   <form:input path="firstName" placeholder="First Name" class="form-control"/>
 </div>
 
 <div class="mb-3"> 
   <form:label path="lastName" class="form-label">Last Name</form:label>
   <form:input path="lastName" placeholder="Last Name" class="form-control"/>
 </div>
 
 <div class="mb-3"> 
   <form:label path="email" class="form-label">Email Address</form:label>
   <form:input path="email" placeholder="name@example.com" class="form-control"/>
 </div>
 
 <div class="mb-3"> 
   <form:label path="password" class="form-label">Password</form:label>
   <form:input path="password" placeholder="Password" class="form-control"/>
 </div>
 
  <button type="submit" class="btn btn-warning">Submit</button>

	 </form:form>
     
        
          </div>
          
        </div>
      </div>
   
</body>
</html>