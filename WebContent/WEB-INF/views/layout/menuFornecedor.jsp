<nav class="navbar navbar-expand-lg navbar-light"
	style="background-color: #563d7c;">

	<img width="50px" height="50px"
		src="resources/imagens/logo_sem_texto.png" />
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
	</div>
	<div>
		<h5 style="color: white">Olá, ${usuarioLogado.nome}</h5>
	</div>
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	<form class="form-inline" action="logout">


		<a href="logout"><img width="50px" height="50px"
				src="resources/imagens/logout.png" /></a>
	</form>
</nav>