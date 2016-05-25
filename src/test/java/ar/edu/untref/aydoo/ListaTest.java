package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ListaTest {
	
	@Test
	public void ListaSeImprimeConUnElementosCorrectamente(){
		
		Lista lista = new Lista("*algo");
		
		Assert.assertEquals("<lu>\n<li>algo</li>\n</lu>", lista.imprimir());
	}
}
