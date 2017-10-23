<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:import url="../layout/iniciarHead.jsp" />
<title>Empresas cadastradas</title>
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />

	<div class="centralizadoFornecedor">
		<form class="alinhadoDireita" action="novoFornecedor">
			<button type="submit" class="btn btn-info">Novo Fornecedor</button>
		</form>
		<table class="table table-striped">
			<tr>
				<th>Fornecedor</th>
				<th>CNPJ</th>
				<th>Endereço</th>
				<th>Celular</th>
				<th>Telefone</th>
				<th>Telefone Comercial</th>
				<th>Status</th>
				<th>Ação</th>
			</tr>
			<c:forEach items="${fornecedores}" var="fornecedor">
				<tr>
					<td style="width: 250px">${fornecedor.nome}</td>
					<td>${fornecedor.cnpj}</td>
					<td><button type="button" class="btn btn-info"
							data-toggle="modal" data-target="#${fornecedor.codFornecedor}">Detalhes</button></td>
					<td>${fornecedor.telefone1}</td>
					<td>${fornecedor.telefone2}</td>
					<td>${fornecedor.telefone3}</td>
					<c:if test="${fornecedor.ativo eq true}">
						<td style="color: blue">Ativo</td>

					</c:if>
					<c:if test="${fornecedor.ativo eq false}">
						<td style="color: red">Inativo</td>

					</c:if>
					<td><a
						href="mostraFornecedor?codFornecedor=${fornecedor.codFornecedor}"><button
								class="btn btn-primary">Alterar</button></a> <c:if
							test="${fornecedor.ativo eq true}">
							<a href="desativaFornecedor?codFornecedor=${fornecedor.codFornecedor}"><button
									class="btn btn-danger">Desativar</button></a>
						</c:if> <c:if test="${fornecedor.ativo eq false}">
							<a href="ativaFornecedor?codFornecedor=${fornecedor.codFornecedor}"><button
									class="btn btn-success">Ativar</button></a>
						</c:if></td>
					<!-- Modal -->
					<div class="modal fade" id="${fornecedor.codFornecedor}"
						tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Endereço:
										${fornecedor.nome}</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">${fornecedor.endereco}</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Fechar</button>
								</div>
							</div>
						</div>
					</div>
				</tr>
			</c:forEach>
		</table>
	</div>



</body>
</html>