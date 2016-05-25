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
			String actual = iteradorContenidos.next();
			
			if(actual.contains("## ")){
				SubTitulo subTitulo = new SubTitulo(actual);
				this.elementos.add(subTitulo);
			}
		}	
		
	}

	public Elemento getElemento(int posicion){
		return this.elementos.get(posicion);
	}

}
