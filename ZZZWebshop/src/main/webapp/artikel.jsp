<%-- Artikel GUI
	 @author Eve-Marie Hellmer (356925) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>
	
<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Artikel" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<%-- Darstellung eines Artikels in der Einzelansicht --%>
<div class="container body-container">
	<%-- Einfügen von Hintergrundschatten, zur besseren Abhebung vom Hintergrund --%>
	<div class="card shadow">
		<%-- Einbindung von ArtikelEinzelTag.java, zum dynamischen Füllen des Inhalts--%>
		<my:ArtikelEinzel/>
		<%-- Button zum Zurückkehren zur Artikelübersicht --%>
		<div class="row justify-content-center m-4">
			<a href="artikeluebersicht.jsp" class="btn btn-dark col-auto"
				type="button">zur Übersicht</a>
		</div>
	</div>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />