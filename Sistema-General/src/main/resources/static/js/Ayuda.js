
$(document).ready(function(){
	document.getElementById("idper").value = document.getElementById("idper1").value;
		
});
$(document).ready(function(){
	document.getElementById("idequ").value = document.getElementById("idequ1").value;
		
});

///////////////////////////////////////////////////////////////////
$(document).ready(function(){
	$("#idced").change(function(){	
		var cedula = $(this).val();
		$('#filtrar').attr('href', $('#baseURL').val() + cedula);
		
		
	});
});
///////////////////////////////////////////////////////////////////

$(document).ready(function(){
	$("#idcedula").change(function(){	
		var cedula = $(this).val();
		$('#filtrar').attr('href', $('#baseURL').val() + cedula);
	});
});


/*MODAL*/
$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
	
	
/*BUSQUEDA FUNCIONARIO*/
	
	    $(document).ready(function () {
        $('#tablabusqueda').DataTable({
            language: {
            	   processing: "Tratamiento en curso...",
                   search: "Buscar Funcionario&nbsp;:",
                   lengthMenu: "Agrupar de _MENU_ Funcionario",
                   info: "Funcionario _START_ al _END_ de un total de _TOTAL_ Funcionarios",
                   infoEmpty: "No existen datos.",
                   infoFiltered: "(filtrado de _MAX_ elementos en total)",
                   infoPostFix: "",
                   loadingRecords: "Cargando...",
                   zeroRecords: "No se encontraron datos con tu busqueda",
                   emptyTable: "No hay datos disponibles en la tabla.",
                   paginate: {
   
                       previous: "Anterior",
                       next: "Siguiente",
                       
                   },
            },
            lengthMenu: [ [5, 10, -1], [5, 10, "All"] ],
        });
    });

/*BUSQUEDA PERIFÉRICO */


$(document).ready(function () {
    $('#tablaperiferico').DataTable({
        language: {
        	   processing: "Tratamiento en curso...",
               search: "Buscar Periférico&nbsp;:",
               lengthMenu: "Agrupar de _MENU_ Funcionario",
               info: "Periférico _START_ al _END_ de un total de _TOTAL_ Periféricos",
               infoEmpty: "No existen datos.",
               infoFiltered: "(filtrado de _MAX_ elementos en total)",
               infoPostFix: "",
               loadingRecords: "Cargando...",
               zeroRecords: "No se encontraron datos con tu busqueda",
               emptyTable: "No hay datos disponibles en la tabla.",
               paginate: {

                   previous: "Anterior",
                   next: "Siguiente",
                   
               },
        },
        lengthMenu: [ [5, 10, -1], [5, 10, "All"] ],
    });
});

/*BUSQUEDA FUNCIONARIO*/


$(document).ready(function () {
    $('#tablafuncionario').DataTable({
        language: {
        	   processing: "Tratamiento en curso...",
               search: "Buscar Funcionario&nbsp;:",
               lengthMenu: "Agrupar de _MENU_ Funcionario",
               info: "Funcionario _START_ al _END_ de un total de _TOTAL_ Funcionarios",
               infoEmpty: "No existen datos.",
               infoFiltered: "(filtrado de _MAX_ elementos en total)",
               infoPostFix: "",
               loadingRecords: "Cargando...",
               zeroRecords: "No se encontraron datos con tu busqueda",
               emptyTable: "No hay datos disponibles en la tabla.",
               paginate: {

                   previous: "Anterior",
                   next: "Siguiente",
                   
               },
        },
        lengthMenu: [ [5, 10, -1], [5, 10, "All"] ],
    });
});


/*BUSQUEDA EQUIPO*/

$(document).ready(function () {
    $('#tablaequipo').DataTable({
        language: {
        	   processing: "Tratamiento en curso...",
               search: "Buscar Equipo&nbsp;:",
               lengthMenu: "Agrupar de _MENU_ Funcionario",
               info: "Equipo _START_ al _END_ de un total de _TOTAL_ Equipos",
               infoEmpty: "No existen datos.",
               infoFiltered: "(filtrado de _MAX_ elementos en total)",
               infoPostFix: "",
               loadingRecords: "Cargando...",
               zeroRecords: "No se encontraron datos con tu busqueda",
               emptyTable: "No hay datos disponibles en la tabla.",
               paginate: {

                   previous: "Anterior",
                   next: "Siguiente",
                   
               },
        },
        lengthMenu: [ [5, 10, -1], [5, 10, "All"] ],
    });
});

////////////////////////////////////////////////////////////////////////////

/* TABLA PERIFERICO */


    $(document).ready(function () {
        $('#tablaperiferico1').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Periféricos&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Periféricos",
                info: "Mostrando del Periférico _START_ al _END_ de un total de _TOTAL_ Periféricos",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
            },
        });
    });

//////////////////////////////////////////////////
/*SOFTWARE*/
 $(document).ready(function () {
        $('#tablasoftware').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Software&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Software",
                info: "Mostrando del Software _START_ al _END_ de un total de _TOTAL_ Software",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
            },
        });
    });


///////////////////////////////////////////////////////////////////////////////////
/*EQUIPO*/

$(document).ready(function () {
        $('#equipo1').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Equipo&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Equipo",
                info: "Mostrando del Equipo _START_ al _END_ de un total de _TOTAL_ Equipo",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
                
            },
            
        });
    });


//////////////////////////////////////////////////////////////////////////////

/*INFORME EQUIPO*/

 $(document).ready(function () {
        $('#tablainfoequi').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Informe de Equipo&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Equipo",
                info: "Mostrando del Informe _START_ al _END_ de un total de _TOTAL_ Informe",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
            },
        });
    });
/*INFORME PERIFERICOS*/

 $(document).ready(function () {
        $('#tablainfoper').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Informe de Periférico&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Periférico",
                info: "Mostrando del Informe _START_ al _END_ de un total de _TOTAL_ Informe",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
            },
        });
    });
/////////////////////////////////////////////////////////////////////////

/*LISTAR PERIFERICO*/

 $(document).ready(function () {
        $('#tablalistarperi').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Software&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Software",
                info: "Mostrando del Software _START_ al _END_ de un total de _TOTAL_ Software",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
            },
        });
    });

//////////////////////////////////////////////////////////////////////////////////////

/*TABLA ASIGNACION PERIFERICO*/

 $(document).ready(function () {
        $('#tablainfoperi').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Asignacion Periférico&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Asignacion",
                info: "Mostrando de la Asignacion _START_ al _END_ de un total de _TOTAL_ Periféricos Asignados",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
            },
        });
    });

/////////////////////////////////////////////////////////////////////////////////////////////////////////

//ASIGNACION EQUIPO
$(document).ready(function () {
        $('#tablalistequipo').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar Asignacion Equipo&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ Asignacion",
                info: "Mostrando dela Asignacion _START_ al _END_ de un total de _TOTAL_ Asignacion",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
            },
        });
    });
 