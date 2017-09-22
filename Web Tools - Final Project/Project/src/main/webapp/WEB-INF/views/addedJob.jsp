<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employer Added Successfully</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />

<style>
#page {
	margin: 20px;
}

#logo {
	width: 35%;
	margin-top: 5px;
	font-family: georgia;
	font-color: black;
	display: inline-block;
}
</style>
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
				<li><a href="redirectEmployerHome.htm?employerId=${requestScope.employerId}&username=${requestScope.username}" method="get">My Home Page</a></li>
				<li><a href="logout.htm" method="get">Logout</a></li>
				
			</ul>
		</div>
	</div>
    <h1>Job added successfully</h1>
</body>
</html>