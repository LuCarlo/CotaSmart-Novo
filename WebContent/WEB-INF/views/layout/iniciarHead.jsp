<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="shortcut icon" href="resources/imagens/favicon.png"
	type="image/x-icon" />
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



<!-- calendário -->
<!-- <link rel="stylesheet" -->
<!-- 	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" /> -->
<!-- <script src="http://code.jquery.com/jquery-1.8.2.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script> -->


<c:if test="${usuarioLogado.administrador eq true}">
	<c:import url="../layout/menu.jsp" />
</c:if>
<c:if test="${usuarioLogado.administrador eq false}">
	<c:import url="../layout/menuFornecedor.jsp" />
</c:if>
<hr />
