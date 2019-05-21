package br.unisul.databaseload;

public class DataModel {

	private String nome;
	private String cpf;
	private String matriculaServidor;
	private String nomeOrgao;
	private String siglaOrgao;
	private String codigoOrgaoSuperior;
	private String cargo;
	private String classe;
	private String padrao;
	private String referencia;
	private String nivel;
	private String tipoAposentadoria;
	private String fundamentacaoInatividade;
	private String nomeDiploma;
	private String dataPublicacaoDiploma;
	private String ingressoServicoPublico;
	private String dataIngressoServico;
	private String valorRendimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getMatriculaServidor() {
		return matriculaServidor;
	}
	public void setMatriculaServidor(String matriculaServidor) {
		this.matriculaServidor = matriculaServidor;
	}
	public String getNomeOrgao() {
		return nomeOrgao;
	}
	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}
	public String getSiglaOrgao() {
		return siglaOrgao;
	}
	public void setSiglaOrgao(String siglaOrgao) {
		this.siglaOrgao = siglaOrgao;
	}
	public String getCodigoOrgaoSuperior() {
		return codigoOrgaoSuperior;
	}
	public void setCodigoOrgaoSuperior(String codigoOrgaoSuperior) {
		this.codigoOrgaoSuperior = codigoOrgaoSuperior;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getPadrao() {
		return padrao;
	}
	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getTipoAposentadoria() {
		return tipoAposentadoria;
	}
	public void setTipoAposentadoria(String tipoAposentadoria) {
		this.tipoAposentadoria = tipoAposentadoria;
	}
	public String getFundamentacaoInatividade() {
		return fundamentacaoInatividade;
	}
	public void setFundamentacaoInatividade(String fundamentacaoInatividade) {
		this.fundamentacaoInatividade = fundamentacaoInatividade;
	}
	public String getNomeDiploma() {
		return nomeDiploma;
	}
	public void setNomeDiploma(String nomeDiploma) {
		this.nomeDiploma = nomeDiploma;
	}
	public String getDataPublicacaoDiploma() {
		return dataPublicacaoDiploma;
	}
	public void setDataPublicacaoDiploma(String dataPublicacaoDiploma) {
		this.dataPublicacaoDiploma = dataPublicacaoDiploma;
	}
	public String getIngressoServicoPublico() {
		return ingressoServicoPublico;
	}
	public void setIngressoServicoPublico(String ingressoServicoPublico) {
		this.ingressoServicoPublico = ingressoServicoPublico;
	}
	public String getDataIngressoServico() {
		return dataIngressoServico;
	}
	public void setDataIngressoServico(String dataIngressoServico) {
		this.dataIngressoServico = dataIngressoServico;
	}
	public String getValorRendimento() {
		return valorRendimento;
	}
	public void setValorRendimento(String valorRendimento) {
		this.valorRendimento = valorRendimento;
	}
	@Override
	public String toString() {
		return "DataModel [nome=" + nome + ", cpf=" + cpf + ", matriculaServidor=" + matriculaServidor + ", nomeOrgao="
				+ nomeOrgao + ", siglaOrgao=" + siglaOrgao + ", codigoOrgaoSuperior=" + codigoOrgaoSuperior + ", cargo="
				+ cargo + ", classe=" + classe + ", padrao=" + padrao + ", referencia=" + referencia + ", nivel="
				+ nivel + ", tipoAposentadoria=" + tipoAposentadoria + ", fundamentacaoInatividade="
				+ fundamentacaoInatividade + ", nomeDiploma=" + nomeDiploma + ", dataPublicacaoDiploma="
				+ dataPublicacaoDiploma + ", ingressoServicoPublico=" + ingressoServicoPublico
				+ ", dataIngressoServico=" + dataIngressoServico + ", valorRendimento=" + valorRendimento
				+ ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getMatriculaServidor()="
				+ getMatriculaServidor() + ", getNomeOrgao()=" + getNomeOrgao() + ", getSiglaOrgao()=" + getSiglaOrgao()
				+ ", getCodigoOrgaoSuperior()=" + getCodigoOrgaoSuperior() + ", getCargo()=" + getCargo()
				+ ", getClasse()=" + getClasse() + ", getPadrao()=" + getPadrao() + ", getReferencia()="
				+ getReferencia() + ", getNivel()=" + getNivel() + ", getTipoAposentadoria()=" + getTipoAposentadoria()
				+ ", getFundamentacaoInatividade()=" + getFundamentacaoInatividade() + ", getNomeDiploma()="
				+ getNomeDiploma() + ", getDataPublicacaoDiploma()=" + getDataPublicacaoDiploma()
				+ ", getIngressoServicoPublico()=" + getIngressoServicoPublico() + ", getDataIngressoServico()="
				+ getDataIngressoServico() + ", getValorRendimento()=" + getValorRendimento() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}