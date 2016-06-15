package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImagenTest {

	@Test
	public void ElContenidoDelaImagenSeSeteaCorrectamente() {

		Elemento unaImagen = new Imagen();
		unaImagen.setContenido("i:imagen.png");

		Assert.assertEquals("i:imagen.png", unaImagen.getContenido());

	}

	@Test
	public void ElContenidoDelaImagenSeTransformaCorrectamente() {

		Elemento unaImagen = new Imagen();
		unaImagen.setContenido("i:imagen.png");

		Assert.assertEquals("<img src=\"imagen.png\"/>\n", unaImagen.transformarContenidoMD());
	}

}
