package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Archivo extends Elemento {

	private List<Elemento> elementos;

	public Archivo(String contenido) {
		super(contenido);
		this.elementos = new LinkedList<Elemento>();
	}

	public void agregarElemento(Elemento elemento) {
		elementos.add(elemento);
	}

	public String getContenidoElemento(int posicion) {
		return elementos.get(posicion).getContenido();
	}

	@Override
	public String imprimir() {

		Iterator<Elemento> listaDeElementos = elementos.iterator();
		while (listaDeElementos.hasNext()) {
			Elemento actual = listaDeElementos.next();
			System.out.println(actual.imprimir());
		}
		return null;
	}

}