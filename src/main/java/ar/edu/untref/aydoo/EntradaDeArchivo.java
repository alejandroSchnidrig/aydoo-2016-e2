package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

public class EntradaDeArchivo {

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
		CreadorDeArchivoMD arhcivoMD = new CreadorDeArchivoMD();
		OrganizadorDeArchivo organizandoElFormato = new OrganizadorDeArchivo();
		if(existeArchivoEnRuta.exists()){
			copiarDirectorio.copiarArchivos(copiaDirectorio, generarDirectorio);
			arhcivoMD.crearArchivoMD(rutaArchivo);
			organizandoElFormato.organizarElementos(arhcivoMD.getListaDeElementos());
			generarArchivo.generarArchivoEnDirectorio(directorio, organizandoElFormato.imprimir());

		}else{
			throw new NoExisteArchivoException ();
		}

	}

	public void mostrarDatosPorPantalla(String rutaArchivo) throws IOException {
		CreadorDeArchivoMD lecturaDeArchivo = new CreadorDeArchivoMD();
		OrganizadorDeArchivo organizandoElFormato = new OrganizadorDeArchivo();
		lecturaDeArchivo.crearArchivoMD(rutaArchivo);
		organizandoElFormato.organizarElementos(lecturaDeArchivo.getListaDeElementos());
		System.out.println(organizandoElFormato.imprimir());
	}	
}