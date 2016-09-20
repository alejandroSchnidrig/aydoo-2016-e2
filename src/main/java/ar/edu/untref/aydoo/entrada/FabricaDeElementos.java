package ar.edu.untref.aydoo.entrada;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Lista;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.TextoPlano;
import ar.edu.untref.aydoo.dominio.Titulo;

public class FabricaDeElementos {

	private Elemento siguiente;

	public Elemento crearElementos(String contenido) {
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

		return elemento;
	}

	public void setSiguiente(Elemento elemento) {
		this.siguiente = elemento;
	}

	public Elemento getSiguiente() {
		return this.siguiente;
	}

}