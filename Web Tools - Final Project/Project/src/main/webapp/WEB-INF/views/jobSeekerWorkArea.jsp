<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Seeker Work Area</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />


<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;	
	overflow: hidden;
	background-color: maroon;
	
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

/* Change the link color to #111 (black) on hover */
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
		<li><a href="#home">Home</a></li>
		<li><a href="#news">News</a></li>
		<li><a href="#contact">Contact</a></li>
		<li style="float: right"><a href="logout.htm"
			method="get">Logout</a></li>
	</ul>
				<h2>
				Hello
				<c:out value="${sessionScope.jobSeeker.username}"></c:out>
			</h2>
			<br>
    <center>
       <c:set var="jobSeekerId" value="${sessionScope.jobSeeker.jobSeekerId}"></c:set>
       <a href="setupProfile.htm" method="get">SetUp a Profile</a><br><br>
       <a href="viewProfile.htm" method="get">View Profile</a><br><br>
       <a href="searchJob.htm" method="get">Search Job</a><br><br>
       <a href="viewAppliedJobs.htm?jobSeekerId=${jobSeekerId}" >View Jobs You Have Applied!</a>
      
    </center>
</body>
</html>