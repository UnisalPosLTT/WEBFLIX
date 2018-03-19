<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../pages/template/header.jsp" />

<div class="container">

	<h1 style="color: white;">Usuários</h1>
	<form class="form-group" action="salvarUsuario" method="post">
		<div class="form-group">
			<input type="text" placeholder="nome" name="nome" class="form-control" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" placeholder="email" name="email" class="form-control" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" placeholder="login" name="login" class="form-control" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" placeholder="senha" name="senha" class="form-control" required="required"/>
		</div>
		<br/>
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
				<th>Email</th>
				<th>Login</th>
				<th>Senha</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="u" items="${usuarios}">
					<th id="usuario_${u.id}"></th>
					<td>${u.id}</td>
					<td>${u.nome}</td>
					<td>${u.email}</td>
					<td>${u.login}</td>
					<td>${u.senha}</td>
						<td> <form class="form-group" action="encontrarUsuario" method="post"> 
									<input type="hidden" name="id"   value="${u.id}"/> 
									<button type="submit" class="btn btn-alert"><span class="glyphicon glyphicon-remove"></span> Edit</button>
									</form>
						</td>
						<td> 
									<form class="form-group" action="deletarUsuario" method="post"> 
									<input type="hidden" name="id"   value="${u.id}"/> 
									<button type="submit" class="btn btn-danger" onclick="return confirm('Você tem certeza que deseja excluir?')"><span class="glyphicon glyphicon-remove"></span> Delete</button>
									</form>
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<br/>
</div>

<c:import url="../pages/template/footer.jsp" />
