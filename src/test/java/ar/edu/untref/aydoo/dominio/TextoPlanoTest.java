package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.TextoPlano;

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
