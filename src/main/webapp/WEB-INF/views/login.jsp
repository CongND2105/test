<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/account/login" method="post">
		<input name="username"> 
		<input name="password"> 
		<input type="checkbox" name="remember" value="true">
		<button>Login</button>
	</form>


</body>
</html>