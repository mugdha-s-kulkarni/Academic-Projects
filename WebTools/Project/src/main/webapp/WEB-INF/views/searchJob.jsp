<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Jobs</title>

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

<script type="text/javascript">
	function ValidateForm() {
		var keyword = document.form.keyword;	

		var alpha = /^[a-zA-Z]*$/;  // for validating alphabets
		var alphanumeric = /^[a-zA-Z0-9]*$/;
		
		
		if (alpha.test(keyword.value)) {
			
		} else {
			window.alert("Please enter a valid keyword");
			keyword.focus();
			return false;
		}
		
        return true;
	}
</script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />

</head>
<body>


	<ul>
		<li>JobFinder.com</li>
		<li>News</li>
		<li style="float: right"><a href="logout.htm" method="get">Logout</a></li>
		<li style="float: right"><a href="redirectJobSeeker.htm"
			method="get">My Home Page</a></li>
	</ul>

	<center><h3>Searching Jobs</h3></center>
	<center><form action="searchJob.htm" method="post" name="form"
		onsubmit="return ValidateForm();">

		<input type="radio" name="searchBy" value="locationSearch">By
		Location <input type="radio" name="searchBy" value="titleSearch">By
		Title <input type="radio" name="searchBy" value="companySearch">By
		Company <input type="radio" name="searchBy" value="categorySearch">By
		Category<br> <br> Keyword: <input type="text" name="keyword">
		<input type="submit" name="Search">
	</form></center>



</body>
</html>