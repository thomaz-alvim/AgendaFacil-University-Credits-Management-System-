package models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Superclasse de 3 classes de entidade. Armazena seus participantes em um Set.
 */
public abstract class Evento {
	protected String titulo;
	protected String descricao;
	protected String data;
	protected int id;
	protected int pontuacao;
	protected int maxParticipantes;
	protected Set<Estudante> participantes = new HashSet<Estudante>();
	
	// Getters
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	// Lógica
	
	public void adicionarParticipante(Estudante estudante) {
		participantes.add(estudante);
	}
	
	public boolean checarParticipante(Estudante estudante) {
		return participantes.contains(estudante);
	}
	
	public boolean checarLotado() {
		return participantes.size() >= maxParticipantes;
	}
	
	// Overrides
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return titulo + "\n" + descricao + "\n" + "Data: " + data + "\n" + "Pontuação: " + pontuacao
				+ "\n" + "Participantes: " + participantes.toString();
	}
	
}
