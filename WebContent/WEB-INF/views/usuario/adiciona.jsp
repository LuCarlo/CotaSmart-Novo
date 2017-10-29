<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Usuário</title>
<c:import url="../layout/iniciarHead.jsp" />
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />
	<!-- Inicio do formulário -->
	<form class="centralizadoFormulario" action="adicionaUsuario">
		<h5 class="centralizado">Adicionar Usuário</h5>
		<!-- Nome -->
		<div class="form-group">
			<label class="col-form-label" for="nome">Nome</label> <input
				type="text" class="form-control" name="nome" required="required"
				placeholder="Ex: José da Silva">
		</div>
		<!-- Login -->
		<div class="form-group">
			<label class="col-form-label" for="login">Usuário</label> <input
				type="text" class="form-control" name="login" required="required"
				placeholder="Ex: zezinho">
		</div>
		<!-- Senha -->

		<div class="form-group">
			<label class="col-form-label" for="senha">Senha</label> <input
				type="password" class="form-control" name="senha"
				required="required" placeholder="Ex: 123456">
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