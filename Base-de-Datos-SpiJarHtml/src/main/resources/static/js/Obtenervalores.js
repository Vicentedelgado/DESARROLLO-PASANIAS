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
		document.getElementById('idinstitucionnombre').innerHTML=registrospi.idinstitucion.nombre;
		$('.editar #estado').val(registrospi.estado);
		$('.editar #cantidad').val(registrospi.cantidad);
		$('.editar #cantidadrequerida').val(registrospi.cantidadrequerida);
		$('.editar #holguradecantidad').val(registrospi.holguradecantidad);
		$('.editar #prioridad').val(registrospi.prioridad);
		$('.editar #accionrealizada').val(registrospi.accionrealizada);
		$('.editar #periodo').val(registrospi.periodo);
		var fecha=new Date(registrospi.fechaaccion);
		$('.editar #fechaaccion').val(fecha);
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
			$('.editar #cedula').val(rrhh.cedula);
			$('.editar #idzona').val(rrhh.idzona.idzona);
			$('.editar #idspi').val(rrhh.idspi.idspi);
			$('.editar #cargo').val(rrhh.cargo);
			$('.editar #estado').val(rrhh.estado);
			$('.editar #unidad').val(rrhh.unidad);
			$('.editar #telefono').val(rrhh.telefono);
			$('.editar #email').val(rrhh.email);
			$('.editar #direccion').val(rrhh.direccion);
																	
		});
		
		$('.editar #editarModal3').modal();
	});
});




