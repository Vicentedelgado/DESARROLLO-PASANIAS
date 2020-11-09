/**
 * FORMULARIO JS
 */

/*Cambio de color según prioridad en formulario*/
$(function() {
	$("table td:nth-child(7):contains(Baja)")
	.parents("tr")
    .css("background-color", "#d5e8d4");
	
	$("table td:nth-child(7):contains(Media)")
	.parents("tr")
    .css("background-color", "#fff2cc");
	
	$("table td:nth-child(7):contains(Alta)")
	.parents("tr")
    .css("background-color", "#f8cecc");
});

//////////////////////////////////////////////////////////////////////////////////
//función select dinámico página formulario
$('#spiporzonaformulario').change(
        function() {
            $.getJSON("http://localhost:9898/views/DataSpi/Formulario/Elegirspi", {
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un SPI...</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idspi').html(html);
        });
    });

//función obtener value spi para filtrado en página formulario
$(document).ready(function(){
	$("#idspi").change(function(){
		var spiValue = $(this).children('option:selected').val();
		$('#filtrarform').attr('action', $('#baseURL').val() + spiValue);
	});
});
/////////////////////////////////////////////////////////////////////////////

//función select dinámico página formulario por tipo
$('#filtrarportipo').change(
        function() {
            $.getJSON("http://localhost:9898/views/DataSpi/RegistroDelSpi/Elegiractivo", {
                idtipo : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un bien/servicio...</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idactivo + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idactivo1').html(html);
        });
});


///////////////////////////////////////////////////////////////////////////////

/*cambio de valores para la ventana modal editar y guardar en formulario */


/*REGISTRO DEL SPI*/
$(document).ready(function(){
	
$('.table .editModal2').on('click',function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	$.get(href,function(registrospi,status){
		$('.editar #idregistro').val(registrospi.idregistro);
		$('.editar #idactivo').val(registrospi.idactivo.idactivo);
		document.getElementById('idactivonombre').innerHTML=registrospi.idactivo.nombre;
		$('.editar #idspi').val(registrospi.idspi.idspi);
		$('.editar #idinstitucion').val(registrospi.idinstitucion.idinstitucion);
		$('.editar #estado').val(registrospi.estado);
		$('.editar #cantidad').val(registrospi.cantidad);
		$('.editar #cantidadrequerida').val(registrospi.cantidadrequerida);
		$('.editar #holguradecantidad').val(registrospi.holguradecantidad);
		$('.editar #prioridad').val(registrospi.prioridad);
		$('.editar #accionrealizada').val(registrospi.accionrealizada);
		$('.editar #periodo').val(registrospi.periodo);
		document.getElementById('periodonombre').innerHTML=registrospi.periodo;
		$('.editar #fechaaccion').val(registrospi.fechaaccion.substr(0,10));
		$('.editar #observaciones').val(registrospi.observaciones);
		$('.editar #archivo').val(registrospi.archivo);
	});
	
	$('.editar #editarModal2').modal();
});
});

$('#saveModal').on('show.bs.modal', function (event) {
    $("#saveModal input").val('');
    $("#archivo").val('vacio_sdh.pdf');
    $("#saveModal select").val("");
    $("#saveModal textarea").val('');
    $("#saveModal small").val('');
    $("#spi").val(document.getElementById("spi1").value);
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
