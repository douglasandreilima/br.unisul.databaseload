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

		String sql = "INSERT INTO DADOSGOV(idn_empreendimento,idn_digs,dsc_titulo) VALUES(?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			while (!(queue.take().finish)) {
				pst.setInt(1, queue.take().getIdnEmpreendimento());
				pst.setInt(2, queue.take().getIdnDigs());
				pst.setString(3, queue.take().getDscTitulo());

				pst.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
