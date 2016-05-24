package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArchivoTest {
	
	@Test
	public void ArchivoImprimeUnTituloCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unTitulo = new Titulo("# Titulo numero uno");
		
		unArchivo.agregarElemento(unTitulo);
		
		Assert.assertEquals("<h1>Titulo numero uno</h1>", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnSubTituloCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unSubTitulo = new SubTitulo("## SubTitulo numero uno");
		
		unArchivo.agregarElemento(unSubTitulo);
		
		Assert.assertEquals("<h2>SubTitulo numero uno</h2>",  unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnaImagenCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unaImagen = new Imagen("i:imagen.png");
		
		unArchivo.agregarElemento(unaImagen);
		
		Assert.assertEquals("<img src=\"imagen.png\"/>", unArchivo.imprimir());
	}
	
	@Test
	public void ArchivoImprimeUnaSeccionVaciaCorrectamente(){
		
		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento seccion = new Seccion("");
		
		unArchivo.agregarElemento(seccion);
		
		unArchivo.imprimir();
		
		Assert.assertEquals("<section>\n</section>", unArchivo.imprimir());
	}

	@Test
	public void ArchivoImprimeSusElementosCorrectamente() {

		Archivo unArchivo = new Archivo("archivo.txt");
		Elemento unTitulo = new Titulo("# Titulo numero uno");
		Elemento unTitulo2 = new Titulo("# Titulo numero dos");
		Elemento unSubTitulo = new SubTitulo("## SubTitulo numero uno");
		Elemento unSubTitulo2 = new SubTitulo("## SubTitulo numero dos");
		Elemento unaImagen = new Imagen("i:unaImagen.png");

		unArchivo.agregarElemento(unTitulo);
		unArchivo.agregarElemento(unSubTitulo);
		unArchivo.agregarElemento(unSubTitulo2);
		unArchivo.agregarElemento(unTitulo2);
		unArchivo.agregarElemento(unaImagen);

		unArchivo.imprimir();

		Assert.assertEquals("<h1>Titulo numero uno</h1>", unArchivo.getContenidoElemento(0));
		Assert.assertEquals("<h2>SubTitulo numero uno</h2>", unArchivo.getContenidoElemento(1));
		Assert.assertEquals("<h2>SubTitulo numero dos</h2>", unArchivo.getContenidoElemento(2));
		Assert.assertEquals("<h1>Titulo numero dos</h1>", unArchivo.getContenidoElemento(3));
		Assert.assertEquals("<img src=\"unaImagen.png\"/>", unArchivo.getContenidoElemento(4));

	}

}