package br.com.cotasmart.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws SQLException {
		String driver = "org.postgresql.Driver";
		String usuario = "postgres";
		String senha = "";
//		String url = "jdbc:postgresql://localhost:5433/sicop"; 
//		PC CARLOS
		String url = "jdbc:postgresql://localhost:5433/sicop";

		System.out.println("Tentando Conectar....");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro de conexão(VERIFICAR PORTA): " + e.getMessage());
			throw new SQLException(e);
		}
		System.out.println("Sucesso.");
		return DriverManager.getConnection(url, usuario, senha);
		
	}

}
