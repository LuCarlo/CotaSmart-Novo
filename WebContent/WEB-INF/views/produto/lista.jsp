<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:import url="../layout/iniciarHead.jsp" />
<title>Insert title here</title>
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />
	<div class="centralizado">
		<button type="button" class="btn btn-info" data-toggle="modal"
			data-target="#novoProduto">Novo Produto</button>
		<table class="table table-striped">
			<tr>
				<th>Nome</th>
				<th>Status</th>
				<th>Ação</th>
			</tr>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.nome}</td>
					<c:if test="${produto.ativo eq true}">
						<td style="color: blue">Ativo</td>

					</c:if>
					<c:if test="${produto.ativo eq false}">
						<td style="color: red">Inativo</td>

					</c:if>
					<td><a href="mostraProduto?codProduto=${produto.codProduto}"><button
								class="btn btn-primary">Alterar</button></a> <c:if
							test="${usuario.ativo eq true}">
							<a href="desativarProduto?codProduto=${produto.codProduto}"><button
									class="btn btn-danger">Desativar</button></a>
						</c:if> <c:if test="${usuario.ativo eq false}">
							<a href="ativarUsuario?codProduto=${produto.codProduto}"><button
									class="btn btn-success">Ativar</button></a>
						</c:if></td>
				</tr>
			</c:forEach>


		</table>
	</div>

	<!-- Modal -->
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
					<div class="form-group">
						<label class="col-form-label" for="nome">Nome</label> <input
							type="text" class="form-control" name="nome" required="required"
							placeholder="Ex: Arroz">
					</div>






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