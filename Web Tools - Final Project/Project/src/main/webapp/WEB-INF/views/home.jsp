<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />

</head>

<body>

	<form>
		<div id="page">
			<div id="logo">
				<h1>
					<a id="logoLink">Job Search Website</a>
				</h1>
			</div>

			<div id="nav">
				<ul>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="signup.jsp">Sign Up</a></li>
					
				</ul>
			</div>

			<div id="content">

				<p style="font-family: 'verdana'">JobFinder
				<p>We connect people with job opportunities!</p>
			</div>
		</div>



		<table>

			<h3>Login</h3>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username"></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>

		</table>
		<input type="submit" value="Submit"> <input type="hidden"
			name="action" value="login"></br> </br>


	</form>



</body>
</html>
