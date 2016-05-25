package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

public class OrganizadorDeArchivo {

	private Archivo unArchivo;

	public OrganizadorDeArchivo() {
		this.unArchivo = new Archivo("");
	}

	public void organizarElementos(List<Elemento> elementos) {

		Iterator<Elemento> iteradorElementos = elementos.iterator();
		while (iteradorElementos.hasNext()) {
			Elemento actual = iteradorElementos.next();

			if (actual.getContenido().contains("---")) {
				while (iteradorElementos.hasNext()) {
					Elemento proximo = iteradorElementos.next();
					if (proximo.getContenido().contains("---")) {
						this.unArchivo.agregarElemento(actual);
						actual = proximo;
					} else if (!proximo.getContenido().contains("---")) {
						actual.agregarElemento(proximo);
					}
				}
				this.unArchivo.agregarElemento(actual);
			} else if (actual.getContenido().contains("*")) {

			} else {
				this.unArchivo.agregarElemento(actual);
			}
		}
	}

	public String imprimir() {
		return this.unArchivo.imprimir();
	}

}
