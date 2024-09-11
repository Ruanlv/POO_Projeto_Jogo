package jogo;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public final class ServicoJogo {
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
	 * Método para cadastrar um jogo, recebendo os dados e instanciando o novo
	 * objeto que será colocado em um vetor
	 * 
	 * @return Retorna um novo objeto do tipo Jogo
	 * @throws Exception Para as exceções que podem acontecer
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
				quantidadeVendas = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Digite a quantidade de vendas total do jogo. Caso o jogo seja gratuito digite 0",
						"Dados do Jogo", JOptionPane.INFORMATION_MESSAGE));

				while (quantidadeVendas < 0) {
					quantidadeVendas = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Digite a quantidade de vendas válida", "Dados do Jogo", JOptionPane.WARNING_MESSAGE));
				}
			}
		}
		return new Jogo(dadosJogo[0], cadastrarDesenvolvedora(), pegarGeneroJogo(), pegarTemaJogo(), pegarModoDeJogo(),
				pegarClassificacaoIndicativa(), dadosJogo[1], pegarTipoPlataforma(), quantidadeVendas);
	}

	/**
	 * Método para criar novos objetos da classe Desenvolvedora
	 * 
	 * @return Retorna um novo objeto da classe Desenvolvedora que será usado para
	 *         criar um jogo
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static Desenvolvedora cadastrarDesenvolvedora() throws Exception {
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
	 * Método para pegar uma enumeração do gênero do jogo, com base na escolha do
	 * usuário
	 * 
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
	 * Método para pegar uma enumeração do tema do jogo, com base na escolha do
	 * usuário
	 * 
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
	 * Método para modo uma enumeração do modo de jogo, com base na escolha do
	 * usuário
	 * 
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
	 * Método para pegar uma enumeração da classificação indicativa do jogo, com
	 * base na escolha do usuário
	 * 
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

	/**
	 * Método para receber os dados da plataforma do jogo. Esses dados são o tipo da
	 * plataforma, ou seja, se o jogo roda em uma plataforma em específico ou se
	 * roda em várias plataformas, e se o jogo tem subversões, por exemplo.
	 * 
	 * @return
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static Plataforma pegarTipoPlataforma() throws Exception {
		String tipoPlataforma, versaoAlternativa;
		boolean versaoAlternativaResultado = false;

		tipoPlataforma = JOptionPane.showInputDialog(null,
				"Digite se o jogo é multi-plataforma ou a plataforma que o jogo roda:", "Plataforma",
				JOptionPane.INFORMATION_MESSAGE);

		while (tipoPlataforma.isEmpty()) {
			tipoPlataforma = JOptionPane.showInputDialog(null, "Dados inválidos, digite novamente", "Plataforma",
					JOptionPane.WARNING_MESSAGE);
		}

		do {

			versaoAlternativa = JOptionPane.showInputDialog(null, "O jogo tem subversões, digite Sim ou Não?",
					"Plataforma", JOptionPane.INFORMATION_MESSAGE);

			if (versaoAlternativa.equalsIgnoreCase("Sim")) {
				versaoAlternativaResultado = true;
				break;

			} else if (versaoAlternativa.equalsIgnoreCase("Não") || versaoAlternativa.equalsIgnoreCase("Nao")) {
				versaoAlternativaResultado = false;
				break;

			} else {
				versaoAlternativa = "";
			}
		} while (versaoAlternativa.isEmpty());

		return new Plataforma(tipoPlataforma, versaoAlternativaResultado);
	}

	/**
	 * Método para receber do usuário um valor do tipo int para a realização das
	 * manipulações dos métodos referente ao vetor de jogos
	 * 
	 * @param vetorJogos - Recebe a variável de referência que aponta para o objeto
	 *                   da classe VetorJogo
	 * @return Retorna uma valor inteiro que será usado nas manipulações do métodos
	 *         do vetor de objetos
	 * @throws Exception Para as exceções que podem acontecer
	 */
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

	/**
	 * Método para receber do usuário uma String com um nome de um jogo que ele
	 * deseja buscar dentro do vetor de jogos
	 * 
	 * @return Retorna uma String para a manipulação do método da classe VetorJogo
	 *         buscarElemento(String elemento)
	 * @throws Exception Para as exceções que podem acontecer
	 */
	public static String receberNomeDoJogoParaBuscar() throws Exception {
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