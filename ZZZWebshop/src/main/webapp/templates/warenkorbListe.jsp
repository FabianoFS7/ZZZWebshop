<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<!--Einträge müssen hier dynamisch generiert werden -->
<c:forEach var="i" begin="0" end="${artikelListe.size() - 1 }"  >



<div class="card my-4" style="width: 34rem;">
	<div class="row">
		<div class="col">
			<div class="card-body">
				<h5 class="card-title">${artikelListe.get(i).getName() }</h5>
			</div>
		</div>
		<div class="col my-auto col-md-3">
			<div class="btn-group btn-group-sm" role="group">
				<button type="button" class="btn btn-dark">
					<span class=" bi bi-dash-lg" aria-hidden="true"></span>
				</button>
				<button type="button" class="btn btn-dark">
					<span class=" bi bi-x-lg" aria-hidden="true"></span>
				</button>
				<button type="button" class="btn btn-dark">
					<span class=" bi bi-plus-lg" aria-hidden="true"></span>
				</button>
			</div>
		</div>
		<div class="col my-auto col-md-2">
			<h5 class="card-title">${artikelListe.get(i).getPreis() }</h5>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="card-body">
				<p class="card-text">Kategorie: ${artikelListe.get(i).getKategorie() }</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>
</div>
</c:forEach>
Gesamtpreis: ${gesamtPreis }
</body>
</html>