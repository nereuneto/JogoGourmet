package com.provaObj.jogoGourmet;

import java.util.ArrayList;
import java.util.*;

import javax.swing.JOptionPane;

public class JogoGourmetController {
	
	List<PratoList> listaPrato = new ArrayList<>();
	
	PratoList novoPrato(String anterior) {
		String descricao = JogoGourmetMensagens.perguntaDesisto();
		String tipo = JogoGourmetMensagens.mensagemCompleta(descricao, anterior);
		Prato novoPrato = new Prato(descricao,tipo);
		PratoList pratoListNovo = new PratoList(novoPrato);
		return pratoListNovo;
	}
	
	boolean validarPrato(List<PratoList> pratoLista, boolean isTipo) {
		for (PratoList prato : pratoLista) {
			int result;
			if(isTipo) {
				result = JogoGourmetMensagens.validarPrato(prato.getPrato().getTipo());
			}else {
				result = JogoGourmetMensagens.validarPrato(prato.getPrato().getDescricao());
			}
			if (result == JOptionPane.YES_OPTION) {
				if (prato.getPratoList() == null) {
					if (JogoGourmetMensagens.pratoNovo(prato.getPrato().getDescricao()) == JOptionPane.YES_OPTION) {
						JogoGourmetMensagens.repostaCorreta();
						return true;	
					} else {
						listaPrato.add(novoPrato(prato.getPrato().getDescricao()));
						prato.setPratoList(listaPrato);
						return true;
					}
				} else {
					boolean validacaoPrato = validarPrato(prato.getPratoList(),false);			
					if (validacaoPrato) {
						return true;
					} else {
						if (JogoGourmetMensagens.pratoNovo(prato.getPrato().getDescricao()) == JOptionPane.YES_OPTION) {
							JogoGourmetMensagens.repostaCorreta();
							return true;
						} else {
							List<PratoList> novaListaPratos = prato.getPratoList();
							novaListaPratos.add(novoPrato(prato.getPrato().getDescricao()));
							prato.setPratoList(novaListaPratos);		
							return true;
						}
					}
				}
			} 
		} 
		return false;
	}
}
