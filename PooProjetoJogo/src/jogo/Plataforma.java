package jogo;

public class Plataforma {
	private String tipo;
	private boolean subversao;

	public Plataforma(String tipo, boolean subversao) {
		this.tipo = tipo;
		this.subversao = subversao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isSubversao() {
		return subversao;
	}

	public void setSubversao(boolean subversao) {
		this.subversao = subversao;
	}

	private String subVersao() {
		if (subversao) {
			return "O jogo tem subversões";
		}
		return "O jogo não tem subversões";
	}

	@Override
	public String toString() {
		return "Plataforma [tipo=" + tipo + ", subversao=" + subVersao() + "]";
	}
	
	

}
