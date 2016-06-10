package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class EscrituraDeArchivoTest {


	@Test
	public void seEscribeArchivoConDosElementos() throws IOException{
		EscrituraDeArchivo escribirArchivo = new EscrituraDeArchivo();
		String ruta = (System.getProperty("user.dir")+"/template/EscritorArchivo.txt");
		List<String> listaDeLineas = new ArrayList<String>();
		LectorDeArchivo lector = new LectorDeArchivo();

		
		Elemento nuevoArchivo = new Archivo("");
		Elemento unTitulo = new Titulo("# Titulares Importantes");
		Elemento unSubTitulo = new SubTitulo("## Subtitulos");
		
		nuevoArchivo.agregarElemento(unTitulo);
		nuevoArchivo.agregarElemento(unSubTitulo);
		listaDeLineas.add(nuevoArchivo.imprimir());
		escribirArchivo.grabarArchivoEnDirectorio(ruta, listaDeLineas);
		
		lector.leerArchivo(ruta);
		
		Assert.assertEquals("<h1>Titulares Importantes</h1>", lector.getContenido(0));
		Assert.assertEquals("<h2>Subtitulos</h2>", lector.getContenido(1));
	}
}
