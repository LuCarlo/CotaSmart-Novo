<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Usuário</title>
<c:import url="../layout/iniciarHead.jsp" />
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />

	<!-- Inicio do formulário -->
	<form class="centralizadoFormulario" action="atualizarUsuario">
		<h5 class="centralizado">Alterar Usuário</h5>
		<!-- Nome -->
		<div class="form-group">
			<label class="col-form-label" for="nome">Nome</label> <input
				type="text" class="form-control" name="nome" required="required"
				value="${usuario.nome}">
		</div>
		<!-- Login -->
		<div class="form-group">
			<label class="col-form-label" for="login">Usuário</label> <input
				type="text" class="form-control" name="login" required="required"
				disabled value="${usuario.login}">
		</div>
		<div class="form-group">
			<input type="hidden" class="form-control" name="login"
				required="required" value="${usuario.login}">
		</div>

		<!-- Senha -->

		<div class="form-group">
			<label class="col-form-label" for="senha">Senha</label> <input
				type="password" class="form-control" name="senha"
				required="required" value="${usuario.senha}">
		</div>

		Grupo do Usuário <br>
		<div class="form-group">
			<select id="inputState" class="form-control" required="required">
				<option>Administrador</option>
				<option>Fornecedor</option>
			</select>
		</div>



		<div class="centralizarTexto">
			<input class="btn btn-success" type="submit" value="Salvar" /> <a
				href="listaUsuario"><button type="button" class="btn btn-danger">Cancelar</button></a>
		</div>

	</form>

</body>
</html>