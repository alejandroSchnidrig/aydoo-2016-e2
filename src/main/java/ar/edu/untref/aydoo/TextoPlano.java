package ar.edu.untref.aydoo;

public class TextoPlano  extends Elemento {

	public TextoPlano(String contenido) {
		super(contenido);
	}

	@Override
	public String imprimir() {

		System.out.println(contenido);

		return contenido;
	}

}
