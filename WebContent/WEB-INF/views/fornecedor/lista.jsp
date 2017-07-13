<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Empresas cadastradas</title>
</head>
<body>
<a href="novoFornecedor">Cadastrar Fornecedor</a>
	<table border=1;>
		<tr>
			<th>ID</th>
			<th>FORNECEDOR</th>
			<th>CNPJ</th>
			<th>ENDEREÇO</th>
			<th>CELULAR</th>
			<th>TELEFONE</th>
			<th>TELEFONE COMERCIAL</th>
			<th>EXCLUIR/ALTERAR</th>
		</tr>
		<c:forEach items="${fornecedores}" var="fornecedor">
		<tr>
			<td>${fornecedor.codFornecedor}</td>
			<td>${fornecedor.nome}</td>
			<td>${fornecedor.cnpj}</td>
			<td>${fonecedor.endereco}</td>
			<td>${fornecedor.telefone1}</td>
			<td>${fornecedor.telefone2}</td>
			<td>${fornecedor.telefone3}</td>
			<td><a href="removeFornecedor?codfornecedor=${fornecedor.codFornecedor}">Remover</a>
				<a href="mostraFornecedor?codfornecedor=${fornecedor.codFornecedor}">Alterar</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>