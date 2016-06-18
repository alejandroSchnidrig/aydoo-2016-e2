package ar.edu.untref.aydoo.salida;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.Titulo;
import ar.edu.untref.aydoo.modelado.CreadorDeArchivoHTML;
import ar.edu.untref.aydoo.modelado.CreadorDeArchivoMD;
import ar.edu.untref.aydoo.salida.EscrituraDeArchivo;

import org.junit.Assert;

public class EscrituraDeArchivoTest {


	@Test
	public void seEscribeArchivoConDosElementos() throws IOException{
		EscrituraDeArchivo escribirArchivo = new EscrituraDeArchivo();
		String ruta = (System.getProperty("user.dir")+"/archivosDeEjemplo/EscritorArchivo.txt");
		List<String> listaDeLineas = new ArrayList<String>();
		CreadorDeArchivoMD lector = new CreadorDeArchivoMD();

		List<Elemento> elementos = new LinkedList<Elemento>();
		
		CreadorDeArchivoHTML archivoHTML = new CreadorDeArchivoHTML();
		Elemento unTitulo = new Titulo();
		Elemento unSubTitulo = new SubTitulo();
		
		unTitulo.setContenido("# Titulares Importantes");
		unSubTitulo.setContenido("## Subtitulos");
		
		elementos.add(unTitulo);
		elementos.add(unSubTitulo);
		
		archivoHTML.organizarElementos(elementos);
		listaDeLineas.add(archivoHTML.TransformarContenidosAHTML());
		escribirArchivo.grabarArchivoEnDirectorio(ruta, listaDeLineas);
		
		lector.crearArchivoMD(ruta);
		
		Assert.assertEquals("<h1>Titulares Importantes</h1>", lector.getContenido(0));
		Assert.assertEquals("<h2>Subtitulos</h2>", lector.getContenido(1));
	}
}
