<%-- Login bzw. Anmeldung GUI
	 @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Anmelden " />
	<jsp:param name="navbar" value="" />
</jsp:include>

<div class="d-flex justify-content-center my-4 mh-100">
	<%-- Formular, zum Anmelden mit Mailadresse & Passwort --%>
	<form class="needs-validation" action="LoginServlet" method="POST">
		<%-- Feld, zur Abfrage der Mailadresse --%>
		<div class="container mb-3">
			<label for="mail" class="form-label">E-Mail</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-at"></i></span> <input
					type="email" class="form-control" id="email" name="email"
					aria-describedby="email" placeholder="Mail" required>
			</div>
		</div>
		<%-- Feld, zur Abfrage des Passworts --%>
		<div class="container mb-3">
			<label for="passwort" class="form-label">Passwort</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-key-fill"></i></span>
				<input type="password" class="form-control" id="passwort"
					name="passwort" aria-describedby="passwort" placeholder="Passwort"
					required>
			</div>
		</div>
		<%-- Buttons zum Anmelden bzw. falls Nutzer noch neu ist Weiterleitung zur Registrierung --%>
		<div class="container d-flex justify-content-between">
			<a href="registrierung.jsp" class="btn btn-secondary" type="button">Registrieren</a>
			<button class="btn btn-dark" type="submit">Anmelden</button>
		</div>
	</form>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />