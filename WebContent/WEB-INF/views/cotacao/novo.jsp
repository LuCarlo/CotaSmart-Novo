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

	<c:import url="../layout/iniciarBody.jsp" />

	<h3 style="text-align: center">Selecione produtos para cotação</h3>

	<div class="form-group" style="width: 400px; align: center">
		<label class="col-form-label" for="produto">Pesquisar</label> <input
			type="text" class="form-control" name="produto"
			placeholder="Nome do produto">
	</div>
<!-- 	<div class="alinhadoDireita"> -->
<!-- 		<button class="btn btn-primary" style="margin-left: 20px">Ocultar -->
<!-- 			produtos</button> -->
<!-- 	</div> -->
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
							style="width: 50px; text-align: center">
							<select class="custom-select">
							<option>Unidade(s)</option>
							<option>Caixa(s)</option>
							<option>Fardo(s)</option>
							</select>
							
							</td>

						<td><a href="#"><input type="button" value="Selecionar"
								class="btn btn-info"></a></td>


					</tr>
				</c:forEach>
		</table>

		<h4 style="text-align: center">Produtos selecionados</h4>
		<div class="form-group" style="width: 400px; align: center">
			<label class="col-form-label" for="produto">Pesquisar</label> <input
				type="text" class="form-control" name="produto"
				placeholder="Nome do produto">
		</div>
<!-- 		<div class="alinhadoDireita"> -->
<!-- 			<button class="btn btn-primary" style="margin-left: 20px">Ocultar -->
<!-- 				produtos</button> -->
<!-- 		</div> -->
		<table class="table table-striped">
			<tr>
				<th scope="col">Produto</th>
				<th scope="col" style="text-align: center">Quantidade</th>
				<th scope="col">Ação</th>
			</tr>
			<tr>
				<td>Arroz</td>
				<td style="text-align: center">10 Fardo(s)</td>
				<td><a href="#"><input type="button" value="Remover"
						class="btn btn-danger"></a></td>
			</tr>
			<tr>
				<td>Açúcar</td>
				<td style="text-align: center">20 Fardo(s)</td>
				<td><a href="#"><input type="button" value="Remover"
						class="btn btn-danger"></a></td>
			</tr>
			<tr>
				<td>Biscoito</td>
				<td style="text-align: center">12 Caixa(s)</td>
				<td><a href="#"><input type="button" value="Remover"
						class="btn btn-danger"></a></td>
			</tr>
			<tr>
				<td>Detergente</td>
				<td style="text-align: center">21 Unidade(s)</td>
				<td><a href="#"><input type="button" value="Remover"
						class="btn btn-danger"></a></td>
			</tr>
			<tr>
				<td>Macarrão</td>
				<td style="text-align: center">25 Unidade(s)</td>
				<td><a href="#"><input type="button" value="Remover"
						class="btn btn-danger"></a></td>
			</tr>
			<tr>
				<td>Sabonete</td>
				<td style="text-align: center">30 Caixa(s)</td>
				<td><a href="#"><input type="button" value="Remover"
						class="btn btn-danger"></a></td>
			</tr>



		</table>
		<div style="text-align: center">
			<button class="btn btn-success">Concluir</button>
		</div>

	</form>
</body>
</html>