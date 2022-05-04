<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>

<body>
<header>
<form class="linkmenu">
<input type="button" onmouseover="document.getElementById('leftdropdown').style.display='block'" id="leftmenu" value="Kysymuset">
<table id="leftdropdown" style="display:none">
<tr><td><a href='/showkysymys'>view kysymykset</a></td></tr>
<tr><td><a href='jsp/SearchTab.jsp'>Search tab</a></td></tr>
<tr><td><a href='/form.html'>add kysymys</a></td></tr>
</table>
<input type="button" onmouseover="document.getElementById('rightdropdown').style.display='block'" id="rightmenu" value="Ehdokaat">
<table id="rightdropdown" style="display:none">
<tr><td><a href='/show'>view candidates</a></td></tr>
<tr><td><a href='/ADDEHDOKAS.html'>add ehdokas</a></td></tr>
<tr><td><a href='/EditEhdokaas.html'>Edit Ehdokas</a></td></tr>
</table>
</form>

</header>
</body>
</html>