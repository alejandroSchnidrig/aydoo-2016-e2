package ar.edu.untref.aydoo;

public class ConstructorDeLista extends ContructorDeElementos {

	@Override
	public Elemento construirElemento(String contenido) {
		return new Lista(contenido);
	}

}
