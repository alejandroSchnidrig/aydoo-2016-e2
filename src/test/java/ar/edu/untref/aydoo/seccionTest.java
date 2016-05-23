package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class seccionTest {

	@Test
	public void SeccionImprimeUntituloCorrectamente() {

		Seccion unaSeccion = new Seccion("");
		Elemento unTitulo = new Titulo("#El señor de los anillos");
		
		unaSeccion.agregarElemento(unTitulo);

		Assert.assertEquals("<section>\n<h1>El señor de los anillos</h1>\n</section>", unaSeccion.imprimir());

	}

}
