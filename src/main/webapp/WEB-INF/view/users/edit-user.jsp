<%@include file="../common/header.jsp"%>
<form:form method="post" action="edit-user" commandName="person">
	<h2>You edit your user</h2>
	<si:showSuccessMessage/>
	<si:showSuccessMessage/>
	<select name="roles" multiple="multiple" style="display:non">
				<c:forEach var="role" items="${person.rolesAsList}">
					<option selected="selected" value="${role}">${role}</option>
				</c:forEach>
	</select>
	<%@include file="user-form.jsp"%>
</form:form>
<%@include file="../common/footer.jsp"%>