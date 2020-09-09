/**
 * 
 */
//funcion select dinámico página home
$('#spiporzona').change(
			        function() {
			            $.getJSON("http://localhost:9898/home/Elegirspi", {
			                idzona : $(this).val(),
			                ajax : 'true'
			            }, function(data) {
			                var html = '<option value="">-- Eligir un SPI --</option>';
			                var len = data.length;
			                for ( var i = 0; i < len; i++) {
			                    html += '<option value="' + data[i].idspi + '">'
			                            + data[i].nombre +'</option>';
			                }
			                html += '</option>';
			                $('#idspi').html(html);
		            });
		        });

//función select dinámico página formulario
$('#spiporzonaformulario').change(
        function() {
            $.getJSON("http://localhost:9898/views/Formulario/Elegirspi", {
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">-- Eligir un SPI --</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idspi').html(html);
        });
    });

//función obtener value spi para filtrado en página home y página formulario
$(document).ready(function(){
	$("#idspi").change(function(){
		var spiValue = $(this).children('option:selected').val();
		$('#filtrar').attr('href', $('#baseURL').val() + spiValue);
	});
});


//Función de alerta 

/*$(document).ready(function(){
$('#miboton').click(function(){
	alert($('#spi').val());
});
});*/