package ar.edu.untref.aydoo;

public class TextoPlano extends Elemento {

	private Elemento siguiente;

	public TextoPlano() {
		this.contenido = "";
	}

	@Override
	public Elemento crearElemento(String contenido) {
		TextoPlano unTextoPlano = new TextoPlano();
		unTextoPlano.setContenido(contenido);
		return unTextoPlano;
	}

	@Override
	public String transformarContenidoMD() {

		String resultado = "";
		resultado = this.contenido + "\n";

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
		System.out.println("Un TextoPlano no puede agregar un elemento");
	}

}