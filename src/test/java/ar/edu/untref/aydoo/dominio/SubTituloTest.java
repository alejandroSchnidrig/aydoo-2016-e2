package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.SubTitulo;

public class SubTituloTest {

	@Test
	public void ElContenidoDelSubTituloSeSeteaCorrectamente() {

		Elemento unSubTitulo = new SubTitulo();
		unSubTitulo.setContenido("## SubTitulo");

		Assert.assertEquals("## SubTitulo", unSubTitulo.getContenido());

	}

	@Test
	public void ElContenidoDelSubTituloSeTransformaCorrectamente() {

		Elemento unSubTitulo = new SubTitulo();
		unSubTitulo.setContenido("## SubTitulo");

		Assert.assertEquals("<h2>SubTitulo</h2>\n", unSubTitulo.transformarContenidoMD());
	}

}