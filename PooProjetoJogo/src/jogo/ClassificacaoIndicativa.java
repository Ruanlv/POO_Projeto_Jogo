package jogo;

public enum ClassificacaoIndicativa {
	
	LIVRE("Livre"),
	MENORES_DE_10_ANOS("Não recomendado para menores de 10 anos"),
	MENORES_DE_12_ANOS("Não recomendado para menores de 12 anos"),
	MENORES_DE_14_ANOS("Não recomendado para menores de 14 anos"),
	MENORES_DE_16_ANOS("Não recomendado para menores de 16 anos"),
	MENORES_DE_18_ANOS("Não recomendado para menores de 18 anos");

	private String classificacao;
	
	private ClassificacaoIndicativa(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getClassificacao() {
		return classificacao;
	}
	
}
