<%@page import="mypack.Customer"%>
<%@page import="mypack.Account"%>
<%@page import="java.util.ArrayList"%>
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
		request.getAttribute("selacc");
	%>


	<table align="center" border="1" title="Account Details"
		cellspacing="20px">
		<th>Account_No</th>
		<th>OPENING_DATE</th>
		<th>MIN_BAL</th>
		<th>CURRENT_BAL</th>
		<th>RATE_OF_INTREST</th>
		<th>ACCOUNT_TYPE</th>
		<th>UNAME</th>
		<th>ODLIMIT</th>


		<tr>
			<td>${selacc.account_no }</td>
			<td>${selacc.opening_date }</td>
			<td>${selacc.min_bal }</td>
			<td>${selacc.current_bal }</td>
			<td>${selacc.rate_of_intrest }</td>
			<td>${selacc.account_type }</td>
			<td>${selacc.uname }</td>
			<td>${selacc.getODlimit }</td>

		</tr>
	</table>

	<div id='cssmenu'>
		<ul>
			<li><a href="Controller?action=dep"><span>Deposit
						Amount </span></a></li>
			<li class='last'><a href='Controller?action=with'><span>Withdraw
						Amount</span></a></li>
		</ul>
	</div>

</body>
</html>