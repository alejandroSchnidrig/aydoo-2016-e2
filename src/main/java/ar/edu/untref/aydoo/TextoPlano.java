package ar.edu.untref.aydoo;

public class TextoPlano  extends Elemento {

	public TextoPlano(String contenido) {
		super(contenido);
	}

	@Override
	public String imprimir() {

		String resultado = "";
		resultado = this.contenido + "\n";

		return resultado;
	}

}
