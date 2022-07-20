<%-- Warenkorb GUI
	 @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>	

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Warenkorb" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>

<%-- Erstellung Container für gesamten Inhalt --%>
<div class="container body-container">
	<%-- Erstellung einer Tabelle, für gesamten Warenkorbinhalt --%>
		<table class="table my-5">
			<thead>
				<%-- Erzeugung der Spalten --%>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Artikel</th>
					<th scope="col">Kategorie</th>
					<th scope="col">Anzahl</th>
					<th scope="col">Preis</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<%-- Einbindung von WarenkorbTag.java, zum dynamischen Füllen des Warenkorbinhalts --%>
				<my:WarenkorbListen/>
			</tbody>
		</table>
	<%-- Button zum Abschließen des Artikelauswahlprozzeses & übergang zum Kauf--%>
	<a href="bestellvorgang.jsp" class="btn btn-dark">Kasse</a>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />