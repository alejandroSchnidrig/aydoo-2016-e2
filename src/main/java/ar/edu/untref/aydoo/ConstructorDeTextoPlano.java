package ar.edu.untref.aydoo;

public class ConstructorDeTextoPlano extends ContructorDeElementos {

	@Override
	public Elemento construirElemento(String contenido) {
		return new TextoPlano(contenido);
	}

}
