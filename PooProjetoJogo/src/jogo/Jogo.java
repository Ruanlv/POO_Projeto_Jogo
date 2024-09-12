package jogo;

public class Jogo {
	// Atributos dos objetos;
	private String nome;
	private Desenvolvedora desenvolvedora;
	private Genero genero;
	private Tema temaJogo;
	private ModoDeJogo modoDejogo;
	private ClassificacaoIndicativa classificacaoIndicativa;
	private String perspectivaJogador;
	private Plataforma plataforma;
	private int quantidadeVendas;
	// Atributo da classe;
	private static int quantidadeInstancia = 0;

	/**
	 * Método construtor para a criação de novos objetos com valores definidos pelo
	 * usuário
	 * 
	 * @param nome                    - Recebe o nome do Jogo
	 * @param desenvolvedora          - Recebe os dados da Desenvolvedora
	 * @param genero                  - Recebe um gênero
	 * @param temaJogo                - Recebe um tema para o jogo
	 * @param modoDejogo              - Recebe um modo de jogo
	 * @param classificacaoIndicativa - Recebe uma classificação indicativa
	 * @param perpectivaJogador       - Recebe uma perspectiva para o jogo
	 * @param plataforma              - Recebe uma plataforma para o jogo
	 * @param quantidadeVendas        - Recebe a quantidade de vendas do jogo
	 */
	public Jogo(String nome, Desenvolvedora desenvolvedora, Genero genero, Tema temaJogo, ModoDeJogo modoDejogo,
			ClassificacaoIndicativa classificacaoIndicativa, String perspectivaJogador, Plataforma plataforma,
			int quantidadeVendas) {
		this.nome = nome;
		this.desenvolvedora = desenvolvedora;
		this.genero = genero;
		this.temaJogo = temaJogo;
		this.modoDejogo = modoDejogo;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.perspectivaJogador = perspectivaJogador;
		this.plataforma = plataforma;
		this.quantidadeVendas = quantidadeVendas;
		++quantidadeInstancia;
	}

	/**
	 * Métodos para pegar o nome do jogo salvo
	 * 
	 * @return Retorna o nome salvo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para mudar o nome do jogo
	 * 
	 * @param nome - Recebe o novo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para pegar os dados da desenvolvedora do jogo salvo
	 * 
	 * @return Retorna os dados da desenvolvedora
	 */
	public Desenvolvedora getDesenvolvedora() {
		return desenvolvedora;
	}

	/**
	 * Método para pegar o gênero do jogo salvo
	 * 
	 * @return Retorna o gênero salvo
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Método para mudar o gênero do jogo salvo
	 * 
	 * @param genero - Recebe o novo gênero
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Método para pegar o tema do jogo salvo
	 * 
	 * @return Retorna o tema salvo
	 */
	public Tema getTemaJogo() {
		return temaJogo;
	}

	/**
	 * Método para mudar o tema do jogo salvo
	 * 
	 * @param temaJogo - Recebe o novo tema
	 */
	public void setTemaJogo(Tema temaJogo) {
		this.temaJogo = temaJogo;
	}

	/**
	 * Método para pegar o modo de jogo salvo
	 * 
	 * @return Retorna o modo de jogo salvo
	 */
	public ModoDeJogo getModoDejogo() {
		return modoDejogo;
	}

	/**
	 * Método para mudar o modo de jogo salva
	 * 
	 * @param modoDejogo - Recebe o novo modo de jogo
	 */
	public void setModoDejogo(ModoDeJogo modoDejogo) {
		this.modoDejogo = modoDejogo;
	}

	/**
	 * Método para pegar a classificação indicativa do jogo salva
	 * 
	 * @return Retorna a classificação indicativa salva
	 */
	public ClassificacaoIndicativa getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	/**
	 * Método para mudar a classificação indicativa salva
	 * 
	 * @param classificacaoIndicativa - Recebe a nova classificação indicativa
	 */
	public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	/**
	 * Método para pegar a perspectiva do jogador salvo
	 * 
	 * @return Retorna a perspectiva salva
	 */
	public String getPerpectivaJogador() {
		return perspectivaJogador;
	}

	/**
	 * Método para mudar a perspectiva do jogador
	 * 
	 * @param perspectivaJogador - Recebe a nova perspectiva do jogador
	 */
	public void setPerspectivaJogador(String perspectivaJogador) {
		this.perspectivaJogador = perspectivaJogador;
	}

	/**
	 * Método para pegar a plataforma do jogo salvo
	 * 
	 * @return Retorna a plataforma salva
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * Método para mudar a plataforma do jogo salva
	 * 
	 * @param plataforma - Recebe a nova Plataforma
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Método para pegar a quantidade de vendas do jogo salvo
	 * 
	 * @return Retorna a quantidade de vendas
	 */
	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	/**
	 * Método para mudar a quantidade de vendas do jogo
	 * 
	 * @param quantidadeVendas - Recebe a nova quantidade de vendas
	 */
	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	/**
	 * Método estático para pegar o total de instâncias criadas
	 * 
	 * @return Retorna a quantidade de objetos do tipo Jogo criadas
	 */
	public static int getQuantidadeInstancia() {
		return quantidadeInstancia;
	}

	/**
	 * Método para formatar a saida da informação de vendas do jogo, ou informa que
	 * o jogo não tem quantidade de vendas por ser gratuíto
	 * 
	 * @return Retorna uma String formatada com informações da quantidade de vendas,
	 *         ou caso o jogo seja gratuíto uma mensagem dizem que o jogo não tem
	 *         essa informação
	 * 
	 */
	private String formatarInformacaoPreco() {
		if (this.quantidadeVendas == 0) {
			return "O jogo não tem informações de vendas, pois ele é gratuito";
		}
		return String.format("Total de vendas: %d", this.quantidadeVendas);
	}

	/**
	 * Método para formatar a impressão dos objetos
	 */
	@Override
	public String toString() {
		return "Jogo: " + this.nome + ", Perspectiva: " + this.perspectivaJogador + ", Quantidade de Vendas: "
				+ this.formatarInformacaoPreco() + "\n" + desenvolvedora + "\n" + genero.getNome() + ", "
				+ temaJogo.getTema() + ", " + modoDejogo.getModo() + "\n" + classificacaoIndicativa.getClassificacao()
				+ "\n" + plataforma;
	}
}