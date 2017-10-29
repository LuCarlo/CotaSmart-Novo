<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:import url="../layout/iniciarHead.jsp" />
<title>Lista de Produtos</title>
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />
	<div class="centralizado">
		<form class="alinhadoDireita">
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#novoProduto">Novo Produto</button>
		</form>
		<table class="table table-striped">
			<tr>
				<th>Nome</th>
				<th>Código de Barras</th>
				<th>Status</th>
				<th>Ação</th>
			</tr>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.codBarras}</td>
					<c:if test="${produto.ativo eq true}">
						<td style="color: blue">Ativo</td>
					</c:if>
					<c:if test="${produto.ativo eq false}">
						<td style="color: red">Inativo</td>

					</c:if>
					<td>
						<button type="button" class="btn btn-info" data-toggle="modal"
							data-target="#${produto.codProduto}">Alterar</button> <c:if
							test="${produto.ativo eq true}">
							<a href="desativaProduto?codProduto=${produto.codProduto}"><button
									class="btn btn-danger">Desativar</button></a>
						</c:if> <c:if test="${produto.ativo eq false}">
							<a href="ativaProduto?codProduto=${produto.codProduto}"><button
									class="btn btn-success">Ativar</button></a>
						</c:if>
					</td>
				</tr>
				<!-- Modal Alterar Produto -->
				<form action="alteraProduto">

					<div class="modal fade" id="${produto.codProduto}" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Alterar
										Produto</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="novoProduto">
										<div class="form-group">
											<label class="col-form-label" for="nome">Nome</label> <input
												type="text" class="form-control" name="nome"
												required="required" value="${produto.nome}">
										</div>
										<input type="hidden" value="${produto.codProduto}"
											name="codProduto" />
										<div class="form-group">
											<label class="col-form-label" for="codBarras">Código
												de Barras</label> <input type="text" class="form-control"
												name="codBarras" value="${produto.codBarras}">
										</div>
										<div style="text-align: center">
											<button class="btn btn-success" type="submit">Salvar</button>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Fechar</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</table>
	</div>
	<!-- Modal Novo Produto -->
	<div class="modal fade" id="novoProduto" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Novo Produto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="novoProduto">
						<div class="form-group">
							<label class="col-form-label" for="nome">Nome</label> <input
								type="text" class="form-control" name="nome" required="required"
								placeholder="Ex: Arroz">
						</div>
						<div class="form-group">
							<label class="col-form-label" for="codBarras">Código de
								Barras</label> <input type="text" class="form-control" name="codBarras"
								placeholder="000000000">
						</div>
						<div style="text-align: center">
							<button class="btn btn-success" type="submit">Salvar</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>