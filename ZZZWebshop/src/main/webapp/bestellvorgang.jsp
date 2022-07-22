<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

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
					Straße & Hausnummer:
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
						<select name="zahlungsmethode" class="form-select"
							aria-label="Default select example" required>
							<option value="kreditkarte">Kreditkarte</option>
							<option value="klarna">Klarna</option>
							<option value="paypal">PayPal</option>
						</select>
					</div>
					<input class="btn btn-dark mt-2" type="submit" value="Bestellen">
				</form>
			</div>
		</div>
		<div class="col col-6">
			<h4 class="mb-3">Warenkorb</h4>
			<my:Bestellliste />
		</div>
	</div>
</div>


<jsp:include page="templates/footer.jsp" />