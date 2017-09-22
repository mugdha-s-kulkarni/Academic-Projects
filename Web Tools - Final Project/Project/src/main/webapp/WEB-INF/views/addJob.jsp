<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Job To Advertising</title>

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

<script type="text/javascript">

	function ValidateForm() {
		
		
		var title = document.form.title;
		var vacancies = document.form.vacancies;
		var jobLocation = document.form.jobLocation;
		var jobDescription = document.form.jobDescription;
		var jobRequirements = document.form.jobRequirements;
		var salary = document.form.salary;

		
		var alpha = /^[a-zA-Z ]*$/; // for validating alphabets
		var alphanumeric = /^[a-zA-Z0-9 ,.]*$/;
		var numeric = /^(0|[1-9][0-9]*)$/;

		if (alpha.test(title.value)) {

		} else {
			window.alert("Please enter a valid Title");
			title.focus();
			return false;
		}

		if (alpha.test(jobLocation.value)) {

		} else {
			window.alert("Please enter a valid Job Location.");
			jobLocation.focus();
			return false;
		}

		if (alphanumeric.test(jobDescription.value)) {

		} else {
			window.alert("Please enter a valid Job Description with only letters and numbers.");
			jobDescription.focus();
			return false;
		}

		if (alphanumeric.test(jobRequirements.value)) {

		} else {
			window.alert("Please enter valid Job Requirements with only letters and numbers.");
			jobRequirements.focus();
			return false;
		}
		if (numeric.test(vacancies.value)) {

		} else {
			window.alert("Please enter a valid Vacancy number.");
			vacancies.focus();
			return false;
		}
		if (numeric.test(salary.value)) {

		} else {
			window.alert("Please enter a valid Salary.");
			salary.focus();
			return false;
		}

		return true;
	}

	function EnableDisable(chkbx) {
		if (chkbx.checked == true) {
		} else {
			window.alert("Please select category.");
		}
	}
</script>

</head>

<body>
    
    <ul>
		
		<li style="float: right"><a href="logout.htm"
			method="get">Logout</a></li>
	</ul>


	<center>
		<form:form action="addJob.htm?username=${requestScope.username}"
			commandName="job" method="post" name="form"
			onsubmit="return ValidateForm();">
			<h3>Add Job Here!</h3>
			<table>
				<tr>
					<td>Category</td>
					<td><form:radiobutton path="category" value="FullTime"
							onclick="EnableDisable(this);" />Full Time <form:radiobutton
							path="category" value="Internship" />Internship <form:radiobutton
							path="category" value="Co-op" />Co-op</td>
				</tr>

				<tr>
					<td>Title</td>
					<td><form:input path="title" size="30" /> <font color="red"><form:errors
								path="title" /></font></td>
				</tr>
				<tr>
					<td>Vacancies:</td>
					<td><form:input path="vacancies" size="30" /> <font
						color="red"><form:errors path="vacancies" /></font></td>
				</tr>
				<tr>
					<td>Job Location:</td>
					<td><form:input path="jobLocation" size="30" /> <font
						color="red"><form:errors path="jobLocation" /></font></td>
				</tr>
				<tr>
					<td>Job Description:</td>
					<td><form:textarea path="jobDescription" size="50" /> <font
						color="red"><form:errors path="jobDescription" /></font></td>
				</tr>
				<tr>
					<td>Job Requirements:</td>
					<td><form:textarea path="jobRequirements" size="50" /> <font
						color="red"><form:errors path="jobRequirements" /></font></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><form:input path="salary" size="30" /> <font color="red"><form:errors
								path="salary" /></font></td>
					<form:hidden path="status" value="Open" />
				</tr>
				<tr>
					<td><input type="Submit" value="Add Job"></>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>