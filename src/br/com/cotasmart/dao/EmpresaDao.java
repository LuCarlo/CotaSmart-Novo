package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Empresa;

public class EmpresaDao {
	private Connection connection;

	public EmpresaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Empresa getLista() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM empresa LIMIT 1");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setEndereco(rs.getString("endereco"));
				empresa.setNome(rs.getString("nome"));
				empresa.setTelefone1(rs.getString("telefone1"));
				empresa.setTelefone2(rs.getString("telefone2"));
				return empresa;
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void atualiza(Empresa empresa) {
		String sql = "UPDATE EMPRESA SET nome = ?, cnpj = ?, endereco = ?, telefone1 = ?, telefone2 = ?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, empresa.getNome());
			stmt.setString(2, empresa.getCnpj());
			stmt.setString(3, empresa.getEndereco());
			stmt.setString(4, empresa.getTelefone1());
			stmt.setString(5, empresa.getTelefone2());
			stmt.execute();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
