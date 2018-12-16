<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<form action="./login" method="post">
		<p>
			<label for="username">Username</label> 
			<input type="text" id="username" name="username" />
		</p>
		<p>
			<label for="password">Password</label> 
			<input type="password" id="password" name="password" />
		</p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit" class="btn">Log in</button>
	</form>

</body>
</html>