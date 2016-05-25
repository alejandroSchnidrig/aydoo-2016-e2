package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class EscrituraDeArchivoTest {


	@Test
	public void seEscribeArchivoConDosElementos() throws IOException{
		EscrituraDeArchivo escribirArchivo = new EscrituraDeArchivo();
		List<Elemento> elementos = new LinkedList<Elemento>();
		String ruta = System.getProperty("user.dir");
		FileWriter escritorArchivo = new FileWriter(ruta+"/template/EscritorArchivo.txt");
		LectorDeArchivo lector = new LectorDeArchivo();

		Elemento unTitulo = new Titulo("# Titulares Importantes");
		Elemento unSubTitulo = new SubTitulo("## Subtitulos");
		
		elementos.add(unTitulo);
		elementos.add(unSubTitulo);
		
		escribirArchivo.grabarArchivoEnDirectorio(elementos, escritorArchivo);
		
		lector.leerArchivo(ruta+"/template/EscritorArchivo.txt");
		
		Assert.assertEquals("<h1>Titulares Importantes</h1>", lector.getContenido(0));
		Assert.assertEquals("<h2>Subtitulos</h2>", lector.getContenido(1));
	}
}
