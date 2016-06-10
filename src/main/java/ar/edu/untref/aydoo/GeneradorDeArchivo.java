package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {

	public void generarArchivoEnDirectorio(String rutaArchivo,String nuevaCadena) throws IOException{
		EscrituraDeArchivo modificarArchivo = new EscrituraDeArchivo();

		List<String> lineas = new ArrayList<String>();
	    String unaLinea = null;
	    String directorio = (System.getProperty("user.dir")+"/"+ rutaArchivo+"/index.html");
	    System.out.println("El directorio es: " + directorio);
		File directorioArchivo = new File(directorio);
        FileReader fr = new FileReader(directorioArchivo);
        BufferedReader br = new BufferedReader(fr);

        while ((unaLinea = br.readLine()) != null) {
            if (unaLinea.contains(("[este-es-el-texto-a-reemplazar]"))){
            	unaLinea = unaLinea.replace("[este-es-el-texto-a-reemplazar]", nuevaCadena);
            }
            lineas.add(unaLinea+"\n");
        }
        fr.close();
        br.close();

        modificarArchivo.grabarArchivoEnDirectorio(directorio, lineas);
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
