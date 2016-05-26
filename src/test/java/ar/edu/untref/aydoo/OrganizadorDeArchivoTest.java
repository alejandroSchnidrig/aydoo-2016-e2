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
				+ "\n</section>\n<section>\nslide 3\n<h1>titulo 1</h1>\n<h2>titulo 2</h2>\n" + "</section>\n",
				organizador.imprimir());

	}

	@Test
	public void ImprimeUnaListayElementos() {

		OrganizadorDeArchivo organizador = new OrganizadorDeArchivo();

		List<Elemento> elementos = new LinkedList<Elemento>();

		Lista lista = new Lista("*primer elemento");
		Lista lista2 = new Lista("*segundo elemento");
		Titulo unTitulo = new Titulo("# Titulo");
		SubTitulo unSubTitulo = new SubTitulo("## Subtitulo");
		Lista lista3 = new Lista("*tercer elemento");
		Lista lista4 = new Lista("*cuarto elemento");
		Lista lista5 = new Lista("*quinto elemento");

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
		
		Titulo unTitulo = new Titulo("# Titulo");
		SubTitulo unSubTitulo = new SubTitulo("## Subtitulo");
		Lista lista = new Lista("*primer elemento");
		Lista lista2 = new Lista("*segundo elemento");
		Seccion unaSeccion = new Seccion("---");
		TextoPlano texto = new TextoPlano("slide 3");
		Lista lista3 = new Lista("*tercer elemento");
		
		
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
		
		Seccion unaSeccion = new Seccion("---");
		Titulo unTitulo = new Titulo("# Titulo");
		Imagen imagenPersonal = new Imagen("i: mifoto.png");
		
		
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
		
		Lista lista = new Lista("*Cosas Importantes");
		TextoPlano texto = new TextoPlano("Mi Foto");
		Imagen imagenPersonal = new Imagen("i: mifoto.png");

		
		elementos.add(lista);
		elementos.add(texto);
		elementos.add(imagenPersonal);
		
		organizador.organizarElementos(elementos);
		
		Assert.assertEquals("<ul>\n<li>Cosas Importantes</li>\n</ul>\nMi Foto\n<img src=\" mifoto.png\"/>\n", organizador.imprimir());
	}
}