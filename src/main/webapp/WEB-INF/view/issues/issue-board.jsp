<%@include file="../common/header.jsp"%>
<style>
.issue-board-item{
	width:200px;
	height:200px;
}
</style>
<div class="content-box">
<div class="content-header">
	<b>All issues</b>
</div>
<div class="content-content">
	<c:forEach var="issue" items="${issues}">
		<c:if test="${issue.assignedPersonEmail==sessionScope['current.person'].email && sessionScope['current.person'].email !='superadmin'}">
			<div class="issue-board-item">
				<b>${issue.issueTitle}</b>
				${issue.issueDescription}
			</div>
		</c:if>
		<c:if test="${sessionScope['current.person'].email =='superadmin'}">
			<div class="issue-board-item">
				<h2>${issue.issueTitle}</h2><br/>
				${issue.issueDescription}
			</div>
		</c:if>
	</c:forEach>
</div>
</div>

<%@include file="../common/footer.jsp"%>


