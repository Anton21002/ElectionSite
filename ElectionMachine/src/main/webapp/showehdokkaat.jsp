<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.Ehdokkaat" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<th>ID</th>
	<th>Breed</th>
	<th>Weight</th>
</tr>
<c:forEach var="ehdokkaat" items="${requestScope.candidatelist }">
	<tr>
		<td>${ehdokkaat.id }</td>
		<td>${ehdokkaat.breed }</td>
		<td>${ehdokkaat.weight }</td>
		<td><a href="service/EhdokasService/update?id=${ehdokkaat.id }">update</a></td>
		<td><a href="service/EhdokasService/delete?id=${ehdokkaat.id }">Remove</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>