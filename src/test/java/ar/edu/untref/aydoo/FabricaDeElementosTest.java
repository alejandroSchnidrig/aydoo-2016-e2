package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FabricaDeElementosTest {

	@Test
	public void FabricaConstruyeUnSubTituloCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		List<String> contenidos = new LinkedList<String>();

		String contenido = "## un subtitulo";

		contenidos.add(contenido);

		fabrica.construirElementos(contenidos);

		Assert.assertEquals("<h2>un subtitulo</h2>\n", fabrica.getElemento(0).imprimir());

	}

	@Test
	public void FabricaConstruyeUnTituloCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		List<String> contenidos = new LinkedList<String>();

		String contenido = "# un titulo";

		contenidos.add(contenido);

		fabrica.construirElementos(contenidos);

		Assert.assertEquals("<h1>un titulo</h1>\n", fabrica.getElemento(0).imprimir());

	}

	@Test
	public void FabricaConstruyeUnaImagenCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		List<String> contenidos = new LinkedList<String>();

		String contenido = "i:imagen.png";

		contenidos.add(contenido);

		fabrica.construirElementos(contenidos);

		Assert.assertEquals("<img src=\"imagen.png\"/>\n", fabrica.getElemento(0).imprimir());

	}

	@Test
	public void FabricaConstruyeUnaSeccionCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		List<String> contenidos = new LinkedList<String>();

		String contenido = "---";

		contenidos.add(contenido);

		fabrica.construirElementos(contenidos);

		Assert.assertEquals("<section>\n</section>\n", fabrica.getElemento(0).imprimir());

	}

	@Test
	public void FabricaConstruyeUnTextoPlanoCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		List<String> contenidos = new LinkedList<String>();

		String contenido = "texto solo";

		contenidos.add(contenido);

		fabrica.construirElementos(contenidos);

		Assert.assertEquals("texto solo\n", fabrica.getElemento(0).imprimir());

	}

	@Test
	public void FabricaConstruyeUnaListaPlanoCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		List<String> contenidos = new LinkedList<String>();

		String contenido = "*elemento de una lista";

		contenidos.add(contenido);

		fabrica.construirElementos(contenidos);

		Assert.assertEquals("<lu>\n<li>elemento de una lista</li>\n</lu>", fabrica.getElemento(0).imprimir());

	}

	@Test
	public void FabricaConstruyeseisElementosCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		List<String> contenidos = new LinkedList<String>();

		String contenido0 = "## un subtitulo";
		String contenido1 = "# un titulo";
		String contenido2 = "i:imagen.png";
		String contenido3 = "---";
		String contenido4 = "texto solo";
		String contenido5 = "*elemento de una lista";

		contenidos.add(contenido0);
		contenidos.add(contenido1);
		contenidos.add(contenido2);
		contenidos.add(contenido3);
		contenidos.add(contenido4);
		contenidos.add(contenido5);

		fabrica.construirElementos(contenidos);

		Assert.assertEquals("<h2>un subtitulo</h2>\n", fabrica.getElemento(0).imprimir());
		Assert.assertEquals("<h1>un titulo</h1>\n", fabrica.getElemento(1).imprimir());
		Assert.assertEquals("<img src=\"imagen.png\"/>\n", fabrica.getElemento(2).imprimir());
		Assert.assertEquals("<section>\n</section>\n", fabrica.getElemento(3).imprimir());
		Assert.assertEquals("texto solo\n", fabrica.getElemento(4).imprimir());
		Assert.assertEquals("<lu>\n<li>elemento de una lista</li>\n</lu>", fabrica.getElemento(5).imprimir());
	}

}
