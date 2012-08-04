<%@include file="../common/header.jsp"%>
<style>
 #user-profile-detail tr td:nth-child(odd){
 	font-weight:bold;
 	padding-right:30px;
 }
 #user-profile-detail tr td:nth-child(even){
 	font-weight:lighter;
 	color:#007ACC;
 	font-size:15px;
 }
</style>
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
				<si:showSuccessMessage/>
				<a href="/action/edit-profile" id="logout">Edit my profile </a><span>|</span>
				<a href="/action/change-password" id="logout"> Change my password</a>
				<div class="clear2"></div>
				<form>
				<table id="user-profile-detail">
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