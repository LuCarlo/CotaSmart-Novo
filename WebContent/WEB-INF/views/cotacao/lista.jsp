<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cotações</title>
<c:import url="../layout/iniciarHead.jsp" />
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />


	<div class=centralizado>
		<table class="table table-striped">
			<tr>
				<th>Data</th>
				<th>Valor Total</th>
				<th>Finalizado</th>
				<th>Data Finalização</th>
			</tr>
			<c:forEach items="${cotacoes}" var="cotacao">
			<tr>
			<td>${cotacao.data}</td>
			</tr>
			
			</c:forEach>
		</table>
	</div>

</body>
</html>