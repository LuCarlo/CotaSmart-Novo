<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>


<title>Nova cotação</title>
<c:import url="../layout/iniciarHead.jsp" />

<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

</head>
<body>

	<script>
		function obterValor(nome) {
			var texto = $(nome).val();
			// 	var texto = 'teste';
			aler(texto);

		}
	</script>

	<c:import url="../layout/iniciarBody.jsp" />


	<form>
		<table class="table table-striped">
			<tr>
				<th scope="col">Produto</th>
				<th scope="col" style="text-align: center">Quantidade</th>
				<th scope="col">Ação</th>
			<tr>
				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td>${produto.nome}</td>
						<td style="text-align: center"><input type="text"
							name="quantidade_${produto.codProduto}" value="1"
							style="width: 50px; text-align: center"></td>

						<td><a
							href="adicionaProduto?codProduto=${produto.codProduto}&codCotacao=${cotacao.codCotacao}&quantidade=${produto.codProduto}"><input
								type="button" value="Selecionar" class="btn btn-info"></a></td>


					</tr>
				</c:forEach>
		</table>
	</form>
</body>
</html>