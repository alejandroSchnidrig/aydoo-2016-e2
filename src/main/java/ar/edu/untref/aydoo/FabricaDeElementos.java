package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FabricaDeElementos {

	private List<Elemento> elementos;
	private ContructorDeElementos constructor;

	public FabricaDeElementos() {
		this.elementos = new LinkedList<Elemento>();
	}

	public void construirElementos(List<String> contenidos) {

		Iterator<String> iteradorContenidos = contenidos.iterator();
		while (iteradorContenidos.hasNext()) {
			String contenido = iteradorContenidos.next();

			if (contenido.contains("## ")) {
				constructor = new ConstructorDeSubTitulo();
				Elemento unElemento = constructor.construirElemento(contenido);
				this.elementos.add(unElemento);
			} else if (contenido.contains("# ")) {
				constructor = new ConstructorDeTitulo(); 
				Elemento unElemento = constructor.construirElemento(contenido);
				this.elementos.add(unElemento);
			} else if (contenido.contains("i:")) {
				constructor = new ConstructorDeImagen(); 
				Elemento unElemento = constructor.construirElemento(contenido);
				this.elementos.add(unElemento);
			} else if (contenido.contains("---")) {
				constructor = new ConstructorDeSeccion(); 
				Elemento unElemento = constructor.construirElemento(contenido);
				this.elementos.add(unElemento);
			} else if(contenido.contains("*")){
				constructor = new ConstructorDeLista(); 
				Elemento unElemento = constructor.construirElemento(contenido);
				this.elementos.add(unElemento);
			} else {
				constructor = new ConstructorDeTextoPlano(); 
				Elemento unElemento = constructor.construirElemento(contenido);
				this.elementos.add(unElemento);
			}
		}

	}

	public Elemento getElemento(int posicion) {
		return this.elementos.get(posicion);
	}

}
