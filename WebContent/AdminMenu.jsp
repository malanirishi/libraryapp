<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@include file="header.jsp" %>
	<%@include file="footer.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body background="images/online_banking.jpg">

Welcome <%= session.getAttribute("name") %>
<div id='cssmenu'>
<ul>
   <li><a href="Controller?action=add"><span>Add New Customer</span></a></li>
   <li><a href='Controller?action=view'><span>View all Customers</span></a></li>
   <li><a href='Controller?action=viewAllCusAcccounts'><span>View all Customers' Accounts</span></a></li>
   <li class='last'><a href='Controller?action=search'><span>Search Customers</span></a></li>
</ul>
</div>
</body>
</html>