package ar.edu.untref.aydoo;

public class SubTitulo extends Elemento {

	public SubTitulo(String contenido) {
		super(contenido);
	}

	@Override
	public String imprimir() {

		String resultado = "";
		String[] partes = contenido.split("##");
		String nuevoContenido = partes[1];
		resultado = "<h2>" + nuevoContenido + "</h2>";

		System.out.println(resultado);
		this.setContenido(resultado);

		return resultado;
	}

}