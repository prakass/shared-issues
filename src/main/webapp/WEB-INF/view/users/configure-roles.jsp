<%@include file="../common/header.jsp"%>
<h2>Select user and configure roles</h2>
<h2>Users</h2>
<form action="configure-roles" method="post">
<select name="email">
	<c:forEach var="person" items="${persons}">
		<option value="${person.email}">${person.email}</option>
	</c:forEach>
</select>
<h2>Current rolesRoles</h2>
<select name="roles" multiple="multiple">
		<option value="SUPERADMIN">Superadmin</option>
		<option value="ADMIN">Admin</option>
		<option value="USER">User</option>
</select>
<br/>
<input type="submit" value="submit" class="button"/>
</form>
<%@include file="../common/footer.jsp"%>