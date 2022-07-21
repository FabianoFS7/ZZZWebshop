<%-- Registrierung GUI
	 @author Eve-Marie Hellmer (356925) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Registrierung" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<%-- Erstellung Container für gesamten Inhalt --%>
<div class="container d-flex justify-content-center my-4">
	<%-- Formular, zum Registrieren eines neuen Kontos für Nutzer --%>
	<form class="needs-validation" action="RegistrierungsServlet"
		method="POST">
		<%-- Feld, zur Abfrage des Vornamens --%>
		<div class="container mb-3">
			<label for="vorname" class="form-label">Vorname</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-person-fill"></i></span>
				<input type="text" class="form-control" name="vorname"
					aria-describedby="vorname" required>
			</div>
		</div>
		<%-- Feld, zur Abfrage des Nachnamens --%>
		<div class="container mb-3">
			<label for="nachname" class="form-label">Nachname</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-person-fill"></i></span>
				<input type="text" class="form-control" name="nachname"
					aria-describedby="nachname" required>
			</div>
		</div>
		<%-- Feld, zur Abfrage der Mailadresse --%>
		<div class="container mb-3">
			<label for="mail" class="form-label">E-Mail</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-at"></i></span> <input
					type="email" class="form-control" name="mail"
					aria-describedby="mail" required>
			</div>
		</div>
		<%-- Feld, zur Abfrage des Passworts--%>
		<div class="container mb-3">
			<label for="passwort" class="form-label">Passwort</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-key-fill"></i></span>
				<input type="password" class="form-control" name="passwort"
					aria-describedby="passwort" required>
			</div>
		</div>
		<%-- Feld, zur wiederholten Abfrage des Passworts 
			 TODO Wird geprüft ob die Passwörter gleich sind? --%>
		<div class="container mb-3">
			<label for="passwortWDH" class="form-label">Passwort
				wiederholen</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-key-fill"></i></span>
				<input type="password" class="form-control" name="passwortWDH"
					aria-describedby="passwortWDH" required>
			</div>
		</div>
		<%-- Feld, zur Abfrage der Straße --%>
		<div class="container mb-3">
			<label for="strasse" class="form-label">Straße</label>
			<div class="input-group">
				<span class="input-group-text"><i
					class="bi bi-house-door-fill"></i></span> <input type="text"
					class="form-control" name="strasse" aria-describedby="strasse"
					required>
			</div>
		</div>
		<%-- Feld, zur Abfrage der Hausnummer --%>
		<div class="container mb-3">
			<label for="hausnummer" class="form-label">Hausnummer</label>
			<div class="input-group">
				<span class="input-group-text"><i
					class="bi bi-house-door-fill"></i></span> <input type="text"
					class="form-control" name="hausnummer"
					aria-describedby="hausnummer" required>
			</div>
		</div>
		<%-- Feld, zur Abfrage der Postleitzahl --%>
		<div class="container mb-3">
			<label for="plz" class="form-label">Postleitzahl</label>
			<div class="input-group">
				<span class="input-group-text"><i
					class="bi bi-signpost-split-fill"></i></span> <input type="number"
					class="form-control" name="postleitzahl" aria-describedby="plz"
					required>
			</div>
		</div>
		<%-- Feld, zur Abfrage des Wohnortes --%>
		<div class="container mb-3">
			<label for="ort" class="form-label">Ort</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-geo-alt-fill"></i></span>
				<input type="text" class="form-control" name="ort"
					aria-describedby="ort" required>
			</div>
		</div>
		<%-- Buttons zum Registrieren bzw. falls Nutzer bereits ein Konto hat Weiterleitung zur Anmeldung --%>
		<div class="container d-flex justify-content-between">
			<a href="login.jsp" class="btn btn-secundary" type="button">Anmelden</a>
			<button class="btn btn-dark" type="submit">Registrieren</button>
		</div>
	</form>

</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />