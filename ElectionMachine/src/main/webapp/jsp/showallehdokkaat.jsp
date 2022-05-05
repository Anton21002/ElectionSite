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
<c:forEach var="fish" items="${requestScope.fishlist }">
	<tr>
		<td>${fish.id }testing</td>
		<td>${fish.breed }testing</td>
		<td>${fish.weight }testing</td>
		<td><a href="service/Fishservice/update?id=${fish.id }">update</a></td>
		<td><a href="service/Fishservice/delete?id=${fish.id }">Remove</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>