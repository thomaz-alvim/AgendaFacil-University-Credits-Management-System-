package controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes.
 */
public class TestAgendaFacil {
	private AgendaFacil sistema;
	
	@BeforeEach
	void setup() {
		this.sistema = new AgendaFacil();
	}
	
	@Test
	void testCalculoPontuacaoEstudante() {
		sistema.cadastrarEstudante("Alice", "alice@email.com");
		int idPalestra = sistema.cadastrarPalestra("Palestra Java", "Intro", "10/10", 50);
		
		sistema.inscreverParticipanteEmEvento("alice@email.com", idPalestra);
		
		String detalhes = sistema.exibirEstudante("alice@email.com");
		assertTrue(detalhes.contains("Quantidade de Pontos: 2"));
	}
	
	@Test
	void testRankingEstudantesPorPontuacao() {
		sistema.cadastrarEstudante("Alice", "alice@email.com");
		sistema.cadastrarEstudante("Bob", "bob@email.com");
		
		int idOficina = sistema.cadastrarOficinaAprendizagem("Oficina de Spring", "Desc", "11/10", 30, 5, true); 
		
		sistema.inscreverParticipanteEmEvento("bob@email.com", idOficina);
		
		String[] ranking = sistema.listarEstudantes();
		assertTrue(ranking[0].contains("bob@email.com"));
		assertTrue(ranking[1].contains("alice@email.com"));
	}
}