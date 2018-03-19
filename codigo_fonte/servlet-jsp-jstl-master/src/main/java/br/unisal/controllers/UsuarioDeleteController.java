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

import br.unisal.dao.UsuarioDAO;
import br.unisal.model.Usuario;
import br.unisal.util.Constantes;

@WebServlet(name = "UsuarioDeleteController", description = "Controlador para deletar Usuario", urlPatterns = "/deletarUsuario")
public class UsuarioDeleteController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380365497770693025L;
	
	private static final UsuarioDAO Usuario_DAO = UsuarioDAO.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		
		try {
			Usuario_DAO.delete(id);
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
		
		List<Usuario> usuarios = new ArrayList<>();
		
		try {			
			usuarios = Usuario_DAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}

		req.setAttribute("usuarios", usuarios);
		req.getRequestDispatcher(Constantes.raizPages + "usuario.jsp").forward(req, resp);
				
		
	}

}
