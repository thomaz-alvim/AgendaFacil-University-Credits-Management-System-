package controllers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import models.*;

/**
 * Controlador do sistema. Armazena estudantes e eventos em mapas.
 */
public class AgendaFacil {
	private Map<String, Estudante> estudantes;
	private Map<Integer, Evento> eventos;
	private int proximoId;
	
	public AgendaFacil() {
		this.estudantes = new HashMap<>();
		this.eventos = new HashMap<>();
	}
	
	// Estudantes
	
	public boolean cadastrarEstudante(String nome, String email) {
		if (email == null || email.isEmpty()) {
			throw new NullPointerException("Nenhum email foi digitado.");
		}
		if (estudantes.containsKey(email)) {
			throw new IllegalArgumentException("Este estudante já possui cadastro.");
		}
		estudantes.put(email, new Estudante(nome, email));
		return true;
	}
	
	public String exibirEstudante(String email) {
		return estudantes.get(email).toString();
	}
	
	public String[] listarEstudantes() {
		return estudantes.values().stream().sorted(Comparator.comparingInt(Estudante::getQuantidadePontos).reversed()).map(Estudante::toString).toArray(String[]::new);
	}
	
	// Eventos
	
	public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes) {
		proximoId++;
		eventos.put(proximoId, new Palestra(titulo, descricao, data, maxParticipantes, proximoId));
		return proximoId;
	}
	
	public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		proximoId++;
		eventos.put(proximoId, new Workshop(titulo, descricao, data, maxParticipantes, duracao, proximoId));
		return proximoId;
	}
	
	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao) {
		proximoId++;
		eventos.put(proximoId, new OficinaAprendizagem(titulo, descricao, data, maxParticipantes, duracao, certificacao, proximoId));
		return proximoId;
	}
	
	public boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento) {
		Evento evento = eventos.get(idEvento);
		Estudante estudante = estudantes.get(emailParticipante);
		
		if (evento.checarParticipante(estudante) == true) {
			throw new IllegalArgumentException("Este estudante já está cadastrado neste evento.");
		}
		if (evento.checarLotado() == true) {
			throw new IllegalArgumentException("Este evento já está lotado.");
		}
		
		evento.adicionarParticipante(estudante);
		
		estudante.adicionarEvento();
		estudante.adicionarPontos(evento.getPontuacao());
		
		return true;
	}
	
	public String exibirDetalhesEvento (int idEvento) {
		Evento evento = eventos.get(idEvento);
		return evento.toString();
	}

}
