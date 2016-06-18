package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FabricaDeElementosTest {

	@Test
	public void FabricaConstruyeUnSubTituloCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenido = "## un subtitulo";

		Elemento nuevoElemento = fabrica.crearElementos(contenido);

		Assert.assertEquals("<h2>un subtitulo</h2>\n", nuevoElemento.transformarContenidoMD());
	}

	@Test
	public void FabricaConstruyeUnTituloCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenido = "# un titulo";

		Elemento nuevoElemento = fabrica.crearElementos(contenido);

		Assert.assertEquals("<h1>un titulo</h1>\n", nuevoElemento.transformarContenidoMD());
	}

	@Test
	public void FabricaConstruyeUnaImagenCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenido = "i:imagen.png";

		Elemento nuevoElemento = fabrica.crearElementos(contenido);

		Assert.assertEquals("<img src=\"imagen.png\"/>\n", nuevoElemento.transformarContenidoMD());
	}

	@Test
	public void FabricaConstruyeUnaSeccionCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenido = "---";

		Elemento nuevoElemento = fabrica.crearElementos(contenido);

		Assert.assertEquals("<section>\n</section>\n", nuevoElemento.transformarContenidoMD());
	}

	@Test
	public void FabricaConstruyeUnTextoPlanoCorrectamente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenido = "texto solo";

		Elemento nuevoElemento = fabrica.crearElementos(contenido);

		Assert.assertEquals("texto solo\n", nuevoElemento.transformarContenidoMD());
	}
	
	@Test
	public void FabricaConstruyeDosElementosYVerificaElSiguiente() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenido = "texto solo";
		String contenidoSeccion = "---";
		
		Elemento nuevoElemento = fabrica.crearElementos(contenido);
		Elemento nuevoElementoSeccion = fabrica.crearElementos(contenidoSeccion);
		nuevoElemento.setSiguiente(nuevoElementoSeccion);
		Assert.assertEquals("<section>\n</section>\n", nuevoElemento.getSiguiente().transformarContenidoMD());
	}

}
