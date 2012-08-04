<%@include file="/helper/tags.jsp" %>
<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<span>Change your password</span>
</div>
<div class="content-content">
	<form method="post" action="/action/change-password">
	<table>
		<tr>
			<td>Select your password
			<input id="password" type="password" name="password" class="required" minlength="6"/> </td>
		</tr>
		
		<tr>
			<td>Confirm you password
			<input name="password1" type="password" class="required" minlength="6" equalTo="#password"/> </td>
		</tr>
		<tr>
			<td><button class="button">SUBMIT</button> </td>
			<td></td>
		</tr>
	</table>
</form>
</div>
</div>
<script>
	$('form').validate();
</script>
<%@include file="../common/footer.jsp"%>