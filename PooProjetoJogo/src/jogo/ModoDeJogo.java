package jogo;

public enum ModoDeJogo {
	CO_OP("Co-Operative"),
	MMO("Massively Multiplayer Online"),
	MULTIPLAYER("Multiplayer"),		
	SINGLE_PLAYER("Single Player"),	
	SPLIT_SCREEN("Split Screen"),
	BATTLE_ROYALE("Battle Royale");

	private String modo;

	private ModoDeJogo(String modo) {
		this.modo = modo;
	}

	public String getModo() {
		return modo;
	}
}
