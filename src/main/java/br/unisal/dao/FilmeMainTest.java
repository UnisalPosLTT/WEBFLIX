package br.unisal.dao;

import java.io.IOException;
import java.sql.SQLException;

import br.unisal.model.Filme;
import java.util.List;

public class FilmeMainTest {
	
	private static final FilmeDAO FILME_DAO = FilmeDAO.getInstance();

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Filme filme = new Filme("Jether Rodrigues");
		FILME_DAO.insert(filme);
		
                List<Filme> filmes = FILME_DAO.findAll ();
                for (Filme u: filmes) {
                    System.out.println(u.toString());
                }
//		FILME_DAO.findAll().forEach(u -> u.toString());
	}

}