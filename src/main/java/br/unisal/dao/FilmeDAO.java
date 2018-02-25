package br.unisal.dao;

import static br.unisal.dao.GenericDAO.getConnectionPool;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisal.interfaces.DAOInterface;
import br.unisal.model.Filme;
import br.unisal.util.DbUtil;

public class FilmeDAO extends GenericDAO 
    implements DAOInterface<Filme> {
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
		String sql = "update filme set nome = ? from filme";
		PreparedStatement ps = null;
		try {
			ps = getConnectionPool().prepareStatement(sql);
			ps.setLong(5, t.getId());
			ps.setString(1, t.getNome());
			ps.execute();
		} finally {
			DbUtil.getInstance().closeQuietly(ps);
		}
	}

	public void insert(Filme t) throws ClassNotFoundException, SQLException, IOException {
		String sql = "insert into filme (nome, uuid) values (?,?)";
		PreparedStatement ps = null;
		try {
			ps = getConnectionPool().prepareStatement(sql);
			
			ps.setString(1, t.getNome());
			ps.setString(2, t.getUuid());
			ps.execute();
			
		} finally {
			DbUtil.getInstance().closeQuietly(ps);
		}
	}

	public List<Filme> findAll() throws ClassNotFoundException, SQLException, IOException {
		String sql = "select id, nome, uuid from filme";
		List<Filme> filmes = new ArrayList<>();

		List<Object[]> objects = executaSqlSemParametro(getConnectionPool(), sql);
		if (objects != null) {
			for (Object[] os : objects) {
				filmes.add(castObjectToModel(os));
			}
		}

		return filmes;
	}

	public Filme findById(Long id) throws ClassNotFoundException, SQLException, IOException {
		String sql = "select id, nome, uuid from filme where id = ?";
		Filme filme = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = getConnectionPool().prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				filme = new Filme();
				filme.setId(rs.getLong(1));
				filme.setNome(rs.getString(2));
				filme.setUuid(rs.getString(3));
			}
		} finally {
			DbUtil.getInstance().closeQuietly(ps, rs);
		}

		return filme;
	}

	private Filme castObjectToModel(Object[] obj) {
		Filme filme = new Filme();
		filme.setId((Long) obj[0]);
		filme.setNome((String) obj[1]);
		filme.setUuid((String) obj[2]);
		return filme;
	}
}

