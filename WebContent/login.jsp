<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function validateForm() {
		var x = document.getElementById("username").value;
		if (x == null || x == "") {
			alert("Username must be filled out");
		}

		var y = document.getElementById("password").value;
		if (y == null || y == "") {
			alert("Password must be filled out");
			return false;
		}
	}
</script>
</head>

<body background="images/online_banking.jpg">
	<div align="center">
		<form name="Login" action="Controller"
			onsubmit="return validateForm()" method="post">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="txtUsername" id="username">
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="txtPassword" id="password">
				</tr>
				<tr>
					<td><input type="submit" name="txtPassword">
				</tr>
				<input type="hidden" name="action" value="login">

			</table>
		</form>
	</div>
</body>
</html>