<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New User</title>
</head>
<body font="Arial">
<div align="center">
<h1 align="center">Register New User</h1>


<form action="ControlServlet" method="post">
Enter phone number:
<input type="text" name="phoneNumber">
<br>
Enter Password:
<input type="password" name="password">
<br>
Enter Name:
<input type="text" name="name">
<br>
Enter Email:
<input type="text" name="email">
<br>
<br>

Select Feeds to Import:
<br>
Google News (World)
<input type="checkbox" name="GoogleNews:World"><br>
Google News (Entertainment)
<input type="checkbox" name="GoogleNews:Entertainment"><br>
BBC News (World)
<input type="checkbox" name="BBCNews:World"><br>

<br>
<input type="hidden" name="action" value="register">
<input type="submit" name="Submit">
</div>
</form>
</body>
</html>