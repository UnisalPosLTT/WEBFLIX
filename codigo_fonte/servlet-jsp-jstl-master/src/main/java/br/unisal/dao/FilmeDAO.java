package br.unisal.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisal.interfaces.DAOInterface;
import br.unisal.model.Filme;
import br.unisal.util.DbUtil;

public class FilmeDAO extends GenericDAO implements DAOInterface<Filme> {
	private static FilmeDAO INSTANCE;

	private FilmeDAO() {
	}

	public static FilmeDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FilmeDAO();
		}
		return INSTANCE;
	}

	public void delete(Long id) throws ClassNotFoundException, SQLException, IOException {
		String sql = "delete from filme where id = ?";

		PreparedStatement ps = null;
		try {
			ps = getConnectionPool().prepareStatement(sql);
			ps.setLong(1, id);
			ps.execute();
		} finally {
			DbUtil.getInstance().closeQuietly(ps);
		}
	}

	public void update(Filme t) throws ClassNotFoundException, SQLException, IOException {
		String sql = "update filme set nome = ?, image = ?, descricao = ? where id = ?";
		PreparedStatement ps = null;
		try {
			ps = getConnectionPool().prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getImage());
			ps.setString(3, t.getDescricao());
			ps.setLong(4, t.getId());
			ps.execute();
		} finally {
			DbUtil.getInstance().closeQuietly(ps);
		}
	}

	public void insert(Filme t) throws ClassNotFoundException, SQLException, IOException {
		String sql = "insert into filme (nome, image, descricao, uuid) values (?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = getConnectionPool().prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getImage());
			ps.setString(3, t.getDescricao());
			ps.setString(4, t.getUuid());
			ps.execute();
			
		} finally {
			DbUtil.getInstance().closeQuietly(ps);
		}
	}

	public List<Filme> findAll() throws ClassNotFoundException, SQLException, IOException {
		String sql = "select id, nome, image, descricao, uuid from filme";
		List<Filme> Filmes = new ArrayList<>();

		List<Object[]> objects = executaSqlSemParametro(getConnectionPool(), sql);
		if (objects != null) {
			for (Object[] os : objects) {
				Filmes.add(castObjectToModel(os));
			}
		}

		return Filmes;
	}

	public Filme findById(Long id) throws ClassNotFoundException, SQLException, IOException {
		String sql = "select id, nome, image, descricao, uuid from Filme where id = ?";
		Filme Filme = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = getConnectionPool().prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Filme = new Filme();
				Filme.setId(rs.getLong(1));
				Filme.setNome(rs.getString(2));
				Filme.setImage(rs.getString(3));
				Filme.setDescricao(rs.getString(4));
				Filme.setUuid(rs.getString(5));
			}
		} finally {
			DbUtil.getInstance().closeQuietly(ps, rs);
		}

		return Filme;
	}

	private Filme castObjectToModel(Object[] obj) {
		Filme Filme = new Filme();
		Filme.setId((Long) obj[0]);
		Filme.setNome((String) obj[1]);
		Filme.setImage((String) obj[2]);
		Filme.setDescricao((String) obj[3]);
		Filme.setUuid((String) obj[4]);
		return Filme;
	}

	@Override
	public Filme pesquisaUsuarioLogin(String login, String senha)
			throws ClassNotFoundException, SQLException, IOException {
		
		return null;
	}

}
