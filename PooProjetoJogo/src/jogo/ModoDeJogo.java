package jogo;

public enum ModoDeJogo {
	// Instâncias
	CO_OP("Co-Operative"),
	MMO("Massively Multiplayer Online"),
	MULTIPLAYER("Multiplayer"),		
	SINGLE_PLAYER("Single Player"),	
	SPLIT_SCREEN("Split Screen"),
	BATTLE_ROYALE("Battle Royale");

	// Atributo;
	private String modo;

	/**
	 * Método construtor para as instâncias da enumeração
	 * 
	 * @param modo - Valor da enumeração
	 */
	private ModoDeJogo(String modo) {
		this.modo = modo;
	}

	/**
	 * Método para pegar o valor salvo na enumeração
	 * 
	 * @return Retorna o valor salvo;
	 */
	public String getModo() {
		return String.format("Modo de Jogo: %s", this.modo);
	}
}
