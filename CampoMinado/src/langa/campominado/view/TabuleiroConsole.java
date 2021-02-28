package langa.campominado.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import langa.campominado.exception.ExplosaoException;
import langa.campominado.exception.SairException;
import langa.campominado.model.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner (System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				ciclodoJogo();
				System.out.println("Jogar novamente? (S/n) ");
				String resposta = entrada.nextLine();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
			}
			
		}catch(SairException e ){
			
			System.out.println("Adeus!");
			
		}finally {
			entrada.close();
		}
		
	}

	private void ciclodoJogo() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = pegarValorDigitado("Digite (x,y): ");
				
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();
				digitado = pegarValorDigitado("Digite\n1 - Abrir\n2 - (Des)Marcar");
				
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else {
					tabuleiro.marcar(xy.next(), xy.next());
				}
			}
			System.out.println(tabuleiro);
			System.out.println("Você ganhou!!");
		}catch(ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!");
			
		}
		
	}
	
	private String pegarValorDigitado(String texto) {
		System.out.println(texto);
		String digitado = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		
		return digitado;
	}
	

}
