<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>	
    
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Warenkorb" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>

<div class="container body-container" style="width: 70%;">

		<table class="table my-5">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Artikel</th>
					<th scope="col">Kategorie</th>
					<th scope="col">Anzahl</th>
					<th scope="col">Preis</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			
				
				<my:WarenkorbListen/>
			

				<tr class="align-middle table-light">
					<td scope="row" colspan="4">Gesamtpreis</td>
					<td class="fw-bold">${gesamtpreis }€</td>
				</tr>
			</tbody>
		</table>

	<a href="bestellvorgang.jsp">
		<div class="btn btn-dark">Kasse</div>
	</a>

</div>

<jsp:include page="templates/footer.jsp" />