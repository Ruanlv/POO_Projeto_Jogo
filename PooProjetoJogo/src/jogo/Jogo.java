package jogo;

public class Jogo {
	private String nome;
	private Desenvolvedora desenvolvedora;
	private Genero genero;
	private Tema temaJogo;
	private ModoDeJogo modoDejogo;
	private ClassificacaoIndicativa classificacaoIndicativa;
	private String perspectivaJogador;
	private Plataforma plataforma;
	private int quantidadeVendas;
	private static int quantidadeInstancia;
	
	public Jogo(String nome, Desenvolvedora desenvolvedora, Genero genero, Tema temaJogo, ModoDeJogo modoDejogo,
			ClassificacaoIndicativa classificacaoIndicativa, String perpectivaJogador, Plataforma plataforma,
			int quantidadeVendas) {
		this.nome = nome;
		this.desenvolvedora = desenvolvedora;
		this.genero = genero;
		this.temaJogo = temaJogo;
		this.modoDejogo = modoDejogo;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.perspectivaJogador = perpectivaJogador;
		this.plataforma = plataforma;
		this.quantidadeVendas = quantidadeVendas;
		++quantidadeInstancia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Desenvolvedora getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Tema getTemaJogo() {
		return temaJogo;
	}

	public void setTemaJogo(Tema temaJogo) {
		this.temaJogo = temaJogo;
	}

	public ModoDeJogo getModoDejogo() {
		return modoDejogo;
	}

	public void setModoDejogo(ModoDeJogo modoDejogo) {
		this.modoDejogo = modoDejogo;
	}

	public ClassificacaoIndicativa getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public String getPerpectivaJogador() {
		return perspectivaJogador;
	}

	public void setPerpectivaJogador(String perpectivaJogador) {
		this.perspectivaJogador = perpectivaJogador;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	public static int getQuantidadeInstancia() {
		return quantidadeInstancia;
	}

	@Override
	public String toString() {
		return "Jogo [nome=" + nome + ", desenvolvedora=" + desenvolvedora + ", genero=" + genero + ", temaJogo="
				+ temaJogo + ", modoDejogo=" + modoDejogo + ", classificacaoIndicativa=" + classificacaoIndicativa
				+ ", perspectivaJogador=" + perspectivaJogador + ", plataforma=" + plataforma + ", quantidadeVendas="
				+ quantidadeVendas + "]";
	}
}