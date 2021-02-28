package langa.campominado;

import langa.campominado.model.Tabuleiro;
import langa.campominado.view.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,1);
		
		new TabuleiroConsole(tabuleiro);
		
		
	}

}
