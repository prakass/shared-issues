<%@include file="../common/header.jsp" %>
<div class="content-box">

<div class="content-header">
	<span class="header-font2">All files</span>
</div>
<div class="content-content">
<c:forEach var="image" items="${images}">
	<div style="padding:5px; border:1px solid #F5F5F5;margin:20px;display:inline-table;text-align:center;">
	    <a style="float:right;" href="/action/image/remove?imageUuid=${image.imageUuid}&target=/action/image/all-images"><img src="/resources/images/icons/delete-4.png" class="action-icon" title="Remove this image"/> </a>
	 	<a href="/action/image/get/${image.imageUuid}"><img src="/action/image/get/${image.imageUuid}" style="width:150px;height:150px;"/></a></td>
 	</div>
 </c:forEach> 	
</div>
</div>
<div class="content-box">
	<h2>Add new</h2>
	<form method="post" action="/action/image/upload?externalUuid=none&externalFlag=overall&target=/action/image/all-images" enctype="multipart/form-data">
		<%@include file="../common/upload-image.jsp"%>
	</form>
</div>
</table>
<%@include file="../common/footer.jsp" %>