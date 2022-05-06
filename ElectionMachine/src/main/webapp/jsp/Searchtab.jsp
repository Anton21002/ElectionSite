<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html>
<html>
<head>
<%@ include file="UniversalHeader.jsp" %>
<meta charset="ISO-8859-1">
<title>Search tab</title>
</head>
<body>
<h1>Search for questions that include</h1><br>
<form action="/service/KysymusSearch/startsearch" method="get">
<input type="text" name="Searchdata">
<input type="submit" value="Search">



</form>



<br>
Similar questions:
<br>
<ol>
<c:forEach var="list" items="${requestScope.kysymus.kysymuslist }">
<li>${kysymus.id}: ${kysymus.kysymus}
</c:forEach>
</ol>

</body>
</html>