package br.com.cotasmart.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws SQLException {
		String driver = "org.postgresql.Driver";
		String usuario = "postgres";
		String senha = "juizladrao";
		String url = "jdbc:postgresql://localhost:5433/CotaSmart"; 
//		PC CARLOS
//		String url = "jdbc:postgresql://localhost:5432/CotaSmart";

		System.out.println("Tentando Conectar....");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro de conexão(VERIFICAR PORTA): " + e.getMessage());
			throw new SQLException(e);
		}

		return DriverManager.getConnection(url, usuario, senha);
	}

}
