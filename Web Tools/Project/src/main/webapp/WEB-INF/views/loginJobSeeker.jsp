<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />

<script type="text/javascript">
	function ValidateForm() {
		
		var username = document.form.username1;
		var password = document.form.password1;

	
		if (username.value.trim() == "")
	    {
	        window.alert("Please enter a valid Username.");
	        username.focus();
	        return false;
	    }
		if (password.value.trim() == "")
	    {
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
	<form id="jobSeeker" name="form" action="loginJobSeeker.htm" method="post" onsubmit="return ValidateForm();">
		<table>

			<h3>Login</h3>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username1"></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>

			<tr>
			<td><input type="submit" value="Submit"> <input type="hidden"
			name="action" value="loginJobSeeker">
			</tr>
		</table>		

	</form>
	
	</center>




</body>
</html>