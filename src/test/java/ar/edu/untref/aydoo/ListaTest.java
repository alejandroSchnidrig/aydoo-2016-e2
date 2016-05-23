package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ListaTest {
	
	@Test
	public void ListaImprimeUntituloCorrectamente() {

		Lista unaLista = new Lista("");
		Elemento unTitulo = new Titulo("#El señor de los anillos");

		unaLista.agregarElemento(unTitulo);

		Assert.assertEquals("<lu>\n<li><h1>El señor de los anillos</h1></li>\n</lu>", unaLista.imprimir());
	}

}
