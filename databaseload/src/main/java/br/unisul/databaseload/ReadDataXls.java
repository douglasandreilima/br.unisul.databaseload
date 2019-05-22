package br.unisul.databaseload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataXls {

	public List<DataModel> ler(String caminho) {
		List<DataModel> list = new ArrayList<DataModel>();
		File directory = new File(caminho);
		if (directory.exists()) {
			BufferedReader conteudoCSV = null;
			String linha = "";
			String csvSeparadorCampo = ";";
			String[] dado = null;

			try {
				for (File file : directory.listFiles()) {
					conteudoCSV = new BufferedReader(new FileReader(file));
					while ((linha = conteudoCSV.readLine()) != null) {
						if (linha.isEmpty())
							continue;
						dado = linha.split(csvSeparadorCampo);
						DataModel novoDado = newDataModel(dado);
						list.add(novoDado);
					}
				}
			} catch (IOException e) {
				System.err.println("error to read files " + e.getMessage());
			}
		}else {
			System.err.println("directory not found " + directory);
		}
		return list;
	}

	private DataModel newDataModel(String[] dado) {
		DataModel novoDado = new DataModel();
		novoDado.setNome(dado[0]);
		novoDado.setCpf(dado[1]);
		novoDado.setMatriculaServidor(dado[3]);
		novoDado.setNomeOrgao(dado[4]);
		novoDado.setSiglaOrgao(dado[5]);
		novoDado.setCodigoOrgaoSuperior(dado[6]);
		novoDado.setCargo(dado[7]);
		novoDado.setClasse(dado[8]);
		novoDado.setPadrao(dado[9]);
		novoDado.setReferencia(dado[10]);
		novoDado.setTipoAposentadoria(dado[11]);
		novoDado.setFundamentacaoInatividade(dado[12]);
		novoDado.setNomeDiploma(dado[13]);
		novoDado.setDataPublicacaoDiploma(dado[14]);
		novoDado.setIngressoServicoPublico(dado[15]);
		novoDado.setDataIngressoServico(dado[16]);
		novoDado.setValorRendimento(dado[17]);
		return novoDado;
	}
}
