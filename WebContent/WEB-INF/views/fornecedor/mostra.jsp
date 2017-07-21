<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/estilo.css">
<c:import url="../layout/iniciarHead.jsp" />
<title>Alterar Fornecedor</title>
</head>
<body>

	<c:import url="../layout/iniciarBody.jsp" />
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<h5>Alterar Forncedor - ${fornecedores.codFornecedor}</h5>
	<form  name="form" class="centralizado" action="alteraFornecedor" method="post">
	
	<input type="hidden" name="codFornecedor" value="${fornecedores.codFornecedor}" />
	<h5 class="centralizarTexto">Alterar Fornecedor</h5>
		<br />
		<!-- Nome -->
		<div class="input-field col s12">
			<input type="text" name="nome" value="${fornecedores.nome}" required="required" class="validate">
			<label for="nome">Nome da Empresa</label> <br />
		</div>
		<!-- Endereço -->
		<div class="input-field col s12">
			<input id="endereco" type="text" name="endereco" value="${fornecedores.endereco}"required="required"
				class="validate"> <label for="nome">Endereço</label> <br />
		</div>

		<table>
			<tr>
				<!-- Telefone 1 -->
				<td><div class="input-field col s12">
						<input name="tel1" value="${fornecedores.telefone1}" type="tel" pattern=".{15,}" class="validate"
							maxlength="15" onKeyPress="MascaraTelefone(form.tel1);">
						<label for="tel1">Celular</label> <br />
					</div></td>
				<!-- Telefone 2 -->
				<td>
					<div class="input-field col s12">
						<input name="tel2" value="${fornecedores.telefone2}"type="tel" pattern=".{15,}" class="validate"
							maxlength="15" onKeyPress="MascaraTelefone(form.tel2);">
						<label for="tel2">Telefone</label> <br />
					</div>
				</td>
				<!-- Telefone 3 -->
				<td>
					<div class="input-field col s12">
						<input name="tel3" value="${fornecedores.telefone3}"type="tel" pattern=".{15,}" class="validate"
							maxlength="15" onKeyPress="MascaraTelefone(form.tel3);">
						<label for="tel3">Telefone Comercial</label> <br />
					</div>

				</td>
			</tr>
		</table>

		<!-- CNPJ -->
		<div class="input-field col s12">
			<input name="cnpj" value="${fornecedores.cnpj}"type="text" pattern=".{15,}" class="validate"
				maxlength="18" onKeyPress="MascaraCNPJ(form.cnpj);"> <label
				for="cnpj">CNPJ</label> <br />
		</div>
		<!-- Status -->
		<p>
			<input type="checkbox" id="status" /> <label for="status">Ativo</label>
		</p>
		<p>
		<div class="centralizarTexto">
			<input class="waves-effect waves-light btn" type="submit"
				value="Salvar" />
		</div>
	
		</form>
	
	
	

	
</html>