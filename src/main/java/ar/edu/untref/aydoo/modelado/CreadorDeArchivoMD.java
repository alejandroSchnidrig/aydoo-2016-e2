package ar.edu.untref.aydoo.modelado;
	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.LinkedList;
	import java.util.List;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.entrada.FabricaDeElementos;

	public class CreadorDeArchivoMD {
		
		List<Elemento> elementos;
		FabricaDeElementos fabrica;
		
		public CreadorDeArchivoMD(){
			this.elementos = new LinkedList<Elemento>();
			fabrica = new FabricaDeElementos();
		}
		
		public void crearArchivoMD(String ruta) throws IOException{
			
			String contenido;
			File archivo = new File(ruta);
			FileReader f = new FileReader(archivo);
		    BufferedReader b = new BufferedReader(f);
		    
		    while((contenido = b.readLine())!=null) {
		          Elemento nuevoElemento = fabrica.crearElementos(contenido);
		          this.elementos.add(nuevoElemento);
		    }
		    b.close();
		    
		}
		
		public String getContenido(int posicion){
			return this.elementos.get(posicion).getContenido();
		}
		
		public Elemento getElemento(int posicion){
			return this.elementos.get(posicion);
		}
		
		public List<Elemento> getListaDeElementos(){
			return this.elementos;
		}


}
