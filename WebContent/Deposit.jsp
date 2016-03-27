<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="mypack.Customer"%>
<%@page import="mypack.Account"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		request.getAttribute("selacc");
	%>

	<form action="Controller">
		<table>
			<tr>
				<td>Account No:</td>
				<td><input type="text" name="txtaccno" id="txtaccno"
					value=<%=request.getSession().getAttribute("selaccno")%>></td>
			</tr>
			<tr>
				<td>Enter Amount:</td>
				<td><input type="text" name="txtdepamt" id="txtdepamt">
			</tr>
		</table>
		<input type="hidden" name="action" value="deposit"> <input
			type="submit" value="Deposit">
	</form>
</body>
</html>