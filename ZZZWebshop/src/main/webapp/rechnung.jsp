<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Rechnung" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<!--Einträge müssen hier dynamisch generiert werden -->
<div class="container mx-auto my-4" style="width: 100%;">
	<div class="row justify-content-between">
		<div class="col col-6">
			<div class="container">
				<div class="alert alert-success" role="alert">
					<h4 class="alert-heading">Ihre Bestellung war erfolgreich!</h4>
					<hr>
					<div class="row">
						<div class="col">
							<p>Rechnung als PDF herrunterladen</p>
						</div>
						<div class="col">
							<a href="https://www.lexoffice.de/wp-content/uploads/vorlage-rechnung-musterrechnung-kostenlos-lexoffice.png" class="btn btn-dark bi bi-filetype-pdf"
								type="button"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col col-6">
			<h4 class="mb-3">Ihre Bestellung</h4>
			<div class="card my-4" style="width: 35rem;">
				<div class="row">
					<div class="col">
						<div class="card-body">
							<h5 class="card-title">Special title treatment</h5>
						</div>
					</div>
					<div class="col my-auto col-md-2">
						<h5 class="card-title">X x</h5>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="card-body">
							<p class="card-text">With supporting text below as a natural
								lead-in to additional content.</p>
							<p class="card-text">
								<small class="text-muted">Last updated 3 mins ago</small>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="templates/footer.jsp" />