package com.provaObj.jogoGourmet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class JogoGourmetView {
	private boolean fechar = false;
	private List<PratoList> pratoList = new ArrayList<>();
	private List<PratoList> boloList = new ArrayList<>();
	private JogoGourmetController controller = new JogoGourmetController();
	
	public void iniciarJogo() {
		int jogo = JogoGourmetMensagens.mensagemInicial();
		if (jogo == JOptionPane.NO_OPTION || jogo == JOptionPane.CLOSED_OPTION) {
			System.exit(1);
		}
		if (JogoGourmetMensagens.perguntaMassa() == 0) {			
			if (!controller.validarPrato(this.pratoList)) { 
				if (JogoGourmetMensagens.perguntaLasanha() == 0) {
					JogoGourmetMensagens.repostaCorreta();
				} else {
					pratoList.add(controller.novoPrato(this.pratoList ,ConstJogoGourmet.LASANHA));
				}	
			}
		} else {
			if (!controller.validarPrato(this.boloList)) { 
				if (JogoGourmetMensagens.perguntaBolo() == 0) {
					JogoGourmetMensagens.repostaCorreta();
				} else {
					boloList.add(controller.novoPrato(this.boloList, ConstJogoGourmet.BOLO_DE_CHOCOLATE));
				}	
			}
		}
		iniciarJogo();
	}
	
	public boolean getBotaoFechar() {
		return fechar;
	}
}
