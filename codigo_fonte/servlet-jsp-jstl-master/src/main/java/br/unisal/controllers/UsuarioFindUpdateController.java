package br.unisal.controllers;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisal.dao.UsuarioDAO;
import br.unisal.model.Usuario;
import br.unisal.util.Constantes;

@WebServlet(name = "UsuarioFindUpdateController", description = "Controlador buscar usuario", urlPatterns = "/encontrarUsuario")
public class UsuarioFindUpdateController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380365497770693025L;
	
	private static final UsuarioDAO Usuario_DAO = UsuarioDAO.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		Long id = Long.parseLong(req.getParameter("id"));
		
		
		try {
			usuario = Usuario_DAO.findById(id);
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
		req.setAttribute("usuario", usuario);
		req.getRequestDispatcher(Constantes.raizPages + "usuarioUpdate.jsp").forward(req, resp);
		
	}

}
