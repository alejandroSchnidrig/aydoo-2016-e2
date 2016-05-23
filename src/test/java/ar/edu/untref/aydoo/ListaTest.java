package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ListaTest {

	@Test
	public void ListaImprimeUntituloCorrectamente() {

		Lista unaLista = new Lista("");
		Elemento unTitulo = new Titulo("#Un titulo");

		unaLista.agregarElemento(unTitulo);

		Assert.assertEquals("<lu>\n<li><h1>Un titulo</h1></li>\n</lu>", unaLista.imprimir());
	}

	@Test
	public void ListaImprime3ElementosCorrectamente() {

		Lista unaLista = new Lista("");
		Elemento unTitulo = new Titulo("#Un titulo");
		Elemento unSubTitulo = new SubTitulo("##Un sub-titulo");
		Elemento Texto = new TextoPlano("soy un texto plano");

		unaLista.agregarElemento(unTitulo);
		unaLista.agregarElemento(unSubTitulo);
		unaLista.agregarElemento(Texto);

		Assert.assertEquals("<lu>\n<li><h1>Un titulo</h1></li>\n<li><h2>Un sub-titulo</h2></li>\n"
				+ "<li>soy un texto plano</li>\n</lu>", unaLista.imprimir());
	}

	@Test
	public void ListaImprimeOtraListaVaciaCorrectamente(){
		Lista primerLista = new Lista("");
		Lista segundaLista = new Lista("Segunda Lista");

		primerLista.agregarElemento (segundaLista);

		Assert.assertEquals("<lu>\n<li><lu>\n</lu></li>\n</lu>", primerLista.imprimir());
	}
	
	@Test
	public void ListaSinElementosSeImprimeCorrectamente(){
		Lista primerLista = new Lista("");

		Assert.assertEquals("<lu>\n</lu>", primerLista.imprimir());
	}
	
	@Test
	public void NonmbreDeLaListaSeImprimeCorrectamente(){
		Lista Lista = new Lista("soy una lista");
		
		Assert.assertEquals("soy una lista", Lista.getContenido());
	}

}
