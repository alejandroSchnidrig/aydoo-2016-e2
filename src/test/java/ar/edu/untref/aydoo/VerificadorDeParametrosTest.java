package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class VerificadorDeParametrosTest {

	@Test (expected = NoExisteArchivoException.class)
	public void noExisteElArchivoEnLaRutaIndicada() throws IOException, NoExisteDirectorioException, NoExisteArchivoException, CaracteresInvalidosException{
		VerificadorDeParametros verificoParametros = new VerificadorDeParametros();
		String[]argumentos = {"output=prueba","mipresentacion.md"};
		File nuevoArchivo = new File ("mipresentacion.md");
		verificoParametros.lectorDeParametros(argumentos);
		
		Assert.assertTrue(nuevoArchivo.exists());
	}
	@Test (expected = CaracteresInvalidosException.class)
	public void seIngresanCaracteresInvalidos() throws IOException, NoExisteDirectorioException, NoExisteArchivoException, CaracteresInvalidosException{
		VerificadorDeParametros verificoParametros = new VerificadorDeParametros();
		String[]argumentos = {"output=prueba","mipresentacioñ.md"};
		File nuevoArchivo = new File ("mipresentacion.md");
		verificoParametros.lectorDeParametros(argumentos);
		
		Assert.assertTrue(nuevoArchivo.exists());
	}
}
