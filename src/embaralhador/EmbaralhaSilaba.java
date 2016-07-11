package embaralhador;

public class EmbaralhaSilaba implements Embaralhador {

	@Override
	public String embaralharPalavra(String palavra) {
		String palavraFinal = "";		
		
		char conjunto[] = palavra.toCharArray();
		int tamanho = conjunto.length;
		
		int tamanhoPar = 0, tamanhoImpar = 0;
		if(tamanho / 2 == 0){			
			tamanhoPar = tamanho /2;
			tamanhoImpar = tamanho/2;
		}else{
			tamanhoPar =   ( (tamanho-1) /2) ;
			tamanhoImpar = ( (tamanho-1) /2)+1;
		}
		
		char conjuntoImpar[] = palavra.substring(tamanhoPar).toCharArray() ;	
		char conjuntoPar[] = palavra.substring(tamanhoImpar).toCharArray();			
		
		int indexPar = 0, indexImpar = 0;
		for (int i = 0; i < tamanho; i++) {
			if((i+1) % 2 == 0){
				conjuntoPar[indexPar] = conjunto[i];
				indexPar++;
			}else{
				conjuntoImpar[indexImpar] = conjunto[i];
				indexImpar++;
			}
		}
		
		if(palavra.length() % 2 != 0){
			tamanho = tamanho -1;
		}	
		
		indexPar = 0; indexImpar = 0;
		for(int i = 0; i < tamanho; i++){
			if((i) % 2 == 0){
				palavraFinal += String.valueOf(conjuntoPar[indexPar]);
				indexPar++;
			}else{
				palavraFinal += String.valueOf(conjuntoImpar[indexImpar]);
				indexImpar++;
			}
		}
		
		if(palavra.length() % 2 != 0){
			palavraFinal = palavraFinal+conjuntoImpar[conjuntoImpar.length - 1];
		}
		
		return palavraFinal;
	}
}
