package br.unisul.databaseload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.unisul.dao.ModuloConexao;

public class DatabaseWriter {

	private List<DataModel> list;

	public DatabaseWriter(List<DataModel> list) {
		this.list = list;
	}

	public void insertInfo() {

		Connection conexao = null;
		PreparedStatement pst = null;

		conexao = ModuloConexao.conector();

		String sql = "INSERT INTO info(cnpj,nome,endereco,produto) VALUES(?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			for (DataModel dataModel : list) {
				pst.setInt(1, dataModel.getCnpj());
				pst.setString(2, dataModel.getNome());
				pst.setString(3, dataModel.getEndereco());
				pst.setString(4, dataModel.getProduto());

				pst.executeUpdate();
			}

		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}
