<%@include file="../common/header.jsp"%>
<c:set var="person" value="${sessionScope['current.person']}"/>
<div>
	<si:showSuccessMessage/>
	<h2>Your profile</h2>
	<table>
		<tr>
			<td style="vertical-align:top;">
				<c:if test="${person.profilePicture!=null && person.profilePicture!=''}">
					<img width="200" height="200" src="/action/image/get/${person.profilePicture}">
				</c:if>
				<c:if test="${person.profilePicture==null or person.profilePicture==''}">
					<img width="200" height="200" src="/resources/images/profile.jpg"/>
				</c:if>	
			</td>
			<td style="color:green; font-weight:bold;padding-left:20px; vertical-align: top;">
				 <label>Your first name:</label>${person.firstName}<br/>
				 <label>Your last name:</label>${person.lastName}<br/>
				<label>Your email:</label>${person.email}<br/>
				<label>City</label>:${person.city}<br/>
				<br/>
				<a href="/action/users/edit-user?email=${person.email}">Edit your profile</a>
			</td>
		</tr>
	</table>
	<hr/>
	<form method="post" action="/action/image/upload?externalUuid=${person.personUuid}&externalFlag=overall&target=/action/users/upload-image" enctype="multipart/form-data">
		<%@include file="../common/upload-image.jsp"%>
	</form>
</div>
<%@include file="../common/footer.jsp"%>