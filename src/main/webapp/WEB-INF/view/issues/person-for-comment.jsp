<%@include  file="/helper/tags.jsp" %>
<table class="top-flow" style="width:160px;">
	<tr>
		<td>
			<c:choose>
			<c:when test="${not empty person.profilePicture}">
				<img width="50" height="50" src="/action/image/get/${person.profilePicture}">
			</c:when>
			<c:otherwise>
				<img width="50" height="50" src="/resources/images/profile.jpg"/>
			</c:otherwise>
		</c:choose>
		</td>
		<td style="vertical-align:top;">
			<span class="person-link">${person.firstName} ${person.lastName}</span>
		</td>
	</tr>
</table>