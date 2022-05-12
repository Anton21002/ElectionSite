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
<style>
body
{background-color: antiquewhite;
width: 100%;    

}
table {
margin:auto;
width: 50%;
text-align:center;
border: 1px solid black;
}
h2,h1{
margin:auto;
width:50%;
text-align:center;
}

.firstrow{
padding:10px;

}
th,td{
border: 1px solid black;
}
</style>
<h1>Vaalikone</h1>
<table>
<tr>
	<th class="firstrow">ID</th>
	<th class="firstrow">ETUNIMI</th>
	<th class="firstrow">SUKUNIMI</th>
	<th class="firstrow">IKA</th>
	<th class="firstrow">PUOLUE</th>
	<th class="firstrow">KOTIPAIKKAKUNTA</th>
	<th class="firstrow">MIKSI_EDUSKUNTAAN</th>
	<th class="firstrow">MITA_ASIOITA_EDISTAT</th>
	<th class="firstrow">AMMATTI</th>
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
		<td><a href="/service/EhdokasService/deleteEhdokas/${ehdokkaat.EHDOKAS_ID}">Remove</a></td>
	</tr>
</c:forEach>
</table>
<br><br>
<h2><a href="/ehdokkaatforms.html">link to update and add page</a></h2>
</body>
</html>