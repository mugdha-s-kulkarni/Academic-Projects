<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobSeeker SignUp</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />


<script type="text/javascript">
	function ValidateForm() {
		var name = document.form.name;
		var emailId = document.form.emailId;
		var username = document.form.username;
		var password = document.form.password;

		if (emailId.value.indexOf("@", 0) < 0) {
			window.alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}
		if (emailId.value.indexOf(".", 0) < 0) {
			window.alert("Please enter a valid e-mail address.");
			email.focus();
			return false;
		}

		var alpha = /^[a-zA-Z ]*$/; // for validating alphabets
		var alphanumeric = /^[a-zA-Z0-9]*$/;

		if (alpha.test(name.value)) {

		} else {
			window.alert("Please enter a valid name.");
			name.focus();
			return false;
		}
		if (alphanumeric.test(username.value)) {

		} else {
			window
					.alert("Please enter a valid username with only letters and numbers.");
			username.focus();
			return false;
		}

		if (alphanumeric.test(password.value)) {

		} else {
			window
					.alert("Please enter a valid password with only letters and numbers.");
			password.focus();
			return false;
		}

		return true;
	}
</script>


</head>
<body>

	<div id="page">
		<div id="logo">
			<h1>
				<a id="logoLink">JobFinder.com</a>
			</h1>
		</div>


		<div id="nav">
			<ul>
				<li><a href="loginJobSeeker.htm" method="get">JobSeeker
						Login<i class="glyphicon glyphicon-user"></i>
				</a></li>
				<li><a href="logout.htm" method="get">Home Page</a></li>
			</ul>
		</div>
	</div>


	<center>
		<form:form action="signupJobSeeker.htm" name="form"
			commandName="jobSeeker" method="post" role="form"
			onsubmit="return ValidateForm();">
			<h3>(New User?)Sign Up!</h3>
			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" size="30" /> <font color="red"><form:errors
								path="name" /></font></td>
				</tr>

				<tr>
					<td>Email Id:</td>
					<td><form:input path="emailId" size="30" /> <font color="red"><form:errors
								path="emailId" /></font></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><form:input path="username" size="30" /> <font
						color="red"><form:errors path="username" /></font></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" size="30" /> <font
						color="red"><form:errors path="password" /></font></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Sign Up"></td>
				</tr>
			</table>

		</form:form>

	</center>
</body>
</html>