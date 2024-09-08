package jogo;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class TestaJogo {
	public static void main(String[] args) {
		int opcao = 0;
		VetorJogo vetorJogos = null;
		int opcaoCriarVetor = 0;
		int opcaoSair = 0;

		do {
			try {
				opcaoCriarVetor = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1 - Para criar um vetor com um tamanho padrão\n2 - Para criar um vetor com um tamanho específico",
						"Digite o que Você Deseja", JOptionPane.QUESTION_MESSAGE));

				switch (opcaoCriarVetor) {
				case 1 -> {
					vetorJogos = new VetorJogo();
				}
				case 2 -> {
					vetorJogos = new VetorJogo(receberTamanhoVetorJogos());
				}
				default -> {
					JOptionPane.showMessageDialog(null, "Digite novamente", "Criar Vetor", JOptionPane.WARNING_MESSAGE);
				}
				}
			} catch (Exception ex) {
				// Pegando a mensagem de erro;
				String erro = ex.getMessage();
				if (erro.contains("For input string:")) {
					JOptionPane.showMessageDialog(null, "Inserção inválida de dados, digite novamente");

				} else if (erro.contains("Cannot parse null string")) {
					JOptionPane.showMessageDialog(null, "Fechado o sistema, aguarde", "Mensagem",
							JOptionPane.WARNING_MESSAGE);
					System.exit(opcao);
				} else {
					JOptionPane.showMessageDialog(null, "Erro: " + erro, "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (opcaoCriarVetor > 2 || opcaoCriarVetor < 1);

		while (true) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
						String.format("Digite um opção válida:%n%s", formatarMenuDeOpcoes()), "Menu",
						JOptionPane.INFORMATION_MESSAGE));

				switch (opcao) {
				case 1 -> {
					vetorJogos.adicionarElemento(cadastrarJogo());
				}
				case 2 -> {
					vetorJogos.adicionarElemento(receberPosicaoParaOVetor(vetorJogos), vetorJogos);
				}
				case 3 -> {
					if (!(vetorJogos.estaVazio())) {
						JOptionPane.showMessageDialog(null,
								vetorJogos.buscarElemento(receberPosicaoParaOVetor(vetorJogos)), "Elemento",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				case 4 -> {
					if (!(vetorJogos.estaVazio())) {
						JOptionPane.showMessageDialog(null,
								String.format("O jogo foi encontrado na posição %d do vetor%n",
										vetorJogos.buscarElemento(receberNomeDoJogoParaBuscar())),
								"Busca por Nome", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				case 5 -> {
					if (!(vetorJogos.estaVazio())) {
						vetorJogos.removerJogo(receberPosicaoParaOVetor(vetorJogos));
					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
					vetorJogos.removerJogo(receberPosicaoParaOVetor(vetorJogos));
				}
				case 6 -> {
					if (!(vetorJogos.estaVazio())) {
						JOptionPane.showMessageDialog(null,
								vetorJogos.imprimirVeiculo(receberPosicaoParaOVetor(vetorJogos)), "Jogo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
					vetorJogos.imprimirVeiculo(receberPosicaoParaOVetor(vetorJogos));
				}
				case 7 -> {
					if (!(vetorJogos.estaVazio())) {
						JOptionPane.showMessageDialog(null, String.format("Quantidade de jogos criados %d%nJogos:%n%s",
								Jogo.getQuantidadeInstancia(), vetorJogos.toString()));

					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				case 8 -> {
					opcaoSair = JOptionPane.showConfirmDialog(null,
							"Realmente deseja sair do sistem? Aperte sim para sair | Aparte não ou cancelar para ficar no sistema",
							"Sair do Sistema", JOptionPane.INFORMATION_MESSAGE);

					if (opcaoSair == 0) {
						break;
					}
					continue;

				}
				default -> {
					JOptionPane.showMessageDialog(null, "Opção inválida, digite novamente", "Opção Inválida",
							JOptionPane.WARNING_MESSAGE);
					continue;
				}
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println(ex.getMessage());
			}
		}
	}

	public static String formatarMenuDeOpcoes() {
		return "1 - Cadastrar Novo Jogo\n2 - Cadastrar Novo Jogo em um posição especifica\n3 - Buscar Jogo pela posição"
				+ "\n4 - Buscar Jogo pelo nome\n5 - Excluir Jogo\n6 - Imprimir um Jogo\n7 - Imprimir todos os Jogos\n8 - Sair";
	}

	public static int receberTamanhoVetorJogos() throws Exception {
		int tamanho = 0;

		do {
			tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um inteiro para inicializar o vetor",
					"Receber valor", JOptionPane.INFORMATION_MESSAGE));
		} while (tamanho < 1);

		return tamanho;
	}

	public static Jogo cadastrarJogo() throws Exception {
		String[] dadosJogo = { "o Nome do jogo", " a Perspectiva do Jogador" };
		int quantidadeVendas = 0;
		// Desenvolvedora;
		Desenvolvedora desenvolvedora = pegarDesenvolvedora();
		// Enumerações;
		Genero genero = pegarGeneroJogo();
		Tema tema = pegarTemaJogo();
		ModoDeJogo modoDeJogo = pegarModoDeJogo();
		ClassificacaoIndicativa classificacaoIndicativa = pegarClassificacaoIndicativa();
		// Plataforma
		Plataforma plataforma = pegarTipoPlataforma();

		for (int i = 0; i < dadosJogo.length; i++) {
			dadosJogo[i] = JOptionPane.showInputDialog(null, String.format("Digite o %s%n", dadosJogo[i]),
					"Dados do Jogo", JOptionPane.INFORMATION_MESSAGE);

			while (dadosJogo[i].isEmpty()) {
				dadosJogo[i] = JOptionPane.showInputDialog(null, "O campo não pode ficar vázio, digite novamente",
						"Dados do Jogo", JOptionPane.WARNING_MESSAGE);

			}

			if (dadosJogo[i] == null) {
				// TODO: O programa deverá sair;
			}

			if (i == dadosJogo.length - 1) {
				quantidadeVendas = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de vendas total do jogo",
								"Dados do Jogo", JOptionPane.INFORMATION_MESSAGE));

				while (quantidadeVendas < 0) {
					quantidadeVendas = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Digite a quantidade de vendas válida", "Dados do Jogo", JOptionPane.WARNING_MESSAGE));
				}
			}
		}
		return new Jogo(dadosJogo[0], desenvolvedora, genero, tema, modoDeJogo, classificacaoIndicativa, dadosJogo[1],
				plataforma, quantidadeVendas);
	}

	public static Desenvolvedora pegarDesenvolvedora() throws Exception {
		String[] dadosDesenvolvedora = { "Nome", "Pais de Origem", "tipoDesenvolvedora" };
		int ano = 0, mes = 0, dia = 0;
		LocalDate dataCriacao = LocalDate.of(2018, 07, 22);

		for (int i = 0; i < dadosDesenvolvedora.length; i++) {
			dadosDesenvolvedora[i] = JOptionPane.showInputDialog(null,
					String.format("Digite o %s da desenvolvedora%n", dadosDesenvolvedora[i]), "Dados da Desenvolvedora",
					JOptionPane.INFORMATION_MESSAGE);

			while (dadosDesenvolvedora[i].isEmpty()) {
				dadosDesenvolvedora[i] = JOptionPane.showInputDialog(null,
						"O campo não pode ficar vazio, digite novamnte", "Dados da Desenvolvedora",
						JOptionPane.INFORMATION_MESSAGE);
			}

			if (dadosDesenvolvedora[i] == null) {
				// TODO: O programa deverá sair;
			}

			if (i == dadosDesenvolvedora.length - 1) {
				do {
					ano = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de criação de desenvolvedora",
									"Dados da desenvolvedora", JOptionPane.INFORMATION_MESSAGE));
					mes = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Digite o mês de criação de desenvolvedora",
									"Dados da desenvolvedora", JOptionPane.INFORMATION_MESSAGE));
					dia = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Digite o dia de criação de desenvolvedora",
									"Dados da desenvolvedora", JOptionPane.INFORMATION_MESSAGE));

				} while (ano < 0 || mes < 0 || mes > 12 || dia < 0 || dia > 31);
			}

			// dataCriacao = LocalDate.of(ano, mes, dia);
		}
		return new Desenvolvedora(dadosDesenvolvedora[0], dadosDesenvolvedora[1], dadosDesenvolvedora[2], dataCriacao);
	}

	/**
	 * Método para pegar o gênero do jogo
	 * 
	 * @param genero - Recebe o genêro
	 * @return - Retorna o gênero escolhido
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static Genero pegarGeneroJogo() throws Exception {
		Genero genero = (Genero) JOptionPane.showInputDialog(null, "Gêneros disponíveis:", "Escolha um Gênero",
				JOptionPane.INFORMATION_MESSAGE, null, Genero.values(), Genero.values());

		return genero;
	}

	/**
	 * Método para pegar o tema do jogo
	 * 
	 * @param tema - Recebe o tema
	 * @return Retorna o tema escolhido
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static Tema pegarTemaJogo() throws Exception {
		Tema tema = (Tema) JOptionPane.showInputDialog(null, "Temas disponíveis", "Escolha um Tema",
				JOptionPane.INFORMATION_MESSAGE, null, Tema.values(), Tema.values());

		return tema;
	}

	/**
	 * Método para modo de jogo
	 * 
	 * @param modoDeJogo - Recebe o modo de jogo
	 * @return Retorna o modo de jogo escolhido
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static ModoDeJogo pegarModoDeJogo() throws Exception {
		ModoDeJogo modoDeJogo = (ModoDeJogo) JOptionPane.showInputDialog(null, "Modos de jogos disponíveis",
				"Escolha uma Modo de Jogo", JOptionPane.INFORMATION_MESSAGE, null, ModoDeJogo.values(),
				ModoDeJogo.values());

		return modoDeJogo;
	}

	/**
	 * Método para pegar a classificação indicativa
	 * 
	 * @param classificacaoIndicativa - Recebe a classificação indicativa
	 * @return Retorna a classificação indicativa escolhida
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static ClassificacaoIndicativa pegarClassificacaoIndicativa() throws Exception {
		ClassificacaoIndicativa classificacaoIndicativa = (ClassificacaoIndicativa) JOptionPane.showInputDialog(null,
				"Classificação Indicativa:", "Escolha uma Classificação Indicativa", JOptionPane.INFORMATION_MESSAGE,
				null, ClassificacaoIndicativa.values(), ClassificacaoIndicativa.values());

		return classificacaoIndicativa;
	}

	public static Plataforma pegarTipoPlataforma() {
		String tipoPlataforma, subPlataforma;
		boolean subPlataformaResultado;

		tipoPlataforma = JOptionPane.showInputDialog(null,
				"Digite se o jogo é multi-plataforma ou a plataforma que o jogo roda:", "Plataforma",
				JOptionPane.INFORMATION_MESSAGE);

		while (tipoPlataforma.isEmpty()) {
			tipoPlataforma = JOptionPane.showInputDialog(null, "Dados inválidos, digite novamente", "Plataforma",
					JOptionPane.WARNING_MESSAGE);
		}

		subPlataforma = JOptionPane.showInputDialog(null, "O jogo tem subversões, digite Sim ou Não?", "Plataforma",
				JOptionPane.INFORMATION_MESSAGE);

		while (!(subPlataforma.equalsIgnoreCase("SIM")) || (subPlataforma.equalsIgnoreCase("NÃO"))
				|| subPlataforma.isEmpty()) {
			subPlataforma = JOptionPane.showInputDialog(null,
					"Valor inválido, digite sim se jogo tiver subversões ou não caso ele não tenha", "Plataforma",
					JOptionPane.WARNING_MESSAGE);
		}

		if (subPlataforma.equalsIgnoreCase("SIM")) {
			subPlataformaResultado = true;
		} else {
			subPlataformaResultado = false;
		}

		return new Plataforma(tipoPlataforma, subPlataformaResultado);
	}

	public static int receberPosicaoParaOVetor(VetorJogo vetorJogos) throws Exception {
		int posicao;

		posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual posição você deseja acessar",
				"Posição do Vetor", JOptionPane.INFORMATION_MESSAGE));

		while (posicao < 0 || posicao > vetorJogos.getComprimento() - 1) {
			posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor inválido, digite novamente",
					"Posição do Vetor", JOptionPane.INFORMATION_MESSAGE));
		}

		return posicao;
	}

	public static String receberNomeDoJogoParaBuscar() {
		String nome;

		nome = JOptionPane.showInputDialog(null, "Digite o nome do jogo que deseja procurar", "Procurar Jogo por Nome",
				JOptionPane.INFORMATION_MESSAGE);

		while (nome.isEmpty()) {
			nome = JOptionPane.showInputDialog(null, "O campo não pode ficar vazio, digite novamente",
					"Procurar Jogo por Nome", JOptionPane.WARNING_MESSAGE);
		}
		return nome;
	}
}