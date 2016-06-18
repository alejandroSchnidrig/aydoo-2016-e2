package ar.edu.untref.aydoo.salida;

import java.io.File;
import java.io.IOException;

import ar.edu.untref.aydoo.modelado.CreadorDeArchivoHTML;
import ar.edu.untref.aydoo.modelado.CreadorDeArchivoMD;

public class GeneradorSalida {

	public void crearCarpetaYArchivo(String rutaArchivo, String tieneOutput) throws IOException, NoExisteDirectorioException, NoExisteArchivoException {
		File existeArchivoEnRuta = new File(rutaArchivo);
		File copiaDirectorio = new File(System.getProperty("user.dir"),"/plantilla/");
		String directorio = "";
		if(tieneOutput.equals("")){
			directorio = rutaArchivo.substring(0, rutaArchivo.lastIndexOf('.'));
		}else{
			directorio = tieneOutput;
		}
		File generarDirectorio = new File(directorio);
		CopiadoDeCarpeta copiarDirectorio = new CopiadoDeCarpeta();
		GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
		CreadorDeArchivoMD archivoMD = new CreadorDeArchivoMD();
		CreadorDeArchivoHTML archivoHTML = new CreadorDeArchivoHTML();
		if(existeArchivoEnRuta.exists()){
			copiarDirectorio.copiarArchivos(copiaDirectorio, generarDirectorio);
			archivoMD.crearArchivoMD(rutaArchivo);
			archivoHTML.organizarElementos(archivoMD.getListaDeElementos());
			generarArchivo.generarArchivoEnDirectorio(directorio, archivoHTML.TransformarContenidosAHTML());

		}else{
			throw new NoExisteArchivoException ();
		}

	}

	public void mostrarDatosPorPantalla(String rutaArchivo) throws IOException {
		CreadorDeArchivoMD lecturaDeArchivo = new CreadorDeArchivoMD();
		CreadorDeArchivoHTML archivoHTML = new CreadorDeArchivoHTML();
		lecturaDeArchivo.crearArchivoMD(rutaArchivo);
		archivoHTML.organizarElementos(lecturaDeArchivo.getListaDeElementos());
		System.out.println(archivoHTML.TransformarContenidosAHTML());
	}	
}