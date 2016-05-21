package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArchivoTest {

	@Test
	public void ImprimeSusElementosCorrectamente() {

		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unTitulo = new Titulo("#Titulo numero uno");
		Elemento unTitulo2 = new Titulo("#Titulo numero dos");
		Elemento unSubTitulo = new SubTitulo("##SubTitulo numero uno");
		Elemento unSubTitulo2 = new SubTitulo("##SubTitulo numero dos");
		Elemento unaImagen = new Imagen("i:unaImagen.png");

		unArchivo.agregarElemento(unTitulo);
		unArchivo.agregarElemento(unSubTitulo);
		unArchivo.agregarElemento(unSubTitulo2);
		unArchivo.agregarElemento(unTitulo2);
		unArchivo.agregarElemento(unaImagen);

		unArchivo.imprimir();

		Assert.assertEquals("<h1>Titulo numero uno</h1>", unArchivo.getContenidoElemento(0));
		Assert.assertEquals("<h2>SubTitulo numero uno</h2>", unArchivo.getContenidoElemento(1));
		Assert.assertEquals("<h2>SubTitulo numero dos</h2>", unArchivo.getContenidoElemento(2));
		Assert.assertEquals("<h1>Titulo numero dos</h1>", unArchivo.getContenidoElemento(3));
		Assert.assertEquals("<img src=\"unaImagen.png\"/>", unArchivo.getContenidoElemento(4));

	}
	
	@Test
	public void ImprimeSinAgregarElementos() {

		Archivo unArchivo = new Archivo("archivo.txt");
		unArchivo.imprimir();
		Assert.assertEquals("<h1>Titulo numero uno</h1>", unArchivo.getContenidoElemento(0));

	}


}