<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employer SignUp</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous" />

<style type="text/css">
center {
	font-size: 150%;
}
logo{
font-family: georgia;
}

</style>

<script type="text/javascript">
	function ValidateForm() {
		var companyName = document.form.companyName;
		var city = document.form.city;
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

		var alpha = /^[a-zA-Z]*$/;  // for validating alphabets
		var alphanumeric = /^[a-zA-Z0-9]*$/;
		
		
		if (alpha.test(city.value)) {
			
		} else {
			window.alert("Please enter a valid City Name.");
			city.focus();
			return false;
		}
		
		if (alpha.test(companyName.value)) {
			
		} else {
			window.alert("Please enter a valid Company Name.");
			city.focus();
			return false;
		}
		
		if (alphanumeric.test(username.value)) {
			
		} else {
			window.alert("Please enter a valid username with only letters and numbers.");
			username.focus();
			return false;
		}
		
		if (alphanumeric.test(password.value)) {
			
		} else {
			window.alert("Please enter a valid password with only letters and numbers.");
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
				<li><a href="login.htm" method="get">Login<i
						class="glyphicon glyphicon-user"></i></a></li>
				<li><a href="logout.htm" method="get">Home Page</a></li>



			</ul>
		</div>
	</div>

	<center>
		<form:form id="employer" action="signup.htm" commandName="employer"
			method="post" role="form" name="form"
			onsubmit="return ValidateForm();">
			<h3>(New User?)Sign Up!</h3>
			<table>

				<tr>
					<td>Company name:</td>
					<td><form:input path="companyName" size="30" /> <font
						color="red"><form:errors path="companyName" /></font></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:input path="city" size="30" /> <font color="red"><form:errors
								path="city" /></font></td>
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
			<c:choose>
				<c:when test="${!empty requestScope.error}">
					<font color="red">Please enter valid credentials!</font>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>

		</form:form>
	</center>


</body>
</html>