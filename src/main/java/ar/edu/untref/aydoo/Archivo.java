package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Archivo extends Elemento {

	public List<Elemento> elementos;

	public Archivo() {
		this.contenido = "";
		this.elementos = new LinkedList<Elemento>();
	}

	@Override
	public Elemento crearElemento(String contenido) {
		return null;
	}

	@Override
	public String transformarContenidoMD() {
		
		String resultado = "";
		Iterator<Elemento> listaDeElementos = elementos.iterator();
		while (listaDeElementos.hasNext()) {
			Elemento actual = listaDeElementos.next();
			resultado += actual.transformarContenidoMD();
		}
		return resultado;
	}

	@Override
	public void agregarElemento(Elemento elemento) {
		this.elementos.add(elemento);
	}
	
	

	@Override
	public void setSiguiente(Elemento elemento) {
	}

	@Override
	public Elemento getSiguiente() {
		return null;
	}

	public String getContenidoElemento(int posicion) {
		return this.elementos.get(posicion).getContenido();
	}

}
