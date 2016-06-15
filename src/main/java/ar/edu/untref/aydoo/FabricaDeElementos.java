package ar.edu.untref.aydoo;

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