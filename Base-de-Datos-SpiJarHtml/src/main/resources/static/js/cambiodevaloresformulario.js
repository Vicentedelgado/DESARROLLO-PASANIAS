/**
 * 
 */
/*Cambio de color según prioridad en formulario*/
$(function() {
	$("table td:nth-child(5):contains(Baja)")
	.parents("tr")
    .css("background-color", "#d5e8d4");
	
	$("table td:nth-child(5):contains(Media)")
	.parents("tr")
    .css("background-color", "#fff2cc");
	
	$("table td:nth-child(5):contains(Alta)")
	.parents("tr")
    .css("background-color", "#f8cecc");
});

//función select dinámico página formulario por tipo
$('#filtrarportipo').change(
        function() {
            $.getJSON("http://localhost:9898/views/Formulario/Elegiractivo", {
                idtipo : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">-- Elija un activo --</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idactivo + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idactivo1').html(html);
        });
});

//función obtener value activo en formulario
$(document).ready(function(){
	$("#idactivo1").change(function(){
		var activoValue = $(this).children('option:selected').val();
		document.getElementById("idactivo2").value = activoValue;
	});
});

/*cambio de valores para la ventana modal editar y guardar en formulario */
$(document).ready(function(){
	document.getElementById("spi").value = document.getElementById("spi1").value;
	document.getElementById("spi2").value = document.getElementById("spi3").value;
	document.getElementById("idinstitucion1").value = document.getElementById("idinstitucion2").value;
	document.getElementById("idinstitucion3").value = document.getElementById("idinstitucion4").value;
		
});

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
	    var fecha = registrospi.fechaaccion;     
		$('.editar #fechaaccion').val(fecha);
	});
	
	$('.editar #editarModal2').modal();
});
});
