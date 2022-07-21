<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%-- Dooplung mit footer.jsp; welche soll behalten werden?
	 Rückmeldungen in Form von Alerts bei Eingaben bzw. Ereignissen --%>
<c:choose>
	<%-- Erfolgsmeldung --%>
	<c:when test="${ erfolg != null }">
		<div class="alert alert-success alert-dismissible alert-nachricht fade fixed-bottom show" role="alert">
			<c:out value="${ erfolg }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:when>
	<%-- Fehlermeldung --%>
	<c:when test="${ fehler != null }">
		<div class="alert alert-danger alert-dismissible alert-nachricht fade fixed-bottom show" role="alert">
			<c:out value="${ fehler }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:when>
	<%-- Infomeldung bei Änderungen --%>
	<c:when test="${ info != null }">
		<div class="alert alert-primary alert-dismissible alert-nachricht fade fixed-bottom show" role="alert">
			<c:out value="${ info }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:when>
</c:choose>