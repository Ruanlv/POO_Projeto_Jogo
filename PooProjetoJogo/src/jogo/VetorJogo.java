package jogo;

public final class VetorJogo {

	private Object[] elementos;
	private int tamanho;
	private int comprimento;

	public VetorJogo(int tamanhoVetor) {
		this.elementos = new Object[tamanhoVetor];
		this.tamanho = 0;
		this.comprimento = elementos.length;
	}

	public VetorJogo() {
		this(10);
	}

	public int getComprimento() {
		return comprimento;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public boolean estaVazio() {
		return tamanho == 0;
	}

	private void aumentarCapacidade() {
		if (this.tamanho == this.elementos.length) {
			Object[] elementosNovos = new Object[this.elementos.length * 2];

			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos;
			}
			this.elementos = elementosNovos;
		}
	}

	public void adicionarElemento(Object elemento) throws Exception {
		aumentarCapacidade();
		this.elementos[this.tamanho] = elemento;
		this.tamanho++;
	}

	public void adicionarElemento(int posicao, Object elemento) throws Exception {
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

	public Object buscarElemento(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			return this.elementos[posicao];
		} else {
			throw new Exception("Posição Inválida");
		}
	}

	public int buscarElemento(String elemento) throws Exception {
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

	public String imprimirVeiculo(int posicao) throws Exception {
		if (posicao >= 0 && posicao < this.comprimento - 1) {
			StringBuilder s = new StringBuilder();
			s.append(this.elementos[posicao]);
			s.append("\n");

			return s.toString();
		} else {
			throw new Exception("Elementro não encontrado");
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (Object obj : this.elementos) {
			if (obj == null) {
				continue;
			}
			s.append(obj);
			s.append(", ");
		}
		return s.toString();
	}
}
