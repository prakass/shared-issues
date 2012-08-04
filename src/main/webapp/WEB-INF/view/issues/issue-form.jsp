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
</table> 
<script>
	$('form').validate();
</script>
<form:input cssStyle="display:none;" path="creatorPersonEmail" value="${sessionScope['current.person'].email}"/>