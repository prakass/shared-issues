<%@include file="/helper/tags.jsp" %>
<c:if test="${not empty comments}">
	<h2>All comments</h2>
	<c:forEach var="comment" items="${comments}">
		<c:if test="${comment.issueUuid==issue.issueUuid}">
		<div class="comment">
			${comment.personEmail}::${comment.comment}
		</div>
		<hr/>
		</c:if>
	</c:forEach>
</c:if>

<h2>Add your comment</h2>
<div class="comment-form">
	<form:form method="post" action="comment" commandName="comment">
		<table>
			<tr>
				<td>Write your comment</td>
				<td>
					<form:textarea  path="comment"/>
					<br/>
					<input type="submit" value="submit" class="button"/>
				</td>
				<td style="display:none;">
					<form:input path="issueUuid" value="${issue.issueUuid}"/>
					<input name="personEmail" value="${sessionScope['current.person'].email}"/>
				</td>
			</tr>
			
		</table>
	</form:form>
</div>