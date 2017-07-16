<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="css/estilo.css">
<c:import url="../layout/iniciarHead.jsp" />
<title>Alterar Fornecedor</title>
</head>
<body>

	<c:import url="../layout/iniciarBody.jsp" />
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>





	<h3>Alterar tarefa - ${fornecedor.codFornecedor}</h3>
	<form action="alterafornecedor" method="post">
		<input type="hidden" name="id" value="${fornecedor.codFornecedor}" />
		Descrição:<br />
		<textarea name="descricao" cols="100" rows="5"><%--
--%>${fornecedor.nome}<%--
--%></textarea>
		<br /> <br /> <input type="submit" value="Alterar" />
		</form>
</body>
</html>