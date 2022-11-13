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
	background-color: rgb(255, 230, 0);
}
</style>
</head>
<body>
	<jsp:include page="../view/fragments/navBar.jsp"></jsp:include>
<form class=addMessage action="addMessage" method="get">
	<div class="input-group input-group-lg">
		<div class="input-group-prepend">
			<span>enter comment</span>

		</div>
		<input type="text" class="form-control" id="message" name="message"
			aria-label="Large" aria-describedby="inputGroup-sizing-sm">
	</div>
</form>
<h2 class=" text-center">comments</h2>
<c:if test="${PostList!='[]'}">
	<table>
		<c:forEach var="Post" items="${PostList}">

			<div class="card"
				style="width: 45rem; border: 2px solid blue; padding: 15px; border-radius: 5px;">
				<div class="card-body">
					<h3 class="card-title text-center">
						<c:out value="${Post.post}" />
					</h3>
					<p>
						post_id :
						<c:out value="${Post.postId}" />
					</p>

				</div>
			</div>
			<c:forEach var="Comment" items="${Post.commentList}">

				<div class="card"
					style="width: 45rem; border: 2px solid blue; padding: 15px; border-radius: 5px;">
					<div class="card-body">
						<h3 class="card-title text-center">
							<c:out value="${Comment.comment}" />
						</h3>
					</div>

				</div>


			</c:forEach>
		</c:forEach>
	</table>
</c:if>


<c:if test="${MessageList=='[]'}">
	<h3 class="card-title text-center">You don't have any friends ,
		please go home</h3>
</c:if>
</body>




</html>