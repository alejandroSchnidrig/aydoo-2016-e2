package ar.edu.untref.aydoo.entrada;

@SuppressWarnings("serial")
public class ParametroInvalidoException extends Exception{
	
	private static String msg = "Alguno de los parametros ingresado no es valido";
	
	public ParametroInvalidoException() {
		super(msg);
	}

}
