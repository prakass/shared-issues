<%@include file="../common/header.jsp"%>
<c:set var="person" value="${sessionScope['current.person']}"/>
<div class="content-box">
	<div class="content-header">
	<span>Your profile</span>
	</div>
	<div class="content-content">
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
			<td class="content-font" style="padding-left:50px;">
				<form>
				<table class="detail-table">
				<tr><td>Your name</td><td>${person.userSalutation} ${person.firstName} ${person.lastName}</td></tr>
				<tr><td>Email</td><td>${person.email}</td></tr>
				<tr><td>Address</td><td>${person.address}</td></tr>
				<tr><td>City</td><td>${person.city}</td></tr>
				<tr><td>Country</td><td>${person.country}</td></tr>
				</table>
				</form>
				<p class="header-font2">Change your profile picture</p>
				<form method="post" action="/action/image/upload?externalUuid=${person.personUuid}&externalFlag=overall&target=/action/users/upload-image" enctype="multipart/form-data">
					<%@include file="../common/upload-image.jsp"%>
				</form>
				<div class="clear"></div>
			</td>
		</tr>
	</table>
	</div>
</div>
<div class="clear3"></div>
<%@include file="../common/footer.jsp"%>