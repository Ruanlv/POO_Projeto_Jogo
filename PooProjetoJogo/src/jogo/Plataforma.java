package jogo;

public class Plataforma {
	// Atributos
	private String tipo;
	private boolean subversao;

	/**
	 * Método construtor para a criação de novos objetos com valores definidos pelo
	 * usuário
	 * 
	 * @param tipo      - Recebe o tipo de plataforma que o jogo está presente
	 * @param subversao - Recebe true, caso o jogo tenha subversões ou false, caso
	 *                  ele não tenha
	 */
	public Plataforma(String tipo, boolean subversao) {
		this.tipo = tipo;
		this.subversao = subversao;
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
	public boolean isSubversao() {
		return subversao;
	}

	/**
	 * Método para mudar o estado do atributo subversao
	 * 
	 * @param subversao - Recebe o novo estado da subversao
	 */
	public void setSubversao(boolean subversao) {
		this.subversao = subversao;
	}

	/**
	 * Método para verificar se a subversao é true ou false. Esse método é usado
	 * dentro do toString
	 * 
	 * @return Retorna uma String com uma mensagem dizendo se o jogo tem subversões
	 *         ou não
	 */
	private String subVersao() {
		if (this.subversao) {
			return "O jogo tem subversões";
		}
		return "O jogo não tem subversões";
	}

	/**
	 * Método para formatar a impressão dos objetos
	 */
	@Override
	public String toString() {
		return "tipo=" + tipo + ", subversao=" + subVersao();
	}
}