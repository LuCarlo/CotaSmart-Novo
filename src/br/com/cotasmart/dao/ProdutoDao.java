package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Produto;

public class ProdutoDao {
	private Connection connection;

	public ProdutoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Produto produto) {
		String sql = "INSERT INTO produtos (" + "nome, ativo, codBarras) " + "VALUES (?,?,?)";
		try {
			if (produto != null) {
				PreparedStatement stmt = connection.prepareStatement(sql);

				stmt.setString(1, produto.getNome());
				stmt.setBoolean(2, true);
				stmt.setString(3, produto.getCodBarras());

				stmt.execute();
			} else {
				System.out.println("Produto = null");
			}

		} catch (SQLException e) {
			System.out.println("Falha ao inserir produto: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void altera(Produto produto) {
		String sql = "UPDATE produtos SET nome=?, codBarras = ? WHERE codProduto=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getCodBarras());
			stmt.setInt(3, produto.getCodProduto());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Não foi possivel alterar produto: " + e);
			throw new RuntimeException(e);
		}
	}

	public List<Produto> getLista() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM produtos ORDER BY nome");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setNome(rs.getString("nome"));
				produto.setCodProduto(rs.getInt("codProduto"));
				produto.setCodBarras(rs.getString("codBarras"));
				produto.setAtivo(rs.getBoolean("ativo"));
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void ativaProduto(int codProduto) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE produtos SET ativo = ? WHERE codProduto = ?");
			stmt.setBoolean(1, true);
			stmt.setLong(2, codProduto);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void desativaProduto(int codProduto) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE produtos SET ativo = ? WHERE codProduto = ?");
			stmt.setBoolean(1, false);
			stmt.setLong(2, codProduto);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
