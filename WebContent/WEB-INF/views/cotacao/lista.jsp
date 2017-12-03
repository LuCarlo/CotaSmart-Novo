<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cotações</title>
<c:import url="../layout/iniciarHead.jsp" />
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />


	<div class=centralizado>
		<c:if test="${usuarioLogado.administrador eq true}">
			<div class="alinhadoDireita">
				<a href="novaCotacao"><button class="btn btn-info" type="button">Iniciar
						nova cotação</button> </a>
			</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th>Data</th>
				<th>Valor Total</th>
				<th>Situação</th>
				<th>Status</th>

				<th>Data Finalização</th>
			</tr>
			<c:forEach items="${cotacoes}" var="cotacao">
				<tr>
					<td>11/12/2017</td>
					<td>R$ ${cotacao.valorTotal}</td>
					<c:if test="${cotacao.finalizado eq true}">
						<td style="color: red">Finalizado</td>
					</c:if>
					<c:if test="${cotacao.finalizado eq false}">
						<td style="color: blue"><a href="informarValorProdutos">Em Aberto</a></td>
					</c:if>
					<c:if test="${cotacao.ativo eq true}">
						<td style="color: blue">Ativo </td>
					</c:if>
					<c:if test="${cotacao.ativo eq false}">
						<td style="color: red">Inativo</td>
					</c:if>
					<td>${cotacao.dataFinalizacao}</td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>