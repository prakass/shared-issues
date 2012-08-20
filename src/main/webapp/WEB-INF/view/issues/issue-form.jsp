<%@include file="/helper/tags.jsp" %>
<table>
	<tr>
		<td>Title<br/>
		<form:input path="issueTitle" class="required"/> </td>
	</tr>
	<tr>
		<td>Description<br/>
		<form:textarea path="issueDescription" class="required"/> </td>
	</tr>
	<tr>
		<td><div class="clear2"></div>Strategies and procedures<br/>
		<form:textarea path="strategy"/> </td>
	</tr>
	
	<tr>
		<td>Assign to
		<br/>
			<form:select path="assignedPersonEmail">
				<c:forEach var="person" items="${persons}">
					<c:if test="${issue.assignedPersonEmail==person.email}">
						<form:option value="${person.email}" selected="selected">${person.email}</form:option>
					</c:if>
					<c:if test="${issue.assignedPersonEmail!=person.email}">
						<form:option value="${person.email}">${person.email}</form:option>
					</c:if>
				</c:forEach>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>Set priority<br/>
		
			<form:select path="priority">
				<form:option value="general">General</form:option>
				<form:option value="low">Low</form:option>
				<form:option value="high">High</form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>Select category
			<br/>
			<form:select path="category">
				<form:option value="task">Task</form:option>
				<form:option value="bug">Bug</form:option>
				<form:option value="notice">Notice</form:option>
			</form:select>
		</td>
	</tr>
	<tr>
		<td>Set deadline <span style="color:#F7BD1C;"> (Format:mm/dd/yyyy)</span>
	    <form:input path="deadline" class="required date"/> </td>
	</tr>
</table> 
<form:input cssStyle="display:none;" path="creatorPersonEmail" value="${issue.creatorPersonEmail}"/>
<form:input cssStyle="display:none;" path="status" value="${issue.status}"/>
<script>
var date = $('#issue input#deadline').val();
if(date!=null){
 $('#issue input#deadline').val('<fmt:formatDate pattern="M/dd/yy" value="${issue.deadline}"/>');
}
</script>