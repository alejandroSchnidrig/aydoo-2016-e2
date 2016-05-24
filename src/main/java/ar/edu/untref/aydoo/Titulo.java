package ar.edu.untref.aydoo;

public class Titulo extends Elemento {

	public Titulo(String contenido) {
		super(contenido);
	}

	@Override
	public String imprimir() {

		String resultado = "";
		String[] partes = contenido.split("# ");
		String nuevoContenido = partes[1];
		resultado = "<h1>" + nuevoContenido + "</h1>" + "\n";
				

		this.setContenido(resultado);

		return resultado;
	}

}