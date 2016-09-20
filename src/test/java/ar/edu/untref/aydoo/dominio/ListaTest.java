package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Lista;

public class ListaTest {
	
	@Test
	public void ListaSeTransformaConUnElementoCorrectamente(){
		
		Lista lista = new Lista();
		lista.setContenido("*algo");
		
		Assert.assertEquals("<ul>\n<li>algo</li>\n</ul>\n", lista.transformarContenidoMD());
	}
	
	@Test
	public void ListaConDosElementosTransformaCorrectamente(){
		
		Lista lista = new Lista();
		Lista otraLista = new Lista();
		Lista tercerLista = new Lista();
		
		lista.setContenido("*primera");
		otraLista.setContenido("*segunda");
		tercerLista.setContenido("*tercera");
		
		lista.agregarElemento(otraLista);
		lista.agregarElemento(tercerLista);
		
		Assert.assertEquals("<ul>\n<li>primera</li>\n<li>segunda</li>\n<li>tercera</li>\n</ul>\n", lista.transformarContenidoMD());
	}
	@Test
	public void ListaConCuatroElementosTransformaCorrectamente(){
		
		Lista lista = new Lista();
		Lista segundaLista = new Lista();
		Lista tercerLista = new Lista();
		Lista cuartaLista = new Lista();
		
		lista.setContenido("*algo");
		segundaLista.setContenido("*mas");
		tercerLista.setContenido("*en");
		cuartaLista.setContenido("*lista");
		
		lista.agregarElemento(segundaLista);
		lista.agregarElemento(tercerLista);
		lista.agregarElemento(cuartaLista);
		
		Assert.assertEquals("<ul>\n<li>algo</li>\n<li>mas</li>\n<li>en</li>\n<li>lista</li>\n</ul>\n", lista.transformarContenidoMD());
	}
	
	@Test
	public void ListaVaciaSeTransformaCorrectamente(){
		
		Lista lista = new Lista();
		
		Assert.assertEquals("<ul>\n<li></li>\n</ul>\n", lista.transformarContenidoMD());
	}
	
	
}
	