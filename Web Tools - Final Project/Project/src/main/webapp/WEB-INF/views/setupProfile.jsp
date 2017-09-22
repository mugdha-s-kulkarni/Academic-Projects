<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Up Profile</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />

<script type="text/javascript">
	function ValidateForm() {
		var firstName = document.form.firstName;
		var lastName = document.form.lastName;
		var country = document.form.country;
		var state = document.form.state;
		var zipCode = document.form.zipCode;
		var phoneNo = document.form.phoneNo;
		var prevEmployer = document.form.prevEmployer;
		var jobTitle = document.form.jobTitle;
		var prevWorkCountry = document.form.prevWorkCountry;
		var expYears = document.form.expYears;
		var name = document.form.name;

		var alpha = /^[a-zA-Z]*$/; // for validating alphabets
		var alphanumeric = /^[a-zA-Z0-9]*$/;
		var alphanumeric = /^[0-9]+$/;
		var phone = /^[0-9]{10}$/;
		
		if (alphanumeric.test(phoneNo.value)) {

		} else {
			window.alert("Please enter a valid Phone Number.");
			phoneNo.focus();
			return false;
		}
		
		if (alphanumeric.test(expYears.value)) {

		} else {
			window.alert("Please enter a valid experience number");
			expYears.focus();
			return false;
		}
		if (alphanumeric.test(zipCode.value)) {

		} else {
			window.alert("Please enter a valid zipcode");
			zipCode.focus();
			return false;
		}
		
		if (alpha.test(firstName.value)) {

		} else {
			window.alert("Please enter a valid First Name.");
			firstName.focus();
			return false;
		}

		if (alpha.test(lastName.value)) {

		} else {
			window.alert("Please enter a valid Last Name.");
			lastName.focus();
			return false;
		}
		if (alpha.test(country.value)) {

		} else {
			window.alert("Please enter a valid Country Name.");
			country.focus();
			return false;
		}
		if (alpha.test(state.value)) {

		} else {
			window.alert("Please enter a valid State Name.");
			state.focus();
			return false;
		}
		if (alpha.test(prevEmp.value)) {

		} else {
			window.alert("Please enter a valid Employer Name.");
			prevEmployer.focus();
			return false;
		}
		if (alpha.test(jobTitle.value)) {

		} else {
			window.alert("Please enter a valid Job Title.");
			jobTitle.focus();
			return false;
		}
		if (alpha.test(workCountry.value)) {

		} else {
			window.alert("Please enter a valid Country Name.");
			prevWorkCountry.focus();
			return false;
		}
		if (alpha.test(name.value)) {

		} else {
			window.alert("Please enter a valid Resume Name.");
			name.focus();
			return false;
		}	
		if (phone.test(phoneNo.value)) {

		} else {
			window.alert("Please enter a valid 10 digit phone Number.");
			phoneNo.focus();
			return false;
		}	

		return true;
	}
</script>

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


</head>
<body>

	<ul>
		<li><a href="#home">Home</a></li>
		<li><a href="#news">News</a></li>
		<li><a href="#contact">Contact</a></li>
		<li style="float: right"><a href="logout.htm" method="get">Logout</a></li>
	</ul>
	
<%-- 	      <c:choose> --%>
<%-- 	        <c:when test="${requestScope.emptyProfile=='no'}"></c:when> --%>
<!-- 	       <h1>You already have set up a profile! You can update it!</h1> -->
<%-- 	      </c:choose> --%>
	<center>
		<form:form action="setupProfile.htm" commandName="profile"
			enctype="multipart/form-data" method="post" name="form"
			onsubmit="return ValidateForm();">
			<h3>Add Profile Here!</h3>
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" size="30" /> <font
						color="red"><form:errors path="firstName" /></font></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" size="30" /> <font
						color="red"><form:errors path="lastName" /></font></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><form:input path="country" size="30" /> <font color="red"><form:errors
								path="country" /></font></td>
				</tr>
				<tr>
					<td>State</td>
					<td><form:input path="state" size="30" /> <font color="red"><form:errors
								path="state" /></font></td>
				</tr>
				<tr>
					<td>Zipcode</td>
					<td><form:input path="zipCode" size="30" /> <font color="red"><form:errors
								path="zipCode" /></font></td>
				</tr>

				<tr>
					<td>Educational Level</td>
					<td><form:select path="eduLevel">
							<form:option value="Master's Degree">Master's Degree</form:option>
							<form:option value="Bachelor's Degree">Bachelor's Degree</form:option>
							<form:option value="Vocational">Vocational</form:option>
							<form:option value="High School or Equivalent">High School or
								Equivalent</form:option>
							<form:option value="Professional">Professional</form:option>
							<form:option value="Doctorate">Doctorate</form:option>
						</form:select></td>

				</tr>
				<tr>
					<td>Work Authorization</td>
					<td><form:radiobutton path="workAuth" value="yes" />Yes <form:radiobutton
							path="workAuth" value="no" />No</td>
				</tr>

				<tr>
					<td>Phone Number</td>
					<td><form:input path="phoneNo" size="30" /> <font color="red"><form:errors
								path="phoneNo" /></font></td>
				</tr>
				<tr>
					<td>Previous Employer</td>
					<td><form:input path="prevEmployer" size="30" /> <font
						color="red"><form:errors path="prevEmployer" /></font></td>
				</tr>
				<tr>
					<td>Job Title</td>
					<td><form:input path="jobTitle" size="30" /> <font
						color="red"><form:errors path="jobTitle" /></font></td>
				</tr>
				<tr>
					<td>Work Country</td>
					<td><form:input path="prevWorkCountry" size="30" /> <font
						color="red"><form:errors path="prevWorkCountry" /></font></td>
				</tr>
				<tr>
					<td>Years of Experience</td>
					<td><form:input path="expYears" size="30" /> <font
						color="red"><form:errors path="expYears" /></font></td>
				</tr>

				<tr>
					<td>Resume Name:</td>
					<td><form:input path="name" size="30" /></td>
				</tr>

				<tr>
					<td><form:label path="content">Resume (Max: 500 KB)</form:label></td>
					<td><input type="file" name="file" id="file"></input></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Add Profile"></>
				</tr>
			</table>
		</form:form>
	</center>

</body>
</html>