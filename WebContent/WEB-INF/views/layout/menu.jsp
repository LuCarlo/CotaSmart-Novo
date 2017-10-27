<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<!-- <nav class="navbar navbar-dark bg-dark"> -->
	<a class="navbar-brand" href="#">Menu</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="inicio">Início
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navCotacao"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Cotação </a>
				<div class="dropdown-menu" aria-labelledby="navCotacao">
					<a class="dropdown-item" href="listaCotacoes">Listar</a> <a
						class="dropdown-item" href="#">Novo</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navFornecedor"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Fornecedores </a>
				<div class="dropdown-menu" aria-labelledby="navFornecedor">
					<a class="dropdown-item" href="listaFornecedor">Listar</a> <a
						class="dropdown-item" href="novoFornecedor">Novo</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navProdutos"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Produtos </a>
				<div class="dropdown-menu" aria-labelledby="navProdutos">
					<a class="dropdown-item" href="listaProduto">Listar</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navUsuario"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Usuários </a>
				<div class="dropdown-menu" aria-labelledby="navUsuario">
					<a class="dropdown-item" href="listaUsuario">Listar</a> <a
						class="dropdown-item" href="novoUsuario">Novo</a>
				</div></li>

		</ul>
	</div>
	<form class="form-inline">
		<button class="btn btn-danger" type="submit">Sair</button>
	</form>
</nav>