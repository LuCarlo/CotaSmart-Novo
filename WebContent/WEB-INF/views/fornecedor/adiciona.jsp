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
				<td><select class="custom-select" name="uf">
						<option selected>UF</option>
						<option value="AC">AC</option>
						<option value="AL">AL</option>
						<option value="AM">AM</option>
						<option value="AP">AP</option>
						<option value="BA">BA</option>
						<option value="CE">CE</option>
						<option value="DF">DF</option>
						<option value="ES">ES</option>
						<option value="GO">GO</option>
						<option value="MA">MA</option>
						<option value="MG">MG</option>
						<option value="PA">PA</option>
						<option value="PB">PB</option>
						<option value="PE">PE</option>
						<option value="PI">PI</option>
						<option value="PR">PR</option>
						<option value="RJ">RJ</option>
						<option value="RN">RN</option>
						<option value="RO">RO</option>
						<option value="RS">RS</option>
						<option value="SP">SP</option>
						<option value="TO">TO</option>
				</select></td>
				<td><input type="text" class="form-control" name="cidade"
					required="required" placeholder="Cidade"
					style="text-transform: uppercase"></td>
			</tr>
		</table>
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
		<!-- 				Vincular usuário -->


		<div class="form-group">
			<label class="col-form-label" for="codUsuario">Vincular
				Usuário</label> <select class="custom-select" name="codUsuario">
				<c:forEach items="${usuarios}" var="usuario">
					<option value="${usuario.codUsuario}">${usuario.nome}</option>
				</c:forEach>
			</select>
		</div>







		<!-- 		<div class="alinhadoDireita"> -->

		<!-- 			<button type="button" class="btn btn-primary" data-toggle="modal" -->
		<!-- 				data-target="#listaUsuario">Vincular Usuário</button> -->

		<!-- 		</div> -->

		<div class="centralizarTexto">
			<input class="btn btn-success" type="submit" value="Salvar" /> <a
				href="listaFornecedor"><button type="button"
					class="btn btn-danger">Cancelar</button></a>
		</div>
	</form>

	<!-- 	Modal Usuários -->
	<!-- 	<div class="modal fade" id="listaUsuario" tabindex="-1" role="dialog" -->
	<!-- 		aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
	<!-- 		<div class="modal-dialog" role="document"> -->
	<!-- 			<div class="modal-content"> -->
	<!-- 				<div class="modal-header"> -->
	<!-- 					<h5 class="modal-title" id="exampleModalLabel">Vincular -->
	<!-- 						Usuário</h5> -->
	<!-- 					<button type="button" class="close" data-dismiss="modal" -->
	<!-- 						aria-label="Close"> -->
	<!-- 						<span aria-hidden="true">&times;</span> -->
	<!-- 					</button> -->
	<!-- 				</div> -->
	<!-- 				<div class="modal-body"> -->
	<!-- 					<table class="table table-striped"> -->

	<!-- 						<tr> -->
	<!-- 							<th scope="col">Vincular</th> -->
	<!-- 							<th scope="col">Usuário</th> -->
	<!-- 							<th scope="col">Nome</th> -->
	<!-- 						</tr> -->
	<%-- 						<c:forEach items="${usuarios}" var="usuario"> --%>
	<!-- 							<tr> -->
	<!-- 								<td><input type="radio" name="codUsuario" -->
	<%-- 									value="${usuario.codUsuario}"><br></td> --%>

	<%-- 								<td>${usuario.login}</td> --%>
	<%-- 								<td>${usuario.nome}</td> --%>
	<!-- 							</tr> -->
	<%-- 						</c:forEach> --%>
	<!-- 					</table> -->

	<!-- 				</div> -->
	<!-- 				<div class="modal-footer"> -->
	<!-- 					<button type="button" class="btn btn-secondary" -->
	<!-- 						data-dismiss="modal">Fechar</button> -->
	<!-- 					<button type="button" class="btn btn-success">Salvar</button> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
</body>
</html>