package jogo;

public enum Tema {
	// Instâncias
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
	
	// Atributo;
	private String tema;
	
	/**
	 * Método construtor para as instâncias da enumeração
	 * 
	 * @param tema - Valor da enumeração
	 */
	private Tema(String tema) {
		this.tema = tema;
	}
	
	/**
	 * Método para pegar o valor salvo na enumeração
	 * 
	 * @return Retorna o valor salvo;
	 */
	public String getTema() {
		return String.format("Tema: %s", this.tema);
	}
	
}