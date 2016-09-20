package ar.edu.untref.aydoo.salida;

@SuppressWarnings("serial")
public class NoExisteDirectorioException extends Exception {

	private static String msg = "No existe el directorio especificado";

	public NoExisteDirectorioException() {
		super(msg);
	}

}
