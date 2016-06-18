package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.TextoPlano;
import ar.edu.untref.aydoo.dominio.Titulo;

public class SeccionTest {

	@Test
	public void SeccionTransformaUntituloCorrectamente() {

		Seccion unaSeccion = new Seccion();
		Elemento unTitulo = new Titulo();
		
		unTitulo.setContenido("# El señor de los anillos");

		unaSeccion.agregarElemento(unTitulo);

		Assert.assertEquals("<section>\n<h1>El señor de los anillos</h1>\n</section>\n", unaSeccion.transformarContenidoMD());
	}
	
	@Test
	public void SeccionTransformaUnSubTituloCorrectamente() {

		Seccion unaSeccion = new Seccion();
		Elemento unSubTitulo = new SubTitulo();
		unSubTitulo.setContenido("## El señor de los anillos");

		unaSeccion.agregarElemento(unSubTitulo);

		Assert.assertEquals("<section>\n<h2>El señor de los anillos</h2>\n</section>\n", unaSeccion.transformarContenidoMD());
	}
	
	@Test
	public void SeccionTransformaUnaImagenCorrectamente() {

		Seccion unaSeccion = new Seccion();
		Elemento unaImagen = new Imagen();
		unaImagen.setContenido("i:imagen.png");

		unaSeccion.agregarElemento(unaImagen);

		Assert.assertEquals("<section>\n<img src=\"imagen.png\"/>\n</section>\n", unaSeccion.transformarContenidoMD());
	}
	
	@Test
	public void SeccionTransformaUnTextoPlanoCorrectamente() {

		Seccion unaSeccion = new Seccion();
		Elemento texto = new TextoPlano();
		texto.setContenido("El señor de los anillos");

		unaSeccion.agregarElemento(texto);

		Assert.assertEquals("<section>\nEl señor de los anillos\n</section>\n", unaSeccion.transformarContenidoMD());
	}

	@Test
	public void SeccionTransformaDosElementosCorrectamente() {

		Seccion otraSeccion = new Seccion();
		Elemento unTitulo = new Titulo();
		Elemento SubTitulo = new SubTitulo();
		
		unTitulo.setContenido("# El Hobbit");
		SubTitulo.setContenido("## 4000 años antes... ");

		otraSeccion.agregarElemento(unTitulo);
		otraSeccion.agregarElemento(SubTitulo);

		Assert.assertEquals("<section>\n<h1>El Hobbit</h1>\n<h2>4000 años antes... </h2>\n</section>\n",
				otraSeccion.transformarContenidoMD());

	}

	@Test
	public void SeccionTransformaCuatroElementosCorrectamente() {

		Seccion otraSeccion = new Seccion();
		Elemento unTitulo = new Titulo();
		Elemento SubTitulo = new SubTitulo();
		Elemento unaImagen = new Imagen();
		Elemento otroTitulo = new Titulo();
		
		unTitulo.setContenido("# El Hobbit");
		SubTitulo.setContenido("## 4000 años antes... ");
		unaImagen.setContenido("i:foto.png");
		otroTitulo.setContenido("# FIN");

		otraSeccion.agregarElemento(unTitulo);
		otraSeccion.agregarElemento(SubTitulo);
		otraSeccion.agregarElemento(unaImagen);
		otraSeccion.agregarElemento(otroTitulo);

		Assert.assertEquals("<section>\n<h1>El Hobbit</h1>\n<h2>4000 años antes... </h2>\n<img src=\"foto.png\"/>\n"
				+ "<h1>FIN</h1>\n</section>\n", otraSeccion.transformarContenidoMD());

	}

	@Test
	public void SeccionSinElementosSeTransformaCorrectamente() {

		Seccion otraSeccion = new Seccion();
		Assert.assertEquals("<section>\n</section>\n", otraSeccion.transformarContenidoMD());

	}

	@Test
	public void NombreDelaSeccionSeTransformaCorrectamente() {
		Seccion seccion = new Seccion();
		seccion.setContenido("---");

		Assert.assertEquals("---", seccion.getContenido());

	}
	
	@Test
	public void SeccionQueContieneOtraSeccionSeTransformaCorrectamente(){
		Seccion seccion = new Seccion();
		Seccion otraSeccion = new Seccion();
		Elemento unTitulo = new Titulo();
		
		unTitulo.setContenido("# El Hobbit");
		
		otraSeccion.agregarElemento(unTitulo);
		seccion.agregarElemento(otraSeccion);
		
		Assert.assertEquals("<section>\n<section>\n<h1>El Hobbit</h1>\n</section>\n</section>\n", seccion.transformarContenidoMD());
	}
}