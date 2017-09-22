<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />


<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous"/>


</head>

<body>


	<form>
		<div id="page">
			<div id="logo">
				<h1>
					<a id="logoLink">JobFinder.com</a>  
				</h1>
				<h1> Hello <c:out value="${requestScope.username}"></c:out></h1><br>
			</div>


			<div id="nav">		
				    <ul>
					<c:choose>
						<c:when test="${!empty requestScope.username}">
							<li><a href="logout.htm" method="get"></a></li>
						</c:when>
						<c:otherwise>
						
							<li><a href="signup.htm" method="get"> Sign Up (Employer)</a></li>
							<li><a href="login.htm" method="get">Employer Login<i
									class="glyphicon glyphicon-user"></i></a></li>
							<li><a href="signupJobSeeker.htm" method="get">Sign
									Up(Job Seeker)</a></li>
							<li><a href="loginJobSeeker.htm" method="get">JobSeeker Login<i
									class="glyphicon glyphicon-user"></i></a></li>
						</c:otherwise>
					</c:choose>
                  </ul>
			
			</div>

			<div id="content">

				<p style="font-family: 'verdana'">
				<h2>JobFinder</h2>
				<p>We connect people with job opportunities!</p>
			</div>
		</div>

	</form>


</body>
</html>
