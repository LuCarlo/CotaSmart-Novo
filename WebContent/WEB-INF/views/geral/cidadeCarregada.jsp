<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 		UF -->
<select class="custom-select">
	<option selected>UF</option>
	<c:forEach items="${cidades}" var="cidade">
		<option value="${cidade.codCidade}">${cidade.uf}</option>
	</c:forEach>
</select>

<!-- 		Cidade -->
<select class="custom-select">
	<option selected>Cidade</option>
	<c:forEach items="${cidades}" var="cidade">
		<option value="${cidade.codCidade}">${cidade.nome}</option>
	</c:forEach>
</select>