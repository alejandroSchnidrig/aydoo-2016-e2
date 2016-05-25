package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FabricaDeElementos {
	
	private List<Elemento> elementos;
	
	public FabricaDeElementos(){
		this.elementos = new LinkedList<Elemento>();
	}

	public void construirElementos(List<String> contenidos) {
		
		Iterator<String> iteradorContenidos = contenidos.iterator();
		while(iteradorContenidos.hasNext()){
			String contenido = iteradorContenidos.next();
			
			if(contenido.contains("## ")){
				SubTitulo subTitulo = new SubTitulo(contenido);
				this.elementos.add(subTitulo);
			}else if(contenido.contains("# ")){
				Titulo unTitulo = new Titulo(contenido);
				this.elementos.add(unTitulo);
			}else if(contenido.contains("i:")){
				Imagen unaImagen = new Imagen(contenido);
				this.elementos.add(unaImagen);
			}else if(contenido.contains("---")){
				Seccion unaSeccion = new Seccion(contenido);
				this.elementos.add(unaSeccion);
			}else{
				TextoPlano texto = new TextoPlano(contenido);
				this.elementos.add(texto);
			}	
		}	
		
	}

	public Elemento getElemento(int posicion){
		return this.elementos.get(posicion);
	}

}
