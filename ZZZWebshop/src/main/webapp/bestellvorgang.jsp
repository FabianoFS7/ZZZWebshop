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
				<div class="col col-3">
					<select class="form-select" aria-label="Default select example">
						<option selected disabled>w‰hlen</option>
						<option value="1">Kreditkarte</option>
						<option value="2">Klarna</option>
						<option value="3">PayPal</option>
					</select>
				</div>
			</div>
			<div class="container">
				<br> <a href="rechnung.jsp" class="btn btn-dark" type="button">Bestellen</a>
			</div>
		</div>
		<div class="col col-6">
			<h4 class="mb-3">Warenkorb</h4>
			<jsp:include page="templates/warenkorb.jsp" />
		</div>
	</div>
</div>


<jsp:include page="templates/footer.jsp" />