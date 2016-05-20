package ar.edu.untref.aydoo;

public class Imagen extends Elemento {

	public Imagen(String contenido) {
		super(contenido);
	}

	@Override
	public String imprimir() {

		String resultado = "";
		String[] partes = contenido.split("i:");
		String nuevoContenido = partes[1];
		resultado = "<img src=\"" + nuevoContenido + "\"/>";

		System.out.println(resultado);
		this.setContenido(resultado);

		return resultado;
	}

}
