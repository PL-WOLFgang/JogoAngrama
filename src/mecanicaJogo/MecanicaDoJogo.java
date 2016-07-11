package mecanicaJogo;

public interface MecanicaDoJogo {	
	
	public boolean testaPalavra(String palavra, String entrada);
	
	public int palavrasCertas();
	
	public int palavrasErradas();	
	
	public boolean fimDeJogo();

	public boolean ganhou();
	
	public String regrajogo();
	
	public boolean testeIniciarJogo(int quantidadePalavras);
	
	public String mensagemIniciar();
}
