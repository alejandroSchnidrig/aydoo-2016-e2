package ar.edu.untref.aydoo.entrada;

@SuppressWarnings("serial")
public class NoSeIngresaronParametrosException extends Exception {
	
	private static String msg = "No ha ingresado parametros. Por favor indique minimamente el archivo que desea transformar";
	public NoSeIngresaronParametrosException (){
		super(msg);
	}
}