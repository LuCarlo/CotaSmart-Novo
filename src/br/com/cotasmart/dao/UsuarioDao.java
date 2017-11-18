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

	public boolean adiciona(Usuario usuario) {
		try {
			// Verifica se já existe algum usuário cadastrado
			String sql1 = "SELECT 1 FROM usuarios WHERE login = ?";
			PreparedStatement stmt1 = connection.prepareStatement(sql1);
			stmt1.setString(1, usuario.getLogin());
			ResultSet rs = stmt1.executeQuery();

			if (rs.next()) {
				// Se já estiver um login retornar a mensagem para a tela
				return false;
			} else {
				String sql = "INSERT INTO usuarios (nome, login, senha, ativo, administrador) VALUES (?,?,?,?,?) ";
				try {

					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, usuario.getNome());
					stmt.setString(2, usuario.getLogin());
					stmt.setString(3, usuario.getSenha());
					stmt.setBoolean(4, true);
					stmt.setBoolean(5, usuario.isAdministrador());
					stmt.execute();
					return true;
				} catch (SQLException e) {
					System.out.println("Erro ao incluir usuário: " + e.getMessage());
					throw new RuntimeException(e);
				}
			}
		} catch (SQLException e) {
			System.out.println("Erro ao incluir usuário: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	public void altera(Usuario usuario) {
		String sql = "UPDATE usuarios SET " + "nome= ?, " + "senha = ? where login =?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getLogin());

			stmt.execute();
			System.out.println(usuario.getNome() + "," + usuario.getLogin());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getLista() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios ORDER BY nome");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setCodUsuario(rs.getLong("codUsuario"));
				usuario.setAtivo(rs.getBoolean("ativo"));
				usuario.setAdministrador(rs.getBoolean("administrador"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscaPorId(Long codUsuario) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuarios WHERE codUsuario = ?");
			stmt.setLong(1, codUsuario);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setAdministrador(rs.getBoolean("administrador"));
				usuario.setAtivo(rs.getBoolean("ativo"));
				usuario.setCodUsuario(rs.getLong("codUsuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha("senha");

				return usuario;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// Caso não encontre nenhum resultado retorna null
		return null;
	}

	public void desativarUsuario(Long codUsuario) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE usuarios SET ativo = ? WHERE codUsuario = ?");
			stmt.setBoolean(1, false);
			stmt.setLong(2, codUsuario);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void ativarUsuario(Long codUsuario) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE usuarios SET ativo = ? WHERE codUsuario = ?");
			stmt.setBoolean(1, true);
			stmt.setLong(2, codUsuario);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean existeUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		try {
			String sql = "SELECT 1 FROM usuarios WHERE login = ? AND senha = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			System.out.println(usuario.getLogin() + "," + usuario.getSenha());

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();
			return encontrado;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public Usuario alimentarUsuario(Usuario usuario) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement(
					"SELECT nome, administrador, codusuario FROM usuarios WHERE login = ? AND ativo = true");
			stmt.setString(1, usuario.getLogin());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setAdministrador(rs.getBoolean("administrador"));
				u.setCodUsuario(rs.getLong("codusuario"));
				return u;
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
