package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OrganizadorDeArchivoTest {

	@Test
	public void testeaUnaSeccionyElementos() {

		OrganizadorDeArchivo organizador = new OrganizadorDeArchivo();

		List<Elemento> elementos = new LinkedList<Elemento>();

		Seccion unaSeccion = new Seccion("---");
		Titulo slide1 = new Titulo("# slide1 :titulo 1");
		Seccion unaSeccion2 = new Seccion("---");
		SubTitulo slide2 = new SubTitulo("## slide2: titulo 2");
		Seccion unaSeccion3 = new Seccion("---");
		TextoPlano texto = new TextoPlano("slide 3");
		Titulo titulo1 = new Titulo("# titulo 1");
		SubTitulo subtitulo2 = new SubTitulo("## titulo 2");

		elementos.add(unaSeccion);
		elementos.add(slide1);
		elementos.add(unaSeccion2);
		elementos.add(slide2);
		elementos.add(unaSeccion3);
		elementos.add(texto);
		elementos.add(titulo1);
		elementos.add(subtitulo2);

		organizador.organizarElementos(elementos);
		
		Assert.assertEquals("<section>\n<h1>slide1 :titulo 1</h1>\n</section>\n<section>\n<h2>slide2: titulo 2</h2>"
				+ "\n</section>\n<section>\nslide 3\n<h1>titulo 1</h1>\n<h2>titulo 2</h2>\n"
				+ "</section>\n", organizador.imprimir());

	}

}