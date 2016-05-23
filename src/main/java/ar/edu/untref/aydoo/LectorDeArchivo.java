package ar.edu.untref.aydoo;
	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.LinkedList;
	import java.util.List;

	public class LectorDeArchivo {
		
		List<String> contenidos;
		
		public LectorDeArchivo(){
			this.contenidos = new LinkedList<String>();
		}
		
		public void leerArchivo(String ruta) throws IOException{
			
			String contenido;
			File archivo = new File(ruta);
			FileReader f = new FileReader(archivo);
		    BufferedReader b = new BufferedReader(f);
		    
		    while((contenido = b.readLine())!=null) {
		          this.contenidos.add(contenido);
		      }
		    b.close();
		    
		}
		
		public String getContenido(int posicion){
			return this.contenidos.get(posicion);
		}
		
		public List<String> getListaDeContenidos(){
			return this.contenidos;
		}


}
