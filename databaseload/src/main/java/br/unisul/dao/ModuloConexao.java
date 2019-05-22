package br.unisul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public static int insertDatabase(PreparedStatement statement) {
		int idReturn = 0;
		try {
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				idReturn = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return idReturn;
	}
}
