<%-- Footer 
	 @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Rückmeldungen in Form von Alerts bei Eingaben bzw. Ereignissen --%>
<c:choose>
	<%-- Erfolgsmeldung --%>
	<c:when test="${ erfolg != null }">
		<div
			class="alert alert-success alert-dismissible alert-nachricht fade fixed-bottom show"
			role="alert">
			<c:out value="${ erfolg }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:when>
	<%-- Fehlermeldung --%>
	<c:when test="${ fehler != null }">
		<div
			class="alert alert-danger alert-dismissible alert-nachricht fade fixed-bottom show"
			role="alert">
			<c:out value="${ fehler }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:when>
	<%-- Infomeldung bei Änderungen --%>
	<c:when test="${ info != null }">
		<div
			class="alert alert-secondary alert-dismissible alert-nachricht fade fixed-bottom show"
			role="alert">
			<c:out value="${ info }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:when>
</c:choose>

<%-- Footer fixiert am Seitenende, zur Anzeige von Websiteinformationen & Erstellungsdatum --%>
<nav class="navbar bg-light fixed-bottom">
	<div class="container-fluid">
		<a class="navbar-brand mx-auto h6" href="#">2022 &copy;
			PuppieDeluxe Webshop</a>
	</div>
</nav>

</body>
</html>