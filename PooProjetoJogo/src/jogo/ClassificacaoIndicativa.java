package jogo;

public enum ClassificacaoIndicativa {
	// Instâncias
	LIVRE("Livre"),
	MAIORES_DE_10_ANOS("Não recomendado para menores de 10 anos"),
	MAIORES_DE_12_ANOS("Não recomendado para menores de 12 anos"),
	MAIORES_DE_14_ANOS("Não recomendado para menores de 14 anos"),
	MAIORES_DE_16_ANOS("Não recomendado para menores de 16 anos"),
	MAIORES_DE_18_ANOS("Não recomendado para menores de 18 anos");

	// Atributo;
	private String classificacao;
	
	/**
	 * Método construtor para as instâncias da enumeração 
	 * 
	 * @param classificacao - Valor da enumeração
	 */
	private ClassificacaoIndicativa(String classificacao) {
		this.classificacao = classificacao;
	}

	/**
	 * Método para pegar o valor salvo na enumeração
	 * 
	 * @return Retorna o valor salvo;
	 */
	public String getClassificacao() {
		return String.format("Classificação Indicativa: %s", this.classificacao);
	}
}
