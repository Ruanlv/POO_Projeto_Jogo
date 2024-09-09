package jogo;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class TestaJogo {

	/**
	 * Método para criar um vetor de jogos, seja ele um vetor com tamanho padrão ou
	 * com um tamanho determinado pelo usuário
	 * 
	 * @param opcaoCriarVetor - Recebe um inteiro que será usado para escolher qual
	 *                        contrutor usar para criar o vetor de jogos
	 * @return Retorna um objeto da classe VetorJogo
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static VetorJogo criarVetorDeJogos(int opcaoCriarVetor) throws Exception {
		VetorJogo vetorJogos = null;
		do {
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
		} while (opcaoCriarVetor > 2 || opcaoCriarVetor < 1);

		return vetorJogos;
	}

	/**
	 * Método para formatar um menu de opções que será usada na manipulação dos
	 * objetos Jogo
	 * 
	 * @return Retorna uma String com o menu formatado
	 */
	public static String formatarMenuDeOpcoes() {
		return "1 - Cadastrar Novo Jogo\n2 - Cadastrar Novo Jogo em um posição especifica\n3 - Buscar Jogo pela posição"
				+ "\n4 - Buscar Jogo pelo nome\n5 - Excluir Jogo\n6 - Imprimir um Jogo\n7 - Imprimir todos os Jogos";
	}

	/**
	 * Método para receber um tamanho para criar o vetor da classe VetorObjeto com
	 * um tamanho determinado pelo usuário
	 * 
	 * @return Retorna um valor inteiro para criar o vetor com tamanho específico
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static int receberTamanhoVetorJogos() throws Exception {
		int tamanho = 0;

		do {
			tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um inteiro para inicializar o vetor",
					"Receber valor", JOptionPane.INFORMATION_MESSAGE));
		} while (tamanho < 1);

		return tamanho;
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Jogo cadastrarJogo() throws Exception {
		String[] dadosJogo = { "o Nome do jogo", " a Perspectiva do Jogador" };
		int quantidadeVendas = 0;

		for (int i = 0; i < dadosJogo.length; i++) {
			dadosJogo[i] = JOptionPane.showInputDialog(null, String.format("Digite o %s%n", dadosJogo[i]),
					"Dados do Jogo", JOptionPane.INFORMATION_MESSAGE);

			while (dadosJogo[i].isEmpty()) {
				dadosJogo[i] = JOptionPane.showInputDialog(null, "O campo não pode ficar vázio, digite novamente",
						"Dados do Jogo", JOptionPane.WARNING_MESSAGE);

			}
			if (dadosJogo[i] == null) {
				throw new Exception("Cannot parse null string");
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
		return new Jogo(dadosJogo[0], pegarDesenvolvedora(), pegarGeneroJogo(), pegarTemaJogo(), pegarModoDeJogo(),
				pegarClassificacaoIndicativa(), dadosJogo[1], pegarTipoPlataforma(), quantidadeVendas);
	}

	public static Desenvolvedora pegarDesenvolvedora() throws Exception {
		String[] dadosDesenvolvedora = { "Nome", "Pais de Origem", "Tipo" };
		int ano = 1, mes = 1, dia = 1;
		LocalDate dataCriacao = null;

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
				throw new Exception("Cannot parse null string");
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

			dataCriacao = LocalDate.of(ano, mes, dia);
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
		Genero genero;

		do {
			genero = (Genero) JOptionPane.showInputDialog(null, "Gêneros disponíveis:", "Escolha um Gênero",
					JOptionPane.INFORMATION_MESSAGE, null, Genero.values(), Genero.values());
		} while (genero == null);

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
		Tema tema;
		do {
			tema = (Tema) JOptionPane.showInputDialog(null, "Temas disponíveis", "Escolha um Tema",
					JOptionPane.INFORMATION_MESSAGE, null, Tema.values(), Tema.values());
		} while (tema == null);

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
		ModoDeJogo modoDeJogo;

		do {
			modoDeJogo = (ModoDeJogo) JOptionPane.showInputDialog(null, "Modos de jogos disponíveis",
					"Escolha uma Modo de Jogo", JOptionPane.INFORMATION_MESSAGE, null, ModoDeJogo.values(),
					ModoDeJogo.values());
		} while (modoDeJogo == null);

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
		ClassificacaoIndicativa classificacaoIndicativa;

		do {
			classificacaoIndicativa = (ClassificacaoIndicativa) JOptionPane.showInputDialog(null,
					"Classificação Indicativa:", "Escolha uma Classificação Indicativa",
					JOptionPane.INFORMATION_MESSAGE, null, ClassificacaoIndicativa.values(),
					ClassificacaoIndicativa.values());
		} while (classificacaoIndicativa == null);

		return classificacaoIndicativa;
	}

	public static Plataforma pegarTipoPlataforma() {
		String tipoPlataforma, subPlataforma;
		boolean subPlataformaResultado = false;

		tipoPlataforma = JOptionPane.showInputDialog(null,
				"Digite se o jogo é multi-plataforma ou a plataforma que o jogo roda:", "Plataforma",
				JOptionPane.INFORMATION_MESSAGE);

		while (tipoPlataforma.isEmpty()) {
			tipoPlataforma = JOptionPane.showInputDialog(null, "Dados inválidos, digite novamente", "Plataforma",
					JOptionPane.WARNING_MESSAGE);
		}

		do {

			subPlataforma = JOptionPane.showInputDialog(null, "O jogo tem subversões, digite Sim ou Não?", "Plataforma",
					JOptionPane.INFORMATION_MESSAGE);

			if (subPlataforma.equalsIgnoreCase("Sim")) {
				subPlataformaResultado = true;
				break;

			} else if (subPlataforma.equals("Não") || subPlataforma.equals("Nao")) {
				subPlataformaResultado = false;
				break;

			} else {
				subPlataforma = "";
			}
		} while (subPlataforma.isEmpty());

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

	// Método Main;
	public static void main(String[] args) {
		int opcao = -1, opcaoCriarVetor = 0, opcaoSair = 0;
		VetorJogo vetorJogos = null;

		while (true) {
			try {
				if (opcao == -1) {
					vetorJogos = criarVetorDeJogos(opcaoCriarVetor);
					opcao = 0;
				}
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
						String.format("Digite um opção válida:%n%s", formatarMenuDeOpcoes()), "Menu",
						JOptionPane.INFORMATION_MESSAGE));

				switch (opcao) {
				// Adicionar jogos ao vetor;
				case 1 -> {
					vetorJogos.adicionarElemento(cadastrarJogo());
				}
				// Adicionar jogos ao vetor em uma posição específica;
				case 2 -> {
					vetorJogos.adicionarElemento(receberPosicaoParaOVetor(vetorJogos), vetorJogos);
				}
				// Buscar elemento por posição;
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
				// Buscar elemento por nome
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
				// Remover jogo em uma determinada posição;
				case 5 -> {
					if (!(vetorJogos.estaVazio())) {
						vetorJogos.removerJogo(receberPosicaoParaOVetor(vetorJogos));
						
						JOptionPane.showMessageDialog(null, "Dado excluído com sucesso", "Remover Jogo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				// Imprimir um jogo específico;
				case 6 -> {
					if (!(vetorJogos.estaVazio())) {
						JOptionPane.showMessageDialog(null,
								vetorJogos.imprimirElemento(receberPosicaoParaOVetor(vetorJogos)), "Jogo",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				// Imprimir todos os jogos;
				case 7 -> {
					if (!(vetorJogos.estaVazio())) {
						JOptionPane.showMessageDialog(null, String.format(
								"Quantidade de jogos criados: %d%nComprimento total do vetor: %d%nQuantidade de elementos no vetor: %d%n%n%s",
								Jogo.getQuantidadeInstancia(), vetorJogos.getComprimento(), vetorJogos.getTamanho(),
								vetorJogos.toString()));

					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				default -> {
					JOptionPane.showMessageDialog(null, "Opção inválida, digite novamente", "Opção Inválida",
							JOptionPane.WARNING_MESSAGE);
					continue;
				}
				}

			} catch (Exception ex) {
				// Pegando a mensagem de erro;
				String erro = ex.getMessage();

				if (erro.contains("For input string:")) {
					JOptionPane.showMessageDialog(null, "Inserção inválida de dados, digite novamente");

				} else if (erro.contains("Cannot parse null string")) {
					opcaoSair = JOptionPane.showConfirmDialog(null,
							"Realmente deseja sair do sistem? Aperte sim para sair | Aparte não ou cancelar para ficar no sistema",
							"Sair do Sistema", JOptionPane.INFORMATION_MESSAGE);
				
					if (opcaoSair == 0) {
						JOptionPane.showMessageDialog(null, "Fechado o sistema, aguarde", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					continue;
				
				} else if (vetorJogos.estaVazio()) {
					JOptionPane.showMessageDialog(null, "Não há jogos salvos", "Erro", JOptionPane.ERROR_MESSAGE);
				
				} else {
					JOptionPane.showMessageDialog(null, "Erro: " + erro, "Erro", JOptionPane.ERROR_MESSAGE);
				}
				// TODO: Analisar as exceções, depois remover o System.out.println();
				System.out.println(ex.getMessage());
			}
		}
	}
}