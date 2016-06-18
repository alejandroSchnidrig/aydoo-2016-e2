package ar.edu.untref.aydoo.salida;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelado.CreadorDeArchivoHTML;
import ar.edu.untref.aydoo.salida.GeneradorDeArchivo;

public class GeneradorDeArchivoTest {

	@Test
	public void VerificaLaGeneracionDelArchivoConUnElemento() throws IOException{
		GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
		String ruta =System.getProperty("user.dir" )+ ("/README.md");
		CreadorDeArchivoHTML archivoHTML = new CreadorDeArchivoHTML();

		generarArchivo.generarArchivoEnDirectorio("archivosDeEjemplo", archivoHTML.TransformarContenidosAHTML());

		Assert.assertTrue(generarArchivo.existeArchivo(ruta) == true);
	}
	@Test
	public void VerificarQueElArchivoNoExiste() throws IOException{
		GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
		String ruta =System.getProperty("user.dir" )+ ("/index.md");

		Assert.assertTrue(generarArchivo.existeArchivo(ruta) == false);
	}
}
