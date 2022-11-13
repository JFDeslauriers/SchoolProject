<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
[class="collapse navbar-collapse"] {
	background-color: rgb(255, 230, 0);
}

[class*="col"] {
	padding: 1rem;
	background-color: rgba(71, 24, 12, 0.185);
	border: 2px solid rgba(240, 234, 234, 0.925);
	text-align: center;
}

[class="collapse navbar-collapse"] {
	background-color: rgb(226, 156, 120);
	border: 2px solid rgba(240, 234, 234, 0.925);
}
</style>

</head>
<body>

	<jsp:include page="../view/fragments/navBar.jsp"></jsp:include>

	<div class="container-fluid">

		<div class="row">

			<div class="col-md-8">
				<form class=addPost action="addPost" method="get">
					<div class="form-group">
						<label for="post-name">Make a spicy post</label> <input
							type="text" id="post" class="form-control" name="post" />
					</div>
				</form>
				<h2 class=" text-center">posts</h2>
				<c:if test="${PostList!='[]'}">
					<table>
						<c:forEach var="Post" items="${PostList}">
							<div class="card"
								style="max-width: 180rem; border: 20px solid rgb(16, 16, 17); padding: 15px; border-radius: 5px;">

								<div class="card-body">
									<img src="resources/images/literature-3033196_640--1-.jpg"
										class="card-img" alt="...">
									<div class="card-img-overlay">
										<h3 class="card-title text-center">
											<c:out value="${Post.post}" />


										</h3>

										<form class=addComment action="addComment" method="get">
											<div class="form-group">

												<input type="hidden" name="postId" value="${Post.postId}" />
												<input type="text" id="comment" class="form-control"
													name="comment" />
											</div>
											<button type="submit" class="btn btn-default">add
												comment</button>
											
										</form>
									</div>
								</div>
							</div>
							<c:forEach var="Comment" items="${Post.commentList}">
								<div class="card"
									style="max-width: 180rem; border: 2px solid rgb(20, 15, 10); padding: 15px; border-radius: 5px;">
									<div class="card-body" style="max-width: 180rem;">
										<h3 class="card-title text-center">
											<c:out value="${Comment.comment}" />
										</h3>
									</div>
								</div>
							</c:forEach>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${PostList=='[]'}">
					<h3 class="card-title text-center">You don't have any friends
						, please go home</h3>
				</c:if>
			</div>
			<div class="col-md-4">
				<table class="table">
					<!-- Table group dividers  -->
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">id</th>
							<th scope="col">follow</th>

						</tr>
					</thead>
					<tbody class="table-group-divider">
						<c:forEach var="User" items="${userList}">

							<tr>
								<th scope="row">1</th>
								<td><c:out value="${User.firstName}" /></td>
								<td><c:out value="${User.lastName}" /></td>
								<td><c:out value="${User.userId}" /></td>
								<td>
									<form action="addFollow" method="post">
										<input type="hidden" name="otherUserId" value="${User.userId}" />
										<button class="btn btn-primary" type="submit">Follow</button>
									</form>
									<form action="deleteFollow" method="post">
										<input type="hidden" name="otherUserId" value="${User.userId}" />
										<button class="btn btn-primary" type="submit">Unfollow</button>
									</form>
								</td>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>


</body>
</html>
