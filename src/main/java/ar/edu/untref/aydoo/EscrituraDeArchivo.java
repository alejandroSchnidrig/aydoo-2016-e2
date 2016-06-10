package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscrituraDeArchivo {

	public void grabarArchivoEnDirectorio(String nuevoArchivo, List<String> lineas) throws IOException{

        FileWriter escribirArchivo = new FileWriter(nuevoArchivo);
        BufferedWriter salidaArchivo = new BufferedWriter(escribirArchivo);
        for(String PalabrasPorLinea: lineas){
        	salidaArchivo.write(PalabrasPorLinea);
        }
        salidaArchivo.flush();
        salidaArchivo.close();	
	
	}

}
