package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

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