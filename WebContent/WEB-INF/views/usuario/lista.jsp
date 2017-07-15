<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:import url="../layout/iniciarHead.jsp" />
</head>
<body>
	<c:import url="../layout/iniciarBody.jsp" />
	<h3>Usuários Cadastrados</h3>
	<table class="striped">
		<tr>
			<th></th>
			<th>Login</th>
			<th>Nome</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td><input type="checkbox"></td>
				<td>${usuario.login}</td>
				<td>${usuario.nome}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>