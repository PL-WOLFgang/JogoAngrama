

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BancoDePalavras {
	
	private ArrayList<String> palavras;
	private ArrayList<String> palavrasJogadas;
	
	public BancoDePalavras(Scanner arquivo) {
		this.palavras = new ArrayList<>();
		this.palavrasJogadas = new ArrayList<>();
		getPalavrasArquivo(arquivo);
	}
	
	private void getPalavrasArquivo(Scanner arquivo){
		if(arquivo != null){
			while (arquivo.hasNext()) {
				String palavra = arquivo.next();	
				if(!palavras.contains(palavra)){
					palavras.add(palavra.toUpperCase());	
				}							
			}
		}
		palavrasJogadas.addAll(palavras);
	}
	
	public int getQtePalavrasJogar(){
		return palavrasJogadas.size();
	}	
	
	public String pegaPalavraAleatoria(){		
		String palavra = "";	
		
		if(palavrasJogadas.size() > 1){
			Random random = new Random();	
			int indice =  random.nextInt(palavrasJogadas.size()-1);
			palavra = palavrasJogadas.get(indice);
			palavrasJogadas.remove(indice);
		}else{
			palavra = palavrasJogadas.get(0);
			palavrasJogadas.remove(0);
		}
		
		return palavra;
	}
}
