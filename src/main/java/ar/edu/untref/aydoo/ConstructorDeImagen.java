package ar.edu.untref.aydoo;

public class ConstructorDeImagen extends ContructorDeElementos {

	@Override
	public Elemento construirElemento(String contenido) {
		return new Imagen(contenido);
	}

}
