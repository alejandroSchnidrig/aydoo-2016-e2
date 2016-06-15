package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TextoPlanoTest {

	@Test
	public void ElContenidoDelTextoPlanoSeSeteaCorrectamente() {

		Elemento textoPlano = new TextoPlano();
		textoPlano.setContenido("solo texto");

		Assert.assertEquals("solo texto", textoPlano.getContenido());

	}

	@Test
	public void ElContenidoDelTextoPlanoSeTransformaCorrectamente() {

		Elemento textoPlano = new TextoPlano();
		textoPlano.setContenido("solo texto");

		Assert.assertEquals("solo texto\n", textoPlano.transformarContenidoMD());
	}

}
