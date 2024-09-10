package jogo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Desenvolvedora {
	// Atributos;
	private String nome;
	private String paisDeOrigem;
	private String tipoDesenvolvedora;
	private LocalDate dataCriacao;

	/**
	 * Método construtor para a criação de novos objetos com valores definidos pelo
	 * usuário
	 * 
	 * @param nome               - Recebe o nome da desenvolvedora
	 * @param paisDeOrigem       - Recebe o pais de origem da desenvolvedora
	 * @param tipoDesenvolvedora - Recebe o tipo de desenvolvedora, por exeplo:
	 *                           Indie ou Grandes Desenvolvedoras
	 * @param dataCriacao        - Recebe a data de criação da desenvolvedora
	 */
	public Desenvolvedora(String nome, String paisDeOrigem, String tipoDesenvolvedora, LocalDate dataCriacao) {
		this.nome = nome;
		this.paisDeOrigem = paisDeOrigem;
		this.tipoDesenvolvedora = tipoDesenvolvedora;
		this.dataCriacao = dataCriacao;
	}

	/**
	 * Método para pegar o nome salvo da desenvolvedora
	 * 
	 * @return Retorna o nome salvo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para mudar o nome da desenvolvedora
	 * 
	 * @param nome - Recebe o novo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para pegar o tipo de desenvolvedora
	 * 
	 * @return Retorna o tipo salvo
	 */
	public String getTipoDesenvolvedora() {
		return tipoDesenvolvedora;
	}

	/**
	 * Método para mudar o tipo de desenvolvedora
	 * 
	 * @param tipoDesenvolvedora - Recebe um novo tipo
	 */
	public void setTipoDesenvolvedora(String tipoDesenvolvedora) {
		this.tipoDesenvolvedora = tipoDesenvolvedora;
	}

	/**
	 * Método para pegar o país de origem da desenvolvedora
	 * 
	 * @return Retorna o país salvo
	 */
	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	/**
	 * Método para pegar a data de criação da desenvolvedora
	 * 
	 * @return - Retorna a data salva
	 */
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * Método para formatar a data de criação da desenvolvedora
	 * 
	 * @return Retorna a data formatada
	 */
	private String formatarData() {
		String dataFormatada = this.dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return dataFormatada;
	}

	/**
	 * Método para formatar a impressão dos objetos
	 */
	@Override
	public String toString() {
		return "Desenvolvedora: " + nome + ", Pais: " + paisDeOrigem + ", tipoDesenvolvedora:" + tipoDesenvolvedora
				+ ", Criação: " + this.formatarData();
	}
}