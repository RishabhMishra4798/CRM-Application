<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<h2>Search Result..</h2>
	<c:forEach var = "i" begin = "1" end = "5">
		<c:out value = "${i}"/><p>
	</c:forEach>
	
	<table>
	<tr>
	<th>Id</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Mobile</th>
	</tr>
	<c:forEach items="${leads}" var="lead">
	<tr>
	<td>${lead.id}</td>
	<td>${lead.firstName}</td>
	<td>${lead.lastName}</td>
	<td>${lead.email}</td>
	<td>${lead.mobile}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>