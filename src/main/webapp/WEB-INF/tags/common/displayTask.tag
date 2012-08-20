<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="header"%>
<%@attribute name="name"%>
<%@attribute name="status"%>
<%@attribute name="category"%>
<%@attribute name="issueUuid"%>
<tr>
<td>
	<c:if test="${category eq 'bug'}">
		<img src="/resources/images/bug-1.gif" title="Bug"/>
	</c:if>
	<c:if test="${category eq 'task'}">
		<img src="/resources/images/task-1.gif" title="Task"/>
	</c:if>
	<c:if test="${category eq 'notice'}">
		<img src="/resources/images/notice-1.gif" title="Notice"/>
	</c:if>
</td>
<c:choose>
	<c:when test="${status eq 'new'}">
		<td> <a href="/action/issues/detail?issueUuid=${issueUuid}"> ${name}</a></td><td><span style="color:blue;font-size:small;">*New</span> </td>
	</c:when>
	<c:when test="${status eq 'viewed'}">
		<td> <a href="/action/issues/detail?issueUuid=${issueUuid}"> ${name}</a></td><td><span style="color:#1781D9;font-size:small;">viewed</span> </td>
	</c:when>
	<c:when test="${status eq 'in-progress'}">
		<td><a href="/action/issues/detail?issueUuid=${issueUuid}"> ${name}</a></td><td><span style="color:#1781D9;font-size:small;">in progress</span> </td>
	</c:when>
	<c:when test="${status eq 'resolved'}">
		<td><a href="/action/issues/detail?issueUuid=${issueUuid}"> ${name}</a></td><td><span style="color:#1781D9;font-size:small;">resolved</span> </td>
	</c:when>
	<c:when test="${status eq 'closed'}">
		<td> <a href="/action/issues/detail?issueUuid=${issueUuid}"> ${name}</a></td><td><span style="color:#1781D9;font-size:small;">closed</span> </td>
	</c:when>
	<c:otherwise>
		<td> <a href="/action/issues/detail?issueUuid=${issueUuid}"> ${name}</a></td><td><span style="color:#1781D9;font-size:small;"></span> </td>
	</c:otherwise>
</c:choose>
</tr>