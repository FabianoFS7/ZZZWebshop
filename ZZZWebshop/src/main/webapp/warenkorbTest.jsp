<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
    
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
					<th scope="col">Beschreibung</th>
					<th scope="col">Anzahl</th>
					<th scope="col">Preis</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<tr class="align-middle">
					<th scope="row">1</th>
					<td>Lorem ipsum dolor sit amet</td>
					<td>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</td>
					<td>
						<a href="add-warenkorb?id=1&anzahl=2&type=reduce"><i class="bi bi-dash-square-fill"></i></a>
						2
						<a href="add-warenkorb?id=1&anzahl=2&type=add"><i class="bi bi-plus-square-fill"></i></a>
						</td>
					<td>12,99€</td>
				</tr>
				<tr class="align-middle">
					<th scope="row">2</th>
					<td>Jacob</td>
					<td>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</td>
					<td>
						<a href="add-warenkorb?id=2&anzahl=3&type=reduce"><i class="bi bi-dash-square-fill"></i></a>
						3
						<a href="add-warenkorb?id=2&anzahl=3&type=add"><i class="bi bi-plus-square-fill"></i></a>
					</td>
					<td>12,99€</td>
				</tr>
				<tr class="align-middle">
					<th scope="row">3</th>
					<td>Larry the Bird</td>
					<td>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</td>
					<td>1</td>
					<td>12,99€</td>
				</tr>
				<tr class="align-middle table-light">
					<td scope="row" colspan="4">Gesamtpreis</td>
					<td class="fw-bold">38,97€</td>
				</tr>
			</tbody>
		</table>

	<a href="kasse.jsp">
		<div class="btn btn-dark">Kasse</div>
	</a>

</div>

<jsp:include page="templates/footer.jsp" />