package com.provaObj.jogoGourmet;

import java.util.ArrayList;
import java.util.*;

import javax.swing.JOptionPane;

public class JogoGourmetController {
	
	PratoList novoPrato(List<PratoList> novaLista, String anterior) {
		String descricao = JogoGourmetMensagens.perguntaDesisto();
		String tipo = JogoGourmetMensagens.mensagemCompleta(descricao, anterior);
		Prato novoPrato = new Prato(descricao,tipo);
		PratoList pratoListNovo = new PratoList(novoPrato);
		return pratoListNovo;
	}
	
	boolean validarPrato(List<PratoList> pratoLista) {
		for (PratoList prato : pratoLista) {
			int result = JogoGourmetMensagens.validarPrato(prato.getPrato().getTipo());
			if (result == JOptionPane.YES_OPTION) {
				if (prato.getPratoList() == null) {
					if (JogoGourmetMensagens.pratoNovo(prato.getPrato().getDescricao()) == JOptionPane.YES_OPTION) {
						JogoGourmetMensagens.repostaCorreta();
						return true;	
					} else {
						List<PratoList> novaLista = new ArrayList<>();
						novoPrato(novaLista, prato.getPrato().getDescricao());
						prato.setPratoList(novaLista);						
						return true;
					}
				} else {
					boolean validacaoPrato = validarPrato(prato.getPratoList());			
					if (validacaoPrato) {
						return true;
					} else {
						if (JogoGourmetMensagens.pratoNovo(prato.getPrato().getTipo()) == JOptionPane.YES_OPTION) {
							JogoGourmetMensagens.repostaCorreta();
							return true;
						} else {
							List<PratoList> novaListaPratos = prato.getPratoList();
							novoPrato(novaListaPratos, prato.getPrato().getDescricao());
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
