<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
body {
	font-family: georgia;
	font-size: 80%;
	line-height: 1.2em;
	width: 100%;
	margin: 0;
	background: #eee;
}

h1, h2, h3, h4 {
	font-color: orange;
	font-weight: normal;
	line-height: 1.1em;
	margin: 0 0 .5em 0;
}
</style>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />


<script type="text/javascript">
	function ValidateForm() {

		var username = document.form.username;
		var password = document.form.password;

		if (username.value.trim() == "") {
			window.alert("Please enter a valid Username.");
			username.focus();
			return false;
		}
		if (password.value.trim() == "") {
			window.alert("Please enter a valid Password.");
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
				<li><a href="logout.htm" method="get">Home Page</a></li>
			</ul>
		</div>
	</div>
	<center>
		<form id="employer" name="form" action="login.htm" method="post"
			onsubmit="return ValidateForm();">

			<h3>Login</h3>
			<center><table>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="username"></td>
				</tr>

				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr><td><input type="submit" value="Submit"> <input type="hidden"
				name="action" value="login"></td></tr>

			</table></center>
			
		</form>
	</center>
	<br>
	<br>
</body>
</html>