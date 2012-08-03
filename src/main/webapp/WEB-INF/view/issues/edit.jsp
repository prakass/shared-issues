<%@include file="../common/header.jsp" %>
<div class="content-box">
	<div class="content-header">
		<h2>Edit this issue</h2>
	</div>
	<div class="content-content">
		<form:form commandName="issue" method="post">
			<%@include file="issue-form.jsp" %>
		<input type="submit" value="Save changes" class="button"/>
</form:form>
</div>
</div>
<%@include file="../common/footer.jsp" %>