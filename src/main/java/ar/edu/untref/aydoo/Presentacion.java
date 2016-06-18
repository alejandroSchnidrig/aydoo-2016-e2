package ar.edu.untref.aydoo;


import java.io.IOException;

import ar.edu.untref.aydoo.entrada.CaracteresInvalidosException;
import ar.edu.untref.aydoo.entrada.VerificadorDeParametros;
import ar.edu.untref.aydoo.salida.NoExisteArchivoException;
import ar.edu.untref.aydoo.salida.NoExisteDirectorioException;

public class Presentacion {


	public static final void main(String arg[]) throws IOException, NoExisteDirectorioException, NoExisteArchivoException,CaracteresInvalidosException {
		VerificadorDeParametros lectorDeParametros = new VerificadorDeParametros();
		lectorDeParametros.lectorDeParametros(arg);
	}

}