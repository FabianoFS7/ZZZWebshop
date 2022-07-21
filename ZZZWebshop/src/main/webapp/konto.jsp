<%-- Konto GUI
	 TODO Kommentare im Bestellungenteil
	 @author Eve-Marie Hellmer (356925) & Fabian Segieth (360266) --%>
	 
<%@ page language="java" session="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Konto" />
	<jsp:param name="navbar" value="" />
</jsp:include>

<%-- Erstellung Container f¸r gesamten Inhalt --%>
<div class="container mx-auto my-4">
	<%-- Erzeugung erste Zeile --%>
	<div class="row justify-content-between">
		<%-- Erzeugung erste Spalte, f¸r Anzeige von Kontodaten --%>
		<div class="col col-6">
			<div class="container">
				<h4 class="mb-3"> Deine Daten</h4>
				<%-- Ausgabe des Vor- & Nachnamen der dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					Name:
					<c:out value="${benutzer.getFullName()}" />
				</p>
				<%-- Ausgabe der Straﬂe & Hausnummer die dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					Straﬂe & Hausnummer:
					<c:out value="${sessionScope.benutzer.getFullStrasse()}" />
				</p>
				<%-- Ausgabe des Wohnorts die dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					PLZ & Ort:
					<c:out value="${sessionScope.benutzer.getFullOrt()}" />
				</p>
				<br>
				<%-- Ausgabe der Mailadresse die dem Konto zugeordnet ist --%>
				<p class="fw-normal">
					Mailadresse:
					<c:out value="${sessionScope.benutzer.getEmail()}" />
				</p>
			</div>
		</div>

		<%-- Erzeugung zweite Spalte, f¸r Anzeige von den letzten Bestellungen mit dem Konto --%>
		<div class="col col-6">
			<h4 class="mb-3">Letzte Bestellungen</h4>
			<div class="d-flex align-items-center justify-content-center">
				<div class="accordion" id="accordionExample">
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingOne">
							<button class="accordion-button h5" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">
								<div class="row justify-content-between">
									<div class="col-10">Bestellung vom XX.XX.XX XX:XX Uhr</div>
									<div class="col-2">XX,XX</div>
								</div>
							</button>
						</h2>
						<div id="collapseOne" class="accordion-collapse collapse show"
							aria-labelledby="headingOne" data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<div class="card my-1" style="width: 35rem;">
									<div class="row">
										<div class="col">
											<div class="card-body">
												<p class="card-text">X * Artikelname</p>
											</div>
										</div>
										<div class="col my-auto col-md-2">
											<h5 class="card-title">X x</h5>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingTwo">
							<button class="accordion-button collapsed" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">Accordion
								Item #2</button>
						</h2>
						<div id="collapseTwo" class="accordion-collapse collapse"
							aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<strong>This is the second item's accordion body.</strong> It is
								hidden by default, until the collapse plugin adds the
								appropriate classes that we use to style each element. These
								classes control the overall appearance, as well as the showing
								and hiding via CSS transitions. You can modify any of this with
								custom CSS or overriding our default variables. It's also worth
								noting that just about any HTML can go within the
								<code>.accordion-body</code>
								, though the transition does limit overflow.
							</div>
						</div>
					</div>
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingThree">
							<button class="accordion-button collapsed" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseThree"
								aria-expanded="false" aria-controls="collapseThree">Accordion
								Item #3</button>
						</h2>
						<div id="collapseThree" class="accordion-collapse collapse"
							aria-labelledby="headingThree" data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<strong>This is the third item's accordion body.</strong> It is
								hidden by default, until the collapse plugin adds the
								appropriate classes that we use to style each element. These
								classes control the overall appearance, as well as the showing
								and hiding via CSS transitions. You can modify any of this with
								custom CSS or overriding our default variables. It's also worth
								noting that just about any HTML can go within the
								<code>.accordion-body</code>
								, though the transition does limit overflow.
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col col-4"></div>
	</div>
</div>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />