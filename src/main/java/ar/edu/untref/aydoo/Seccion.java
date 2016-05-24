package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Seccion extends Elemento {

	private List<Elemento> elementos;

	public Seccion(String contenido) {
		super(contenido);
		this.elementos = new LinkedList<Elemento>();
	}

	@Override
	public String imprimir() {

		String resultado = "";
		Iterator<Elemento> iteradorSeccion = this.elementos.iterator();
		while (iteradorSeccion.hasNext()) {
			Elemento actual = iteradorSeccion.next();
			resultado += actual.imprimir();
		}

		return "<section>" + "\n" + resultado + "</section>" + "\n";
	}

	public void agregarElemento(Elemento Elemento) {
		this.elementos.add(Elemento);
	}

}
