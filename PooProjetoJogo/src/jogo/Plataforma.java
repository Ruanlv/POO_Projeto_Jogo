package jogo;

public class Plataforma {
	// Atributos
	private String tipo;
	private boolean versaoAlternativa;

	/**
	 * Método construtor para a criação de novos objetos com valores definidos pelo
	 * usuário
	 * 
	 * @param tipo      - Recebe o tipo de plataforma que o jogo está presente
	 * @param subversao - Recebe true, caso o jogo tenha subversões ou false, caso
	 *                  ele não tenha
	 */
	public Plataforma(String tipo, boolean versaoAlternativa) {
		this.tipo = tipo;
		this.versaoAlternativa = versaoAlternativa;
	}

	/**
	 * Método para pegar o tipo de plataforma
	 * 
	 * @return Retorna o tipo salvo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método para mudar o tipo de plataforma
	 * 
	 * @param tipo - Recebe o novo tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método para verificar qual é o estado do atributo subversao
	 * 
	 * @return Retorna o estado da subversao
	 */
	public boolean isVersaoAlternativa() {
		return versaoAlternativa;
	}

	/**
	 * Método para mudar o estado do atributo subversao
	 * 
	 * @param subversao - Recebe o novo estado da subversao
	 */
	public void setVersaoAlternativa(boolean versaoAlternativa) {
		this.versaoAlternativa = versaoAlternativa;
	}

	/**
	 * Método para verificar se o versaoAlternativa é true ou false. A versão
	 * alternativa é usada para verificar se o jogo tem outras versões do mesmo
	 * jogo. Exemplos: Minecraft Java (Original) e Minecraft Bedrock (versão
	 * alternativa), ambos são Minecraft com alguns diferenças entre si, mas a sua
	 * estrutura é a mesma.
	 * 
	 * @return Retorna uma String com uma mensagem dizendo se o jogo tem alguma versão alternativa ou não
	 *         ou não
	 */
	private String versaoAlternativa() {
		if (this.versaoAlternativa) {
			return "O jogo tem versões alternativas";
		}
		return "O jogo não tem versões alternativas";
	}

	/**
	 * Método para formatar a impressão dos objetos
	 */
	@Override
	public String toString() {
		return "Tipo: " + tipo + ", Subversão: " + versaoAlternativa();
	}
}