package br.unisul.databaseload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

import br.unisul.dao.ModuloConexao;

public class DatabaseWriter extends Thread {

	protected BlockingQueue<DataModel> queue = null;

	public DatabaseWriter(BlockingQueue<DataModel> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		this.escreverConteudoArquivo();
	}

	public void escreverConteudoArquivo() {

		Connection conexao = null;
		PreparedStatement pst = null;

		conexao = ModuloConexao.conector();

		String sql = "INSERT INTO info(cnpj,nome,endereco,produto) VALUES(?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			while (!(queue.take().finish)) {
				pst.setInt(1, queue.take().getCnpj());
				pst.setString(2, queue.take().getNome());
				pst.setString(3, queue.take().getEndereco());
				pst.setString(4, queue.take().getProduto());

				pst.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
