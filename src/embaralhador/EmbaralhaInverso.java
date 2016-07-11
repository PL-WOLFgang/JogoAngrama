package embaralhador;

public class EmbaralhaInverso implements Embaralhador {

	@Override
	public String embaralharPalavra(String palavra) {
		palavra = new StringBuilder(palavra).reverse().toString();		
		return palavra;
	}

}
