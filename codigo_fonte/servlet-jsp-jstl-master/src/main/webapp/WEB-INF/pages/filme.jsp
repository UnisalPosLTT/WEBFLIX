<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../pages/template/header.jsp" />

<div class="container">
	<h1 style="color: white;">Filmes</h1>
	<form class="form-group" action="salvarFilme" method="post">
		<div class="form-group">
			<div class="form-group"><input type="text" placeholder="nome" name="nome" class="form-control" required="required"/></div>
			<div class="form-group"><input type="text" placeholder="URL image" name="image" class="form-control" required="required"/></div>
			<div class="form-group"><input type="text" placeholder="sinopse" name="descricao" class="form-control" required="required"/></div>
		</div>
		<button type="submit" class="btn btn-success">Salvar</button>
	</form>
</div>
<br/>
<br/>
<div class="container">
<div class="table-responsive">
	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th></th>
				<th>#</th>
				<th>Nome</th>
				<th>Sinopse</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="f" items="${filmes}">
					<tr>
						<th id="filme_${f.id}"></th>
						<td>${f.id}</td>
						<td>${f.nome}</td>
						<td>${f.descricao}</td>	
												
						<td> <form class="form-group" action="encontrarFilme" method="post"> 
									<input type="hidden" name="id"   value="${f.id}"/> 
									<button type="submit" class="btn btn-alert"><span class="glyphicon glyphicon-remove"></span> Edit</button>
									</form>
						</td>
						<td> 
									<form class="form-group" action="deletarFilme" method="post"> 
									<input type="hidden" name="id"   value="${f.id}"/> 
									<button type="submit" class="btn btn-danger" onclick="return confirm('Você tem certeza que deseja excluir?')"><span class="glyphicon glyphicon-remove"></span> Delete</button>
									</form>
						</td>

					</tr>
				</c:forEach>
		</tbody>
	</table>
	<br/>
	<div class="container">
	<form class="form-group"
		action="listaFilmes" method="post">
	</form>
	</div>
</div>
</div>

<c:import url="../pages/template/footer.jsp" />
