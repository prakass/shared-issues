<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<span>Edit user</span>
</div>
<div class="content-content">
	<form:form method="post" action="edit-user" commandName="person">
	<form:select path="roles" multiple="multiple" cssStyle="display:none;">
		<c:forEach var="role" items="${person.rolesAsList}">
			<c:if test="${role=='USER'}">
				<form:option selected="selected" value="USER">USER</form:option>
			</c:if>
			<c:if test="${role=='ADMIN'}">
				<form:option selected="selected" value="ADMIN">ADMIN</form:option>
			</c:if>
			<c:if test="${role=='SUPERADMIN'}">
				<form:option selected="selected" value="SUPERADMIN">SUPERADMIN</form:option>
			</c:if>
		</c:forEach>
		<form:option value=""></form:option>
	</form:select>
	<%@include file="user-form.jsp"%>
</form:form>
</div>
</div>
<%@include file="../common/footer.jsp"%>