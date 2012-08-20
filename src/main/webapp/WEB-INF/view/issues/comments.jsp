<%@include file="/helper/tags.jsp" %>
<div class="content-box">
<c:set var="cmt" value="false"/>
<c:if test="${not empty comments}">
	<h3>Comments</h3>
	<div class="clear1"></div>
	<c:forEach var="comment" items="${comments}">
		<c:if test="${comment.issueUuid eq issue.issueUuid}">
		<c:set var="cmt" value="true"/>
		<div class="single-comment">
			<table>
			<tr>
			<td>
			<div id="${comment.commentUuid}" style="background-color:#EFEFEF;"></div>
			</td>
			<td><span style="color:#666666;font-size:small;">${comment.comment}</span><br/><span style="font-weight:bold;font-size:small;"><fmt:formatDate value="${comment.date}" pattern="EEE, MMM d yyyy 'around' HH:mm"/></span></td>
			<tr>
			</table>
		</div>
		<div class="clear2"></div>
		</c:if>
	</c:forEach>
	<c:if test="${not cmt}">
		<div style="padding:10px;" class="single-comment">There are no comments for this issues</div>
	</c:if>
</c:if>

<h3>Add your comment</h3>
<div class="comment-form" style="margin-left:30px;">
	<form:form method="post" action="comment" commandName="comment">
		
				 <b>Write your comment</b>
					<div class="clear1"></div>
					<form:textarea  path="comment"  class="required" minlength="10"/>
					<br/>
					<button type="submit" class="button">Post</button>
				
				<div style="display:none;">
					<form:input path="issueUuid" value="${issue.issueUuid}"/>
					<form:input path="personEmail" value="${personProfile.email}"/>
				</div>
			
	</form:form>
</div>
</div>
<script>
<c:forEach var="comment" items="${comments}">
		$('div#${comment.commentUuid}').load('/action/issues/get-person-for-comment?email=${comment.personEmail}');
</c:forEach>
</script>