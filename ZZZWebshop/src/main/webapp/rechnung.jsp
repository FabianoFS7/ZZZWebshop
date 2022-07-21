<%-- Rechnung bzw. Bestätigung der Bestellung GUI
	 @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Rechnung" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<%-- Erstellung Container für gesamten Inhalt --%>
<div class="container mx-auto my-4">
	<%-- Erzeugung erste Zeile --%>
	<div class="row justify-content-between">
		<%-- Erzeugung erste Spalte, für Anzeige von Bestellinformationen --%>
		<div class="col col-6">
			<%-- Erzeugung eines Alerts über erfolgreiche Bestellung --%>
			<div class="alert alert-success" role="alert">
				<h4 class="alert-heading">Ihre Bestellung war erfolgreich!</h4>
				<hr>
				<%-- Erzeugung von Zeile im Alert --%>
				<div class="row">
					<%-- Erzeugung erste Spalte, für die Anzeige der Informationen zur Rechnung --%>
					<div class="col">
						<p>Rechnung als PDF herunterladen</p>
					</div>
					<%-- Erzeugung zweite Spalte, für Button für Rechnungsexport --%>
					<div class="col">
						<a
							href="https://www.lexoffice.de/wp-content/uploads/vorlage-rechnung-musterrechnung-kostenlos-lexoffice.png"
							class="btn btn-dark bi bi-filetype-pdf" type="button"></a>
					</div>
				</div>
			</div>
		</div>
		<%-- Erzeugung zweite Spalte, für Anzeige von Bestelldetails, wie Artikelanzahl, -menge & -preis --%>
		<div class="col col-6">
			<h4 class="mb-3">Ihre Bestellung</h4>
			<%-- TODO funktioniert noch nicht --%>
			<my:ErfolgreicheBestellung />
		</div>
	</div>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />