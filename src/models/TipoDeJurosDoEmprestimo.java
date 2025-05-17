package models;

public enum TipoDeJurosDoEmprestimo {
	SIMPLES("simples"),
	COMPOSTO("composto");
	
	private String tipoDeJurosDoEmprestimo;
	
	private TipoDeJurosDoEmprestimo(String tipoDeJurosDoEmprestimo) {
		this.tipoDeJurosDoEmprestimo=tipoDeJurosDoEmprestimo;
	}
	
	public String getTipoDeJurosDoEmprestimo() {
		return this.tipoDeJurosDoEmprestimo;
	}
}
