<%-- Artikel�bersicht GUI
	 @author Eve-Marie Hellmer (356925) --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Artikeluebersicht" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>

<%-- Erstellung Container f�r gesamte Artikel�bersicht --%>
<div class="container body-container">
	<%-- Zeile f�r die Anzeige von Suchleiste & Filtern, die auf die Artikel angewendet werden k�nnen --%>
	<div class="row mb-3">
		<%-- Spalte, f�r die Suchleiste inkl. Button 
			 TODO: Beschreibung vervollst�ndigen --%>
		<div class="col col-4">
			<form class="d-flex" role="search" method="POST" action="SuchServlet">
				<input class="form-control me-2" name="suchfilter" type="search"
					placeholder="Suchbegriff" aria-label="Search" value="<c:if test = "${suchfilter != null}"><c:out value = "${ suchfilter }"/></c:if>">
				<button class="btn btn-outline-secondary" type="submit">Suchen</button>
			</form>
		</div>
		<%-- Splate f�r die Anzeige der Filterfunktion --%>
		<div class="col col-2">
			<select class="form-select" aria-label="Default select example">
				<option selected disabled>Kategorien Filtern</option>
				<option value="1">Erneahrung</option>
				<option value="2">Zubehoer</option>
				<option value="3">Schlafen</option>
				<option value="4">Pflege</option>
			</select>
		</div>
	</div>
	<%-- Erzeugung von Zeilen f�r die Darstellungen der Artikelvorschauen --%>
	<div class="row">	
		<%-- Einbindung von ArtikeTag.java, zum dynamischen F�llen des Inhalts --%>
		<my:ArtikelListe/>
	</div>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />