package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArchivoTest {
	
	@Test
	public void ArchivoTransformaUnTituloCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento unTitulo = new Titulo();
		
		unTitulo.setContenido("# Titulo numero uno");
		
		unArchivo.agregarElemento(unTitulo);
		
		Assert.assertEquals("<h1>Titulo numero uno</h1>\n", unArchivo.transformarContenidoMD());
	}
	
	@Test
	public void ArchivoGuardaUnContenidoCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento unTitulo = new Titulo();
		Elemento segundoTitulo = new Titulo();
		
		unTitulo.setContenido("# Titulo numero uno");
		segundoTitulo.setContenido("# Titulo numero dos");
		
		unArchivo.agregarElemento(unTitulo);
		unArchivo.agregarElemento(segundoTitulo);
		
		Assert.assertEquals("# Titulo numero uno", unArchivo.getContenidoElemento(0));
	}
	
	@Test
	public void ArchivoTransformaUnSubTituloCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento unSubTitulo = new SubTitulo();
		
		unSubTitulo.setContenido("## SubTitulo numero uno");
		
		unArchivo.agregarElemento(unSubTitulo);
		
		Assert.assertEquals("<h2>SubTitulo numero uno</h2>\n",  unArchivo.transformarContenidoMD());
	}
	
	@Test
	public void ArchivoTransformaUnaImagenCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento unaImagen = new Imagen();
		
		unaImagen.setContenido("i:imagen.png");
		
		unArchivo.agregarElemento(unaImagen);
		
		Assert.assertEquals("<img src=\"imagen.png\"/>\n", unArchivo.transformarContenidoMD());
	}
	
	@Test
	public void ArchivoTransformaTextoPlanoCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento texto = new TextoPlano();
		
		texto.setContenido("hola mundo");
		
		unArchivo.agregarElemento(texto);
		
		Assert.assertEquals("hola mundo\n", unArchivo.transformarContenidoMD());
	}
	
	@Test
	public void ArchivoTransformaUnaSeccionVaciaCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento seccion = new Seccion();
		
		unArchivo.agregarElemento(seccion);
		
		Assert.assertEquals("<section>\n</section>\n", unArchivo.transformarContenidoMD());
	}
	
	@Test
	public void ArchivoTransformaUnaSeccionConElementosCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento seccion = new Seccion();
		Elemento unTitulo = new Titulo();
		Elemento unSubTitulo = new SubTitulo();
		
		unTitulo.setContenido("# Titulo numero uno");
		unSubTitulo.setContenido("## SubTitulo numero uno");
		
		seccion.agregarElemento(unTitulo);
		seccion.agregarElemento(unSubTitulo);
		unArchivo.agregarElemento(seccion);
		
		Assert.assertEquals("<section>\n<h1>Titulo numero uno</h1>\n<h2>SubTitulo numero uno</h2>\n</section>\n", unArchivo.transformarContenidoMD());
	}
	
	@Test
	public void ArchivoTransformaUnaListaVaciaCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento lista = new Lista();
		
		unArchivo.agregarElemento(lista);
		
		Assert.assertEquals("<ul>\n<li></li>\n</ul>\n", unArchivo.transformarContenidoMD());
	}
	
	@Test
	public void ArchivoTransformaUnaListaConElementosCorrectamente(){
		
		Archivo unArchivo = new Archivo();
		Elemento lista = new Lista();
		Elemento listaDos = new Lista();
		Elemento listaTres = new Lista();
		
		lista.setContenido("*mi nombre es");
		listaDos.setContenido("*Robbin");
		listaTres.setContenido("*Hood");
		
		lista.agregarElemento(listaDos);
		lista.agregarElemento(listaTres);
		unArchivo.agregarElemento(lista);
		
		Assert.assertEquals("<ul>\n<li>mi nombre es</li>\n<li>Robbin</li>\n<li>Hood</li>\n</ul>\n", unArchivo.transformarContenidoMD());
	}

	@Test
	public void ArchivoTransformaTodosSusElementosCorrectamente() {

		Archivo unArchivo = new Archivo();
		Elemento unTitulo = new Titulo();
		Elemento unTitulo2 = new Titulo();
		Elemento unSubTitulo = new SubTitulo();
		Elemento unSubTitulo2 = new SubTitulo();
		Elemento unaImagen = new Imagen();
		Elemento seccion = new Seccion();
		
		unTitulo.setContenido("# Titulo numero uno");
		unTitulo2.setContenido("# Titulo numero dos");
		unSubTitulo.setContenido("## SubTitulo numero uno");
		unSubTitulo2.setContenido("## SubTitulo numero dos");
		unaImagen.setContenido("i:unaImagen.png");
		

		unArchivo.agregarElemento(unTitulo);
		unArchivo.agregarElemento(unSubTitulo);
		seccion.agregarElemento(unSubTitulo2);
		seccion.agregarElemento(unTitulo2);
		unArchivo.agregarElemento(seccion);
		unArchivo.agregarElemento(unaImagen);

		Assert.assertEquals("<h1>Titulo numero uno</h1>\n<h2>SubTitulo numero uno</h2>\n<section>\n"
				+ "<h2>SubTitulo numero dos</h2>\n<h1>Titulo numero dos</h1>\n</section>\n<img src=\"unaImagen.png\"/>\n"
					, unArchivo.transformarContenidoMD());
		

	}
	
	@Test
	public void ArchivoTransformaTodosSusElementosSegundaPruebaCorrectamente() {

		Archivo unArchivo = new Archivo();
		Elemento unTitulo = new Titulo();
		Elemento unTitulo2 = new Titulo();
		Elemento unSubTitulo = new SubTitulo();
		Elemento unSubTitulo2 = new SubTitulo();
		Elemento unaImagen = new Imagen();
		Elemento seccion = new Seccion();
		Elemento lista = new Lista();
		Elemento lista2 = new Lista();

		unTitulo.setContenido("# Titulo numero uno");
		unTitulo2.setContenido("# Titulo numero dos");
		unSubTitulo.setContenido("## SubTitulo numero uno");
		unSubTitulo2.setContenido("## SubTitulo numero dos");
		unaImagen.setContenido("i:unaImagen.png");
		lista.setContenido("*primer elemento");
		lista2.setContenido("*segundo elemento");
		
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
				+ "<ul>\n<li>primer elemento</li>\n<li>segundo elemento</li>\n</ul>\n"	, unArchivo.transformarContenidoMD());
		

	}

}