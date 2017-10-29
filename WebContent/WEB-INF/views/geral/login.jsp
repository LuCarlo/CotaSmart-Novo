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
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<script type="text/javascript" src="resources/js/funcao.js"></script>



<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<title>Login</title>
</head>
<body>

	<div class="wrapper">
		<form class="form-signin" action="efetuaLogin">
			<h2 class="form-signin-heading">Cota Smart</h2>
			<br /> <input type="text" class="form-control" name="login"
				placeholder="Login" required="" autofocus="" /> <br /> <input
				type="password" class="form-control" name="senha"
				placeholder="Senha" required="" /> <br />
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
	</div>
</body>
</html>