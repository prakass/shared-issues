<%@include file="../common/header.jsp" %>
<div class="content-box">

<div class="content-header">
	<span class="header-font2">All files</span>
</div>
<div class="content-content">
<c:forEach var="image" items="${images}">
	<div style="border:1px solid #F5F5F5;margin:20px;display:inline-table;text-align:center;">
	 	<img src="/action/image/get/${image.imageUuid}" style="width:150px;height:150px;"/></td>
	    <div style="border-top:1px solid #F5F5F5;">
	    	 <a href="/action/image/remove?imageUuid=${image.imageUuid}&target=/action/image/all-images"><button>Remove</button></a>
	    </div>
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