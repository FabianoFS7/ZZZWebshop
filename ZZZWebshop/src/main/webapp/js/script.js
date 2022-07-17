function nameToUpperCase(field) {
	field.value = field.value.toUpperCase();
}

function checkRating(field) {
	var value = field.value;

	if (value <= 0 || value > 5) {
		field.style.backgroundColor = 'red';
	} else {
		field.style.backgroundColor = 'green';
	}
}

