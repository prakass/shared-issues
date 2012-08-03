<%@include file="../common/header.jsp" %>
<h2>Create new issue</h2>
<form:form commandName="issue" method="post">
<%@include file="issue-form.jsp" %>
<input type="submit" value="Create" class="button"/>
</form:form>
<%@include file="../common/footer.jsp" %>