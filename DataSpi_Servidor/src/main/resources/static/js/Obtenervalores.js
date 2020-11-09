/**
 * 
 */

/*SPI DATOS*/
$(document).ready(function(){
	
	$('.table .editModal1').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(spidatos,status){
			$('.editar #idspi').val(spidatos.idspi);
			$('.editar #nombre').val(spidatos.nombre);
			$('.editar #idzona').val(spidatos.idzona.idzona);
			$('.editar #idinstitucion').val(spidatos.idinstitucion.idinstitucion);
			$('.editar #direccion').val(spidatos.direccion);
			$('.editar #telefono').val(spidatos.telefono);
			$('.editar #numerodeoficina').val(spidatos.numerodeoficina);
			$('.editar #convenio').val(spidatos.convenio);
			$('.editar #daservicioa').val(spidatos.daservicioa);
			$('.editar #observaciones').val(spidatos.observaciones);
			$('.editar #fechafinconvenio').val(spidatos.fechafinconvenio.substr(0,10));
			$('.editar #archivo').val(spidatos.archivo);
				
		});
		
		$('.editar #editarModal1').modal();
	});
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
		document.getElementById('idspinombre').innerHTML=registrospi.idspi.nombre;
		$('.editar #idinstitucion').val(registrospi.idinstitucion.idinstitucion);
		$('.editar #estado').val(registrospi.estado);
		$('.editar #cantidad').val(registrospi.cantidad);
		$('.editar #cantidadrequerida').val(registrospi.cantidadrequerida);
		$('.editar #holguradecantidad').val(registrospi.holguradecantidad);
		$('.editar #prioridad').val(registrospi.prioridad);
		$('.editar #accionrealizada').val(registrospi.accionrealizada);
		$('.editar #periodo').val(registrospi.periodo);
		document.getElementById('periodoano').innerHTML=registrospi.periodo;
		$('.editar #fechaaccion').val(registrospi.fechaaccion.substr(0,10));
		$('.editar #observaciones').val(registrospi.observaciones);
		$('.editar #archivo').val(registrospi.archivo);
	});
	
	$('.editar #editarModal2').modal();
});
});


/*RRHH*/
$(document).ready(function(){
	
	$('.table .editModal3').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(rrhh,status){
			$('.editar #idusuario').val(rrhh.idusuario);
			$('.editar #nombres').val(rrhh.nombres);
			$('.editar #apellidos').val(rrhh.apellidos);
			$('.editar #cargo').val(rrhh.cargo);
			$('.editar #cedula').val(rrhh.cedula);
			$('.editar #idzona').val(rrhh.idzona.idzona);
			$('.editar #idspi').val(rrhh.idspi.idspi);
			$('.editar #cargo').val(rrhh.cargo);
			$('.editar #idmodalidad').val(rrhh.idmodalidad.idmodalidad);
			$('.editar #idunidad').val(rrhh.idunidad.idunidad);
			$('.editar #telefono').val(rrhh.telefono);
			$('.editar #email').val(rrhh.email);
			$('.editar #direccion').val(rrhh.direccion);
																	
		});
		
		$('.editar #editarModal3').modal();
	});
});




