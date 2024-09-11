package jogo;

public final class VetorJogo {

	// Atributos;
	private Object[] elementos;
	private int tamanho;
	private int comprimento;

	/**
	 * Método construtor para criar um vetor de objetos com um tamanho definido pelo
	 * usuário
	 * 
	 * @param tamanhoVetor - Recebe um valor inteiro para criar o vetor com um
	 *                     tamanho específico
	 */
	public VetorJogo(int tamanhoVetor) {
		this.elementos = new Object[tamanhoVetor];
		this.tamanho = 0;
		this.comprimento = elementos.length;
	}

	/**
	 * Método construtor para criar um vetor com tamanho padrão
	 */
	public VetorJogo() {
		this(10);
	}

	/**
	 * Método para pegar o comprimento total do vetor
	 * 
	 * @return Retorna o comprimento do vetor
	 */
	public int getComprimento() {
		return comprimento;
	}

	/**
	 * Método para pegar o tamanho do vetor, neste caso o tamanho é a quantidade de
	 * elementos presente dentro do vetor
	 * 
	 * @return Retorna o tamanho do vetor
	 */
	public int getTamanho() {
		return this.tamanho;
	}

	/**
	 * Método para verificar se o vetor está vazio, ou seja sem elementos
	 * 
	 * @return Retorna true se o vetor estiver vazio ou false caso ele tenha
	 *         elementos
	 */
	public boolean estaVazia() {
		return tamanho == 0;
	}

	/**
	 * Método para aumentar a capacidade do vetor quando o mesmo tiver o tamanho, ou
	 * seja a quantidade de elementos dentro do vetor igual ao tamaho do total do
	 * vetor
	 */
	private void aumentarCapacidade() {
		if (this.tamanho == this.elementos.length) {
			Object[] elementosNovos = new Object[this.elementos.length * 2];

			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos;
			}
			this.elementos = elementosNovos;
		}
	}

	/**
	 * Método para adicionar um objeto dentro do vetor
	 * 
	 * @param elemento - Recebe o objeto a ser adicionado ao vetor
	 * @throws Exception Para as exceções que podem ocorrer
	 */
	public void adicionarElemento(Object elemento) throws Exception {
		aumentarCapacidade();
		this.elementos[this.tamanho] = elemento;
		this.tamanho++;
	}

	/**
	 * Método para adicionar um objeto dentro vetor em um posição específica
	 * 
	 * @param posicao  - Recebe a posição na qual o usuário deseja colocar o objeto
	 * @param elemento - Recebe o objeto a ser adicionado ao vetor
	 * @throws Exception Para as execeções que podem ocorrer
	 */
	public void adicionarElemento(int posicao, Object elemento) throws Exception {
		if (posicao >= this.comprimento) {
			throw new Exception(
					"Não é possível adicionar um elemento nesta posição, pois ela está fora dos limites do vetor");
		}

		if (posicao >= 0 && posicao < this.comprimento) {
			for (int i = this.tamanho - 1; i >= posicao; i--) {
				this.elementos[i + 1] = this.elementos[i];
			}
			this.elementos[posicao] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Posição Inválida");
		}
	}

	/**
	 * Método para buscar um elemento através de um valor inteiro
	 * 
	 * @param posicao - Recebe a posição que o usuário deseja realizar a busca
	 * @return Retorna o objeto que foi encontrado na posição informada
	 * @throws Exception Para as execeções que podem ocorrer
	 */
	public Object buscarElemento(int posicao) throws Exception {
		if (this.estaVazia()) {
			throw new Exception("Não é possível realizar a busca se o vetor estiver vazio");
		}

		if (posicao >= 0 && posicao < tamanho) {
			return this.elementos[posicao];
		} else {
			throw new Exception("Posição Inválida");
		}
	}

	/**
	 * Método para buscar um elemento através do nome do Jogo
	 * 
	 * @param elemento - Recebe o nome do Jogo que deseja buscar
	 * @return Retorna a posição do jogo
	 * @throws Exception Para as execeções que podem ocorrer
	 */
	public int buscarElemento(String elemento) throws Exception {
		if (this.estaVazia()) {
			throw new Exception("Não é possível realizar a busca se o vetor estiver vazio");
		}

		for (int i = 0; i < this.elementos.length; i++) {
			Jogo jogo = (Jogo) this.elementos[i];

			if (elementos[i] == null) {
				continue;
			} else {
				if (jogo.getNome().equalsIgnoreCase(elemento)) {
					return i;
				}
			}
		}
		throw new Exception("Não foi possível encontrar esse Jogo");
	}

	/**
	 * Método para buscar o jogo mais vendido da lista
	 * 
	 * @return Retorna uma String formatada com alguns dados do jogo mais vendido
	 * @throws Exception Para as exceções que podem acontencer
	 */
	public String buscarJogoMaisVendido() throws Exception {
		int maior = Integer.MIN_VALUE;
		Jogo jogoResultado = null;

		if (this.estaVazia()) {
			throw new Exception("Não é possível buscar o jogo mais vendido, pois o vetor está vazio");
		}

		for (int i = 0; i < this.elementos.length; i++) {
			Jogo jogo = (Jogo) this.elementos[i];

			if (jogo == null || jogo.getQuantidadeVendas() == 0) {
				continue;
			}

			if (jogo.getQuantidadeVendas() > maior) {
				jogoResultado = jogo;
				maior = jogo.getQuantidadeVendas();
			}
		}
		return (jogoResultado == null ? "Você não cadastrou jogos pagos"
				: String.format("O jogo %s teve um total de %d vendas", jogoResultado.getNome(),
						jogoResultado.getQuantidadeVendas()));
	}

	/**
	 * Método para buscar o jogo menos vendido da lista
	 * 
	 * @return Retorna uma String formatada com alguns dados do jogo menos vendido
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public String buscarJogoMenosVendido() throws Exception {
		int menor = Integer.MAX_VALUE;
		Jogo jogoResultado = null;

		if (this.estaVazia()) {
			throw new Exception("Não é possível buscar o jogo menos vendido, pois o vetor está vazio");
		}

		for (int i = 0; i < this.elementos.length; i++) {
			Jogo jogo = (Jogo) this.elementos[i];

			if (jogo == null || jogo.getQuantidadeVendas() == 0) {
				continue;
			}

			if (jogo.getQuantidadeVendas() < menor) {
				jogoResultado = jogo;
				menor = jogo.getQuantidadeVendas();
			}
		}

		return (jogoResultado == null ? "Você não cadastrou jogos pagos"
				: String.format("O jogo mais vendido é %s ele teve um total de %d vendas", jogoResultado.getNome(),
						jogoResultado.getQuantidadeVendas()));
	}

	/**
	 * Método para remover os jogos do vetor
	 * 
	 * @param posicao - Recebe a posição de um jogo que deseja remover
	 * @throws Exception Para as execeções que podem ocorrer
	 */
	public void removerJogo(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			for (int i = posicao; i < this.tamanho - 1; i++) {
				this.elementos[i] = this.elementos[i + 1];
			}
			this.tamanho--;
		} else {
			throw new Exception("Posição inválida");
		}
	}

	/**
	 * Método para imprimir um Jogo, escolhido pelo usuário
	 * 
	 * @param posicao - Recebe a posição de um jogo que deseja imprimir
	 * @return Retorna uma String formatada com os dados do Jogo
	 * @throws Exception Para as execeções que podem ocorrer
	 */
	public String imprimirElemento(int posicao) throws Exception {
		if (posicao >= 0 && posicao < this.comprimento - 1) {
			if (this.elementos[posicao] == null) {
				return "Sem jogo";
			}
			StringBuilder s = new StringBuilder();
			s.append(this.elementos[posicao]);
			return s.toString();

		} else {
			throw new Exception("Elementro não encontrado");
		}
	}

	/**
	 * Método para formatar a impressão dos objetos
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (Object obj : this.elementos) {
			if (obj == null) {
				continue;
			}
			s.append(obj);
			s.append("\n");
			s.append("\n");
		}
		return s.toString();
	}
}
