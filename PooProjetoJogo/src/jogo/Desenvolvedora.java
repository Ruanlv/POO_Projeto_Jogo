package jogo;

import java.time.LocalDate;

public class Desenvolvedora {
	private String nome;
	private String paisDeOrigem;
	private String tipoDesenvolvedora;
	private LocalDate dataCriacao;
	
	public Desenvolvedora(String nome, String paisDeOrigem, String tipoDesenvolvedora, LocalDate dataCriacao) {
		this.nome = nome;
		this.paisDeOrigem = paisDeOrigem;
		this.tipoDesenvolvedora = tipoDesenvolvedora;
		this.dataCriacao = dataCriacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoDesenvolvedora() {
		return tipoDesenvolvedora;
	}

	public void setTipoDesenvolvedora(String tipoDesenvolvedora) {
		this.tipoDesenvolvedora = tipoDesenvolvedora;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	@Override
	public String toString() {
		return "Desenvolvedora [nome=" + nome + ", paisDeOrigem=" + paisDeOrigem + ", tipoDesenvolvedora="
				+ tipoDesenvolvedora + ", dataCriacao=" + dataCriacao + "]";
	}
}