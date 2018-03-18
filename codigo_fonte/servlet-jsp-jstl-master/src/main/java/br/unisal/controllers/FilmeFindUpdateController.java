package br.unisal.controllers;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisal.dao.FilmeDAO;
import br.unisal.model.Filme;
import br.unisal.util.Constantes;

@WebServlet(name = "FilmeFindUpdateController", description = "Controlador buscar filme", urlPatterns = "/encontrarFilme")
public class FilmeFindUpdateController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380365497770693025L;
	
	private static final FilmeDAO Filme_DAO = FilmeDAO.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Filme filme = new Filme();
		Long id = Long.parseLong(req.getParameter("id"));
		
		
		try {
			filme = Filme_DAO.findById(id);
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
		req.setAttribute("filme", filme);
		req.getRequestDispatcher(Constantes.raizPages + "filmeUpdate.jsp").forward(req, resp);
		
	}

}
