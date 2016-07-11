package mecanicaJogo;

public class MecanicaJogoPadrao implements MecanicaDoJogo {

	private int certas;
	private int erradas;
	private int jogadas;
	
	private String mensagemIniciar;
	
	@Override
	public int palavrasCertas() {
		return certas;
	}

	@Override
	public int palavrasErradas() {
		return erradas;
	}

	@Override
	public boolean fimDeJogo() {
		if(erradas > 3 || jogadas > 19){
			return true;
		}	
		return false;
	}

	@Override
	public boolean testaPalavra(String palavra, String entrada) {
		jogadas++;
		if(palavra.equals(entrada)){
			certas++;
			return true;
		}else{
			erradas++;
			return false;
		}
	}

	@Override
	public boolean ganhou() {
		if(certas > 4){
			return true;
		}
		return false;
	}

	@Override
	public String regrajogo() {
		return "Modo Padrão: Você pode ter no mínimo 4 erros e pelo menos 5 acertos para ganhar";
	}
	
	@Override
	public boolean testeIniciarJogo(int quantidadePalavras) {
		if(quantidadePalavras > 19){
			return true;
		}
		this.mensagemIniciar = "Modo Padrão: Necessário ter no mínimo 20 palavras para jogar.";
		return false;		
	}

	@Override
	public String mensagemIniciar() {
		return this.mensagemIniciar == null? "" : this.mensagemIniciar ;
	}
}
