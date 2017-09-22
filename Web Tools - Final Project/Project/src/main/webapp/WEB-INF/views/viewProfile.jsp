<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />

<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: maroon;
	font-color: white;
}

body {
	font-family: georgia;
	font-size: 80%;
	line-height: 1.2em;
	width: 100%;
	margin: 0;
	background: #eee;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 7px 9px;
	text-decoration: none;
	font-size: 0.9em
}

li a:hover {
	background-color: orange;
}

.active {
	background-color: orange;
}

b:link, a:visited {
	background-color: #f44336;
	color: black;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

b:hover, a:active {
	background-color: green;
}
</style>

</head>
<body>

	<ul>
		<li style="float: right"><a href="logout.htm" method="get">Logout</a></li>
		<li style="float: right"><a href="redirectJobSeeker.htm"
			method="get">My Home Page</a></li>
	</ul>

	<c:if test="${!empty requestScope.profile}">
		<center>
			<table border="1" cellpadding="5" cellspacing="5">
				<h1>Document List</h1>
				<tr>
					<th>Name</th>
					<th>Description</th>

				</tr>
				<c:set var="profileId" value="${requestScope.profile.profileId}" />
				<tr>
					<td>${profile.fileName}</td>
					<td><a href="download.htm?profileId=${profileId}">Download</a></td>
					
				</tr>

			</table>
		</center>
	</c:if>
</body>
</html>