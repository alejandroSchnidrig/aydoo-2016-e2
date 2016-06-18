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
	@Test (expected = CaracteresInvalidosException.class)
	public void seIngresanCaracteresInvalidosConAcentoEnO() throws IOException, NoExisteDirectorioException, NoExisteArchivoException, CaracteresInvalidosException{
		VerificadorDeParametros verificoParametros = new VerificadorDeParametros();
		String[]argumentos = {"--output=presentación1","mipresentacion.md"};
		File nuevoArchivo = new File ("mipresentacion.md");
		verificoParametros.lectorDeParametros(argumentos);
		
		Assert.assertTrue(nuevoArchivo.exists());
	}
	@Test (expected = CaracteresInvalidosException.class)
	public void seIngresanCaracteresInvalidosConAcentoEnA() throws IOException, NoExisteDirectorioException, NoExisteArchivoException, CaracteresInvalidosException{
		VerificadorDeParametros verificoParametros = new VerificadorDeParametros();
		String[]argumentos = {"--output=presentacián1","mipresentacion.md"};
		File nuevoArchivo = new File ("mipresentacion.md");
		verificoParametros.lectorDeParametros(argumentos);
		
		Assert.assertTrue(nuevoArchivo.exists());
	}
	@Test (expected = CaracteresInvalidosException.class)
	public void seIngresanCaracteresInvalidosConAcentoEnE() throws IOException, NoExisteDirectorioException, NoExisteArchivoException, CaracteresInvalidosException{
		VerificadorDeParametros verificoParametros = new VerificadorDeParametros();
		String[]argumentos = {"--mode=défault","mipresentacion.md"};
		File nuevoArchivo = new File ("mipresentacion.md");
		verificoParametros.lectorDeParametros(argumentos);
		
		Assert.assertTrue(nuevoArchivo.exists());
	}
	@Test (expected = CaracteresInvalidosException.class)
	public void seIngresanCaracteresInvalidosConAcentoEnI() throws IOException, NoExisteDirectorioException, NoExisteArchivoException, CaracteresInvalidosException{
		VerificadorDeParametros verificoParametros = new VerificadorDeParametros();
		String[]argumentos = {"--output=presentacíon1","mipresentacion.md"};
		File nuevoArchivo = new File ("mipresentacion.md");
		verificoParametros.lectorDeParametros(argumentos);
		
		Assert.assertTrue(nuevoArchivo.exists());
	}
}