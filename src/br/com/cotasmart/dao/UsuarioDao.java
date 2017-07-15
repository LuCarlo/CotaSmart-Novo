package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Usuario;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome, login, senha) VALUES (?,?,?) ";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
//			stmt.setLong(4, usuario.getCodStatus());
//			stmt.setLong(5, usuario.getCodGrupo());

			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao incluir usuário: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	public void altera(Usuario usuario) {
		String sql = "UPDATE usuarios SET " + "senha = ?, " + "codStatus = ?," + "codGrupo = ? ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getSenha());
			stmt.setLong(2, usuario.getCodStatus());
			stmt.setLong(3, usuario.getCodGrupo());

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void exclui(Usuario usuario) {
		String sql = "DELETE FROM usuarios WHERE codUsuario = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, usuario.getCodUsuario());

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Usuario> getLista() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
