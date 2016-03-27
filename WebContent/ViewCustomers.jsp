<%@page import="mypack.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="table.css">
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
	<%
		ArrayList customerList = new ArrayList();
		request.getAttribute("customerList");
	%>

	<div class="CSSTableGenerator">
		<table border="1" title="Customers Details" cellspacing="20px">
			<th>Name</th>
			<th>Uname</th>
			<th>Password</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Pincode</th>
			<th>PhoneNumber</th>
			<th>E-mail</th>

			<s:forEach var="str" items="${customerList }">
				<tr>
					<td>${str.name }</td>
					<td>${str.uname }</td>
					<td>${str.password }</td>
					<td>${str.address }</td>
					<td>${str.city }</td>
					<td>${str.state }</td>
					<td>${str.pinCode }</td>
					<td>${str.phoneNumber }</td>
					<td>${str.email }</td>

				</tr>
			</s:forEach>
		</table>
	</div>


</body>
</html>