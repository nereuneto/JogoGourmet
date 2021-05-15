package com.provaObj.jogoGourmet;

import java.util.ArrayList;
import java.util.*;

import javax.swing.JOptionPane;

public class JogoGourmetController {
	
	void novoPrato(List<PratoList> novaLista, String anterior) {
		String description = JogoGourmetMensagens.perguntaDesisto();
		String characteristic = JogoGourmetMensagens.mensagemCompleta(description, anterior);
		novaLista.add(new PratoList(new Prato(description, characteristic)));
	}
	
	boolean validarPrato(List<PratoList> pratoLista) {
		for (PratoList prato : pratoLista) {
			int result = JogoGourmetMensagens.validarPrato(prato.getPrato().getDescricao());
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
						if (JogoGourmetMensagens.pratoNovo(prato.getPrato().getDescricao()) == JOptionPane.YES_OPTION) {
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
