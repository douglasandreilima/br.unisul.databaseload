package br.unisul.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {

	public static Connection conector() {
		java.sql.Connection conexao = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/DADOSGOV";
		String user = "root";
		String password = "";

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
