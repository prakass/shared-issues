<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<label class="header-font2">All users</label>
</div>
<div class="content-content">
	<si:showServerError/>
	<si:showSuccessMessage/>
	<span class="content-font2">There are totle ${totleUser} users in the system</span>
	<%@include file="user-list.jsp"%>
</div>
</div>
<%@include file="../common/footer.jsp"%>