/**
 * 
 */
$(document).ready(function(){
	
	$('.table .editModal').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(spidatos,status){
			$('.editar #idspi').val(spidatos.idspi);
			$('.editar #nombre').val(spidatos.nombre);
			$('.editar #idzona option[value="'+spidatos.idzona+'"]').attr("selected","selected");
			$('.editar #idinstitucion').val(spidatos.idinstitucion);
			$('.editar #direccion').val(spidatos.direccion);
			$('.editar #telefono').val(spidatos.telefono);
			$('.editar #numerodeoficina').val(spidatos.numerodeoficina);
			$('.editar #convenio').val(spidatos.convenio);
			$('.editar #daservicioa').val(spidatos.daservicioa);
			$('.editar #observaciones').val(spidatos.observaciones);
			
			$('.editar #idusuario').val(spidatos.idusuario);
			$('.editar #nombres').val(spidatos.nombres);
			$('.editar #apellidos').val(spidatos.apellidos);
			$('.editar #cedula').val(spidatos.cedula);
			$('.editar #cargo').val(spidatos.cargo);
			$('.editar #estado').val(spidatos.estado);
			$('.editar #unidad').val(spidatos.unidad);
			$('.editar #email').val(spidatos.email);
			
			$('.editar #idregistro').val(spidatos.idregistro);
			$('.editar #idactivo').val(spidatos.idactivo);
			$('.editar #cantidad').val(spidatos.cantidad);
			$('.editar #cantidadrequerida').val(spidatos.cantidadrequerida);
			$('.editar #holguradecantidad').val(spidatos.holguradecantidad);
			$('.editar #prioridad').val(spidatos.prioridad);
			$('.editar #accionrealizada').val(spidatos.accionrealizada);
			$('.editar #periodo').val(spidatos.periodo);
			$('.editar #fechaaccion').val(spidatos.fechaaccion);
		});
		
		$('.editar #editarModal').modal();
	});
});