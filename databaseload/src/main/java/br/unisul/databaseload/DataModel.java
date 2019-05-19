package br.unisul.databaseload;

public class DataModel {

	private int cnpj;
	private String nome;
	private String endereco;
	public String produto;
	public boolean finish;

	public DataModel() {

	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "DataModel [cnpj=" + cnpj + ", " + (nome != null ? "nome=" + nome + ", " : "")
				+ (endereco != null ? "endereco=" + endereco + ", " : "")
				+ (produto != null ? "produto=" + produto + ", " : "") + "finish=" + finish + "]";
	}

}