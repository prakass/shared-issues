<%@include file="../common/header.jsp"%>
<div class="content-box">
<div class="content-header">
	<label class="header-font2">Send message to admin</label>
</div>
<div class="content-content">
	<form method="post" action="contact?target=/action/issues/index">
		<table>
			<tr>
				<td>Message title
				<input name="message-title" class="required"/> </td>
			</tr>
			<tr>
				<td>Message
				<textarea name="message" class="required"></textarea> </td>
			</tr>
			<tr>
				<td><button type="submit" class="button">SEND</button> </td>
			</tr>
		</table>
	</form>
</div>
</div>
<script>
	$('form').validate();
</script>
<%@include file="../common/footer.jsp"%>