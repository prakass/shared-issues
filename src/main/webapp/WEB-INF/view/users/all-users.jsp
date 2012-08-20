<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<span>All users</span>
</div>
<div class="content-content">
	<span class="content-font2">There are totle ${totleUser} users in the system</span>
	<div class="clear2"></div>
	<%@include file="user-list.jsp"%>
	<div class="clear2"></div>
</div>
</div>
<%@include file="../common/footer.jsp"%>