<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="../layout/iniciarHead.jsp" />
<title>Alterar Fornecedor</title>
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />

	<!-- Inicio do formul�rio -->
	<form name="form" class="centralizadoFormulario"
		action="alteraFornecedor" method="post">
		<h5 class="centralizarTexto">Alterar Fornecedor</h5>
		<br /> <input type="hidden" value="${fornecedores.codFornecedor}"
			name="codFornecedor" />
		<!-- Nome -->
		<div class="form-group">
			<label class="col-form-label" for="nome">Nome</label> <input
				type="text" class="form-control" name="nome" required="required"
				value="${fornecedores.nome}">
		</div>
		<!-- Endere�o -->
		<div class="form-group">
			<label class="col-form-label" for="endereco">Endere�o</label> <input
				type="text" class="form-control" name="endereco" required="required"
				value="${fornecedores.endereco}">
		</div>
		<table>
			<tr>
				<td><select class="custom-select" name="ufMostra" disabled>
						<option selected>${fornecedores.uf}</option>
				</select></td>
				<td><input type="text" class="form-control" name="cidadeMostra"
					disabled required="required" placeholder="${fornecedores.cidade}"
					style="text-transform: uppercase"></td>
			</tr>
		</table>
		<input type="hidden" value="${fornecedores.uf}" name="uf"> <input
			type="hidden" value="${fornecedores.cidade}" name="cidade">
		<table>
			<tr>
				<!-- Telefone 1 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone1">Celular</label> <input
							type="text" class="form-control" name="telefone1"
							onKeyPress="MascaraCelular(form.telefone1);" required="required"
							pattern=".{16,}" class="validate" maxlength="16"
							value="${fornecedores.telefone1}">
					</div>
				</td>
				<!-- Telefone 2 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone2">Telefone</label> <input
							type="text" class="form-control" name="telefone2"
							onKeyPress="MascaraTelefone(form.telefone2);" required="required"
							pattern=".{14,}" class="validate" maxlength="14"
							value="${fornecedores.telefone2}">
					</div>
				</td>
				<!-- Telefone 3 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone3">Telefone
							Comercial</label> <input type="text" class="form-control"
							name="telefone3" onKeyPress="MascaraTelefone(form.telefone3);"
							pattern=".{14,}" class="validate" maxlength="1"
							required="required" value="${fornecedores.telefone3}">
					</div>

				</td>
			</tr>
		</table>

		<!-- CNPJ -->
		<div class="form-group">
			<label class="col-form-label" for="cnpj">CNPJ</label> <input
				type="text" class="form-control" name="cnpj" required="required"
				pattern=".{15,}" class="validate" maxlength="18"
				onKeyPress="MascaraCNPJ(form.cnpj);" value="${fornecedores.cnpj}">
		</div>


		<div class="form-group">
			<label class="col-form-label" for="mostraUsuario">Usu�rio</label> <input
				type="text" class="form-control" name="mostraUsuario" disabled
				value="${fornecedores.nomeUsuario}">
		</div>

		<div class="centralizarTexto">
			<input class="btn btn-success" type="submit" value="Salvar" /> <a
				href="listaFornecedor"><button type="button"
					class="btn btn-danger">Cancelar</button></a>
		</div>
	</form>

</body>
</html>