<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error!</title>
</head>
<body>

	<h3>Something has went wrong.</h3>

	<c:choose>
		<c:when test="${requestScope.err == 1}">
			<font color="red">No profile found. Create a profile first!</font>
		</c:when>
		<c:when test="${requestScope.err == 2}">
			<font color="red">You already have a profile!</font>
		</c:when>
		<c:when test="${requestScope.err == 3}">
			<font color="red"></font>
		</c:when>
		<c:when test="${requestScope.err == 4}">
			<font color="red">Username or Email already exists!</font>
		</c:when>
		<c:when test="${requestScope.err == 5}">
			<font color="red">Account doesn't exist!</font>
		</c:when>
		
		<c:otherwise>

		</c:otherwise>
	</c:choose>


</body>
</html>