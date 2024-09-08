package jogo;

public enum Tema {
	
	ACTION("Ação"),
	BUSINESS("Negócios"),
	COMEDY("Comédia"),
	DRAMA("Drama"),
	EDUCATIONAL("Educacional"),
	EROTIC("Erótico"),
	FANSTASY("Fantasia"),
	HISTORICAL("Histórico"),
	HORROR("Terror"),
	KIDS("Infantil"),
	MYSTERY("Mistério"),
	NON_FICTION("Real Game"),
	OPEN_WORD("Mundo Aberto"),
	PARTY("Festa"),
	ROMANCE("Romance"),
	SANDBOX("Caixa de areia"),
	SCIENCE_FICTION("Ficção Científica"),
	STEALTH("Stealth"),
	SURVIVAL("Sobrevivência"),
	THRILLER("Thriller"),
	WARFACE("Warface");
	
	private String tema;
	private Tema(String tema) {
		this.tema = tema;
	}
	
	public String getTema() {
		return tema;
	}
	
}