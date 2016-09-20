package ar.edu.untref.aydoo.dominio;

public class SubTitulo extends Elemento {

	private Elemento siguiente;
	
	public SubTitulo(){
		this.contenido = "";
	}

	@Override
	public Elemento crearElemento(String contenido) {

		if (contenido.startsWith("## ")) {
			SubTitulo unSubTitulo = new SubTitulo();
			unSubTitulo.setContenido(contenido);
			return unSubTitulo;
		} else {
			return this.siguiente.crearElemento(contenido);
		}

	}

	@Override
	public String transformarContenidoMD() {

		String nuevoContenido = "";
		String[] partes = contenido.split("## ");
		String auxiliar = partes[1];
		nuevoContenido = "<h2>" + auxiliar + "</h2>" + "\n";

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
		System.out.println("Un SubTitulo no puede agregar un elemento");
	}

}