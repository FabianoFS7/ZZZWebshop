<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Anmelden" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<div class="d-flex justify-content-center my-4 mh-100">

	<form class="needs-validation" action="LoginServlet" method="POST">

		<div class="container mb-3">
			<label for="mail" class="form-label">E-Mail</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-at"></i></span> <input
					type="email" class="form-control" id="email" name="email"
					aria-describedby="email" placeholder="Mail" required>
			</div>
		</div>

		<div class="container mb-3">
			<label for="passwort" class="form-label">Passwort</label>
			<div class="input-group">
				<span class="input-group-text"><i class="bi bi-key-fill"></i></span>
				<input type="password" class="form-control" id="passwort"
					name="passwort" aria-describedby="passwort" placeholder="Passwort" required>
			</div>
		</div>

		<div class="container d-flex justify-content-between">
			<a href="registrierung.jsp" class="btn btn-dark" type="button">Registrieren</a>
			<button class="btn btn-primary" type="submit">Anmelden</button>
		</div>

	</form>

</div>

<jsp:include page="templates/footer.jsp" />