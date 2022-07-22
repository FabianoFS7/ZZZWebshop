<%-- Header 
	 @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- Anzeige des Seittitels im Tab --%>
<title>${param.title} | PuppieDeluxe</title>
<%-- Eindindung von Bootstrap Version 5.2 --%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<%-- Eindindung von Bootstraps CSS --%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/stylesheet.css">
<%-- Eindindung des Logos als Tab-Symbol --%>
<link rel="icon" href="assets/logos/logo.png">
</head>
<body>
	<%-- Eindindung von Bootstraps JS --%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/script.js"></script>

	<%-- Navigationsleiste fixiert am Seitenanfang, zur Anzeige der erreichbaren Unterseiten & um zur Anmeldung zu gelangen --%>
	<nav class="navbar navbar-expand-lg bg-light ${param.navbar}">
		<div class="container-fluid">
			<%-- Anzeige von Logo & Websitename --%>
			<a class="navbar-brand" href="index.jsp"> <img
				src="assets/logos/logo.png" alt="Logo" width="40"
				class="d-inline-block align-text-top me-2"> PuppieDeluxe Webshop
			</a>
			<%-- Links zum navigieren zu Startseite & Artikelübersicht --%>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a class="nav-link link-dark"
					href="index.jsp">Startseite</a></li>
				<li class="nav-item"><a class="nav-link link-dark"
					href="artikeluebersicht.jsp">Artikelübersicht</a></li>
			</ul>
			<form class="justify-content-end" action="LogoutServlet"
				method="POST">
				<c:choose>
					<%-- unangemeldeten Benutzern werden Buttons zur Registierung & Anmeldung angezeigt, damit Auswahl von Produkten & Kaufprozess begonnen werden kann --%>
					<c:when test="${ benutzer == null }">
						<a href="registrierung.jsp" class="btn btn-dark" type="button">Registrieren</a>
						<a href="login.jsp" class="btn btn-dark" type="button">Anmelden</a>
					</c:when>
					<%-- angemeldeten Benutzern werden Buttons zur Abmeldung, Kontoübersicht & zum Warenkorb angezeigt, für eine einfache Navigation --%>
					<c:otherwise>
						<%-- Administartoren wird zusätzlich Button zur Artikelverwaltung angezeigt --%>
						<c:if test="${ benutzer.isAdmin() == true }">
							<a href="artikelverwaltung.jsp" class="btn btn-dark"
								type="button">Artikelverwaltung</a>
						</c:if>
						<a href="LogoutServlet" class="btn btn-dark">Abmelden</a>
						<a href="konto.jsp" class="btn btn-dark" type="button">Konto</a>
						<a href="warenkorb.jsp" class="btn btn-dark" type="button">Warenkorb
							<%-- Anzeige der Anzahl an enthaltenen Artikeln im Warenkorb, für mehr Übersicht beim Kaufprozess --%>
							<span class="badge badge-light">${ artikelAnzahl }</span>
						</a>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</nav>