package ar.edu.untref.aydoo.salida;

import java.io.File;
import java.io.IOException;

import ar.edu.untref.aydoo.modelado.CreadorDeArchivoHTML;
import ar.edu.untref.aydoo.modelado.CreadorDeArchivoMD;

public class GeneradorSalida {

	public void crearCarpetaConArchivo(String rutaArchivo, String tieneOutput)
			throws IOException, NoExisteDirectorioException, NoExisteArchivoException {
		File existeArchivoEnRuta = new File(rutaArchivo);
		File copiaDirectorio = new File(System.getProperty("user.dir"), "/plantilla/");
		String directorio = "";
		if (rutaArchivo.contains(".")) {
			if (tieneOutput.equals("")) {
				directorio = rutaArchivo.substring(0, rutaArchivo.lastIndexOf('.'));
			} else {
				directorio = tieneOutput;
			}
		} else {
			throw new NoExisteArchivoException();
		}

		File generarDirectorio = new File(directorio);
		CopiadoDeCarpeta copiarDirectorio = new CopiadoDeCarpeta();
		GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
		CreadorDeArchivoMD archivoMD = new CreadorDeArchivoMD();
		CreadorDeArchivoHTML archivoHTML = new CreadorDeArchivoHTML();
		if (existeArchivoEnRuta.exists()) {
			copiarDirectorio.copiarArchivos(copiaDirectorio, generarDirectorio);
			archivoMD.crearArchivoMD(rutaArchivo);
			archivoHTML.organizarElementos(archivoMD.getListaDeElementos());
			generarArchivo.generarArchivoEnDirectorio(directorio, archivoHTML.transformarContenidosAHTML());

		} else {
			throw new NoExisteArchivoException();
		}

	}

	public void mostrarDatosPorPantalla(String rutaArchivo) throws IOException {
		CreadorDeArchivoMD lecturaDeArchivo = new CreadorDeArchivoMD();
		CreadorDeArchivoHTML archivoHTML = new CreadorDeArchivoHTML();
		lecturaDeArchivo.crearArchivoMD(rutaArchivo);
		archivoHTML.organizarElementos(lecturaDeArchivo.getListaDeElementos());
		System.out.println(archivoHTML.transformarContenidosAHTML());
	}
}