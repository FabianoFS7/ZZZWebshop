<%-- Konto GUI
	 @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266) --%>

<%@ page language="java" session="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>


<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Konto" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<%-- Erstellung Container für gesamten Inhalt --%>
<div class="container mx-auto my-4">
	<%-- Erzeugung erste Zeile --%>
	<div class="row justify-content-between">
		<%-- Erzeugung erste Spalte, für Anzeige von Kontodaten --%>
		<div class="col col-6">
			<div class="container">
				<h4 class="mb-3">Persönliche Daten</h4>
				<%-- Ausgabe des Vor- & Nachnamen der dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					Name:
					<c:out value="${benutzer.getFullName()}" />
				</p>
				<%-- Ausgabe der Straße & Hausnummer die dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					Straße &amp; Hausnummer:
					<c:out value="${benutzer.getFullStrasse()}" />
				</p>
				<%-- Ausgabe des Wohnorts die dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					PLZ &amp; Ort:
					<c:out value="${benutzer.getFullOrt()}" />
				</p>
				<br>
				<%-- Ausgabe der Mailadresse die dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					Mailadresse:
					<c:out value="${benutzer.getEmail()}" />
				</p>
			</div>
		</div>

		<%-- Erzeugung zweite Spalte, für Anzeige von den letzten Bestellungen mit dem Konto --%>
		<div class="col col-6">
			<h4 class="mb-3">Letzte Bestellungen</h4>
			<%-- Erzeugung Accordion, zur übersichtlichen Darstellung von letzten getätigten Bestellungen --%>
			<div class="accordion">
				<my:Konto />
			</div>
		</div>
	</div>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />