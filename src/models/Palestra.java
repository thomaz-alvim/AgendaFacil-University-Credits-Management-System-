package models;

import java.util.HashSet;

public class Palestra extends Evento {
	
	public Palestra(String titulo, String descricao, String data, int maxParticipantes, int proximoId) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.id = proximoId;
		this.pontuacao = 2;
		this.maxParticipantes = maxParticipantes;
		this.participantes = new HashSet<Estudante>();
	}

}
