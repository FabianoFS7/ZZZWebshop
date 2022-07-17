<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Warenkorb</title>
</head>
<body>
<table>
	<tr>
		<th>Artikel</th>
		<th>Preis</th>
		<th>Menge</th>
	</tr>

			<c:forEach var="i" begin="0" end="${artikelListe.size() - 1 }"  >
	<tr>
		<td>${artikelListe.get(i).getName() }</td>
		<td>${artikelListe.get(i).getPreis() }</td>
		<td>1</td>
		<td><button type="button" class="btn btn-danger">Remove</button></td>	
	</tr>
</c:forEach>	
</table>
Gesamtpreis: ${gesamtPreis }
<a href="bestellvorgang.jsp" class="btn btn-primary" type="button">Zur Kasse</a>
</body>
</html>