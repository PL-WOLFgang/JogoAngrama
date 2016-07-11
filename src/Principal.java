

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import mecanicaJogo.FabricaMecanicaDoJogo;
import mecanicaJogo.MecanicaDoJogo;
import embaralhador.FabricaEmbaralhadores;


public class Principal {

	private static Scanner input;
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);	
		Scanner file = null;
		
		try {			
			file = new Scanner(new FileReader("C:\\Temp\\dicionario.txt")).useDelimiter("\r\n\0|\r|\n|\0");			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erro ao ler arquivo!");
			System.exit(1);
		}
		
		iniciar(new BancoDePalavras(file));		

		file.close();		
		input.close();		
		System.exit(0);		
	}	
	
	private static void jogar(MecanicaDoJogo jogo, BancoDePalavras dicionario){
		
		FabricaEmbaralhadores embaralhador = new FabricaEmbaralhadores();
		
		String entrada = "";String retorno = "";
		while (!jogo.fimDeJogo() && !entrada.equals("-9") && dicionario.getQtePalavrasJogar() > 0) {
			
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("    "+jogo.regrajogo());
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("    Nº Acertos: "+jogo.palavrasCertas()+" Nº Erros: "+jogo.palavrasErradas()+" Nº Jogadas: "+(jogo.palavrasCertas()+jogo.palavrasErradas())+"                          INFORME -9 A QUALQUER MOMENTO PARA SAIR. ");
			System.out.print(retorno);
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			String palavra = dicionario.pegaPalavraAleatoria();
			String embaralhada = embaralhador.embaralhaAleatorio(palavra);
			
			System.out.println("Esta é a jogada Nº "+(jogo.palavrasCertas()+jogo.palavrasErradas()+1)+" : Qual é a solução para o anagrama: "+embaralhada+"?");			
			entrada = input.next().trim().toUpperCase();	
			
			if(!entrada.equals("-9")){
				if(jogo.testaPalavra(palavra, entrada)){
					retorno = (" ** Parabéns, você acertou a palavra: "+palavra+". \n");
				}else{
					retorno = (" ** Eita! Não foi dessa vez. Voce errou a solução para: "+embaralhada+". \n");
				}
			}			
		}
		terminar(jogo);		
	}
	
	private static void iniciar(BancoDePalavras dicionario){
		System.out.println("*********************************** Jogo Anagrama *************************************");
		System.out.println(" Objetivo:        Você tem que descobrir qual é a solução para a palavra embaralhada!");
		System.out.println("***************************************************************************************");
		System.out.println("\nQual modo deseja jogar?");
		System.out.println("1 - Padrão (Minimo de acertos = 5, Minimo de erros = 4, 20 tentativas)");		
		System.out.println("2 - Morte Súbida (Maior quantidade de acertos sem erros)");
		
		String inputText = input.nextLine();	
		
		if(inputText.equals("1") || inputText.equals("2")){
			FabricaMecanicaDoJogo fabJogo = new FabricaMecanicaDoJogo();
			MecanicaDoJogo jogo = fabJogo.getMecanicaJogo(Integer.parseInt(inputText));
			if(jogo.testeIniciarJogo(dicionario.getQtePalavrasJogar())){
				jogar(jogo, dicionario);
			}else{
				System.out.println(jogo.mensagemIniciar());
			}
		}
	}
	
	public static void terminar(MecanicaDoJogo jogo){
		System.out.println("*********************************** FIM DE JOGO **********************************************************");
		System.out.println("Seu placar esta assim:       **Acertos: "+jogo.palavrasCertas()+"   **Erros: "+jogo.palavrasErradas()+"    **Jogadas: "+(jogo.palavrasCertas()+jogo.palavrasErradas()));
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println(jogo.regrajogo());
		System.out.println("\n Resultado:");

		if (jogo.ganhou()) {
			System.out.println("                          !!!!! Ganhou !!!!!!");
			System.out.println("                          Você teve o número de acertos para ganhar! Ta feliz?");
		}else{
			System.out.println("                          !!!!! Não foi dessa vez !!!!!!");
			System.out.println("                          Você deve ter tido muitos erros, ou seu modo de jogo não permite errar. Nesse caso o importante é o número de acertos!");
		} 
	}
}
