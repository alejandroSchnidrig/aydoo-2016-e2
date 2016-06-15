package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OrganizadorDeArchivoTest {

	@Test
	public void ImprimeUnaSeccionyElementos() {

		OrganizadorDeArchivo organizador = new OrganizadorDeArchivo();

		List<Elemento> elementos = new LinkedList<Elemento>();

		Seccion unaSeccion = new Seccion();
		Titulo slide1 = new Titulo();
		Seccion unaSeccion2 = new Seccion();
		SubTitulo slide2 = new SubTitulo();
		Seccion unaSeccion3 = new Seccion();
		TextoPlano texto = new TextoPlano();
		Titulo titulo1 = new Titulo();
		SubTitulo subtitulo2 = new SubTitulo();
		
		unaSeccion.setContenido("---");
		slide1.setContenido("# slide1 :titulo 1");
		unaSeccion2.setContenido("---");
		slide2.setContenido("## slide2: titulo 2");
		unaSeccion3.setContenido("---");
		texto.setContenido("slide 3");
		titulo1.setContenido("# titulo 1");
		subtitulo2.setContenido("## titulo 2");

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
				+ "\n</section>\n<section>\nslide 3\n<h1>titulo 1</h1>\n<h2>titulo 2</h2>\n" + "</section>\n",
				organizador.imprimir());

	}

	@Test
	public void ImprimeUnaListayElementos() {

		OrganizadorDeArchivo organizador = new OrganizadorDeArchivo();

		List<Elemento> elementos = new LinkedList<Elemento>();

		Lista lista = new Lista();
		Lista lista2 = new Lista();
		Titulo unTitulo = new Titulo();
		SubTitulo unSubTitulo = new SubTitulo();
		Lista lista3 = new Lista();
		Lista lista4 = new Lista();
		Lista lista5 = new Lista();
		
		lista.setContenido("*primer elemento");
		lista2.setContenido("*segundo elemento");
		unTitulo.setContenido("# Titulo");
		unSubTitulo.setContenido("## Subtitulo");
		lista3.setContenido("*tercer elemento");
		lista4.setContenido("*cuarto elemento");
		lista5.setContenido("*quinto elemento");

		elementos.add(lista);
		elementos.add(lista2);
		elementos.add(unTitulo);
		elementos.add(unSubTitulo);
		elementos.add(lista3);
		elementos.add(lista4);
		elementos.add(lista5);

		organizador.organizarElementos(elementos);

		Assert.assertEquals("<ul>\n<li>primer elemento</li>\n<li>segundo elemento</li>\n</ul>\n<h1>Titulo</h1>\n"
				+ "<h2>Subtitulo</h2>\n<ul>\n<li>tercer elemento</li>\n<li>cuarto elemento</li>\n<li>quinto elemento</li>"
				+ "\n</ul>\n", organizador.imprimir());

	}
	
	@Test
	public void ImprimeUnaListaYSeccionCorrectamente(){
		
		OrganizadorDeArchivo organizador = new OrganizadorDeArchivo();
		
		List<Elemento> elementos = new LinkedList<Elemento>();
		
		Titulo unTitulo = new Titulo();
		SubTitulo unSubTitulo = new SubTitulo();
		Lista lista = new Lista();
		Lista lista2 = new Lista();
		Seccion unaSeccion = new Seccion();
		TextoPlano texto = new TextoPlano();
		Lista lista3 = new Lista();
		
		unTitulo.setContenido("# Titulo");
		unSubTitulo.setContenido("## Subtitulo");
		lista.setContenido("*primer elemento");
		lista2.setContenido("*segundo elemento");
		unaSeccion.setContenido("---");
		texto.setContenido("slide 3");
		lista3.setContenido("*tercer elemento");
		
		elementos.add(unTitulo);
		elementos.add(unSubTitulo);
		elementos.add(lista);
		elementos.add(lista2);
		elementos.add(unaSeccion);
		elementos.add(texto);
		elementos.add(lista3);
		
		
		organizador.organizarElementos(elementos);
		
		Assert.assertEquals("<h1>Titulo</h1>\n<h2>Subtitulo</h2>\n<ul>\n<li>primer elemento</li>\n"
				+ "<li>segundo elemento</li>\n</ul>\n<section>\nslide 3\n</section>\n<ul>"
				+ "\n<li>tercer elemento</li>\n</ul>\n", organizador.imprimir());
	}
	@Test
	public void ImprimeUnaSeccionConTituloEImagenCorrectamente(){
		
		OrganizadorDeArchivo organizador = new OrganizadorDeArchivo();
		
		List<Elemento> elementos = new LinkedList<Elemento>();
		
		Seccion unaSeccion = new Seccion();
		Titulo unTitulo = new Titulo();
		Imagen imagenPersonal = new Imagen();
		
		unaSeccion.setContenido("---");
		unTitulo.setContenido("# Titulo");
		imagenPersonal.setContenido("i: mifoto.png");
		
		elementos.add(unaSeccion);
		elementos.add(unTitulo);
		elementos.add(imagenPersonal);
		
		organizador.organizarElementos(elementos);
		
		Assert.assertEquals("<section>\n<h1>Titulo</h1>\n<img src=\" mifoto.png\"/>\n</section>\n", organizador.imprimir());
	}
	@Test
	public void ImprimeListaConTextoPlanoEImagenesCorrectamente(){
		
		OrganizadorDeArchivo organizador = new OrganizadorDeArchivo();
		
		List<Elemento> elementos = new LinkedList<Elemento>();
		
		Lista lista = new Lista();
		TextoPlano texto = new TextoPlano();
		Imagen imagenPersonal = new Imagen();
		
		lista.setContenido("*Cosas Importantes");
		texto.setContenido("Mi Foto");
		imagenPersonal.setContenido("i: mifoto.png");
		
		elementos.add(lista);
		elementos.add(texto);
		elementos.add(imagenPersonal);
		
		organizador.organizarElementos(elementos);
		
		Assert.assertEquals("<ul>\n<li>Cosas Importantes</li>\n</ul>\nMi Foto\n<img src=\" mifoto.png\"/>\n", organizador.imprimir());
	}
}