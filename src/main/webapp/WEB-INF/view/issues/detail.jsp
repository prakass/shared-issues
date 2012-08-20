<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<b>${issue.issueTitle}</b>
</div>
<div class="content-content">
	<div class="issue-action-bar">
		<c:if test="${issue.status eq 'viewed' or issue.status eq 'new'}">
			<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=in-progress"><button>Start progress</button></a>
		</c:if>
		<c:if test="${issue.status=='in-progress' or issue.status eq 'viewed' or issue.status eq 'viewed'}">
			<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=resolved"><button>Resolve</button></a>
		</c:if>
		<c:if test="${issue.status=='resolved'}">
			<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=viewed"><button>Reopen issue</button></a>
		</c:if>
		<c:if test="${issue.status!='closed'}">
	    <sec:authorize access="hasRole('SUPERADMIN')">
			<a href="/action/issues/change-status?issueUuid=${issue.issueUuid}&status=closed"><button>Close issue</button></a>
			<a href="/action/issues/remove?issueUuid=${issue.issueUuid}"><button>Remove this issue</button></a>
		</sec:authorize>
		</c:if>
		<a href="/action/issues/edit?issueUuid=${issue.issueUuid}"><button>Edit this issue</button></a>
	</div>
	<div class="clear2"></div>
	<form>
	<table class="detail-table">
		<tr><td>Description</td> <td>${issue.issueDescription}</td></tr>
		<tr><td>Strategy and procedures</td> <td>${issue.strategy}</td></tr>
		<tr><td>Created by</td> <td><div id="created"></div><script>$('#created').load('/action/issues/get-person-for-comment?email=${issue.creatorPersonEmail}'); </script></td></tr>
		<tr><td>Last updated date</td> <td><fmt:formatDate value="${issue.createDate}" pattern="EEE, MMM d yyyy 'around' HH:mm"/></td></tr>
		<tr><td><div class="clear2"></div> Assigned to</td> <td><div id="assigned"></div><script>$('#assigned').load('/action/issues/get-person-for-comment?email=${issue.assignedPersonEmail}'); </script></td></tr>
		<tr><td>Dead line</td> <td><fmt:formatDate value="${issue.createDate}" pattern="EEE, MMM d yyyy"/></td></tr>
		<tr><td>Task type</td> 
				<td>
						<c:if test="${issue.category eq 'bug'}">
							<img src="/resources/images/bug-1.gif" title="Bug"/> Bug
						</c:if>
						<c:if test="${issue.category eq 'task'}">
							<img src="/resources/images/task-1.gif" title="Task"/> Task
						</c:if>
						<c:if test="${issue.category eq 'notice'}">
							<img src="/resources/images/notice-1.gif" title="Notice"/> Notice
						</c:if>
				</td>
		</tr>
		<tr><td>Current status</td> <td>${issue.status}</td></tr>
	
	</table>
	</form>
	<div class="clear3"></div>
</div>
</div>
<div class="clear3"></div>
<%@include file="comments.jsp"%>
<%@include file="../common/footer.jsp"%>