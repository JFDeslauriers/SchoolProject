<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

          <table class="table" style="max-width: 180rem;">
    		<thead>
			<tr>
				
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">follow</th>

			</tr>
		</thead>
		<tbody class="table-group-divider">

			<c:forEach var="User" items="${userList}">
				<tr>
					
					<td><c:out value="${User.firstName}" /></td>
					<td><c:out value="${User.lastName}" /></td>
					<c:set var="yesfoll" value="true" />
					<td><c:set var="yesfoll" value="true" /> <c:forEach var="fl"
							items="${afollowingOBJList}">
							<c:if test="${fl == User.userId}">
								<button class="btn btn-light" type="submit" onclick="location.href='deleteFollow?userId=${User.userId}'">
									Followed <i class="fa-solid fa-check"></i>
								</button>
								<spring:url value="/addFollowUser" var="addmUrl"></spring:url>
								
								<c:set var="yesfoll" value="false" />
							</c:if>
						</c:forEach> <c:if test="${yesfoll}">
							<button class="btn btn-dark" type="submit" onclick="location.href='addFollowUser?userId=${User.userId}'">Follow</button>
						</c:if></td>
			</c:forEach>
		</tbody>
	</table>