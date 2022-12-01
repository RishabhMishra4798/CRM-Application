<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All leads</title>
</head>
<body>
	<h2>Search Result..</h2>
	<table>
	<tr>
	<th>Id</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Mobile</th>
	<th>Delete</th>
	<th>Update</th>
	</tr>
	<c:forEach items="${leads}" var="lead">
	<tr>
	<td>${lead.id}</td>
	<td>${lead.firstName}</td>
	<td>${lead.lastName}</td>
	<td>${lead.email}</td>
	<td>${lead.mobile}</td>
	<td><a href="delete?id=${lead.id}">delete</a></td>
	<td><a href="update?id=${lead.id}">update</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>