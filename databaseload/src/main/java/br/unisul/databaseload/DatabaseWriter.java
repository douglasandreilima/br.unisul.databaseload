package br.unisul.databaseload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unisul.dao.ModuloConexao;

public class DatabaseWriter {

	private Map<String, Integer> cargo;
	private Map<String, Integer> orgao;
	private Map<String, Integer> tipoAposentadoria;
	private Map<String, Integer> pessoa;

	public DatabaseWriter() {
		cargo = new HashMap<String, Integer>();
		orgao = new HashMap<String, Integer>();
		tipoAposentadoria = new HashMap<String, Integer>();
		pessoa = new HashMap<String, Integer>();
	}

	public void inserirDados(List<DataModel> list) {
		for (DataModel dataModel : list) {
			System.out.println("Insert row");
			insertPessoa(dataModel);
			insertOrgao(dataModel);
			insertCargo(dataModel);
			insertAposentadoria(dataModel);
			insertPessoaCargo(dataModel);
			insertPessoaAposentadoria(dataModel);
		}
	}

	private void insertPessoa(DataModel dataModel) {
		if (pessoa.containsKey(dataModel.getMatriculaServidor()))
			return;

		Connection conn = ModuloConexao.conector();
		String sql = "INSERT INTO pessoa(nome, cpf, matricula_servidor) values(?,?,?) RETURNING id_pessoa";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dataModel.getNome());
			statement.setString(2, dataModel.getCpf());
			statement.setLong(3, Long.parseLong(dataModel.getMatriculaServidor()));
			int idReturn = ModuloConexao.insertDatabase(statement);
			pessoa.put(dataModel.getMatriculaServidor(), idReturn);
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private void insertCargo(DataModel dataModel) {
		String cargoName = dataModel.getCargo() + dataModel.getClasse() + dataModel.getPadrao() + dataModel.getNivel()
				+ dataModel.getSiglaOrgao();

		if (cargo.containsKey(cargoName))
			return;

		Connection conn = ModuloConexao.conector();
		String sql = "INSERT INTO cargo(nome_cargo, classe, padrao, nivel, referencia, id_orgao) values(?,?,?,?,?,?) RETURNING id_cargo";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dataModel.getCargo());
			statement.setString(2, dataModel.getClasse());
			statement.setString(3, dataModel.getPadrao());
			statement.setString(4, dataModel.getNivel());
			statement.setString(5, dataModel.getReferencia());
			statement.setInt(6, orgao.get(dataModel.getNomeOrgao()));
			int idReturn = ModuloConexao.insertDatabase(statement);
			cargo.put(cargoName, idReturn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private void insertOrgao(DataModel dataModel) {
		if (orgao.containsKey(dataModel.getNomeOrgao()))
			return;

		Connection conn = ModuloConexao.conector();
		String sql = "INSERT INTO orgao(nome_orgao, sigla_orgao, cod_orgao_superior) values(?,?,?) RETURNING id_orgao";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dataModel.getNomeOrgao());
			statement.setString(2, dataModel.getSiglaOrgao());
			statement.setString(3, dataModel.getCodigoOrgaoSuperior());
			int idReturn = ModuloConexao.insertDatabase(statement);
			orgao.put(dataModel.getNomeOrgao(), idReturn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private void insertAposentadoria(DataModel dataModel) {
		if (tipoAposentadoria.containsKey(dataModel.getTipoAposentadoria()))
			return;

		Connection conn = ModuloConexao.conector();
		String sql = "INSERT INTO aposentadoria(tipo_aposentadoria) values(?) RETURNING id_aposentadoria";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, dataModel.getTipoAposentadoria());
			int idReturn = ModuloConexao.insertDatabase(statement);
			tipoAposentadoria.put(dataModel.getTipoAposentadoria(), idReturn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private void insertPessoaCargo(DataModel dataModel) {
		Connection conn = ModuloConexao.conector();
		String sql = "INSERT INTO pessoa_cargo(id_pessoa, id_cargo, tipo_ingresso, data_ingresso) values(?,?,?,?) RETURNING null";
		String cargoName = dataModel.getCargo() + dataModel.getClasse() + dataModel.getPadrao() + dataModel.getNivel()
				+ dataModel.getSiglaOrgao();
		long dataIngresso = getDateTime(dataModel.getDataIngressoServico());
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, pessoa.get(dataModel.getMatriculaServidor()));
			statement.setInt(2, cargo.get(cargoName));
			statement.setInt(3, tipoAposentadoria.get(dataModel.getTipoAposentadoria()));
			statement.setDate(4, new java.sql.Date(dataIngresso));
			ModuloConexao.insertDatabase(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private void insertPessoaAposentadoria(DataModel dataModel) {
		Connection conn = ModuloConexao.conector();
		String sql = "INSERT INTO pessoa_aposentadoria(id_aposentadoria, "
				+ "id_pessoa, valor_rendimento, data_pub_diploma_legal, "
				+ "nome_diploma_legal,fundamentacao_inatividade) values(?,?,?,?,?,?) RETURNING null";
		long dataPubDiploma = getDateTime(dataModel.getDataPublicacaoDiploma());
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tipoAposentadoria.get(dataModel.getTipoAposentadoria()));
			statement.setInt(2, pessoa.get(dataModel.getMatriculaServidor()));
			statement.setDouble(3,
					Double.parseDouble(dataModel.getValorRendimento().replaceAll("\\.", "").replaceAll("\\,", ".")));
			statement.setDate(4, new java.sql.Date(dataPubDiploma));
			statement.setString(5, dataModel.getNomeDiploma());
			statement.setString(6, dataModel.getFundamentacaoInatividade());
			ModuloConexao.insertDatabase(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private long getDateTime(String stringDate) {
		long dateTime = 0;
		if (stringDate != null && !stringDate.isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
			if (stringDate.length() < 8) {
				stringDate = "0" + stringDate;
			}
			try {
				dateTime = format.parse(stringDate).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
				System.err.println("error to parse date " + e.getMessage());
			}
		}
		;
		return dateTime;
	}
}
