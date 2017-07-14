<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
<title>Empresas cadastradas</title>
</head>
<body>

	
	<div style="width: 1300px; height: 86px; margin-top: 35px; margin-left: 45px; ">
	<a href="novoFornecedor">Cadastrar Fornecedor</a>
	<table class="striped" >
		<tr>
			<th></th>
			<th>ID</th>
			<th>FORNECEDOR</th>
			<th>CNPJ</th>
			<th>ENDEREÇO</th>
			<th>CELULAR</th>
			<th>TELEFONE</th>
			<th>TELEFONE COMERCIAL</th>
			<th>EXCLUIR</th>
		</tr>
		<c:forEach items="${fornecedores}" var="fornecedor">
		<tr>
			<td><input type="checkbox"></td>
			<td>${fornecedor.codFornecedor}</td>
			<td><a href="mostraFornecedor?codFornecedor=${fornecedor.codFornecedor}">${fornecedor.nome}</a></td>
			<td>${fornecedor.cnpj}</td>
			<td>${fonecedor.endereco}</td>
			<td>${fornecedor.telefone1}</td>
			<td>${fornecedor.telefone2}</td>
			<td>${fornecedor.telefone3}</td>
			<td><a href="removeFornecedor?codFornecedor=${fornecedor.codFornecedor}">Remover</a>
				</td>
		</tr>
		</c:forEach>
	</table></div>

</body>
</html>