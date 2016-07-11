package mecanicaJogo;

public class MecanicaJogoMorteSubita implements MecanicaDoJogo {

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
		if(erradas > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean testaPalavra(String palavra, String entrada) {
		jogadas ++;
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
		if(jogadas == certas){
			return true;
		}
		return false;
	}

	@Override
	public String regrajogo() {
		return "Modo Morte S�bida: O importante � voc� acertar o m�ximo de anagramas sem errar um!";
	}

	@Override
	public boolean testeIniciarJogo(int quantidadePalavras) {
		if(quantidadePalavras > 19){
			return true;
		}
		this.mensagemIniciar = "Modo morte S�bita: Necess�rio ter no m�nimo 20 palavras para jogar.";
		return false;		
	}

	@Override
	public String mensagemIniciar() {
		return this.mensagemIniciar == null? "" : this.mensagemIniciar ;
	}

}
