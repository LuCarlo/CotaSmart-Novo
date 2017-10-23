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
		String sql = "INSERT INTO produtos (" + "nome, ativo, codGrupoProdutos, codBarras) " + "VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, produto.getNome());
			stmt.setBoolean(2, true);
			stmt.setLong(3, produto.getCodGrupoProdutos());
			stmt.setString(4, produto.getCodBarras());

			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Falha ao inserir produto: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void altera(Produto produto) {
		String sql = "update produtos set nome=?, codGrupoProdutos, codBarras" + " where codProduto=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setLong(2, produto.getCodGrupoProdutos());
			stmt.setString(3, produto.getCodBarras());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Não foi possivel alterar produto: " + e);
			throw new RuntimeException(e);
		}
	}

	public void remove(Produto produto) {
		String sql = "delete from produtos where codProduto=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, produto.getCodProduto());

			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Não foi possivel excluir produto" + e);
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
				produto.setCodProduto(rs.getInt("codProduto"));
				produto.setCodBarras(("codBarras"));
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

	public void ativaProduto(Long codProduto) {
		try{
			PreparedStatement stmt = this.connection.prepareStatement("UPDATE produtos SET ativo = ? WHERE codProduto = ?");
			stmt.setBoolean(1, true);
			stmt.setLong(2, codProduto);
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	public void desativaProduto(Long codProduto) {
		try{
			PreparedStatement stmt = this.connection.prepareStatement("UPDATE produtos SET ativo = ? WHERE codProduto = ?");
			stmt.setBoolean(1, false);
			stmt.setLong(2, codProduto);
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}

}
