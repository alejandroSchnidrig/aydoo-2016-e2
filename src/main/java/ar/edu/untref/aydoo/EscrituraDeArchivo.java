package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class EscrituraDeArchivo {

	public void grabarArchivoEnDirectorio(Elemento nuevoArchivo,FileWriter escribirArchivo) throws IOException{
		BufferedWriter bw = new BufferedWriter(escribirArchivo);
		PrintWriter wr = new PrintWriter(bw);   
		
		wr.write(nuevoArchivo.imprimir());

		wr.close();
		bw.close();
	}

}
