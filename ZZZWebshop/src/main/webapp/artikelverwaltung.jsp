<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglib/customtags.tld" prefix="my"%>

<jsp:include page="templates/header.jsp">
	<jsp:param name="title" value="Artikelverwaltung" />
	<jsp:param name="navbar" value="fixed-top" />
</jsp:include>


<div class="container body-container" style="width: 100%;">

	<div class="mt-5 h2">Artikelverwaltung - Administration</div>

	<button class="btn btn-success my-2" id="artikel_hinzufügen"
		type="button" data-bs-toggle="modal" data-bs-target="#modal">Hinzufügen</button>

	<table class="table table-hover mb-5" id="artikel_tabelle">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Bild</th>
				<th scope="col">Beschreibung</th>
				<th scope="col">Kategorie</th>
				<th scope="col">Preis</th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<my:ArtikelVerwaltung />
		</tbody>
	</table>
</div>

<div class="modal fade" id="modal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Artikelverwaltung</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="ArtikelVerwaltungServlet" method="POST"
				id="artikel_form">
				<div class="modal-body">
					<input type="hidden" name="id" value="" id="form_id" /> <input
						type="hidden" name="type" value="add" id="form_type" />
					<div class="mb-3">
						<label for="form_name" class="form-label">Name</label> <input
							type="text" class="form-control" id="form_name" name="name">
					</div>
					<div class="mb-3">
						<label for="form_name" class="form-label">Bildname (mit
							Endung wie .jpg, png, ...)</label> <input type="text"
							class="form-control" id="form_bild" name="bild">
					</div>
					<div class="mb-3">
						<label for="form_beschreibung" class="form-label">Beschreibung</label>
						<textarea class="form-control" id="form_beschreibung"
							rows="8" name="beschreibung"></textarea>
					</div>
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
					<div class="mb-3">
						<label for="form_preis" class="form-label">Preis (in
							&euro;)</label> <input type="number" step="0.01" class="form-control"
							id="form_preis" name="preis">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Schließen</button>
					<button type="submit" class="btn btn-primary">Speichern</button>
					<button type="button" class="btn btn-danger" id="form_delete"
						style="display: none;">Löschen</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
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

		$('#artikel_hinzufügen').click(function() {
			$('#artikel_form').trigger('reset');
			$('#form_delete').hide();
			$('#form_type').val('add');
		});

		$('#form_delete').click(function() {
			$('#form_type').val('delete');
			$('#artikel_form').submit();
		});
	});
</script>

<jsp:include page="templates/footer.jsp" />