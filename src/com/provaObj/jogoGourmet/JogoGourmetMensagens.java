package com.provaObj.jogoGourmet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JogoGourmetMensagens {
	private static final Object[] opcoes = { "Sim", "Não"};
	
	private static JLabel textoJustificado(String mensagem) {
		JLabel label = new JLabel(mensagem);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}
	
	public static int mensagemInicial() {
		Object[] options = { "Ok", "Fechar"};
		return JOptionPane.showOptionDialog(null, textoJustificado(ConstJogoGourmet.PRATO_GOSTO), ConstJogoGourmet.JOGO_GOURMET, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}
	
	public static int perguntaMassa() {
		return JOptionPane.showOptionDialog(null, textoJustificado(ConstJogoGourmet.PRATO_MASSA), ConstJogoGourmet.CONFIRMAR, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
	
	public static int perguntaLasanha() {
		return JOptionPane.showOptionDialog(null, textoJustificado(ConstJogoGourmet.PRATO_MASSA_LASANHA), ConstJogoGourmet.CONFIRMAR, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}

	public static void repostaCorreta() {
		JOptionPane.showMessageDialog(null, textoJustificado(ConstJogoGourmet.ACERTEI), ConstJogoGourmet.JOGO_GOURMET, 1);
	}

	public static int perguntaBolo() {
		return JOptionPane.showOptionDialog(null, textoJustificado(ConstJogoGourmet.PRATO_BOLO), ConstJogoGourmet.CONFIRMAR, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}

	public static String perguntaDesisto() {
		return JOptionPane.showInputDialog(null, ConstJogoGourmet.PRATO_PENSOU, ConstJogoGourmet.DESISTO, 3);
	}

	public static String mensagemCompleta(String descricao, String tipo) {
		return JOptionPane.showInputDialog(null, descricao + ConstJogoGourmet.PRATO_MAS + tipo + ConstJogoGourmet.NEGATIVO, ConstJogoGourmet.COMPLETE, 3);
	}

	public static int pratoNovo(String description) {				
		if (JOptionPane.showOptionDialog(null, ConstJogoGourmet.PRATO_PENSOU + description + ConstJogoGourmet.INTERROGACAO, ConstJogoGourmet.CONFIRMAR, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]) == JOptionPane.YES_OPTION) {
			return JOptionPane.YES_OPTION;				 
		} 
		return JOptionPane.NO_OPTION;
	}
	
	public static int validarPrato(String prato) {
		if (JOptionPane.showOptionDialog(null, ConstJogoGourmet.PRATO_PENSOU + prato + ConstJogoGourmet.INTERROGACAO, ConstJogoGourmet.CONFIRMAR, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]) == JOptionPane.YES_OPTION) {		
			return JOptionPane.YES_OPTION;
		}
		return JOptionPane.NO_OPTION;
	}
}
