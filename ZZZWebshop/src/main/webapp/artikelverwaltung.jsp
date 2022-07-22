<%-- Artikelverwaltung GUI
	 TODO Kommentare im Scriptteil
	 @author Eve-Marie Hellmer (356925) --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

<%-- Einbindung des Headers --%>
<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Artikelverwaltung" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>

<%-- Erstellung Container für gesamte Artikelübersicht --%>
<div class="container body-container">
	<%-- Überschrift --%>
	<div class="mt-5 h2">Artikelverwaltung - Administration</div>
	<%-- Button, damit neue Artikel hinzugefügt werden können --%>
	<button class="btn btn-dark my-2" id="artikel_hinzufügen"
		type="button" data-bs-toggle="modal" data-bs-target="#modal">Hinzufügen</button>

	<%-- Erstellung einer Tabelle, wo alle Artikel aufgelistet werden --%>
	<table class="table table-hover mb-5" id="artikel_tabelle">
		<thead>
			<%-- Erzeugung der Spalten --%>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Bild</th>
				<th scope="col">Beschreibung</th>
				<th scope="col">Kategorie</th>
				<th scope="col">Preis</th>
			</tr>
		</thead>
		<%-- Einbindung von Artikelverwaltung.java, zum dynamischen Füllen des Inhalts--%>
		<tbody class="table-group-divider">
			<my:ArtikelVerwaltung />
		</tbody>
	</table>
</div>

<%-- Erstellung Modal für Änderungen an Artikel, aufrufbar durch anklicken des gewünschten Artikels --%>
<div class="modal fade" id="modal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<%-- Inhalt des Modals --%>
		<div class="modal-content">
			<%-- Header inkl. Titel & Button zum Schließen des Modals --%>
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Artikelverwaltung</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<%-- Formular, zum Ändern von Artikelattributen --%>
			<form action="ArtikelVerwaltungServlet" method="POST"
				id="artikel_form">
				<div class="modal-body">
					<input type="hidden" name="id" value="" id="form_id" /> <input
						type="hidden" name="type" value="add" id="form_type" />
					<%-- Feld, zum Ändern des Artikelnamen --%>
					<div class="mb-3">
						<label for="form_name" class="form-label">Name</label> <input
							type="text" class="form-control" id="form_name" name="name">
					</div>
					<%-- Feld, zum Ändern des Artikelbildnamen --%>
					<div class="mb-3">
						<label for="form_name" class="form-label">Bildname (mit
							Endung wie .jpg, png, ...)</label> <input type="text"
							class="form-control" id="form_bild" name="bild">
					</div>
					<%-- Feld, zum Ändern der Artikelbeschreibung --%>
					<div class="mb-3">
						<label for="form_beschreibung" class="form-label">Beschreibung</label>
						<textarea class="form-control" id="form_beschreibung"
							rows="8" name="beschreibung"></textarea>
					</div>
					<%-- Auswahlfeld, zum Ändern der Artikelkategorie --%>
					<div class="mb-3">
						<label for="form_kategorie" class="form-label">Kategorie</label> <select
							class="form-select" id="form_kategorie" name="kategorie">
							<option selected disabled>Kategorie auswählen</option>
							<option value="Ernährung">Ernährung</option>
							<option value="Zubehör">Zubehör</option>
							<option value="Schlafen">Schlafen</option>
							<option value="Pflege">Pflege</option>
						</select>
					</div>
					<%-- Feld, zum Ändern des Artikelpreises --%>
					<div class="mb-3">
						<label for="form_preis" class="form-label">Preis (in
							&euro;)</label> <input type="number" step="0.01" class="form-control"
							id="form_preis" name="preis">
					</div>
				</div>
				<%-- Footer inkl. Buttons zum verwerfen, speichern & löschen des geänderten Inhalts --%>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Verwerfen</button>
					<button type="submit" class="btn btn-dark">Speichern</button>
					<button type="button" class="btn btn-danger" id="form_delete"
						style="display: none;">Löschen</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		// Einlesen aller data-Attribute und diese dann in die Input Felder im Modal ersetzen (mit Löschen Button)
		$('#artikel_tabelle').on('click', '.artikel_eintrag', function() {
			Id = $(this).data('id');
			Name = $(this).data('name');
			Bild = $(this).data('bild');
			Beschreibung = $(this).data('beschreibung');
			Kategorie = $(this).data('kategorie');
			Preis = $(this).data('preis');
			$('#form_id').val(Id);
			$("#form_name").val(Name);
			$("#form_bild").val(Bild);
			$("#form_beschreibung").val(Beschreibung);
			$("#form_kategorie").val(Kategorie);
			$("#form_preis").val(Preis);
			$('#form_type').val('edit');
			$('#form_delete').show();
			$('#modal').modal('show');
		});

		// Oeffnen des Modals (ohne Löschen Button) beim bestaetigen auf "Hinzufügen"
		$('#artikel_hinzufügen').click(function() {
			$('#artikel_form').trigger('reset');
			$('#form_delete').hide();
			$('#form_type').val('add');
		});

		// Automatisches Bestaetigen des Formulars im Artikel zu loeschen
		$('#form_delete').click(function() {
			$('#form_type').val('delete');
			$('#artikel_form').submit();
		});
	});
</script>

<%-- Einbindung des Footers --%>
<jsp:include page="templates/footer.jsp" />