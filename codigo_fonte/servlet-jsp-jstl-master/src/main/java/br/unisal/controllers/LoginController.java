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
import br.unisal.dao.UsuarioDAO;
import br.unisal.model.Filme;
import br.unisal.model.Usuario;
import br.unisal.util.Constantes;

@WebServlet(name = "LoginController", description = "Controlador para efetivar o login", urlPatterns = "/login")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2664599753751370793L;
	private static final FilmeDAO FILME_DAO = FilmeDAO.getInstance();
	private static final UsuarioDAO USUARIO_DAO = UsuarioDAO.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usuario = new Usuario();
		
		List<Filme> filmes = new ArrayList<>();
		
		try {	
			usuario =  USUARIO_DAO.pesquisaUsuarioLogin(login, senha);
			filmes = FILME_DAO.findAll();
			
			if (usuario == null){
				req.getRequestDispatcher(Constantes.raizPages + "erro.jsp").forward(req, resp);
			}
			else if(login.equals(usuario.getLogin())){
				req.setAttribute("usuario", usuario);
				req.setAttribute("filmes", filmes);
				req.getRequestDispatcher(Constantes.raizPages + "inicio.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher(Constantes.raizPages + "erro.jsp").forward(req, resp);
			}

		} 
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
		

		
	}
	

}
