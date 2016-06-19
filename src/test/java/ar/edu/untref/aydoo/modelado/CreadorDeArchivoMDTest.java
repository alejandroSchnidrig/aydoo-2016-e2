package ar.edu.untref.aydoo.modelado;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.modelado.CreadorDeArchivoMD;

public class CreadorDeArchivoMDTest {

	@Test
	public void LeeyGuardaElArchivoEnUnaListaCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();
		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/textoAProcesar.md");

		Assert.assertEquals("# esto es un titulo", creador.getContenido(0));
		Assert.assertEquals("## esto es un sub-titulo", creador.getContenido(1));
		Assert.assertEquals("i:estoEsUnaImagen.png", creador.getContenido(2));
		Assert.assertEquals("# esto es otro titulo", creador.getContenido(3));
		Assert.assertEquals("textoplano", creador.getContenido(4));

		Assert.assertEquals(5, creador.getListaDeElementos().size());
	}

	@Test
	public void seVerificaLaCantidadDeElementosDeLista() throws IOException {

		CreadorDeArchivoMD lector = new CreadorDeArchivoMD();
		String ruta = System.getProperty("user.dir");
		lector.crearArchivoMD(ruta + "/archivosDeEjemplo/textoAProcesar.md");

		Assert.assertEquals(5, lector.getListaDeElementos().size());
	}

	@Test
	public void CreadorDeArchivoMDCreaTituloCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();

		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/textoAProcesar.md");

		Assert.assertEquals("<h1>esto es un titulo</h1>\n", creador.getElemento(0).transformarContenidoMD());
	}

	@Test
	public void CreadorDeArchivoMDCreaSubTituloCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();

		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/textoAProcesar.md");

		Assert.assertEquals("<h2>esto es un sub-titulo</h2>\n", creador.getElemento(1).transformarContenidoMD());
	}

	@Test
	public void CreadorDeArchivoMDCreaImagenCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();

		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/textoAProcesar.md");

		Assert.assertEquals("<img src=\"estoEsUnaImagen.png\"/>\n", creador.getElemento(2).transformarContenidoMD());
	}

	@Test
	public void CreadorDeArchivoMDCreaSeccionCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();

		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/seccion.md");

		Assert.assertEquals("<section>\n</section>\n", creador.getElemento(0).transformarContenidoMD());
	}

	@Test
	public void CreadorDeArchivoMDCreaListaCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();

		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/lista.md");

		Assert.assertEquals("<ul>\n<li>Una lista</li>\n</ul>\n", creador.getElemento(0).transformarContenidoMD());
	}

	@Test
	public void CreadorDeArchivoMDCreaTextoPlanoCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();

		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/textoAProcesar.md");

		Assert.assertEquals("textoplano\n", creador.getElemento(4).transformarContenidoMD());
	}

	@Test
	public void CreadorDeArchivoMDCreaSeisElementosCorrectamente() throws IOException {

		CreadorDeArchivoMD creador = new CreadorDeArchivoMD();

		String ruta = System.getProperty("user.dir");
		creador.crearArchivoMD(ruta + "/archivosDeEjemplo/SeisElementos.md");

		Assert.assertEquals("<h1>titulo</h1>\n", creador.getElemento(0).transformarContenidoMD());
		Assert.assertEquals("<h2>subtitulo</h2>\n", creador.getElemento(1).transformarContenidoMD());
		Assert.assertEquals("<img src=\"imagen.png\"/>\n", creador.getElemento(2).transformarContenidoMD());
		Assert.assertEquals("<section>\n</section>\n", creador.getElemento(3).transformarContenidoMD());
		Assert.assertEquals("<ul>\n<li>lista</li>\n</ul>\n", creador.getElemento(4).transformarContenidoMD());
		Assert.assertEquals("textoPlano\n", creador.getElemento(5).transformarContenidoMD());
	}

}