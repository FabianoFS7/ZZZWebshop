<%-- Artikelübersicht GUI
	 @author Eve-Marie Hellmer (356925) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Artikeluebersicht" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>

<%-- Erstellung Container für gesamte Artikelübersicht --%>
<div class="container body-container">
	<%-- Zeile für die Anzeige von Suchleiste & Filtern, die auf die Artikel angewendet werden können --%>
	<div class="row mb-3">
		<%-- Spalte, für die Suchleiste inkl. Button 
			 TODO: Beschreibung vervollständigen --%>
		<div class="col col-4">
			<form class="d-flex" role="search" method="POST" action="SuchServlet">
				<input class="form-control me-2" name="suchfilter" type="search"
					placeholder="Suchbegriff" aria-label="Search"
					value="<c:if test = "${suchfilter != null}"><c:out value = "${ suchfilter }"/></c:if>">
				<%-- Spalte für die Anzeige bzw. Auswahl der Filterfunktion --%>
				<select class="form-select me-2" aria-label="Default select example"
					name="suchkategorie">
					<option value="all"
						<c:if test="${ suchkategorie.equals('all') || suchkategorie == null }">selected</c:if>>alle
						Kategorien</option>
					<option value="Ernährung"
						<c:if test="${ suchkategorie.equals('Ernährung') }">selected</c:if>>Ernährung</option>
					<option value="Zubehör"
						<c:if test="${ suchkategorie.equals('Schlafen') }">selected</c:if>>Zubehör</option>
					<option value="Schlafen"
						<c:if test="${ suchkategorie.equals('Schlafen') }">selected</c:if>>Schlafen</option>
					<option value="Pflege"
						<c:if test="${ suchkategorie.equals('Pflege') }">selected</c:if>>Pflege</option>
				</select>
				<button class="btn btn-outline-dark" type="submit">Suchen</button>
			</form>
		</div>
	</div>
	<%-- Erzeugung von Zeilen für die Darstellungen der Artikelvorschauen --%>
	<div class="row">
		<%-- Einbindung von ArtikeTag.java, zum dynamischen Füllen des Inhalts --%>
		<my:ArtikelListe />
	</div>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />