package br.unisul.databaseload;

public class DataModel {

	private int idnEmpreendimento;
	private int idnDigs;
	private String dscTitulo;
	public boolean finish;

	public DataModel(int idnEmpreendimento, int idnDigs, String dscTitulo) {
		super();
		this.idnEmpreendimento = idnEmpreendimento;
		this.idnDigs = idnDigs;
		this.dscTitulo = dscTitulo;
	}

	public DataModel() {

	}

	public int getIdnEmpreendimento() {
		return idnEmpreendimento;
	}

	public void setIdnEmpreendimento(int idnEmpreendimento) {
		this.idnEmpreendimento = idnEmpreendimento;
	}

	public int getIdnDigs() {
		return idnDigs;
	}

	public void setIdnDigs(int idnDigs) {
		this.idnDigs = idnDigs;
	}

	public String getDscTitulo() {
		return dscTitulo;
	}

	public void setDscTitulo(String dscTitulo) {
		this.dscTitulo = dscTitulo;
	}

	@Override
	public String toString() {
		return "Dado [idnEmpreendimento=" + idnEmpreendimento + ", idnDigs=" + idnDigs + ", "
				+ (dscTitulo != null ? "dscTitulo=" + dscTitulo : "") + "]";
	}
}
