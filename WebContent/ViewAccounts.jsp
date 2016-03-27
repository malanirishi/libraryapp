<%@page import="java.util.ArrayList"%>
<%@page import="mypack.Customer"%>
<%@page import="mypack.Account"%>
<%@page import="mypack.CustomerAccount"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">
<link href="table.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<%
	ArrayList accList = new ArrayList();
	request.getAttribute("accList");
%>
<link rel="stylesheet" type="text/css" href="table.css">
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
		<table>
			<th>Account Number</th>
			<th>Account Type</th>
			<th>VIEW</th>
			<s:forEach var="str" items="${accList }">
				<tr>
					<td>${str.account_no }</td>
					<td>${str.account_type }</td>
					<td><input type="radio" name="AccountNo" id=""></td>
				</tr>
			</s:forEach>
		</table>
	</div>
	<form action="Controller">
		Enter Account No.: <input type="text" name="accno" id="accno">
		<input type="hidden" name="action" value="getAcc"> <input
			type="submit" value="Submit">
	</form>
</body>
</html>