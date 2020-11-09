/**
 * GENERALES JS
 */

/*Cambio de color según prioridad en tabal general de bienes*/
$(function() {
	$("table td:nth-child(12):contains(Baja)")
		.parents("tr")
	    .css("background-color", "#d5e8d4");
	 
		 $("table td:nth-child(12):contains(Media)")
	    .parents("tr")
	    .css("background-color", "#fff2cc");
	 
		 $("table td:nth-child(12):contains(Alta)")
	    .parents("tr")
	    .css("background-color", "#f8cecc");
});
//////////////////////////////////////////////////REGISTRO DEL SPI///////////////////////////
//función select dinámico página registro del spi por tipo
$('#filtrarportipo').change(
        function() {
            $.getJSON("http://localhost:9898/views/DataSpi/RegistroDelSpi/Elegiractivo", {
                idtipo : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un bien/servicio.. </option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idactivo + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idactivo1').html(html);
        });
});

//función obtener value activo 
$(document).ready(function(){
	$("#idactivo1").change(function(){
		var activoValue = $(this).children('option:selected').val();
		document.getElementById("idactivo2").value = activoValue;
	});
});

//función select dinámico página rrhh 1 modal save
$('#spiporzona').change(
        function() {
            $.getJSON("http://localhost:9898/views/DataSpi/RegistroDelSpi/Elegirspi", {
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un SPI.. </option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#spiid').html(html);
        });
});

//función obtener value spi para filtrado en página general modal save

///////////////////////////////////////////////////RRHH//////////////////////////////

//función select dinámico página rrhh 2 modal edit
$('#idzona').change(
        function() {
            $.getJSON("http://localhost:9898/views/DataSpi/RRHH/Elegirspi", {
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un SPI.. </option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idspi').html(html);
        });
});



//función obtener value spi para filtrado en página general modal edit
$(document).ready(function(){
	$("#spiporzona2").change(function(){
		var zona2Value = $(this).children('option:selected').val();
		document.getElementById("idzona2").value = zona2Value;
	});
});


/////////////////////////////////////////////////////////////////////COMPARTIDO//////////////////////////
//limpiar form guardar
$('#saveModal').on('show.bs.modal', function (event) {
    $("#saveModal input").val('');
    $("#archivo").val('vacio_sdh.pdf');
    $("#saveModal select").val("");
    $("#saveModal textarea").val('');
    $("#saveModal small").val('');
    $("#Guardar").val("Guardar");
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
