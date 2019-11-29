<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddBook page</title>
<style type="text/css">
.error {
	color: red;
	font-family: serif;
	font-style: italic;
}
body
{
background-image: url("C:/Users/Lenovo/Pictures/pg.jpg");
}
</style>
</head>
<body>
<center>
	<form:form action="addcustomer" method="post" modelAttribute="customer">
		<form:hidden path="id" />
	<h4>Enter Name: <form:input path="name" />
		<form:errors path="name" class="error" />
		<br /></h4>
	<h4>Enter Address: <form:input path="address" />
		<form:errors path="address" class="error" />
		<br /></h4>
	<h4>Enter Email: <form:input path="email" />
		<form:errors path="email" class="error" />
		<br /></h4>
	<h4>Enter Mobile: <form:input path="mobile" />
		<form:errors path="mobile" class="error" />
		<br /></h4>
	<h4>Enter Salary: <form:input path="salary" />
		<form:errors path="salary" class="error" />
		<br /></h4>
	<h4>Enter Employee: <form:select path="employee" items="${pubList }" />
		<br /></h4>
		<input type="submit" value="Add Customer"/>
	</form:form>
	</center>
</body>
</html>