<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div
		class="alert alert-warning alert-dismissible alert-nachricht fade fixed-bottom show" role="alert">
		<c:out value="${param.error}">Bitte überprüfen Sie ihre Eingaben!</c:out>
		<c:out value="${param.success}">Eingaben erfolgreich!</c:out>
		<c:out value="${param.goodbye}">Bis zum nächsten mal NAME!</c:out>
		<button type="button" class="btn-close" data-bs-dismiss="alert"	aria-label="Close"></button>
	</div>
