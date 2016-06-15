package ar.edu.untref.aydoo;

public class Titulo extends Elemento {

	private Elemento siguiente;
	
	public Titulo(){
		this.contenido = "";
	}

	@Override
	public Elemento crearElemento(String contenido) {

		if (contenido.startsWith("# ")) {
			Titulo unTitulo = new Titulo();
			unTitulo.setContenido(contenido);
			return unTitulo;
		} else {
			return this.siguiente.crearElemento(contenido);
		}

	}

	@Override
	public String transformarContenidoMD() {

		String nuevoContenido = "";
		String[] partes = contenido.split("# ");
		String auxiliar = partes[1];
		nuevoContenido = "<h1>" + auxiliar + "</h1>" + "\n";

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
		System.out.println("Un Titulo no puede agregar un elemento");
	}

}