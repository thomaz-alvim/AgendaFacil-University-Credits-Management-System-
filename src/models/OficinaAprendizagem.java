package models;

import java.util.HashSet;

public class OficinaAprendizagem extends Evento {
	private int duracao;
	private boolean certificacao;
	private String emiteCertificacao;
	
	public OficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao, int proximoId) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.duracao = duracao;
		this.certificacao = certificacao;
		this.id = proximoId;
		this.maxParticipantes = maxParticipantes;
		this.participantes = new HashSet<Estudante>();
		
		if (certificacao) {
			this.pontuacao = duracao + 10;
			this.emiteCertificacao = "Emite certificação";
		}
		else {
			this.pontuacao = duracao;
			this.emiteCertificacao = "Não emite certificação";
		}
		}
		
		@Override
		public String toString() {
			return super.toString() + "\n" + "Duração: " + duracao + "\n" + emiteCertificacao;
		}

}
