package models;

import java.util.Objects;

/**
 * Classe de entidade. Cria objetos de Estudantes.
 */
public class Estudante {
	private String nome;
	private String email;
	private int quantidadeEventos;
	private int quantidadePontos;
	
	public Estudante (String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	// Getters
	
	public String getNome() {return this.nome;}
	
	public String getEmail() {return this.email;}
	
	public int getQuantidadeEventos() {return this.quantidadeEventos;}
	
	public int getQuantidadePontos() {return this.quantidadePontos;}
	
	// Setters
	
	public void adicionarEvento() {
		this.quantidadeEventos++;
	}
	
	public void adicionarPontos(int pontuacaoNova) {
		this.quantidadePontos += pontuacaoNova;
	}
	
	// Overrides
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return nome + "(" + email + ")" + "\n" + "Quantidade de Eventos: " + quantidadeEventos + "\n" + "Quantidade de Pontos: " + quantidadePontos;
	}

}
