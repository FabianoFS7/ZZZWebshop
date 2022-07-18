<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>	
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Artikel" />
	<jsp:param name="navbar" value="" />
</jsp:include>


<div class="container body-container" style="width: 90%;">
	<div class="card shadow">
		<my:ArtikelEinzel/>
		<div class="row justify-content-center my-4">
			<a href="artikeluebersicht.jsp" class="btn btn-dark col-auto"
				type="button">zur Übersicht</a>
		</div>
	</div>
</div>


<jsp:include page="templates/footer.jsp" />