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

@WebServlet(name = "FilmeInsertController", description = "Controlador para inserir filmes", urlPatterns = "/salvarFilme")
public class FilmeInsertController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380365497770693025L;
	
	private static final FilmeDAO Filme_DAO = FilmeDAO.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Filme filme = new Filme(req.getParameter("nome"), 
								req.getParameter("image"), 
								req.getParameter("descricao"));
		
		List<Filme> filmes = new ArrayList<>();
		
		try {
			Filme_DAO.insert(filme);
			
			filmes = Filme_DAO.findAll();
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
				
		req.setAttribute("filmes", filmes);
		req.getRequestDispatcher(Constantes.raizPages + "filme.jsp").forward(req, resp);
	}

}
