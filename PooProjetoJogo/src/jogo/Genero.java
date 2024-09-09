package jogo;

public enum Genero {
	// Instâncias
	ADVENTURE("Aventura"),
	ARCADE("Arcade"),
	CARD_BOARD_GAME("Card & Board Game"),
	FIGHTING("Fighting"),
	HACK_AND_SLASH("Hack and Slash"),
	INDIE("Indie"),
	MOBA("Moba"),
	MUSIC("Music"),
	PINBALL("Pinball"),
	PLATFORM("Platform"),
	POINT_AND_CLICK("Point and Click"),
	PUZZLE("Puzzle"),
	QUIZ_TRIVIA("Quiz or trivia"),
	RACING("Racing"),
	REAL_TIME_STRATEGY("Real Time Strategy - RTS"),
	SHOOTER("Shooter"),
	SIMULATOR("Simulator"),
	SPORT("Sport"),
	STRATEGY("Strategy"),
	TACTICAL("Tactical"),
	TURN_BASED_STRATEGY("Turn based Strategy - TBS"),
	VISUAL_NOVEL("Novel game");

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
