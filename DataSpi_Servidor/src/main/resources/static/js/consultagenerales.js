/**
 * GENERALES CONSULTA JS
 */

/*Cambio de color según prioridad en tabal general de bienes*/
$(function() {
	$("table td:nth-child(11):contains(Baja)")
		.parents("tr")
	    .css("background-color", "#d5e8d4");
	 
		 $("table td:nth-child(11):contains(Media)")
	    .parents("tr")
	    .css("background-color", "#fff2cc");
	 
		 $("table td:nth-child(11):contains(Alta)")
	    .parents("tr")
	    .css("background-color", "#f8cecc");
});

//Validaciones de Bootstrap 
(function() {
	  'use strict';
	  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        form.classList.add('was-validated');
	      }, false);
	    });
	  }, false);
	})();

//Cerrar alertas
$('.alert').alert('close')