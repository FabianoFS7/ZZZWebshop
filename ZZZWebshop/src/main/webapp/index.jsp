<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Startseite" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>

<div class="container body-container" style="width: 90%;">

	<div>
		<img src="assets/images/hunde.png" class="img-fluid" alt="Hunde"
			style="margin-bottom: -5em;">
	</div>


	<div class="row">
		<!--Einträge können auch dynamisch generiert werden z.B. die 3 am meisten gekauften Artikel oder so-->
		<div class="col-sm-4">
			<div class="card shadow">
				<img src="assets/images/hund1.png" class="card-img-top" alt="Hund1">
				<div class="card-body">
					<h5 class="card-title">Special title treatment</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="card shadow">
				<img src="assets/images/hund2.png" class="card-img-top" alt="Hund2">
				<div class="card-body">
					<h5 class="card-title">Kuscheltier</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="card shadow">
				<img src="assets/images/leine.png" class="card-img-top"
					alt="Hundeleine">
				<div class="card-body">
					<h5 class="card-title">Hundeleine</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
		</div>
	</div>

	<h1 class="fs-1 mt-5">Unsere Vision</h1>

	<p class="lh-lg">Bei PuppieDeluxe ist es unsere Vision das beste
		für Dich und deinen Hund auszuwählen. Hundefutter und -zubehör kann
		man fast überall kaufen. Ob das angebotene Hundezubehör meinem Hund
		auch wirklich gerecht wird, günstig und gut ist, kann aber nur der
		Profi mit seinen vielfältigen Erfahrungen beurteilen. Hundebedarf ist
		nämlich nicht gleich Hundebedarf. Ein Hundegeschirr muss dem Hund gut
		sitzen, bequem sein und seine Funktion erfüllen. Auch bei Hunden
		spielt die Ernährung eine wichtige Rolle. Deshalb sind Auswahl und
		Kauf von Hundebedarf immer Vertrauenssache.</p>


	<h1 class="fs-1 mt-5">FAQ</h1>

	<div class="accordion mb-4" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingOne">
				<button class="accordion-button" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseOne"
					aria-expanded="true" aria-controls="collapseOne">Wie kann
					ich meine letzten Bestellungen ansehen?</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				aria-labelledby="headingOne" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>Wir zeigen die stets deine letzten Bestellungen
						an.</strong> Unter dem Menüpunkt <a href="konto.jsp" class="alert-link">Konto</a> werden dir alle Kontodaten
					angezeigt, sowie deine letzten Bestellungen die du getätigt hast.
				</div>
			</div>
		</div>
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingTwo">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseTwo"
					aria-expanded="false" aria-controls="collapseTwo">
					Wieso kann ich die Produkte nicht ansehen?</button>
			</h2>
			<div id="collapseTwo" class="accordion-collapse collapse"
				aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>Vertrauen und Qualität sind uns wichtig!</strong> Wir möchten unseren Kunden die größt mögliche Qualität bieten und daher gewähren wir nur registrierten und angemeldeten Kunden Zugang zu unserer Produktauswahl.
				</div>
			</div>
		</div>
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingThree">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseThree"
					aria-expanded="false" aria-controls="collapseThree">
					Meine Frage finde ich nicht in den FAQs?</button>
			</h2>
			<div id="collapseThree" class="accordion-collapse collapse"
				aria-labelledby="headingThree" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>Wir helfen dir gerne weiter!</strong> Falls du dennoch fragen zum Shop oder einzelnen Produkten hast kannst du dich von Montag bis Freitag zwischen 9 und 15 Uhr unter folgender Nummer melden: 012345-67890
				</div>
			</div>
		</div>
	</div>

</div>

<jsp:include page="templates/footer.jsp" />