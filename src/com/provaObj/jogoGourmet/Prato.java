package com.provaObj.jogoGourmet;

public class Prato {
	private String prato;
	private String tipo;

	public Prato(String descricao, String tipo) {
		this.prato = descricao;
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return prato;
	}
	public void setDescricao(String descricao) {
		this.prato = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
