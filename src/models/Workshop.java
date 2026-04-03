package models;

/**
 * Classe de entidade. Cria objetos de Workshop.
 */
public class Workshop extends Evento {
	private int duracao;
	
	public Workshop(String titulo, String descricao, String data, int maxParticipantes, int duracao, int proximoId) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.duracao = duracao;
		this.id = proximoId;
		this.pontuacao = duracao;
		this.maxParticipantes = maxParticipantes;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + "Duração: " + duracao;
	}

}
