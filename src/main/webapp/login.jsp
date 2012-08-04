<%@include file="WEB-INF/view/common/header.jsp"%>
<style>
</style>
<div class="content-box">
		<div class="content-header">
			<span class="header-font2">Enter your credential to login</span>
		</div>
		<div class="content-content">
		<form action="/login" method="post" id="login-form">
		<p>
			<label>User name</label> <input class="text-input" type="text" class="required" minlength="5"
				name="j_username" id="username" />
		</p>
		<br/>
		<p>
			<label>Password</label> <input class="text-input" type="password" class="required" minlength="6"
				name="j_password" />
		</p>
		<button class="button" type="submit">LOGIN</button>
	</form>
	</div>
</div>
<script>$('#login-form').validate();</script>
<%@include file="WEB-INF/view/common/footer.jsp" %>
