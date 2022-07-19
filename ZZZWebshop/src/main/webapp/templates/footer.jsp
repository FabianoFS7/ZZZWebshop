<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<c:choose>
	<c:when test="${ erfolg != null }">
		<div class="alert alert-success alert-dismissible alert-nachricht fade fixed-bottom show" role="alert">
			<c:out value="${ erfolg }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:when>
	<c:when test="${ fehler != null }">
		<div class="alert alert-danger alert-dismissible alert-nachricht fade fixed-bottom show" role="alert">
			<c:out value="${ fehler }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:when>
	<c:when test="${ info != null }">
		<div class="alert alert-secondary alert-dismissible alert-nachricht fade fixed-bottom show" role="alert">
			<c:out value="${ info }"></c:out>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	</c:when>
</c:choose>
    
<nav class="navbar bg-light fixed-bottom">
  <div class="container-fluid">
    <a class="navbar-brand mx-auto h6" href="#">2022 &copy;PuppieDeluxe Webshop</a>
  </div>
</nav>

</body>
</html>