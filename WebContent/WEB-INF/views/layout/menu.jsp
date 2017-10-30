<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark">  style="background-color:#B5B5B5 " -->
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
		<!-- 		<ul class="navbar-nav"> -->
		<ul class="navbar-nav bd-navbar-nav flex-row">
			<li class="nav-item active"><a class="nav-link" href="inicio"
				style="color: white;">Início <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navCotacao"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
				style="color: white;"> Cotação </a>
				<div class="dropdown-menu" aria-labelledby="navCotacao">
					<a class="dropdown-item" href="listaCotacoes">Listar</a> <a
						class="dropdown-item" href="#">Novo</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navFornecedor"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
				style="color: white;"> Fornecedores </a>
				<div class="dropdown-menu" aria-labelledby="navFornecedor">
					<a class="dropdown-item" href="listaFornecedor">Listar</a> <a
						class="dropdown-item" href="novoFornecedor">Novo</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navProdutos"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
				style="color: white;"> Produtos </a>
				<div class="dropdown-menu" aria-labelledby="navProdutos">
					<a class="dropdown-item" href="listaProduto">Listar</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navUsuario"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
				style="color: white;"> Usuários </a>
				<div class="dropdown-menu" aria-labelledby="navUsuario">
					<a class="dropdown-item" href="listaUsuario">Listar</a> <a
						class="dropdown-item" href="novoUsuario">Novo</a>
				</div></li>

		</ul>
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