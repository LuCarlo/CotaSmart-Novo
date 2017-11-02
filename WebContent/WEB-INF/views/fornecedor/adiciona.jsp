<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="../layout/iniciarHead.jsp" />
<title>Adicionar Fornecedor</title>

</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />

	<!-- Inicio do formulário -->
	<form name="form" class="centralizadoFormulario"
		action="adicionaFornecedor" method="post">
		<h5 class="centralizarTexto">Cadastrar Fornecedor</h5>
		<br />
		<!-- Nome -->
		<div class="form-group">
			<label class="col-form-label" for="nome">Nome</label> <input
				type="text" class="form-control" name="nome" required="required"
				placeholder="Ex: Empresa do fulano">
		</div>
		<!-- Endereço -->
		<div class="form-group">
			<label class="col-form-label" for="endereco">Endereço</label> <input
				type="text" class="form-control" name="endereco" required="required"
				placeholder="Ex: Quadra 10">
		</div>
		<table>
			<tr>
				<!-- Telefone 1 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone1">Celular</label> <input
							type="text" class="form-control" name="telefone1"
							onKeyPress="MascaraCelular(form.telefone1);" required="required"
							pattern=".{16,}" class="validate" maxlength="16"
							placeholder="(00) 0 0000-0000">
					</div>
				</td>
				<!-- Telefone 2 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone2">Telefone</label> <input
							type="text" class="form-control" name="telefone2"
							onKeyPress="MascaraTelefone(form.telefone2);" required="required"
							pattern=".{14,}" class="validate" maxlength="14"
							placeholder="(00) 0000-0000">
					</div>
				</td>
				<!-- Telefone 3 -->
				<td>
					<div class="form-group">
						<label class="col-form-label" for="telefone3">Telefone
							Comercial</label> <input type="text" class="form-control"
							name="telefone3" onKeyPress="MascaraTelefone(form.telefone3);"
							pattern=".{14,}" class="validate" maxlength="14"
							required="required" placeholder="(00) 0000-0000">
					</div>

				</td>
			</tr>
		</table>

		<!-- CNPJ -->
		<div class="form-group">
			<label class="col-form-label" for="cnpj">CNPJ</label> <input
				type="text" class="form-control" name="cnpj" required="required"
				pattern=".{15,}" class="validate" maxlength="18"
				onKeyPress="MascaraCNPJ(form.cnpj);"
				placeholder="00.000.000/0000-00">
		</div>
		<div class="centralizarTexto">
			<input class="btn btn-success" type="submit" value="Salvar" /> <a
				href="listaFornecedor"><button type="button"
					class="btn btn-danger">Cancelar</button></a>
		</div>
	</form>
</body>
</html>