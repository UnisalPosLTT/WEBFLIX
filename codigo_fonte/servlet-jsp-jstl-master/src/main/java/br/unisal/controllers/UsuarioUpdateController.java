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

@WebServlet(name = "UsuarioUpdateController", description = "Controlador para alterar usuarios", urlPatterns = "/alterarUsuario")
public class UsuarioUpdateController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2380365497770693025L;
	
	private static final UsuarioDAO Usuario_DAO = UsuarioDAO.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(req.getParameter("id")));
		usuario.setNome(req.getParameter("nome"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setLogin(req.getParameter("login"));
		usuario.setSenha(req.getParameter("senha"));
		usuario.setUuid(req.getParameter("uuid"));
		
		//Long id = Long.parseLong(req.getParameter("id"));
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			Usuario_DAO.update(usuario);
			usuarios = Usuario_DAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
		req.setAttribute("usuarios", usuarios);
		req.getRequestDispatcher(Constantes.raizPages + "usuario.jsp").forward(req, resp);
				
		
	}

}
