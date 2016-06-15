package ar.edu.untref.aydoo;

public abstract class Elemento {

	protected String contenido;

	public Elemento() {
		this.contenido = "";
	}

	public void setContenido(String nuevoContenido) {
		this.contenido = nuevoContenido;
	}

	public String getContenido() {
		return this.contenido;
	}

	public abstract String transformarContenidoMD();
	
	public abstract Elemento crearElemento(String contenido);

	public abstract void agregarElemento(Elemento elemento);

	public abstract void setSiguiente(Elemento elemento);

	public abstract Elemento getSiguiente();

}

