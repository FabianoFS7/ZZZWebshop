<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Bestellung" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<div class="container mx-auto my-4" style="width: 100%;">
	<div class="row justify-content-between">
		<div class="col col-6">
			<div class="container">
				<h4 class="mb-3">Rechnungs- & Versandadresse</h4>
				<p class="fw-normal">
					Name:
					<c:out value="${sessionScope.benutzer.getFullName()}" />
				</p>
				<p class="fw-normal">
					Straﬂe & Hausnummer:
					<c:out value="${sessionScope.benutzer.getFullStrasse()}" />
				</p>
				<p class="fw-normal">
					PLZ & Ort:
					<c:out value="${sessionScope.benutzer.getFullOrt()}" />
				</p>
				<br>
				<p class="fw-normal">
					Mail Adresse:
					<c:out value="${sessionScope.benutzer.getEmail()}" />
				</p>
			</div>
			<div class="container">
				<h4 class="mb-3">Zahlungsmethode</h4>
				<form method="POST" action="BestellungsServlet">
				<div class="col col-3">
					<select name="zahlunngsmethode" class="form-select" aria-label="Default select example">
						<option selected disabled>w‰hlen</option>
						<option value="kreditkarte">Kreditkarte</option>
						<option value="klarna">Klarna</option>
						<option value="paypal">PayPal</option>
					</select>
				</div>
			<div class="container">
				<br> <input class="btn btn-dark" type="submit" value="Bestellen">
			</div>
			</form>
			</div>
		</div>
		<div class="col col-6">
			<h4 class="mb-3">Warenkorb</h4>
			<jsp:include page="templates/warenkorbListe.jsp" />
		</div>
	</div>
</div>


<jsp:include page="templates/footer.jsp" />