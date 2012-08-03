<%@include file="../common/header.jsp"%>
	<h2>Search user by any free text</h2>
	<form method="post">
	<input name="query"/>
	<input type="submit" value="Search"/>
	</form>
	<c:if test="${totleUser > 0}">
		<h2>There are totle ${totleUser} in the system</h2>
		<%@include file="user-list.jsp"%>
	</c:if>
	<c:if test="${totleUser eq 0}">
		<h2>We could not find any user by your query!</h2>
	</c:if>
<%@include file="../common/footer.jsp"%>