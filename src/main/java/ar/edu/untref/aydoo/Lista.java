package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lista extends Elemento {
	
	List<Elemento> elementos;

	public Lista(String contenido) {
		super(contenido);
		this.elementos = new LinkedList<Elemento>();
	}

	
	public String imprimir() {
		
		String resultado = "";
		Iterator<Elemento> iteradorLista = this.elementos.iterator();
		while (iteradorLista.hasNext()) {
			Elemento actual = iteradorLista.next();
			resultado += "<li>" + actual.imprimir() + "</li>" + "\n";
		}
		
		return "<lu>" + "\n" + resultado + "</lu>";
	}


	public void agregarElemento(Elemento Elemento) {
		this.elementos.add(Elemento);
	}

}
