package ar.edu.untref.aydoo.dominio;

public class Imagen extends Elemento {

	private Elemento siguiente;

	public Imagen() {
		this.contenido = "";
	}

	@Override
	public Elemento crearElemento(String contenido) {

		if (contenido.startsWith("i:")) {
			Imagen unaImagen = new Imagen();
			unaImagen.setContenido(contenido);
			return unaImagen;
		} else {
			return this.siguiente.crearElemento(contenido);
		}

	}

	@Override
	public String transformarContenidoMD() {

		String nuevoContenido = "";
		String[] partes = contenido.split("i:");
		String auxiliar = partes[1];
		nuevoContenido = "<img src=\"" + auxiliar + "\"/>" + "\n";

		this.setContenido(nuevoContenido);
		return nuevoContenido;
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
		System.out.println("Una Imagen no puede agregar un elemento");
	}

}