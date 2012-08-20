<%@include file="../common/header.jsp"%>
<c:set var="admin" value="${false}"/>
<c:forEach var="role" items="${sessionScope['current.person'].rolesAsList}">
	<c:if test="${role=='SUPERADMIN' or role=='ADMIN' }">
		<c:set var="admin" value="${true}"/>
	</c:if>
</c:forEach>
<table class="body-fit">
	<tr>
		<td>
			<div>
				<div class="content-header">
					<b>Open tasks</b>
				</div>
				<div class="content-content">
					<table class="issues-list">
					<tr>
						<td>Type</td><td>Title</td><td>Status</td>
					</tr>
					<c:forEach var="issue" items="${issues}">
						<c:if test="${issue.status!='closed' && issue.status!='resolved'}">
						<si:displayTask category="${issue.category}" header="false" name="${issue.issueTitle}" status="${issue.status}" issueUuid="${issue.issueUuid}"/> 
						</c:if>
					</c:forEach>
					</table>
				</div>
			</div>
			<div class="clear3"></div>
			<c:if test="${admin}">
				<div class="content-header">
					<b>Completed tasks</b>
				</div>
				<div class="content-content">
					<table class="issues-list">
					<tr>
						<td>Type</td><td>Title</td><td>Status</td>
					</tr>
					<c:forEach var="issue" items="${issues}">
						<c:if test="${issue.status=='resolved'}">
							<si:displayTask category="${issue.category}" header="false" name="${issue.issueTitle}" status="${issue.status}" issueUuid="${issue.issueUuid}"/> 
						</c:if>
					</c:forEach>
					</table>
				</div>
				<div class="clear3"></div>
				<div class="content-header">
					<b>Closed tasks</b>
				</div>
				<div class="content-content">
					<table class="issues-list">
					<tr>
						<td>Type</td><td>Title</td><td>Status</td>
					</tr>
					<c:forEach var="issue" items="${issues}">
						<c:if test="${issue.status=='closed'}">
							<si:displayTask category="${issue.category}" header="false" name="${issue.issueTitle}" status="${issue.status}" issueUuid="${issue.issueUuid}"/> 
						</c:if>
					</c:forEach>
					</table>
				</div>
			</c:if>
		</td>
		<td style="padding-left:10px;width:500px;">
				<div>
				<div class="content-header">
					<b>Task assigned to me</b>
				</div>
				<div class="content-content">
					<table class="issues-list">
					<tr>
						<td>Type</td><td>Title</td><td>Status</td>
					</tr>
					<c:forEach var="issue" items="${issues}">
						<c:if test="${issue.assignedPersonEmail==personProfile.email && issue.status!='closed' && issue.status!='resolved'}">
							<si:displayTask category="${issue.category}" header="false" name="${issue.issueTitle}" status="${issue.status}" issueUuid="${issue.issueUuid}"/> 
						</c:if>
					</c:forEach>
					</table>
				</div>
				</div>
				<div class="clear3"></div>
				<div>
					<div class="content-header">
						<b>Activity stream</b>
					</div>
					<div class="content-content">
					<table>
						<c:forEach var="activity" items="${activities}">
									<tr><td><div id="${activity.activityId}"></div>
										<script>
											$('div#${activity.activityId}').load('/action/issues/get-person-for-comment?email=${activity.who}');
										</script>
									
									</td><td class="activity-item"><span>${activity.what}</span> <br/><label><fmt:formatDate value="${activity.createDate}" pattern="EEE, MMM d yyyy 'around' HH:mm"/></label><div class="clear2"></div></td>
									<td style="padding-left:15px;"><a id="remove-activity" href="/action/remove-activity?activityId=${activity.activityId}">remove</a> </td>
									</tr>
					    </c:forEach>
					    </table>
					</div>
				</div>
		</td>
	</tr>
</table>
<div class="clear3"></div>
<%@include file="../common/footer.jsp"%>