<%@include file="/helper/tags.jsp" %>
<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<span>You add your user</span>
</div>
<div class="content-content">
	<form:form method="post" action="add-user" commandName="person">
	<%@include file="user-form.jsp"%>
</form:form>
</div>
</div>
<%@include file="../common/footer.jsp"%>
