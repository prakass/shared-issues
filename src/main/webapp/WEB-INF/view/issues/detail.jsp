<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<h2>${issue.issueTitle}</h2>
</div>
<div class="content-content">
	<div class="issue-action-bar">
		<c:if test="${issue.status=='viewed'}">
			<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=in-progress"><button>Start progress</button></a>
		</c:if>
		<c:if test="${issue.status=='in-progress'}">
			<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=resolved"><button>Resolve</button></a>
		</c:if>
		<c:if test="${issue.status=='resolved'}">
			<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=viewed"><button>Reopen issue</button></a>
		</c:if>
		<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=closed"><button>Close issue</button></a>
	</div>
	<a href="/action/issues/edit?issueUuid=${issue.issueUuid}">Edit this issue</a>
	<br/>
	<p class="header-font1">hello im header font1</p>
	<p class="header-font3">hello im header font</p>
	<p class="header-font2">hello im header font2</p>
	<p class="header-font4">hello im header font3</p>
	<p class="header-font">hello im header font</p>
	<span class="header-font2">hello im span with header 2</span>
	<h2 class="header-font4"></h2>
	${issue.issueDescription}<br/>
	${issue.assignedPersonEmail}
	${issue.creatorPersonEmail}
	${issue.priority}
	${issue.category}
	status:${issue.status}:
</div>
</div>
<div>
	<%@include file="comments.jsp"%>
</div>
<%@include file="../common/footer.jsp"%>