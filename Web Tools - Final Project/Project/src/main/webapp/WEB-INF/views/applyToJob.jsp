<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply To Job</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />

</head>
<body>
  
 

<center><form action="applyToJob.htm" method="post">

<h3>Apply for this job!</h3>

<c:set var ="jobId" value="${requestScope.jobId}"></c:set>
<c:set var = "job" value="${requestScope.job}"></c:set>

<table>
<tr>
   <td>Title: </td>
   <td>${job.title}</td>
</tr>
<tr>
   <td>Company: </td>
   <td>${job.employer.companyName}</td>
</tr>
<tr>
   <td>Category: </td>
   <td>${job.category}</td>
</tr>
<tr>
   <td>Location: </td>
   <td>${job.jobLocation}</td>
</tr>
<tr>
   <td>Description: </td>
   <td>${job.jobDescription}</td>
</tr>
<tr>
   <td>Requirements: </td>
   <td>${job.jobRequirements}</td>
</tr>
<tr>
   <td>Salary: </td>
   <td>${job.salary}</td>
</tr>

<tr>
   <td><input type="submit" value="Apply"></td>
   <td><input type="hidden" name="jobId" value ="${jobId}"/></td>
   <td><input type="hidden" name="jobSeekerId" value ="${sessionScope.jobSeeker.jobSeekerId}"/></td>
</tr>


</table>
</form>
</center>

</body>
</html>