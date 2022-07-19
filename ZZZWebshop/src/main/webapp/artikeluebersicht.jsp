<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Artikeluebersicht" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>
<div class="container body-container" style="width: 90%;">

	<div class="row mb-3">
		<div class="col col-4">
			<form class="d-flex" role="search" method="POST" action="SuchServlet">
				<input class="form-control me-2" name="suchfilter" type="search"
					placeholder="Artikel suchen" aria-label="Search">
				<button class="btn btn-outline-secondary" type="submit">Suchen</button>
			</form>
		</div>

		<div class="col col-2">
			<select class="form-select" aria-label="Default select example">
				<option selected disabled>Kategorien Filtern</option>
				<option value="1">Erneahrung</option>
				<option value="2">Zubehoer</option>
				<option value="3">Schlafen</option>
				<option value="4">Pflege</option>
			</select>
		</div>

	<a href="SuchServlet">${suchfilter }</a>
	</div>
	<div class="row" style="width: 100%;">	
		<!--Einträge werden hier dynamisch generiert -->
		<my:ArtikelListe/>
		
	</div>

</div>

<jsp:include page="templates/footer.jsp" />