package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {

	public void generarArchivoEnDirectorio(String rutaArchivo,Elemento listaElementos) throws IOException{
		EscrituraDeArchivo escribirArchivo = new EscrituraDeArchivo();
		File directorioArchivo = new File(System.getProperty("user.dir"),"/"+rutaArchivo+"/index.html");
		if(directorioArchivo.exists()){
			directorioArchivo.delete();
		}
		directorioArchivo.createNewFile();

		FileWriter w = new FileWriter(directorioArchivo);
		escribirArchivo.grabarArchivoEnDirectorio(listaElementos,w);
	}
	
	public boolean existeArchivo(String ruta){
		boolean existeEnLaRutaEspecificada=false;
		File archivo = new File(ruta);
		if(archivo.exists()){
			existeEnLaRutaEspecificada=true;
		}else{
			existeEnLaRutaEspecificada=false;
		}
		return existeEnLaRutaEspecificada;
	}
}