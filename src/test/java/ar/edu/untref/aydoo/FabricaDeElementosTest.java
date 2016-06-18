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
	
	@Test
	public void FabricaConstruyeConUnaSeccionYUnTextoPlano() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenidoSeccion = "---";
		String contenido = "texto solo";
		
		Elemento nuevoElemento = fabrica.crearElementos(contenidoSeccion);
		Elemento nuevoElementoSeccion = fabrica.crearElementos(contenido);
		
		nuevoElemento.setSiguiente(nuevoElementoSeccion);
		Assert.assertEquals("texto solo\n", nuevoElemento.getSiguiente().transformarContenidoMD());
	}
	@Test
	public void FabricaConstruyeTresElementoYVerificaElUltimo() {

		FabricaDeElementos fabrica = new FabricaDeElementos();

		String contenidoTitulo = "# un titulo";
		String contenidoSubtitulo = "## un subtitulo";
		String contenidoImagen = "i:imagen.png";
		
		Elemento nuevoElementoTitulo = fabrica.crearElementos(contenidoTitulo);
		Elemento nuevoElementoSubtitulo = fabrica.crearElementos(contenidoSubtitulo);
		Elemento nuevoElementoImagen = fabrica.crearElementos(contenidoImagen);

		nuevoElementoTitulo.setSiguiente(nuevoElementoSubtitulo);
		nuevoElementoSubtitulo.setSiguiente(nuevoElementoImagen);
		
		Assert.assertEquals("<img src=\"imagen.png\"/>\n", nuevoElementoTitulo.getSiguiente().getSiguiente().transformarContenidoMD());
	}

}
