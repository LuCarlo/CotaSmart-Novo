<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar usuário</title>
<c:import url="../layout/iniciarHead.jsp" />
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />
	<form class="centralizado" action="atualizarUsuario">
		<input type="hidden" name="codUsuario" value="${usuario.codUsuario}" />
		Usuário:<br /> <input name="nome" type="text" value="${usuario.nome}"><br />
		<br /> Login:<br /> <input name="login" type="text"
			value="${usuario.login}" disabled="disabled"><br /> <br />
		Senha:<br /> <input name="senha" type="password"
			value="${usuario.senha}"><br /> <br />
		<p>
			<input type="checkbox" name="status" /> <label for="status">Ativo</label>
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


		<div style="text-align: center">
			<button class="waves-effect waves-light btn" type="submit">Salvar</button>

		</div>
	</form>
	<form action="listaUsuario">
		<div style="text-align: center">
			<button onClick="voltar();">Cancelar</button>
		</div>
	</form>
</body>
</html>