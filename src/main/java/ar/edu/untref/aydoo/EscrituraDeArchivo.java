package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraDeArchivo {

	private BufferedWriter bw;
	private PrintWriter wr;
	
	public void grabarArchivoEnDirectorio(String nuevoArchivo,FileWriter escribirArchivo) throws IOException{
		bw = new BufferedWriter(escribirArchivo);
		wr = new PrintWriter(bw);   
		wr.write(nuevoArchivo);
		wr.close();
		bw.close();
	}

}
