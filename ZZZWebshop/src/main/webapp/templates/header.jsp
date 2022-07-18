<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title}| Puppy-Deluxe</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/stylesheet.css">
<link rel="icon" href="assets/images/logo.jpg">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

	<nav class="navbar navbar-expand-lg bg-light ${param.navbar}">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"> <img
				src="assets/images/logo.jpg" alt="Logo" width="30" height="24"
				class="d-inline-block align-text-top"> Puppy-Deluxe Webshop
			</a>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a class="nav-link link-dark"
					href="index.jsp">Startseite</a></li>
				<li class="nav-item"><a class="nav-link link-dark"
					href="artikeluebersicht.jsp">Produkte</a></li>
			</ul>
			<form class="justify-content-end" action="LogoutServlet" method="POST">
			<c:choose>
				<c:when test="${ benutzer == null }">
					<a href="registrierung.jsp" class="btn btn-dark" type="button">Registrieren</a>
					<a href="login.jsp" class="btn btn-dark" type="button">Login</a>
				</c:when>
				<c:otherwise>
				<input type="submit" class="btn btn-dark" value="Logout">
	
				</c:otherwise>		
			</c:choose>
				<a href="konto.jsp" class="btn btn-dark" type="button">Konto</a>
				<a href="warenkorb.jsp" class="btn btn-dark" type="button">Warenkorb<span class="badge badge-light">${artikelAnzahl }</span></a>
				
			</form>
		</div>
	</nav>

