<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
	<fieldset>
		<legend>Enter your credentials to login</legend>
		<form action="/login" method="post">
		<p>
			<label>User name</label> <input class="text-input" type="text"
				name="j_username" id="username" />
		</p>
		<br/>
		<p>
			<label>Password</label> <input class="text-input" type="password"
				name="j_password" />
		</p><br/>
		<p id="remember-password">
			<input type="checkbox" name="_spring_security_remember_me" />Remember
			me on this computer
		</p>
		<div class="clear"></div><br/>
		<input class="button" type="submit" value="Login" />
	</form>
	</fieldset>
</body>
</html>