package mecanicaJogo;

public class FabricaMecanicaDoJogo {

	private MecanicaDoJogo[] mecanica;
	
	public FabricaMecanicaDoJogo() {
		mecanica = new MecanicaDoJogo[2];
		mecanica[0] = new MecanicaJogoPadrao();
		mecanica[1] = new MecanicaJogoMorteSubita();		
	}
	
	public MecanicaDoJogo getMecanicaJogo(int modo){
		if(modo == 2){
			return mecanica[1];
		}else{
			return mecanica[0];
		}
	}
	
}
