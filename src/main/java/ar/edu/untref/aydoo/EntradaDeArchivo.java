package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

public class EntradaDeArchivo {

	public void crearCarpetaYArchivo(String rutaArchivo, String tieneOutput) throws IOException, NoExisteDirectorioException, NoExisteArchivoException {
		File existeArchivoEnRuta = new File(rutaArchivo);
		File copiaDirectorio = new File(System.getProperty("user.dir"),"/template/plantilla/");
		String directorio = "";
		if(tieneOutput.equals("")){
			directorio = rutaArchivo.substring(0, rutaArchivo.lastIndexOf('.'));
		}else{
			directorio = tieneOutput;
		}
		File generarDirectorio = new File(directorio);
		CopiadoDeCarpeta copiarDirectorio = new CopiadoDeCarpeta();
		GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
		LectorDeArchivo lecturaDeArchivo = new LectorDeArchivo();
		FabricaDeElementos elementosOrdenados = new FabricaDeElementos();
		OrganizadorDeArchivo organizandoElFormato = new OrganizadorDeArchivo();
		if(existeArchivoEnRuta.exists()){
			copiarDirectorio.copiarArchivos(copiaDirectorio, generarDirectorio);
			lecturaDeArchivo.leerArchivo(rutaArchivo);
			elementosOrdenados.construirElementos(lecturaDeArchivo.getListaDeContenidos());
			organizandoElFormato.organizarElementos(elementosOrdenados.getListaDeElementos());
			generarArchivo.generarArchivoEnDirectorio(directorio, organizandoElFormato.imprimir());

		}else{
			throw new NoExisteArchivoException ();
		}

	}

	public void mostrarDatosPorPantalla(String rutaArchivo) throws IOException {
		LectorDeArchivo lecturaDeArchivo = new LectorDeArchivo();
		FabricaDeElementos elementosOrdenados = new FabricaDeElementos();
		OrganizadorDeArchivo organizandoElFormato = new OrganizadorDeArchivo();
		lecturaDeArchivo.leerArchivo(rutaArchivo);
		elementosOrdenados.construirElementos(lecturaDeArchivo.getListaDeContenidos());
		organizandoElFormato.organizarElementos(elementosOrdenados.getListaDeElementos());
		System.out.println(organizandoElFormato.imprimir());
	}	
}