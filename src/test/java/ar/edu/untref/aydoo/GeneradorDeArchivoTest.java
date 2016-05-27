package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorDeArchivoTest {

	@Test
	public void VerificaLaGeneracionDelArchivoConUnElemento() throws IOException{
		GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
		String ruta =System.getProperty("user.dir" )+ ("/template");
		Elemento nuevoArchivo = new Archivo("");
		
		generarArchivo.generarArchivoEnDirectorio("plantilla", nuevoArchivo.imprimir());
		
		Assert.assertTrue(generarArchivo.existeArchivo(ruta) == true);
	}
}
