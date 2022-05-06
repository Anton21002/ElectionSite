<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.ehdokkaat" %>
    
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
	<th>ETUNIMI</th>
	<th>SUKUNIMI</th>
	<th>IKA</th>
	<th>PUOLUE</th>
	<th>KOTIPAIKKAKUNTA</th>
	<th>MIKSI_EDUSKUNTAAN</th>
	<th>MITA_ASIOITA_EDISTAT</th>
	<th>AMMATTI</th>
</tr>
<c:forEach var="ehdokkaat" items="${requestScope.ehdokkaatlist }">
	<tr>
		<td>${ehdokkaat.EHDOKAS_ID}</td>
		<td>${ehdokkaat.ETUNIMI}</td>
		<td>${ehdokkaat.SUKUNIMI}</td>
		<td>${ehdokkaat.IKA}</td>
		<td>${ehdokkaat.PUOLUE}</td>
		<td>${ehdokkaat.KOTIPAIKKAKUNTA}</td>
		<td>${ehdokkaat.MIKSI_EDUSKUNTAAN}</td>
		<td>${ehdokkaat.MITA_ASIOITA_HALUAT_EDISTAA}</td>
		<td>${ehdokkaat.AMMATTI}</td>
		<td><a href="service/EhdokasService/update?id=${ehdokkaat.EHDOKAS_ID }">update</a></td>
		<td><a href="service/EhdokasService/delete?id=${ehdokkaat.EHDOKAS_ID }">Remove</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>