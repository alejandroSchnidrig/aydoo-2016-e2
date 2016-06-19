package ar.edu.untref.aydoo.salida;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.salida.CopiadoDeCarpeta;
import ar.edu.untref.aydoo.salida.NoExisteDirectorioException;

public class CopiadoDeCarpetaTest {

	@Test
	public void seCopiaCarpetaDelDirectorioCorrectamente() throws IOException, NoExisteDirectorioException {

		String rutaOrigen = System.getProperty("user.dir");
		String rutaDestino = (rutaOrigen + "/carpetaPruebaCopia");

		File carpetaOrigen = new File(rutaOrigen);
		File carpetaDestino = new File(rutaDestino);
		CopiadoDeCarpeta realizarCopia = new CopiadoDeCarpeta();
		realizarCopia.copiarArchivos(carpetaOrigen, carpetaDestino);

		Assert.assertTrue(carpetaDestino.exists());

	}

	@Test(expected = NoExisteDirectorioException.class)
	public void carpetaInexistenteParaCopiar() throws IOException, NoExisteDirectorioException {

		String rutaOrigen = "DirectorioIncorrecto";
		String rutaDestino = (rutaOrigen + "/pruebaCarpetaCopia");

		File carpetaOrigen = new File(rutaOrigen);
		File carpetaDestino = new File(rutaDestino);
		CopiadoDeCarpeta realizarCopia = new CopiadoDeCarpeta();
		realizarCopia.copiarArchivos(carpetaOrigen, carpetaDestino);

		Assert.assertTrue(carpetaDestino.exists());

	}
}
