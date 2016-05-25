package ar.edu.untref.aydoo;

public class ConstructorDeTitulo extends ContructorDeElementos {

	@Override
	public Elemento construirElemento(String contenido) {
		return new Titulo(contenido);
	}

}
