<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">
<link href="table.css" rel="stylesheet" type="text/css">

<title>Searched Customer</title>
</head>
<body background="images/online_banking.jpg">
	<div id='cssmenu'>
		<ul>
			<li class='active'><a href='#'><span>Home</span></a></li>
			<li class='active'><a href='#'><span>About</span></a>
				<ul>
					<li><a href='aboutus.jsp'><span>About us</span></a></li>
					<li class='last'><a href='contactus.jsp'><span>Contact
								us</span></a></li>
				</ul></li>
			<li class='active'><a href='login.jsp'><span>Login</span></a></li>
		</ul>
	</div>
	<form action="Controller">
		<div>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="txtUsername" /></td>
				</tr>

				<tr>
					<td><input type="submit" name="Search" value="SEARCH" /></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="action" value="searchCustomer">
	</form>
</body>
</html>