<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../pages/template/header.jsp" />


<div class="container">
<h3 style="color: white">${usuario.nome}, seja bem vindo(a) ao Webflix!</h3> <br> <br>

      <section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Filmes e Séries</h1>
          <p class="lead text-muted">Webflix é uma provedora local de filmes e séries de televisão via streaming, atualmente com mais de 100 milhões de assinantes. Fundada em 2018 em Lorena, a empresa surgiu como um serviço de entrega de DVDs pelo correio.</p>
        </div>
      </section>

      <div class="album py-5 bg-light">
        <div class="container">
          <div class="row">
        
<c:forEach var="f" items="${filmes}">


            <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" src="${f.image}" style="height: 225px; width: 100%; display: block;"/>
                <div class="card-body">
                
                  <p class="card-text">${f.nome}</p>
                                    
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                    
		<!-- Button trigger modal -->
		<button type="button" id="${f.uuid}" class="btn btn-primary my-2" data-toggle="modal" data-target="#${f.id}">
		Detalhes
		</button>
                    </div>
                    <small class="text-muted">ID: ${f.id} </small>
                  </div>
                </div>
              </div>
            </div>
 


<!-- Modal -->
<div class="modal fade" id="${f.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Sinopse</b> do filme ${f.nome}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       ${f.descricao}
       <br>
       Imagem:
       <br>
       <div style="text-align: center;">
       <img src="${f.image}" width="auto" height="200"/>
       </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>			

</c:forEach>
          </div>
        </div>
      </div>
</div>

<c:import url="../pages/template/footer.jsp" />

