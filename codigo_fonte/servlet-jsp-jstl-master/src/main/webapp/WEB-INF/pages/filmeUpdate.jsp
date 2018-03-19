<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../pages/template/header.jsp" />

<div class="container">
	<h1 style="color: white;">Filmes</h1>
	<form class="form-group" action="alterarFilme" method="post">
		<div class="form-group">
			<div class="form-group"><input type="hidden" placeholder="nome" name="id" value="${filme.id}" class="form-control" required="required"/></div>
			<div class="form-group"><input type="text" placeholder="nome" name="nome" value="${filme.nome}" class="form-control" required="required"/></div>
			<div class="form-group"><input type="text" placeholder="URL Image" name="image" value="${filme.image}" class="form-control" required="required"/></div>
			<div class="form-group"><input type="text" placeholder="Sinopse" name="descricao" value="${filme.descricao}"class="form-control" required="required"/></div>
		</div>
		<button type="submit" class="btn btn-success">Salvar</button>
	</form>
</div>
<br/>
<br/>
<div class="container">
<div class="table-responsive">
	<br/>
	<div class="container">
	<form class="form-group"
		action="listaFilmes" method="post">
	</form>
	</div>
</div>
</div>

<c:import url="../pages/template/footer.jsp" />
