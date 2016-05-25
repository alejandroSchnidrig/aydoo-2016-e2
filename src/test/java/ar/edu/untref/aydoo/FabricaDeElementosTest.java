package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FabricaDeElementosTest {
	
	@Test
	public void FabricaConstruyeUnSubTituloCorrectamente(){
		
		FabricaDeElementos fabrica = new FabricaDeElementos();
		
		List<String> contenidos = new LinkedList<String>();
		
		String contenido = "## un subtitulo";
		
		contenidos.add(contenido);
		
		fabrica.construirElementos(contenidos);
		
		Assert.assertEquals("## un subtitulo", fabrica.getElemento(0).getContenido());
	
	}
	
	@Test
	public void FabricaConstruyeUnTituloCorrectamente(){
		
		FabricaDeElementos fabrica = new FabricaDeElementos();
		
		List<String> contenidos = new LinkedList<String>();
		
		String contenido = "# un titulo";
		
		contenidos.add(contenido);
		
		fabrica.construirElementos(contenidos);
		
		Assert.assertEquals("# un titulo", fabrica.getElemento(0).getContenido());
	
	}
	
	@Test
	public void FabricaConstruyeUnaImagenCorrectamente(){
		
		FabricaDeElementos fabrica = new FabricaDeElementos();
		
		List<String> contenidos = new LinkedList<String>();
		
		String contenido = "i:imagen.png";
		
		contenidos.add(contenido);
		
		fabrica.construirElementos(contenidos);
		
		Assert.assertEquals("i:imagen.png", fabrica.getElemento(0).getContenido());
	
	}
	
	@Test
	public void FabricaConstruyeUnaSeccionCorrectamente(){
		
		FabricaDeElementos fabrica = new FabricaDeElementos();
		
		List<String> contenidos = new LinkedList<String>();
		
		String contenido = "---";
		
		contenidos.add(contenido);
		
		fabrica.construirElementos(contenidos);
		
		Assert.assertEquals("---", fabrica.getElemento(0).getContenido());
	
	}

}
