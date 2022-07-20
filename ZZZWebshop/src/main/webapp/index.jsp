<%-- Index bzw. Startseite GUI
	 @author Eve-Marie Hellmer (356925) --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Startseite" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>

<%-- Erstellung Container für gesamten Inhalt --%>
<div class="container body-container">
	<%-- Anzeige des Hintergrundbilds; margin -5em damit Hundeohren nicht direkt an Header anliegen --%>
	<div>
		<img src="assets/logos/hunde.png" class="img-fluid" alt="Hunde"
			style="margin-bottom: -5em;">
	</div>
	
	<%-- Abschnitt: Produkte --%>
	<%-- Erzeugung Zeile zur Anzeige von Cards, die Artikelkategorien zeigen --%>
	<div class="row">
		<%-- Erzeugung erste Spalte --%>
		<div class="col-sm-4">
			<%-- Erzeugung Card mit Hintergrundschatten, zur besseren Abhebung vom Hintergrund --%>
			<div class="card shadow">
				<%-- Anzeige des Kategoriebilds, zur Verdeutlichung um welche Kategorie es sich handelt --%>
				<img src="assets/images/Trockenfleisch.jpg" class="card-img-top"
					alt="Trockenfleisch">
				<%-- Anzeige des des Kategorienames & Bedeutung --%>
				<div class="card-body">
					<h5 class="card-title">Ernährung & Pfege</h5>
					<p class="card-text">Alles rund um ausgewogene Mahlzeiten und
						Snacks für deinen liebsten Vierbeiner. Und wenn es mal matschig
						ist, kann man ihn auch mal mit einer Verwöhndusche überraschen.!</p>
				</div>
			</div>
		</div>
		<%-- Erzeugung zweite Spalte --%>
		<div class="col-sm-4">
			<%-- Erzeugung Card mit Hintergrundschatten, zur besseren Abhebung vom Hintergrund --%>
			<div class="card shadow">
				<%-- Anzeige des Kategoriebilds, zur Verdeutlichung um welche Kategorie es sich handelt --%>
				<img src="assets/images/Hundeleine_sport.jpg" class="card-img-top"
					alt="Hundeleine">
				<%-- Anzeige des des Kategorienames & Bedeutung --%>
				<div class="card-body">
					<h5 class="card-title">Zubehör & Spielzeug</h5>
					<p class="card-text">Was das kleine Herz höher schlägenlässt.
						Von sportlichen Gadjets und Leinen bis hin zum Kuscheltier. Damit
						kannst du es deinem Hund so richtig schön machen!</p>
				</div>
			</div>
		</div>
		<%-- Erzeugung dritte Spalte --%>
		<div class="col-sm-4">
			<%-- Erzeugung Card mit Hintergrundschatten, zur besseren Abhebung vom Hintergrund --%>
			<div class="card shadow">
				<%-- Anzeige des Kategoriebilds, zur Verdeutlichung um welche Kategorie es sich handelt --%>
				<img src="assets/images/Hundebett_Superweich.jpg"
					class="card-img-top" alt="Hundebett">
				<%-- Anzeige des des Kategorienames & Bedeutung --%>
				<div class="card-body">
					<h5 class="card-title">Schlafen & Erholung</h5>
					<p class="card-text">Auch Helden müssen mal schlafen. Am besten
						auf einer flauschigen und bewuemen Matte. Gönne deinem Puppie
						einen schönen Schlaf!</p>
				</div>
			</div>
		</div>
	</div>

	<%-- Abschnitt: Vison --%>
	<div>
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
	</div>

	<%-- Abschnitt: FAQ --%>
	<div>
		<h1 class="fs-1 mt-5">FAQ</h1>
		<%-- Erzeugung Accordion, zur übersichtlichen Darstellung von meist gestellten Fragen --%>
		<div class="accordion mb-4" id="accordion">
			<%-- erstes Element des Accordions --%>
			<div class="accordion-item">
				<%-- Überschift des Elements & Button zum ein- bzw. ausklappen des Inhalts --%>
				<h2 class="accordion-header" id="headingOne">
					<button class="accordion-button text-bg-light" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseOne"
						aria-expanded="true" aria-controls="collapseOne">Wie kann
						ich meine letzten Bestellungen ansehen?</button>
				</h2>
				<%-- Inhalt des Elements, mit Markierung des wichtigsten in Fett & Weiterleitung zur Unterseite --%>
				<div id="collapseOne" class="accordion-collapse collapse show"
					aria-labelledby="headingOne" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<strong>Wir zeigen die stets deine letzten Bestellungen
							an.</strong> Unter dem Menüpunkt <a href="konto.jsp" class="link-dark">Konto</a>
						werden dir alle Kontodaten angezeigt, sowie deine letzten
						Bestellungen die du getätigt hast.
					</div>
				</div>
			</div>
			<%-- zweites Element des Accordions --%>
			<div class="accordion-item">
				<%-- Überschift des Elements & Button zum ein- bzw. ausklappen des Inhalts --%>
				<h2 class="accordion-header" id="headingTwo">
					<button class="accordion-button text-bg-light collapsed"
						type="button" data-bs-toggle="collapse"
						data-bs-target="#collapseTwo" aria-expanded="false"
						aria-controls="collapseTwo">Wieso kann ich die Produkte
						nicht ansehen?</button>
				</h2>
				<%-- Inhalt des Elements, mit Markierung des wichtigsten in Fett --%>
				<div id="collapseTwo" class="accordion-collapse collapse"
					aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<strong>Vertrauen und Qualität sind uns wichtig!</strong> Wir
						möchten unseren Kunden die größt mögliche Qualität bieten und
						daher gewähren wir nur registrierten und angemeldeten Kunden
						Zugang zu unserer Produktauswahl.
					</div>
				</div>
			</div>
			<%-- dritts Element des Accordions --%>
			<div class="accordion-item">
				<%-- Überschift des Elements & Button zum ein- bzw. ausklappen des Inhalts --%>
				<h2 class="accordion-header" id="headingThree">
					<button class="accordion-button text-bg-light collapsed"
						type="button" data-bs-toggle="collapse"
						data-bs-target="#collapseThree" aria-expanded="false"
						aria-controls="collapseThree">Meine Frage finde ich nicht
						in den FAQs?</button>
				</h2>
				<%-- Inhalt des Elements, mit Markierung des wichtigsten in Fett --%>
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
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />