package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VerificadorDeParametros {

	private List<String> nuevaLista;

	public VerificadorDeParametros() {
		nuevaLista = new LinkedList<String>();
	}

	public void lectorDeParametros(String argumentos[])
			throws IOException, NoExisteDirectorioException, NoExisteArchivoException, CaracteresInvalidosException {
		GeneradorSalida nuevoLector = new GeneradorSalida();

		for (int contador = 0; contador < argumentos.length; contador++) {

			this.nuevaLista.add(argumentos[contador]);

		}
		Iterator<String> iterador = this.nuevaLista.iterator();
		String nuevo = "";
		String proximo = "";
		String auxiliar = "";
		while (iterador.hasNext()) {
			nuevo = iterador.next();

			if (iterador.hasNext()) {
				proximo = iterador.next();
			}

			if (!(nuevo.substring(0, 2).equals("--")) && (!(proximo == ""))) {
				auxiliar = nuevo;
				nuevo = proximo;
				proximo = auxiliar;
			}

			if(!validarParametrosIncorrectos(nuevo)|| !validarParametrosIncorrectos(proximo)){

				if (nuevo.toLowerCase().equals("--mode=default")) {
					nuevoLector.crearCarpetaYArchivo(proximo, "");
				} else if (nuevo.toLowerCase().equals("--mode=no-output")) {
					nuevoLector.mostrarDatosPorPantalla(proximo);
				} else {
					if (!(nuevo.substring(0, 2).equals("--"))) {
						nuevoLector.crearCarpetaYArchivo(nuevo, "");
					} else if (nuevo.toLowerCase().substring(0, 9).equals("--output=")
							&& !validarParametrosIncorrectos(nuevo)) {
						nuevoLector.crearCarpetaYArchivo(proximo, nuevo.substring(9));
					}
				}
			}
		}
	}

	private boolean validarParametrosIncorrectos(String cadenaCaracteres) throws CaracteresInvalidosException {
		boolean tieneCaracteresIncorrectos = false;
		if (cadenaCaracteres.toLowerCase().contains("ñ") || cadenaCaracteres.toLowerCase().contains("á")
				|| cadenaCaracteres.toLowerCase().contains("é") || cadenaCaracteres.toLowerCase().contains("í")
				|| cadenaCaracteres.toLowerCase().contains("ó") || cadenaCaracteres.toLowerCase().contains("ú")) {
			throw new CaracteresInvalidosException();
		}

		return tieneCaracteresIncorrectos;
	}
}
