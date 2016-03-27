<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylesAdminMenu.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function savingcurrentCheck() {
		if (document.getElementById('saving').checked) {
			document.getElementById('ifSaving').style.display = 'block';
			document.getElementById('ifCurrent').style.display = 'none';
		}
		if (document.getElementById('current').checked) {
			document.getElementById('ifCurrent').style.display = 'block';
			document.getElementById('ifSaving').style.display = 'none';
		}

	}
</script>

<script type="text/javascript">
	function validateForm() {
		var x = document.getElementById("txtAccount_No").value;
		if (x >= 100 && x <= 999)
			return true;
		else {

			alert("Wrong Account No. Enter 3 Digits Only");
			return false;
		}
		var y = document.getElementById("txtRate_Of_Intrest").value;
		if (y >= 10 && y <= 99)
			return true;
		else {

			alert("Wrong Rate Of Interest. Enter Two Digits Only");
			return false;
		}

		x = document.getElementById("txtMin_Bal").value;
		if (x >= 0)
			return true;
		else {

			alert("Minimum Balance Must Be Greater Than 0");
			return false;
		}

		x = document.getElementById("txtOdlimit").value;
		if (x >= 0)
			return true;
		else {

			alert("Over Draft Limit Must Be Greater Than 0");
			return false;
		}

	}
</script>

<%
	String addcusname = request.getSession().getAttribute("addcusname")
			.toString();
%>
<script>
	function addDate() {
		date = new Date();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var year = date.getFullYear();

		if (document.getElementById('txtOpening_Date').value == '') {
			document.getElementById('txtOpening_Date').value = day + '-'
					+ month + '-' + year;
		}

	}
</script>

<title>Add New Customer Account</title>
</head>


<body onload="addDate();" background="images/online_banking.jpg">
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
	<form name="AddAccount" action="Controller"
		onsubmit="return validateForm()" method="post">
		<table align="center">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="txtUname" id="txtUname"
					value=<%=addcusname%>></td>
			</tr>

			<tr>
				<td>Account No:</td>
				<td><input type="text" name="txtAccount_No" id="txtAccount_No">
				</td>
			</tr>

			<tr>
				<td>Opening Date</td>
				<td><input type="text" name="txtOpening_Date"
					id="txtOpening_Date"></td>
			</tr>

			<tr>
				<td>Current Balance</td>
				<td><input type="text" name="txtCurrent_Bal"
					id="txtCurrent_Bal"></td>
			</tr>

			<tr>
				<td>RATE OF INTEREST</td>
				<td><input type="text" name="txtRate_Of_Intrest"
					id="txtRate_Of_Intrest"></td>
			</tr>

			<tr>
				<td>Account Type</td>
				<td>Saving <input type="radio"
					onclick="javascript:savingcurrentCheck();" name="acctype"
					id="saving" value="Saving"> Current <input type="radio"
					onclick="javascript:savingcurrentCheck();" name="acctype"
					id="current" value="Current">
				</td>
			</tr>
		</table>
		<div id="ifSaving" style="display: none" align="center">

			Minimum Balance: <input type="text" name="txtMin_Bal" id="txtMin_Bal">
		</div>

		<div id="ifCurrent" style="display: none" align="center">
			Over Draft Limit <input type="text" name="txtOdlimit" id="txtOdlimit">
		</div>
		<div align="center">

			<input type="hidden" name="action" value="addAccount"> <input
				type="submit" value="SUBMIT">
		</div>
	</form>
</body>
</html>