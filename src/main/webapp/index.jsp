<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body font="Arial">
<h1 align="center">Welcome to KuiperRock System</h1>
<h2 align="center">Please Login</h2>
<br>
<div align="center">
<form action="">
Enter phone number:
<input type="text" name="phoneNumber">
<br>
Enter password:
<input type="hidden" name="action" value="login">
<input type="password" name="password">
<br>
<input type="submit" name="Submit">
</div>
</form>


</body>
</html>