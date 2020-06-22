/**
 * 
 */
$('#spiporzona').change(
			        function() {
			            $.getJSON("http://localhost:9898/home/Elegirspi", {
			                idzona : $(this).val(),
			                ajax : 'true'
			            }, function(data) {
			                var html = '<option value="">-- Eligir Spi --</option>';
			                var len = data.length;
			                for ( var i = 0; i < len; i++) {
			                    html += '<option value="' + data[i].idspi + '">'
			                            + data[i].nombre +'</option>';
			                }
			                html += '</option>';
			                $('#idspi').html(html);
		            });
		        });

$('#spiporzonaformulario').change(
        function() {
            $.getJSON("http://localhost:9898/views/Formulario/Elegirspi", {
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">-- Eligir Spi --</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option th:value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idspi').html(html);
        });
    });

$(document).ready(function(){
	$('#miboton').click(function(){
		alert($('#spi').val());
	});
});

/*$(document).ready(function(){
	$("select[name=idspi]").change(function(){
		    alert($('#spi').val());
            $('input[name=valor1]').val($(this).val());
        });
	$("#idspi").change(function(){
		    alert($('#spi').val());
            $('#valor2').val($(this).val());
	});
	$(".ejemplo3").change(function(){
            alert($('select[class=ejemplo3]').val());
            $('.valor3').val($(this).val());
	});
});*/