package ar.edu.untref.aydoo.modelado;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.dominio.Elemento;

public class CreadorDeArchivoHTML {

	public List<Elemento> elementos;

	public CreadorDeArchivoHTML() {
		this.elementos = new LinkedList<Elemento>();
	}

	public void organizarElementos(List<Elemento> elementos) {

		List<Elemento> unaLista = this.organizaListas(elementos);
		this.elementos = this.organizaSecciones(unaLista);
	}

	private List<Elemento> organizaListas(List<Elemento> elementos) {

		List<Elemento> listaAuxiliar = new LinkedList<Elemento>();
		Elemento lista = null;
		boolean existeLista = false;

		Iterator<Elemento> it = elementos.iterator();
		while (it.hasNext()) {
			Elemento actual = it.next();

			if (actual.getContenido().contains("*") && existeLista == false) {
				lista = actual;
				existeLista = true;
			} else if (actual.getContenido().contains("*") && existeLista == true) {
				lista.agregarElemento(actual);
			}

			if (!actual.getContenido().contains("*") && existeLista == true) {
				listaAuxiliar.add(lista);
				listaAuxiliar.add(actual);
				existeLista = false;
			} else if (!actual.getContenido().contains("*") && existeLista == false) {
				listaAuxiliar.add(actual);
			}
		}

		if (existeLista == true) {
			listaAuxiliar.add(lista);
		}

		return listaAuxiliar;

	}

	private List<Elemento> organizaSecciones(List<Elemento> elementos) {

		List<Elemento> listaAuxiliar = new LinkedList<Elemento>();
		Elemento seccion = null;
		boolean existeSeccion = false;

		Iterator<Elemento> it = elementos.iterator();
		while (it.hasNext()) {
			Elemento actual = it.next();

			if (actual.getContenido().contains("---") && existeSeccion == false) {
				seccion = actual;
				existeSeccion = true;
			} else if (actual.getContenido().contains("---") && existeSeccion == true) {
				listaAuxiliar.add(seccion);
				seccion = actual;
			}

			if (!actual.getContenido().contains("---") && existeSeccion == true) {
				seccion.agregarElemento(actual);
			} else if (!actual.getContenido().contains("---") && existeSeccion == false) {
				listaAuxiliar.add(actual);
			}
		}

		if (existeSeccion == true) {
			listaAuxiliar.add(seccion);
		}

		return listaAuxiliar;

	}

	public String transformarContenidosAHTML() {

		String resultado = "";
		Iterator<Elemento> listaDeElementos = elementos.iterator();
		while (listaDeElementos.hasNext()) {
			Elemento actual = listaDeElementos.next();
			resultado += actual.transformarContenidoMD();
		}
		return resultado;

	}

}