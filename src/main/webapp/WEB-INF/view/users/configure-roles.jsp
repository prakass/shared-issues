<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<span>Select user and configure roles</span>
</div>
<div class="content-content">
<p class="header-font2">Select user</p>
<form action="configure-roles" method="post">
<select name="email">
	<c:forEach var="person" items="${persons}">
		<option value="${person.email}">${person.email}</option>
	</c:forEach>
</select>
<p class="header-font2">Select roles to configure</p>
<select name="roles" multiple="multiple">
		<option value="SUPERADMIN">Superadmin</option>
		<option value="ADMIN">Admin</option>
		<option value="USER">User</option>
</select>
<div class="clear"></div>
<br/>
<button type="submit" class="button">SUBMIT</button>
</form>
</div>
</div>
<%@include file="../common/footer.jsp"%>