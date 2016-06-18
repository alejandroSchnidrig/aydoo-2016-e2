package ar.edu.untref.aydoo.entrada;

@SuppressWarnings("serial")
public class CaracteresInvalidosException extends Exception {
	
	private static String msg = "Se detecta que un caracter ingresado no es correcto. Por favor no utilice ñ o acentos";
	public CaracteresInvalidosException (){
		super(msg);
	}
}