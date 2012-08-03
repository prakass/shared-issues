<%@include file="../common/header.jsp"%>
<form:form method="post" action="add-user" commandName="person">
	<h2>You add your user</h2>
	<si:showServerError/>
	<si:showSuccessMessage/>
	<%@include file="../common/upload-image.jsp"%>
</form:form>
<%@include file="../common/footer.jsp"%>