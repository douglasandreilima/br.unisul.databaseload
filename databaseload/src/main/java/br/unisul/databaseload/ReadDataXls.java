package br.unisul.databaseload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


public class ReadDataXls {

	public List<DataModel> ler(String caminho) {

        String arquivoCSV = caminho;
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";
        String[] dado = null;
        List<DataModel> list = new ArrayList<DataModel>();

        try {
            conteudoCSV = new BufferedReader(new FileReader(arquivoCSV));

            while ((linha = conteudoCSV.readLine()) != null) {
                dado = linha.split(csvSeparadorCampo);

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
                
                list.add(novoDado);
            }

        } catch (IOException e) {
        }
        
        return list;
    }
}
