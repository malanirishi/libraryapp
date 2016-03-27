<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function validateForm() {
		var x = document.getElementById("txtCustomerName").value;
		if (x == null || x == "") {
			alert("Customer Name must be filled out");
			return false;
		}
		x = document.getElementById("txtUsername").value;
		if (x == null || x == "") {
			alert("Username must be filled out");
			return false;
		}

		x = document.getElementById("txtPassword").value;
		if (x == null || x == "") {
			alert("Password must be filled out");
			return false;
		}

		x = document.getElementById("txtAddress").value;
		if (x == null || x == "") {
			alert("Address must be filled out");
			return false;
		}

		x = document.getElementById("txtCity").value;
		if (x == null || x == "") {
			alert("City must be filled out");
			return false;
		}

		x = document.getElementById("txtState").value;
		if (x == null || x == "") {
			alert("State must be filled out");
			return false;
		}

		x = document.getElementById("numPin").value;
		if (x == null || x == "") {
			alert("Pincode must be filled out");
			return false;
		}

		x = document.getElementById("numPhoneNumber").value;
		if (x == null || x == "") {
			alert("Phone number must be filled out");
			return false;
		}

		x = document.getElementById("txtEmail").value;
		if (x == null || x == "") {
			alert("E-mail must be filled out");
			return false;
		}

	}
</script>
<title>Insert title here</title>
</head>
<body background="images/online_banking.jpg">
	Welcome :
	<%=session.getAttribute("name")%>

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

	<div align="center">
		<form name="AddCustomer" action="Controller"
			onsubmit="return validateForm()" method="post">
			<h2>Customer Details</h2>
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="txtUsername" id="txtUsername"></td>
				</tr>

				<tr>
					<td>Customer Name</td>
					<td><input type="text" name="txtCustomerName"
						id="txtCustomerName"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="txtPassword" id="txtPassword"></td>
				</tr>

				<tr>
					<td>Address</td>
					<td><input type="text" name="txtAddress" id="txtAddress"></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="txtCity" id="txtCity"></td>
				</tr>
				<tr>
					<td>State</td>
					<td><input type="text" name="txtState" id="txtState"></td>
				</tr>
				<tr>
					<td>PinCode</td>
					<td><input type="text" name="numPin" id="numPin"></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="numPhoneNumber"
						id="numPhoneNumber"></td>
				</tr>
				<tr>
					<td>e-mail ID</td>
					<td><input type="text" name="txtEmail" id="txtEmail"></td>
				</tr>

				<tr>
					<td><input type="checkbox" name="isAccount" value="yes">
						Create Account</td>
				</tr>

				<tr>
					<td><input type="submit" value="Add Customer"></td>
				</tr>

			</table>
			<input type="hidden" name="action" value="addCustomer"> <input
				type="hidden" name="action2" value="addNewAccount">

		</form>
	</div>

</body>
</html>