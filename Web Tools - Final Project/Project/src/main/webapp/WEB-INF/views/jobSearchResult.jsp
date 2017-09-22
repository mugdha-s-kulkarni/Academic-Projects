<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Search Result</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: maroon;
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



<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />

</head>
<body>
	
	<ul>
		<li><a href="#home">Home</a></li>
		<li><a href="#news">News</a></li>		
		<li style="float: right"><a href="logout.htm" method="get">Logout</a></li>
		<li style="float: right"><a href="redirectJobSeeker.htm" method="get">My Home Page</a></li>
	</ul>
	<c:set var="i" value="${1}"></c:set>
	<center><h1>Job Search List</h1></center>
	<center><table border="1" cellpadding="5" cellspacing="5">
      
		<tr>
			<td></td>
			<td><b>Job Title</b></td>
			<td><b>Company</b></td>
			<td><b>Job Category</b></td>
			<td><b>Location</b>
			<td><b>Status</b>
		</tr>
		<c:forEach var="job" items="${sessionScope.jobNotApplied}">
			<tr>
				<td>${i}.</td>
				<c:set var="jobId" value="${job.jobId}"></c:set>
				<td>${job.title}</td>
				<td>${job.employer.companyName}</td>
				<td>${job.category}</td>
				<td>${job.jobLocation}</td>
				<td>${job.status}</td>
				<td><a href="applyToJob.htm?v=${jobId}" method="get"><font
						color="green">View Job</font></a></td>
			</tr>
			<c:set var="i" value="${i+1}"></c:set>
		</c:forEach>
	</table></center>

</body>
</html>