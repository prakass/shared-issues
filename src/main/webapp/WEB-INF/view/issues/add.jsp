<%@include file="../common/header.jsp" %>
<div class="content-box">
	<div class="content-header">
		<span>Add new issue</span>
	</div>
	<div class="content-content">
		<form:form commandName="issue" method="post">
			<%@include file="issue-form.jsp" %>
		<button type="submit" class="button">SUBMIT</button>
</form:form>
</div>
</div>
<%@include file="../common/footer.jsp" %>