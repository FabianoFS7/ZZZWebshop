/* JavaScript */

/* Ermöglicht dynamisches Ausbleben nach drei Sekunden von allen alert-nachicht */
$(document).ready(function() {
	window.setTimeout(function() {
		$(".alert-nachricht").fadeTo(1000, 0).slideUp(1000, function() {
			$(this).remove();
		});
	}, 3000);
});