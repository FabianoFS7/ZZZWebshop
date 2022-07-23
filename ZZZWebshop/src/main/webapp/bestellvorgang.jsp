<%-- Bestellvorgang GUI
	 @author Eve-Marie Hellmer (356925) --%>
	 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Bestellung" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<%-- Erstellung Container für gesamten Inhalt --%>
<div class="container mx-auto my-4" style="width: 100%;">
	<%-- Erzeugung erste Zeile --%>
	<div class="row justify-content-between">
		<%-- Erzeugung erste Spalte, für Anzeige von Rechnungs- und Versanddaten --%>
		<div class="col col-6">
			<div class="container">
				<%-- Ausgabe der Daten des angemeldeten Nutzers --%>
				<h4 class="mb-3">Rechnungs- &amp; Versandadresse</h4>
				<p class="fw-normal">
					Name:
					<c:out value="${benutzer.getFullName()}" />
				</p>
				<p class="fw-normal">
					Straße &amp; Hausnummer:
					<c:out value="${benutzer.getFullStrasse()}" />
				</p>
				<p class="fw-normal">
					PLZ &amp; Ort:
					<c:out value="${benutzer.getFullOrt()}" />
				</p>
				<br>
				<p class="fw-normal">
					Mail Adresse:
					<c:out value="${benutzer.getEmail()}" />
				</p>
			</div>
			<%-- Auswahlfeld für die Zahlungsmethode --%>
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
					<%-- Button zum Abschließen der Bestellung --%>
					<input class="btn btn-dark mt-2" type="submit" value="Bestellen">
				</form>
			</div>
		</div>
		<%-- Erzeugung zweite Spalte, für Anzeige von der Bestelliste aus dem Warenkorb --%>
		<div class="col col-6">
			<h4 class="mb-3">Warenkorb</h4>
			<my:Bestellliste />
		</div>
	</div>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />