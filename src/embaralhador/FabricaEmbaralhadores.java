package embaralhador;

import java.util.Random;

public class FabricaEmbaralhadores{
	
	private Embaralhador embaralha[];
	
	public FabricaEmbaralhadores() {
		this.embaralha = new Embaralhador[2];
		this.embaralha[0] = new EmbaralhaInverso();
		this.embaralha[1] = new EmbaralhaSilaba();
	}
	
	public String embaralhaAleatorio(String palavra) {
		Random random = new Random();	
		int indice =  random.nextInt(2);	
		return this.embaralha[indice].embaralharPalavra(palavra);
	}
}
