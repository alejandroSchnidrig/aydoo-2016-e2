package ar.edu.untref.aydoo;


import java.io.IOException;

public class Program {


	public static final void main(String arg[]) throws IOException, NoExisteDirectorioException, NoExisteArchivoException {
		VerificadorDeParametros lectorDeParametros = new VerificadorDeParametros();
		lectorDeParametros.lectorDeParametros(arg);
	}

}