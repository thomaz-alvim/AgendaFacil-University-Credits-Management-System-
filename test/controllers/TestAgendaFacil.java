package controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAgendaFacil {
	private AgendaFacil sistema;
	
	@BeforeEach
	void setup() {
		// Fixed: Now correctly initializes the class attribute instead of a local variable
		this.sistema = new AgendaFacil();
	}
	
	@Test
	void testCalculoPontuacaoEstudante() {
		// Testing requirement: Validar o cálculo da pontuação dos estudantes
		sistema.cadastrarEstudante("Alice", "alice@email.com");
		int idPalestra = sistema.cadastrarPalestra("Palestra Java", "Intro", "10/10", 50);
		
		sistema.inscreverParticipanteEmEvento("alice@email.com", idPalestra);
		
		// A Palestra should give exactly 2 points
		String detalhes = sistema.exibirEstudante("alice@email.com");
		assertTrue(detalhes.contains("Quantidade de Pontos: 2"));
	}
	
	@Test
	void testRankingEstudantesPorPontuacao() {
		// Testing requirement: Validar o ranking dos estudantes por pontuação
		sistema.cadastrarEstudante("Alice", "alice@email.com");
		sistema.cadastrarEstudante("Bob", "bob@email.com");
		
		// An Oficina of 5 hours with certification should give 15 points (5 + 10)
		int idOficina = sistema.cadastrarOficinaAprendizagem("Oficina de Spring", "Desc", "11/10", 30, 5, true); 
		
		// Bob registers and gets 15 points. Alice has 0.
		sistema.inscreverParticipanteEmEvento("bob@email.com", idOficina);
		
		// Bob should now appear first in the ranking
		String[] ranking = sistema.listarEstudantes();
		assertTrue(ranking[0].contains("bob@email.com"));
		assertTrue(ranking[1].contains("alice@email.com"));
	}
}