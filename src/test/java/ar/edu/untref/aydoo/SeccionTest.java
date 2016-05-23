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
		

		Assert.assertEquals("<section>\n<h1>El Hobbit</h1>\n<h2>4000 años antes... </h2>\n</section>", otraSeccion.imprimir());

	}
	
	
}
