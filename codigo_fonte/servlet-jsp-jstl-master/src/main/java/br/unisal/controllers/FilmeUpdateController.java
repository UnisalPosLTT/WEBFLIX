package br.unisal.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisal.dao.FilmeDAO;
import br.unisal.model.Filme;
import br.unisal.util.Constantes;

@WebServlet(name = "FilmeUpdateController", description = "Controlador para alterar filmes", urlPatterns = "/alterarFilme")
public class FilmeUpdateController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380365497770693025L;
	
	private static final FilmeDAO Filme_DAO = FilmeDAO.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Filme filme = new Filme();
		filme.setId(Long.parseLong(req.getParameter("id")));
		filme.setNome(req.getParameter("nome"));
		filme.setImage(req.getParameter("image"));
		filme.setDescricao(req.getParameter("descricao"));
		filme.setUuid(req.getParameter("uuid"));
		
		//Long id = Long.parseLong(req.getParameter("id"));
		List<Filme> filmes = new ArrayList<>();
		
		try {
			Filme_DAO.update(filme);
			filmes = Filme_DAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
		req.setAttribute("filmes", filmes);
		req.getRequestDispatcher(Constantes.raizPages + "filme.jsp").forward(req, resp);
				
		
	}

}
