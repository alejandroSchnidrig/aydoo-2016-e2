package ar.edu.untref.aydoo.dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Seccion extends Elemento {

	private Elemento siguiente;
	public List<Elemento> elementos;
	
	public Seccion(){
		this.contenido = "";
		this.elementos = new LinkedList<Elemento>();
	}

	@Override
	public Elemento crearElemento(String contenido) {

		if (contenido.startsWith("---")) {
			Seccion unaSeccion = new Seccion();
			unaSeccion.setContenido(contenido);
			return unaSeccion;
		} else {
			return this.siguiente.crearElemento(contenido);
		}

	}

	@Override
	public String transformarContenidoMD() {

		String resultado = "";
		Iterator<Elemento> iteradorSeccion = this.elementos.iterator();
		while (iteradorSeccion.hasNext()) {
			Elemento actual = iteradorSeccion.next();
			resultado += actual.transformarContenidoMD();
		}

		return "<section>" + "\n" + resultado + "</section>" + "\n";
	}

	@Override
	public void setSiguiente(Elemento elemento) {
		this.siguiente = elemento;
	}

	@Override
	public Elemento getSiguiente() {
		return this.siguiente;
	}

	@Override
	public void agregarElemento(Elemento elemento) {
		this.elementos.add(elemento);
	}

}
