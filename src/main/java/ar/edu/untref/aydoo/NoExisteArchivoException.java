package ar.edu.untref.aydoo;

@SuppressWarnings("serial")
public class NoExisteArchivoException extends Exception {
	
	private static String msg = "No existe el archivo especificado";
	public NoExisteArchivoException (){
		super(msg);
	}
}
