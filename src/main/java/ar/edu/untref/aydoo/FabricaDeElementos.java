package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class FabricaDeElementos {

	private Elemento siguiente;
	public List<Elemento> elementos;

	public FabricaDeElementos() {
		this.elementos = new LinkedList<Elemento>();
	}

	public void fabricarElementos(List<String> contenidos) {
		for (String contenido : contenidos) {
			this.crearElementos(contenido);
		}
	}

	private void crearElementos(String contenido) {
		// Se crean los diferentes tipos de elementos
		Titulo unTitulo = new Titulo();
		SubTitulo unSubTitulo = new SubTitulo();
		Imagen unaImagen = new Imagen();
		Seccion unaSeccion = new Seccion();
		Lista unaLista = new Lista();
		TextoPlano textoPlano = new TextoPlano();

		// Se agregan los elementos a la cadena
		this.setSiguiente(unTitulo);
		unTitulo.setSiguiente(unSubTitulo);
		unSubTitulo.setSiguiente(unaImagen);
		unaImagen.setSiguiente(unaSeccion);
		unaSeccion.setSiguiente(unaLista);
		unaLista.setSiguiente(textoPlano);

		Elemento elemento = this.siguiente.crearElemento(contenido);

		this.elementos.add(elemento);
	}

	public Elemento getElemento(int posicion) {
		return this.elementos.get(posicion);
	}

	public void setSiguiente(Elemento elemento) {
		this.siguiente = elemento;
	}

	public Elemento getSiguiente() {
		return this.siguiente;
	}

	public List<Elemento> getListaDeElementos() {
		return this.elementos;
	}

}