package com.provaObj.jogoGourmet;

import java.util.List;

public class PratoList {
	private Prato prato;
	private List<PratoList> pratoList;
	
	public PratoList(Prato prato) {
		this.prato = prato;
	}
	
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	public List<PratoList> getPratoList() {
		return pratoList;
	}
	public void setPratoList(List<PratoList> pratoList) {
		this.pratoList = pratoList;
	}	
}
