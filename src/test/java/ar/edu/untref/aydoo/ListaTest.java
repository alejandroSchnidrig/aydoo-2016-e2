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
	public void NombreDeLaListaSeImprimeCorrectamente(){
		Lista lista = new Lista("soy una lista");
		
		Assert.assertEquals("soy una lista", lista.getContenido());
	}
	
	@Test
	public void ListaQueContieneUnaSeccionSeImprimeCorrectamente(){
		Lista lista = new Lista("");
		Seccion seccion = new Seccion("");
		Elemento unTitulo = new Titulo("#Un titulo");
		
		seccion.agregarElemento(unTitulo);
		lista.agregarElemento(seccion);
		
		Assert.assertEquals("<lu>\n<li><section>\n<h1>Un titulo</h1>\n</section></li>\n</lu>", lista.imprimir());
	}
	
	@Test
	public void ListaQueContieneUnaListaConElementosSeImprimeCorrectamente(){
		Lista lista = new Lista("");
		Lista otraLista = new Lista("");
		Elemento unTitulo = new Titulo("#Un titulo");
		
		otraLista.agregarElemento(unTitulo);
		lista.agregarElemento(otraLista);
		
		Assert.assertEquals("<lu>\n<li><lu>\n<li><h1>Un titulo</h1></li>\n</lu></li>\n</lu>", lista.imprimir());
	}

}
