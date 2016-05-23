package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SeccionTest {

	@Test
	public void SeccionImprimeUntituloCorrectamente() {

		Seccion unaSeccion = new Seccion("");
		Elemento unTitulo = new Titulo("#El señor de los anillos");

		unaSeccion.agregarElemento(unTitulo);

		Assert.assertEquals("<section>\n<h1>El señor de los anillos</h1>\n</section>", unaSeccion.imprimir());
	}

	@Test
	public void SeccionImprimeDosElementosCorrectamente() {

		Seccion otraSeccion = new Seccion("");
		Elemento unTitulo = new Titulo("#El Hobbit");
		Elemento SubTitulo = new SubTitulo("##4000 años antes... ");

		otraSeccion.agregarElemento(unTitulo);
		otraSeccion.agregarElemento(SubTitulo);

		Assert.assertEquals("<section>\n<h1>El Hobbit</h1>\n<h2>4000 años antes... </h2>\n</section>",
				otraSeccion.imprimir());

	}

	@Test
	public void SeccionImprimeCuatroElementosCorrectamente() {

		Seccion otraSeccion = new Seccion("");
		Elemento unTitulo = new Titulo("#El Hobbit");
		Elemento SubTitulo = new SubTitulo("##4000 años antes... ");
		Elemento unaImagen = new Imagen("i:foto.png");
		Elemento otroTitulo = new Titulo("#FIN");

		otraSeccion.agregarElemento(unTitulo);
		otraSeccion.agregarElemento(SubTitulo);
		otraSeccion.agregarElemento(unaImagen);
		otraSeccion.agregarElemento(otroTitulo);

		Assert.assertEquals("<section>\n<h1>El Hobbit</h1>\n<h2>4000 años antes... </h2>\n<img src=\"foto.png\"/>\n"
				+ "<h1>FIN</h1>\n</section>", otraSeccion.imprimir());

	}

	@Test
	public void SeccionSinElementosSeImprimeCorrectamente() {

		Seccion otraSeccion = new Seccion("");
		Assert.assertEquals("<section>\n</section>", otraSeccion.imprimir());

	}

	@Test
	public void NombreDelaSeccionSeimprimeCorrectamente() {
		Seccion seccion = new Seccion("");

		Assert.assertEquals("", seccion.getContenido());

	}
	
	@Test
	public void SeccionQueContieneOtraSeccionSeImprimeCorrectamente(){
		Seccion seccion = new Seccion("");
		Seccion otraSeccion = new Seccion("");
		Elemento unTitulo = new Titulo("#El Hobbit");
		
		otraSeccion.agregarElemento(unTitulo);
		seccion.agregarElemento(otraSeccion);
		
		Assert.assertEquals("<section>\n<section>\n<h1>El Hobbit</h1>\n</section>\n</section>", seccion.imprimir());
	}
}