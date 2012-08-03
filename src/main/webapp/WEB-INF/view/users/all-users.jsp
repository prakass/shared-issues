<%@include file="../common/header.jsp"%>
	<h2>Your all users</h2>
	<h2>Number of user:${totleUser}</h2>
	<si:showServerError/>
	<si:showSuccessMessage/>
	<%@include file="user-list.jsp"%>
<%@include file="../common/footer.jsp"%>