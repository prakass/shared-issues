<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<h2>Activities</h2>
</div>
<div class="content-content">
	
</div>
</div>
<c:set var="admin" value="${false}"/>
<c:forEach var="role" items="${sessionScope['current.person'].rolesAsList}">
	<c:if test="${role=='SUPERADMIN' or role=='ADMIN' }">
		
	</c:if>
</c:forEach>
<div class="content-box">
<div class="content-header">
	<h2>Assigned to me</h2>
</div>
<div class="content-content">
	<c:forEach var="issue" items="${issues}">
		<c:if test="${issue.assignedPersonEmail==sessionScope['current.person'].email}">
			<a href="/action/issues/detail?issueUuid=${issue.issueUuid}">${issue.issueTitle}</a><br/>
		</c:if>
	</c:forEach>
</div>
</div>

<security:authorize access="hasRole('SUPERADMIN')">
<div class="content-box">
<div class="content-header">
	<h2>All other issues</h2>
</div>
<div class="content-content">
	<c:forEach var="issue" items="${issues}">
		<c:if test="${sessionScope['current.person'].email =='superadmin' && issue.assignedPersonEmail!='superadmin'}">
			<a href="/action/issues/detail?issueUuid=${issue.issueUuid}">${issue.issueTitle}</a><br/>
		</c:if>
	</c:forEach>
</div>
</div>
</security:authorize>

<%@include file="../common/footer.jsp"%>