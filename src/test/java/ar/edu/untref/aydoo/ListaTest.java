package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ListaTest {
	
	@Test
	public void ListaSeImprimeConUnElementosCorrectamente(){
		
		Lista lista = new Lista("*algo");
		
		Assert.assertEquals("<lu>\n<li>algo</li>\n</lu>\n", lista.imprimir());
	}
	
	@Test
	public void ListaConDosListasImprimeCorrectamente(){
		
		Lista lista = new Lista("*primera");
		Lista otraLista = new Lista("*segunda");
		Lista tercerLista = new Lista("*tercera");
		
		lista.agregarElemento(otraLista);
		lista.agregarElemento(tercerLista);
		
		Assert.assertEquals("<lu>\n<li>primera</li>\n<li>segunda</li>\n<li>tercera</li>\n</lu>\n", lista.imprimir());
	}
	@Test
	public void ListaDentroDeOtraListaSeImprimeCorrectamente(){
		
		Lista lista = new Lista("*algo");
		Lista segundaLista = new Lista("*mas");
		Lista tercerLista = new Lista("*en");
		Lista cuartaLista = new Lista("*lista");
		
		lista.agregarElemento(segundaLista);
		lista.agregarElemento(tercerLista);
		lista.agregarElemento(cuartaLista);
		
		Assert.assertEquals("<lu>\n<li>algo</li>\n<li>mas</li>\n<li>en</li>\n<li>lista</li>\n</lu>\n", lista.imprimir());
	}
	
	@Test
	public void ListaVaciaSeImprimeCorrectamente(){
		
		Lista lista = new Lista("");
		
		Assert.assertEquals("<lu>\n<li></li>\n</lu>\n", lista.imprimir());
	}
	
	
}
	