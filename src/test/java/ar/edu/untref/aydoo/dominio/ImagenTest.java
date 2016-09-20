package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.Imagen;

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
