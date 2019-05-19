package br.unisul.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {

	public static Connection conector() {
		java.sql.Connection conexao = null;
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://127.0.0.1:5432/infopreco";
		String user = "postgres";
		String password = "admin";

		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
