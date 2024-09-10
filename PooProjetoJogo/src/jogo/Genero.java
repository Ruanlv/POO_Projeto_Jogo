package jogo;

public enum Genero {
	// Instâncias
	ADVENTURE("Aventura"),
	ARCADE("Arcade"),
	CARD_BOARD_GAME("Jogo de Cartas e Tabuleiro"),
	FIGHTING("Luta"),
	HACK_AND_SLASH("Hack and Slash"),
	INDIE("Indie"),
	MOBA("Moba"),
	MUSIC("Música"),
	PINBALL("Pinball"),
	PLATFORM("Plataforma"),
	POINT_AND_CLICK("Apontar e Clicar"),
	PUZZLE("Quebrea-Cabeça"),
	QUIZ_TRIVIA("Quiz ou Curiosidades"),
	RACING("Corrida"),
	REAL_TIME_STRATEGY("Estratégia em Tempo Real - RTS"),
	SHOOTER("Atirador"),
	SIMULATOR("Simulador"),
	SPORT("Esporte"),
	STRATEGY("Estratégia"),
	TACTICAL("Tático"),
	TURN_BASED_STRATEGY("Estratégia Baseada em Turnos - TBS"),
	VISUAL_NOVEL("Visual Novel");

	// Atributo;
	private String genero;
	
	/**
	 * Método construtor para as instâncias da enumeração
	 * 
	 * @param genero - Valor da enumeração
	 */
	private Genero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Método para pegar o valor salvo na enumeração
	 * 
	 * @return Retorna o valor salvo;
	 */
	public String getNome() {
		return genero;
	}
}
