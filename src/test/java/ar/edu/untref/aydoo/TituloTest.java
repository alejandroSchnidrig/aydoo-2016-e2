package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {

	@Test
	public void ElContenidoDelTituloSeSeteaCorrectamente() {

		Elemento unTitulo = new Titulo();
		unTitulo.setContenido("# titulo");

		Assert.assertEquals("# titulo", unTitulo.getContenido());

	}

	@Test
	public void ElContenidoDelTituloSeTransformaCorrectamente() {

		Elemento unTitulo = new Titulo();
		unTitulo.setContenido("# titulo");

		Assert.assertEquals("<h1>titulo</h1>\n", unTitulo.transformarContenidoMD());
	}

}
