package langa.campominado.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import langa.campominado.exception.ExplosaoException;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		 campo = new Campo(3, 3);
	}

	
	//LATERAIS, SUPERIOR E INFERIOR
	@Test
	void testeVizinhoRealDistancia1() {
		Campo vizinhoEsquerda = new Campo(3, 2);
		boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);
		assertTrue(resultadoEsquerda);
		
		Campo vizinhoDireita = new Campo(3, 4);
		boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultadoDireita);
		
		Campo vizinhoSuperior = new Campo(4, 3);
		boolean resultadoSuperior = campo.adicionarVizinho(vizinhoSuperior);
		assertTrue(resultadoSuperior);
		
		Campo vizinhoInferior = new Campo(2, 3);
		boolean resultadoInferior = campo.adicionarVizinho(vizinhoInferior);
		assertTrue(resultadoInferior);
	}
	
	//DIAGONAIS
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinhoSuperiorEsquerda = new Campo(2, 2);
		boolean resultadoSuperiorEsquerda = campo.adicionarVizinho(vizinhoSuperiorEsquerda);
		assertTrue(resultadoSuperiorEsquerda);
		
		Campo vizinhoSuperiorDireita = new Campo(2, 4);
		boolean resultadoSuperiorDireita = campo.adicionarVizinho(vizinhoSuperiorDireita);
		assertTrue(resultadoSuperiorDireita);
		
		Campo vizinhoInferiorEsquerda = new Campo(4, 2);
		boolean resultadoInferiorEsquerda = campo.adicionarVizinho(vizinhoInferiorEsquerda);
		assertTrue(resultadoInferiorEsquerda);
		
		Campo vizinhoInferiorDireita = new Campo(4, 4);
		boolean resultadoInferiorDireita = campo.adicionarVizinho(vizinhoInferiorDireita);
		assertTrue(resultadoInferiorDireita);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo naoVizinho = new Campo(1, 1);
		boolean resultadonaoVizinho = campo.adicionarVizinho(naoVizinho);
		assertFalse(resultadonaoVizinho);

	}
	
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasVezes() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeValorPadraoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinaNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinaMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinaMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinaNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () ->{
			campo.abrir();
		});
		
	}
	
	@Test
	void testeAbrirComVizinhos() {
		Campo campo22 = new Campo(2,2);
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		
		campo.adicionarVizinho(campo22);
		
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		
		campo.abrir();
		assertTrue(campo22.isAberto() && !campo11.isAberto());
	}
	
	
	
	

}
