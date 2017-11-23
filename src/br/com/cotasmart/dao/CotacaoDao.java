package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Cotacao;
import br.com.cotasmart.modelo.Produto;
import br.com.cotasmart.modelo.Usuario;

public class CotacaoDao {
	private Connection connection;

	public CotacaoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Cotacao adicionaCotacao() {
		String sql = "INSERT INTO cotacao (data, ativo, iniciou) VALUES (now(),?,?)";
//		List<Cotacao> cotacoes = new ArrayList<Cotacao>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM cotacao WHERE iniciou = false");
			stmt.execute();
			stmt = this.connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setBoolean(2, false);
			stmt.execute();
			stmt.close();

			sql = "SELECT CURRVAL('cotacao_codcotacao_seq') as codcotacao";
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				sql = "SELECT * FROM cotacao WHERE codcotacao = ?";
				stmt = this.connection.prepareStatement(sql);
				stmt.setInt(1, rs.getInt("codcotacao"));
				rs = stmt.executeQuery();
				if (rs.next()) {
					Cotacao c = new Cotacao();
					c.setAtivo(rs.getBoolean("ativo"));
					c.setData(rs.getDate("data"));
					c.setCodCotacao(rs.getInt("codcotacao"));
					System.out.println("Codigo da cotação é: "+c.getCodCotacao());
					return c;	
				}
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public List<Cotacao> getLista(Usuario usuario) {
		try {
			List<Cotacao> cotacoes = new ArrayList<Cotacao>();
			String sql = "";
			if (usuario.isAdministrador()) {
				sql = "SELECT * FROM cotacao ORDER BY data";
			} else if (usuario.isAdministrador() == false) {
				sql = "SELECT * FROM cotacao WHERE finalizado = false AND ativo = true ORDER BY data";
			}
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cotacao cotacao = new Cotacao();
				cotacao.setIdCotacao(rs.getInt("codCotacao"));
				cotacao.setAtivo(rs.getBoolean("ativo"));
				cotacao.setData(rs.getDate("data"));
				cotacao.setDataFinalizacao(rs.getDate("datafinalizacao"));
				cotacao.setFinalizado(rs.getBoolean("finalizado"));
				cotacao.setValorTotal(rs.getFloat("valortotal"));
				cotacoes.add(cotacao);
			}
			rs.close();
			stmt.close();
			return cotacoes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adicionaProduto(Produto produto, int codCotacao, int quantidade) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE cotacao SET iniciou = true WHERE codcotacao = ?");
			stmt.setInt(1, codCotacao);
			stmt.execute();
			String sql = "INSERT INTO cotacaoprodutos (codcotacao, codproduto, quantidade) VALUES (?,?,?) ";
			stmt = this.connection.prepareStatement(sql);
			System.out.println("Codico cotação no DAO: "+codCotacao);
			stmt.setInt(1, codCotacao);
			stmt.setInt(2, produto.getCodProduto());
			stmt.setInt(3, quantidade);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
