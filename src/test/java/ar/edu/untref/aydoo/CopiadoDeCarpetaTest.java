package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;



public class CopiadoDeCarpetaTest {
	
	@Test
	public void seCopiaCarpetaDelDirectorioCorrectamente() throws IOException, NoExisteDirectorioException{
		
		String rutaOrigen = System.getProperty("user.dir");
		String rutaDestino = (rutaOrigen+"/carpetaPruebaCopia");

		File carpetaOrigen = new File(rutaOrigen);
		File carpetaDestino = new File(rutaDestino);
		CopiadoDeCarpeta realizarCopia = new CopiadoDeCarpeta();
		realizarCopia.copiarArchivos(carpetaOrigen, carpetaDestino);
		
		Assert.assertTrue(carpetaDestino.exists());

	}
}
