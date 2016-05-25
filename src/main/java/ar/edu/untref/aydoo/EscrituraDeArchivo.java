package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class EscrituraDeArchivo {

	public void grabarArchivoEnDirectorio(List<Elemento> listaElementos,FileWriter escribirArchivo) throws IOException{
		BufferedWriter bw = new BufferedWriter(escribirArchivo);
		PrintWriter wr = new PrintWriter(bw);   
		Iterator<Elemento> iterarLista = listaElementos.iterator();
		while(iterarLista.hasNext()){
			Elemento nuevo = iterarLista.next();
			wr.write(nuevo.imprimir());
		}
		wr.close();
		bw.close();
	}

}
