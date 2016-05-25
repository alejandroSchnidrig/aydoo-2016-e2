package ar.edu.untref.aydoo;

public class ConstructorDeSeccion extends ContructorDeElementos {

	@Override
	public Elemento construirElemento(String contenido) {
		return new Seccion(contenido);
	}

}
