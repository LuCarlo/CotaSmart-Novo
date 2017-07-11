<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Usuário</title>
	<c:import url="iniciarHead.jsp" />
</head>
<body>
	<c:import url="iniciarBody.jsp" />
	
<%-- 	<%@include file ="WebContent/ %> --%>
	<!-- Inicio do formulário -->
	<form class="centralizado" action="adicionaUsuario">
		<h5>Adicionar Usuário</h5>
		<!-- Nome -->
		<div class="input-field col s12">
			<input id="nome" type="text" name="nome" class="validate"> <label
				for="nome">Nome</label> <br />
		</div>
		<!-- Login -->
		<div class="input-field col s12">
			<input id="login" type="text" name="login" class="validate">
			<label for="login">Login</label>
		</div>
		<!-- Senha -->
		<div class="input-field col s12">
			<input id="senha" type="password" name="senha" class="validate">
			<label for="senha">Senha</label> <br />
		</div>
		<!-- Confirmar Senha -->
		<div class="input-field col s12">
			<input id="senha" type="password" name="senha" class="validate">
			<label for="senha">Confirmar Senha</label> <br />
		</div>
		<!-- Status -->
		<p>
			<input type="checkbox" id="status" /> <label for="status">Ativo</label>
		</p>
		<p>
			<!-- Grupo de usuário -->
			<script type="text/javascript">
				$(document).ready(function() {
					$('select').material_select();
				});
			</script>
		<div class="input-field col s12">
			<select>
				<option value="" disabled selected>Grupo do Usuário</option>
				<option value="1">Administrador</option>
				<option value="2">Fornecedor</option>
				<option value="3">Funcionário</option>
			</select>
		</div>
		<div class="centralizarTexto">
			<input class="waves-effect waves-light btn" type="submit"
				value="Salvar" />
		</div>


	</form>
</body>
</html>