package ar.edu.untref.aydoo;

public abstract class Elemento {

	protected String contenido;

	public Elemento(String contenido) {
		this.contenido = contenido;
	}

	public void setContenido(String nuevoContenido) {
		this.contenido = nuevoContenido;
	}

	public String getContenido() {
		return this.contenido;
	}

	public abstract String imprimir();
}
