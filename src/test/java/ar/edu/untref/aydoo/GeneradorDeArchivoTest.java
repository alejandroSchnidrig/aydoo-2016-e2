package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorDeArchivoTest {

	@Test
	public void VerificaLaGeneracionDelArchivoConUnElemento() throws IOException{
		GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
		String ruta =System.getProperty("user.dir" )+ ("/README.md");
		Elemento nuevoArchivo = new Archivo("");

		generarArchivo.generarArchivoEnDirectorio("template", nuevoArchivo.imprimir());

		Assert.assertTrue(generarArchivo.existeArchivo(ruta) == true);
	}
}
