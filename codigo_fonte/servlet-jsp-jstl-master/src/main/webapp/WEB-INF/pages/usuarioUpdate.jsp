<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../pages/template/header.jsp" />

<div class="container">

	<h1 style="color: white;">Usuários</h1>
	<form class="form-group" action="alterarUsuario" method="post">
		<div class="form-group">
			<input type="hidden" placeholder="nome" name="id" value="${usuario.id}" 
			class="form-control" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" placeholder="nome" name="nome" value="${usuario.nome}" class="form-control" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" placeholder="email" name="email" value="${usuario.email}" class="form-control" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" placeholder="login" name="login" value="${usuario.login}" class="form-control" required="required"/>
		</div>
		<div class="form-group">
			<input type="text" placeholder="senha" name="senha" value="${usuario.senha}" class="form-control" required="required"/>
		</div>
		<br/>
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
		action="listaUsuario" method="post">
	</form>
	</div>
</div>
</div>

<c:import url="../pages/template/footer.jsp" />
