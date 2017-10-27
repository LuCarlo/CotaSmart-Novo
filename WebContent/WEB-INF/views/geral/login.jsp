<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">


<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<script type="text/javascript" src="js/funcao.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>
</head>
<body>

	<form class="centralizarLogin">
		<div class="form-group">
			<label for="login">Login</label> <input
				type="text" class="form-control" id="login"
				aria-describedby="emailHelp" placeholder="Usuário"> <small
				id="emailHelp" class="form-text text-muted">Não compartilhe seu usuário com ninguém.</small>
		</div>
		<div class="form-group">
			<label for="senha">Senha</label> <input
				type="password" class="form-control" id="senha"
				placeholder="Senha">
		</div>
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input"> lembrar-me
			</label>
		</div>
		<button type="submit" class="btn btn-primary">Entrar</button>
	</form>
</body>
</html>