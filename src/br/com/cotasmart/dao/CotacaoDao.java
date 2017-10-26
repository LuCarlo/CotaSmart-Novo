package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Cotacao;

public class CotacaoDao {
	private Connection connection;

	public CotacaoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int adicionaCotacao(Cotacao cotacao) {
		String sql = "INSERT INTO cotacao (data, ativo) VALUES (?,?)";
		try {
			java.util.Date d = new Date();
			String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, dStr);
			stmt.setBoolean(2, true);
			stmt.execute();
			stmt.close();

			sql = "SELECT CURRVAL('cotacao_codcotacao_seq') as idCotacao";
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("idCotacao");
			}
			return 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public List<Cotacao> getLista() {
		try {
			List<Cotacao> cotacoes = new ArrayList<Cotacao>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM cotacao ORDER BY data");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cotacao cotacao = new Cotacao();
				cotacao.setIdCotacao(rs.getInt("codCotacao"));
				cotacao.setAtivo(rs.getBoolean("ativo"));
				cotacao.setData(rs.getDate("data"));
				cotacoes.add(cotacao);
			}
			rs.close();
			stmt.close();
			return cotacoes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
