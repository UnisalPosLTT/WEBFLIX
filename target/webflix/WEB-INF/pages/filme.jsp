<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../pages/template/header.jsp" />

<div>
	<form class="form-group" action="salvarFilme" method="post">
		<div class="form-group">
			<input type="text" placeholder="nome" name="nome" class="form-control" required="required"/>
		</div>
		
		<br/>
		<button type="submit" class="btn btn-success">Salvar</button>
	</form>
</div>
<br/>
<br/>
<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>UUID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${filmes}">
				<tr id="filme_${u.id}">
					<td>${u.id}</td>
					<td>${u.nome}</td>
					<td>${u.uuid}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<form class="form-group"
		action="listaFilmes" method="post">
		<button type="submit" class="btn btn-default">Ver filmes</button>
	</form>
</div>

<c:import url="../pages/template/footer.jsp" />
