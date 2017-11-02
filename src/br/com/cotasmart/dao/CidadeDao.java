package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Cidade;

public class CidadeDao {
	private Connection connection;

	public CidadeDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cidade> getListaCidades(){
		try{
			List<Cidade> cidades = new ArrayList<Cidade>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM cidades ORDER BY nome");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Cidade cidade = new Cidade();
				cidade.setNome(rs.getString("nome"));
				cidade.setCodCidade(rs.getInt("codcidade"));
				cidades.add(cidade);
			}
			return cidades;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Cidade> getListaUfs(){
		try{
			List<Cidade> cidades = new ArrayList<Cidade>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT DISTINCT(UF) as uf FROM cidades ORDER BY uf");
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()){
				Cidade cidade = new Cidade();
				cidade.setUf(rs.getString("uf"));
				cidades.add(cidade);
			}
			return cidades;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
