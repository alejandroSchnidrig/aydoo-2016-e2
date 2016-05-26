package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArchivoTest {
	
	@Test
	public void ArchivoImprimeUnTituloCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unTitulo = new Titulo("# Titulo numero uno");
		
		unArchivo.agregarElemento(unTitulo);
		
		Assert.assertEquals("<h1>Titulo numero uno</h1>\n", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnSubTituloCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unSubTitulo = new SubTitulo("## SubTitulo numero uno");
		
		unArchivo.agregarElemento(unSubTitulo);
		
		Assert.assertEquals("<h2>SubTitulo numero uno</h2>\n",  unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnaImagenCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unaImagen = new Imagen("i:imagen.png");
		
		unArchivo.agregarElemento(unaImagen);
		
		Assert.assertEquals("<img src=\"imagen.png\"/>\n", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeTextoPlanoCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento texto = new TextoPlano("hola mundo");
		
		unArchivo.agregarElemento(texto);
		
		Assert.assertEquals("hola mundo\n", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnaSeccionVaciaCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento seccion = new Seccion("");
		
		unArchivo.agregarElemento(seccion);
		
		Assert.assertEquals("<section>\n</section>\n", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnaSeccionConElementosCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento seccion = new Seccion("");
		Elemento unTitulo = new Titulo("# Titulo numero uno");
		Elemento unSubTitulo = new SubTitulo("## SubTitulo numero uno");
		
		seccion.agregarElemento(unTitulo);
		seccion.agregarElemento(unSubTitulo);
		unArchivo.agregarElemento(seccion);
		
		Assert.assertEquals("<section>\n<h1>Titulo numero uno</h1>\n<h2>SubTitulo numero uno</h2>\n</section>\n", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnaListaVaciaCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento lista = new Lista("");
		
		unArchivo.agregarElemento(lista);
		
		Assert.assertEquals("<ul>\n<li></li>\n</ul>\n", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnaListaConElementosCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento lista = new Lista("*mi nombre es");
		Elemento listaDos = new Lista("*Robbin");
		Elemento listaTres = new Lista("*Hood");
		
		lista.agregarElemento(listaDos);
		lista.agregarElemento(listaTres);
		unArchivo.agregarElemento(lista);
		
		Assert.assertEquals("<ul>\n<li>mi nombre es</li>\n<li>Robbin</li>\n<li>Hood</li>\n</ul>\n", unArchivo.imprimir());
	}

	@Test
	public void ArchivoImprimeTodosSusElementosCorrectamente() {

		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unTitulo = new Titulo("# Titulo numero uno");
		Elemento unTitulo2 = new Titulo("# Titulo numero dos");
		Elemento unSubTitulo = new SubTitulo("## SubTitulo numero uno");
		Elemento unSubTitulo2 = new SubTitulo("## SubTitulo numero dos");
		Elemento unaImagen = new Imagen("i:unaImagen.png");
		Elemento seccion = new Seccion("---");

		unArchivo.agregarElemento(unTitulo);
		unArchivo.agregarElemento(unSubTitulo);
		seccion.agregarElemento(unSubTitulo2);
		seccion.agregarElemento(unTitulo2);
		unArchivo.agregarElemento(seccion);
		unArchivo.agregarElemento(unaImagen);

		Assert.assertEquals("<h1>Titulo numero uno</h1>\n<h2>SubTitulo numero uno</h2>\n<section>\n"
				+ "<h2>SubTitulo numero dos</h2>\n<h1>Titulo numero dos</h1>\n</section>\n<img src=\"unaImagen.png\"/>\n"
					, unArchivo.imprimir());
		

	}
	
	@Test
	public void ArchivoImprimeTodosSusElementosSegundaPruebaCorrectamente() {

		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unTitulo = new Titulo("# Titulo numero uno");
		Elemento unTitulo2 = new Titulo("# Titulo numero dos");
		Elemento unSubTitulo = new SubTitulo("## SubTitulo numero uno");
		Elemento unSubTitulo2 = new SubTitulo("## SubTitulo numero dos");
		Elemento unaImagen = new Imagen("i:unaImagen.png");
		Elemento seccion = new Seccion("---");
		Elemento lista = new Lista("*primer elemento");
		Elemento lista2 = new Lista("*segundo elemento");

		unArchivo.agregarElemento(unTitulo);
		unArchivo.agregarElemento(unSubTitulo);
		seccion.agregarElemento(unSubTitulo2);
		seccion.agregarElemento(unTitulo2);
		unArchivo.agregarElemento(seccion);
		unArchivo.agregarElemento(unaImagen);
		lista.agregarElemento(lista2);
		unArchivo.agregarElemento(lista);

		Assert.assertEquals("<h1>Titulo numero uno</h1>\n<h2>SubTitulo numero uno</h2>\n<section>\n"
				+ "<h2>SubTitulo numero dos</h2>\n<h1>Titulo numero dos</h1>\n</section>\n<img src=\"unaImagen.png\"/>\n"
				+ "<ul>\n<li>primer elemento</li>\n<li>segundo elemento</li>\n</ul>\n"	, unArchivo.imprimir());
		

	}

}