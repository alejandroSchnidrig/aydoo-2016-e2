package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImagenTest {

	@Test
	public void ElContenidoDelaimagenEsCorrecto() {

		Elemento unaImagen = new Imagen("i:imagen.png");

		Assert.assertEquals("i:imagen.png", unaImagen.getContenido());

	}

	@Test
	public void ImprimeBienUnaImagen() {

		Elemento unaImagen = new Imagen("i:imagen.png");

		Assert.assertEquals("<img src=\"imagen.png\"/>\n", unaImagen.imprimir());
	}

}
