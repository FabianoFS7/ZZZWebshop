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
		<!--Eintr�ge k�nnen auch dynamisch generiert werden z.B. die 3 am meisten gekauften Artikel oder so-->
		<div class="col-sm-4">
			<div class="card shadow">
				<img src="assets/images/hund1.png" class="card-img-top" alt="Hund1">
				<div class="card-body">
					<h5 class="card-title">Ern�hrung & Pfege</h5>
					<p class="card-text">Alles rund um ausgewogene Mahlzeiten und
						Snacks f�r deinen liebsten Vierbeiner. Und wenn es mal matschig
						ist, kann man ihn auch mal mit einer Verw�hndusche �berraschen.!</p>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="card shadow">
				<img src="assets/images/hund2.png" class="card-img-top" alt="Hund2">
				<div class="card-body">
					<h5 class="card-title">Zubeh�r & Spielzeug</h5>
					<p class="card-text">Was das kleine Herz h�her schl�genl�sst.
						Von sportlichen Gadjets und Leinen bis hin zum Kuscheltier. Damit
						kannst du es deinem Hund so richtig sch�n machen!</p>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="card shadow">
				<img src="assets/images/leine.png" class="card-img-top"
					alt="Hundeleine">
				<div class="card-body">
					<h5 class="card-title">Schlafen & Erholung</h5>
					<p class="card-text">Auch Helden m�ssen mal schlafen. Am besten
						auf einer flauschigen und bewuemen Matte. G�nne deinem Puppie
						einen sch�nen Schlaf!</p>
				</div>
			</div>
		</div>
	</div>

	<h1 class="fs-1 mt-5">Unsere Vision</h1>

	<p class="lh-lg">Bei PuppieDeluxe ist es unsere Vision das beste
		f�r Dich und deinen Hund auszuw�hlen. Hundefutter und -zubeh�r kann
		man fast �berall kaufen. Ob das angebotene Hundezubeh�r meinem Hund
		auch wirklich gerecht wird, g�nstig und gut ist, kann aber nur der
		Profi mit seinen vielf�ltigen Erfahrungen beurteilen. Hundebedarf ist
		n�mlich nicht gleich Hundebedarf. Ein Hundegeschirr muss dem Hund gut
		sitzen, bequem sein und seine Funktion erf�llen. Auch bei Hunden
		spielt die Ern�hrung eine wichtige Rolle. Deshalb sind Auswahl und
		Kauf von Hundebedarf immer Vertrauenssache.</p>


	<h1 class="fs-1 mt-5">FAQ</h1>

	<div class="accordion mb-4" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingOne">
				<button class="accordion-button text-bg-light" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseOne"
					aria-expanded="true" aria-controls="collapseOne">Wie kann
					ich meine letzten Bestellungen ansehen?</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				aria-labelledby="headingOne" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>Wir zeigen die stets deine letzten Bestellungen
						an.</strong> Unter dem Men�punkt <a href="konto.jsp" class="link-dark">Konto</a>
					werden dir alle Kontodaten angezeigt, sowie deine letzten
					Bestellungen die du get�tigt hast.
				</div>
			</div>
		</div>
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingTwo">
				<button class="accordion-button text-bg-light collapsed"
					type="button" data-bs-toggle="collapse"
					data-bs-target="#collapseTwo" aria-expanded="false"
					aria-controls="collapseTwo">Wieso kann ich die Produkte
					nicht ansehen?</button>
			</h2>
			<div id="collapseTwo" class="accordion-collapse collapse"
				aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>Vertrauen und Qualit�t sind uns wichtig!</strong> Wir
					m�chten unseren Kunden die gr��t m�gliche Qualit�t bieten und daher
					gew�hren wir nur registrierten und angemeldeten Kunden Zugang zu
					unserer Produktauswahl.
				</div>
			</div>
		</div>
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingThree">
				<button class="accordion-button text-bg-light collapsed"
					type="button" data-bs-toggle="collapse"
					data-bs-target="#collapseThree" aria-expanded="false"
					aria-controls="collapseThree">Meine Frage finde ich nicht
					in den FAQs?</button>
			</h2>
			<div id="collapseThree" class="accordion-collapse collapse"
				aria-labelledby="headingThree" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					<strong>Wir helfen dir gerne weiter!</strong> Falls du dennoch
					fragen zum Shop oder einzelnen Produkten hast kannst du dich von
					Montag bis Freitag zwischen 9 und 15 Uhr unter folgender Nummer
					melden: 012345-67890
				</div>
			</div>
		</div>
	</div>

</div>

<jsp:include page="templates/footer.jsp" />