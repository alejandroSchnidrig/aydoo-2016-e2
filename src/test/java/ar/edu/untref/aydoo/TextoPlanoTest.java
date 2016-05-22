package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TextoPlanoTest {

	@Test
	public void ElContenidoDelTextoPlanoEsCorrecto() {

		Elemento textoPlano = new TextoPlano("Integrador de archivos");

		Assert.assertEquals("Integrador de archivos", textoPlano.getContenido());

	}

}
