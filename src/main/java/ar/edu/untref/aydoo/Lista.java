package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lista extends Elemento {

	private Elemento siguiente;
	public List<String> elementos;

	public Lista() {
		this.contenido = "";
		this.elementos = new LinkedList<String>();
	}

	@Override
	public Elemento crearElemento(String contenido) {

		if (contenido.startsWith("*")) {
			Lista unaLista = new Lista();
			unaLista.setContenido(contenido);
			return unaLista;
		} else {
			return this.siguiente.crearElemento(contenido);
		}

	}

	@Override
	public String transformarContenidoMD() {

		String resultado = "";

		Iterator<String> iteradorLista = this.elementos.iterator();
		while (iteradorLista.hasNext()) {
			String actual = iteradorLista.next();
			actual = this.Dividir(actual);
			resultado += "<li>" + actual + "</li>" + "\n";
		}

		return "<ul>" + "\n" + "<li>" + this.Dividir(this.contenido) + "</li>" + "\n" + resultado + "</ul>" + "\n";
	}

	private String Dividir(String actual) {

		String resultado = actual;

		if (resultado.contains("*")) {
			String[] partes = actual.split("\\*");
			String nuevoContenido = partes[1];
			resultado = nuevoContenido;
		}

		return resultado;
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
		this.elementos.add(elemento.getContenido());
	}

}
