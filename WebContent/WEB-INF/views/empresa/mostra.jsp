<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="../layout/iniciarHead.jsp" />
<title>Minha Empresa</title>
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />

	<!-- Inicio do formulário -->
	<form name="form" class="centralizadoFormulario"
		action="atualizaMinhaEmpresa" method="post">
		<h5 class="centralizarTexto">Minha Empresa</h5>
		<!-- Nome -->
		<div class="form-group">
			<label class="col-form-label" for="nome">Nome</label> <input
				type="text" class="form-control" name="nome" required="required"
				value="${empresa.nome}">
		</div>
		<!-- Endereço -->
		<div class="form-group">
			<label class="col-form-label" for="endereco">Endereço</label> <input
				type="text" class="form-control" name="endereco" required="required"
				value="${empresa.endereco}">
		</div>

		<table>
			<tr>
				<!-- Telefone 1 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone1">Telefone</label> <input
							type="text" class="form-control" name="telefone1"
							onKeyPress="MascaraTelefone(form.telefone1);" required="required"
							pattern=".{14,}" class="validate" maxlength="14"
							value="${empresa.telefone1}">
					</div>
				</td>
				<!-- Telefone 2 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone2">Telefone</label> <input
							type="text" class="form-control" name="telefone2"
							onKeyPress="MascaraTelefone(form.telefone2);" required="required"
							pattern=".{14,}" class="validate" maxlength="14"
							value="${empresa.telefone2}">
					</div>
				</td>
			</tr>
		</table>

		<!-- CNPJ -->
		<div class="form-group">
			<label class="col-form-label" for="cnpj">CNPJ</label> <input
				type="text" class="form-control" name="cnpj" required="required"
				pattern=".{15,}" class="validate" maxlength="18"
				onKeyPress="MascaraCNPJ(form.cnpj);" value="${empresa.cnpj}">
		</div>
		<div class="centralizarTexto">
			<input class="btn btn-success" type="submit" value="Salvar" /> <a
				href="listaFornecedor"><button type="button"
					class="btn btn-danger">Cancelar</button></a>
		</div>
	</form>

</body>
</html>