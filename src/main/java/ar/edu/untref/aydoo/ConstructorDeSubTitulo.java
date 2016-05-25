package ar.edu.untref.aydoo;

public class ConstructorDeSubTitulo extends ContructorDeElementos {

	@Override
	public Elemento construirElemento(String contenido) {
		return new SubTitulo(contenido);
	}

}
