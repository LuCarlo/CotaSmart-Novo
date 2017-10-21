<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuários Cadastrados</title>
<c:import url="../layout/iniciarHead.jsp" />
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />
	<h4 class="centralizado" style="text-align: center">Usuários
		Cadastrados</h4>

	<form class="alinhadoDireita" action="novoUsuario">
		<button type="submit" class="btn btn-primary btn-sm">Novo
			Usuário</button>
	</form>
	<div class="centralizado">
		<table class="table table-striped">
			<tr>
				<th scope="col">Usuário</th>
				<th scope="col">Nome</th>
				<th scope="col">Status</th>
				<th scope="col">Ação</th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.login}</td>
					<td>${usuario.nome}</td>
					<c:if test="${usuario.ativo eq true}">
						<td style="color: blue">Ativo</td>

					</c:if>
					<c:if test="${usuario.ativo eq false}">
						<td style="color: red">Inativo</td>

					</c:if>
					<td><a href="mostraUsuario?codUsuario=${usuario.codUsuario}"><button
								class="btn btn-primary">Alterar</button></a> <c:if
							test="${usuario.ativo eq true}">
							<a href="desativarUsuario?codUsuario=${usuario.codUsuario}"><button
									class="btn btn-danger">Desativar</button></a>
						</c:if> <c:if test="${usuario.ativo eq false}">
							<a href="ativarUsuario?codUsuario=${usuario.codUsuario}"><button
									class="btn btn-success">Ativar</button></a>

						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>