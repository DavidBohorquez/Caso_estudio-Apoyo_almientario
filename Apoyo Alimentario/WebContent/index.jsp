<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test JSP</title>
</head>
<body>
	<form name="loginForm" method="post" action="TestServlet">
		Username: <input type="text" name="username" /> <br /> Password: <input
			type="password" name="password" /> <br /> <input type="submit"
			value="Login" />
	</form>
	<p>Hello World!!!</p>
	<a method='get' href="TestServlet">Click here</a>
</body>
</html>