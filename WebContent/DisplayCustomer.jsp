<%@page import="mypack.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
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
		request.getAttribute("customer");
	%>
	<%-- <s:forEach var="i" begin="0" end="10" step="1">
		<br />
		<s:out value="i=${i }"></s:out>
	</s:forEach> --%>
	<%-- <s:forEach items="${paramValues.list}" var="elem">
		<s:out value="${elem}" />
	</s:forEach> --%>

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

		<tr>
			<td>${customer.name }</td>
			<td>${customer.uname }</td>
			<td>${customer.password }</td>
			<td>${customer.address }</td>
			<td>${customer.city }</td>
			<td>${customer.state }</td>
			<td>${customer.pinCode }</td>
			<td>${customer.phoneNumber }</td>
			<td>${customer.email }</td>

		</tr>

	</table>



</body>
</html>