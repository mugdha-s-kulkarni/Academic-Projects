<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Applications</title>
<style>
body, ul {
	font-size: 150%;
}
</style>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />
</head>
<body>

	<c:set var="jobId" value="${requestScope.jobId}"></c:set>
	<c:choose>
		<c:when test="${requestScope.job.status == 'Open'}">
			<a href="changeStatus.htm?jobId=${jobId}" method="get">Change
				Status of this position to Closed</a>
		</c:when>
		<c:otherwise>
			<h1>This job position has been closed</h1>

		</c:otherwise>
	</c:choose>


	<center><h1>Applications List</h1></center>
	<c:if test="${!empty requestScope.jobSeekerList}">
		<center>
			<table class="data">
				<tr>
					<th>JobSeeker Name &nbsp;&nbsp;</th>
					<th>Resume Download &nbsp;&nbsp;</th>
					
				</tr>

				<c:forEach items="${requestScope.jobSeekerList}" var="jobSeeker">
					<c:set var="profileId" value="${jobSeeker.profile.profileId}" />
					<tr>
						<td>${jobSeeker.name}</td>
						<td><a href="download.htm?profileId=${profileId}"><i
								class="glyphicon glyphicon-save-file">Download</i></a></td>
					
					</tr>
				</c:forEach>
			</table>
		</center>


	</c:if>

</body>
</html>