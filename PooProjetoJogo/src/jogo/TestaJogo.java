package jogo;

import javax.swing.JOptionPane;

public class TestaJogo {

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

	// Método Main;
	public static void main(String[] args) {
		// Variáveis para a manipulação dos métodos e opções dentro do código;
		int opcao = -1, opcaoCriarVetor = 0, opcaoSair = 0;

		// Variável de referência para um objeto do tipo VetorJogo;
		VetorJogo vetorJogos = null;

		while (true) {
			try {
				// Na primeira passagem da iteração um objeto da classe VetorJogo é criada
				if (opcao == -1) {
					vetorJogos = ServicoJogo.criarVetorDeJogos(opcaoCriarVetor);
					/*
					 * Trocando o valor da variáve, para que o usuário ao digital um valor inválido
					 * nas opções do menu não voltar para a criação de um novo objeto de VetorJogo.
					 */
					opcao = 0;
				}

				// Pegar a opção do usuário baseada nas opções do menu;
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, formatarMenuDeOpcoes(), "Menu de Opções",
						JOptionPane.INFORMATION_MESSAGE));

				switch (opcao) {
				// Adicionar jogos ao vetor;
				case 1 -> {
					vetorJogos.adicionarElemento(ServicoJogo.cadastrarJogo());
				}
				// Adicionar jogos ao vetor em uma posição específica;
				case 2 -> {
					vetorJogos.adicionarElemento(ServicoJogo.receberPosicaoParaOVetor(vetorJogos), vetorJogos);
				}
				// Buscar elemento por posição;
				case 3 -> {
					if (!(vetorJogos.estaVazio())) {
						JOptionPane.showMessageDialog(null,
								vetorJogos.buscarElemento(ServicoJogo.receberPosicaoParaOVetor(vetorJogos)), "Elemento",
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
										vetorJogos.buscarElemento(ServicoJogo.receberNomeDoJogoParaBuscar())),
								"Busca por Nome", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não há jogos cadastrados", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				// Remover jogo em uma determinada posição;
				case 5 -> {
					if (!(vetorJogos.estaVazio())) {
						vetorJogos.removerJogo(ServicoJogo.receberPosicaoParaOVetor(vetorJogos));

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
								vetorJogos.imprimirElemento(ServicoJogo.receberPosicaoParaOVetor(vetorJogos)), "Jogo",
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
				// Pegando a mensagem da exceção;
				String erro = ex.getMessage();

				/*
				 * Caso a exceção seja algo relacionada com a inserção de tipos diferentes. Por
				 * exemplo: Tentar colocar uma String em uma variável do tipo int
				 */
				if (erro.contains("For input string:")) {
					JOptionPane.showMessageDialog(null, "Inserção inválida de dados, digite novamente");

					/*
					 * Caso o campo do JOptionPane para entrada de dados fique vazia. Se isso
					 * acontecer siginifica que o usuário clico no botão de fechar ou no botão de
					 * cancelar.
					 */
				} else if (erro.contains("Cannot parse null string")) {
					// Peguntado se ele realmente deseja sair do sistema;
					opcaoSair = JOptionPane.showConfirmDialog(null,
							"Realmente deseja sair do sistem? Aperte sim para sair | Aparte não ou cancelar para ficar no sistema",
							"Sair do Sistema", JOptionPane.INFORMATION_MESSAGE);

					// Se o valor for igual a zero significa que ele que sair do sistema
					if (opcaoSair == 0) {
						JOptionPane.showMessageDialog(null, "Fechado o sistema, aguarde", "Mensagem",
								JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					continue;

					// Caso o vetor de jogos não tenha elementos cadastrados;
				} else if (vetorJogos.estaVazio()) {
					JOptionPane.showMessageDialog(null, "Não há jogos salvos", "Erro", JOptionPane.ERROR_MESSAGE);

					// Se a exceção não for igual a nenhuma outra listada acima
				} else {
					JOptionPane.showMessageDialog(null, "Erro: " + erro, "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}