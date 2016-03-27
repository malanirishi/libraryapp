<%@page import="mypack.Customer"%>
<%@page import="mypack.CustomerAccount"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<div class="CSSTableGenerator">
		<table border="1" title="Customers Details" cellspacing="20px">
			<th>uname</th>
			<th>name</th>
			<th>pinCode</th>
			<th>account_no</th>
			<th>current_bal</th>
			<th>account_type</th>


			<s:forEach var="str" items="${requestScope.cusAccountList }">
				<tr>
					<td>${str.uname }</td>
					<td>${str.name }</td>
					<td>${str.pinCode }</td>
					<td>${str.account_no }</td>
					<td>${str.current_bal }</td>
					<td>${str.account_type }</td>

				</tr>
			</s:forEach>
		</table>
	</div>


</body>
</html>