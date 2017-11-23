
<%@ attribute name="id" required="true"%>
<script type="text/javascript">
	$(function() {
		$("#${id}").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					// 					"changeYear" : true,
					// 					"changeMonth" : true,
					showOn : "button",
					buttonImage : "resources/imagens/calendario.png",
					buttonImageOnly : true,

					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Próximo',
					prevText : 'Anterior'

				});
	});
</script>
<input type="text" id="${id}" name="${id}"
	style="width: 100px; text-align: center" onkeypress="MascaraData(${id});" />
