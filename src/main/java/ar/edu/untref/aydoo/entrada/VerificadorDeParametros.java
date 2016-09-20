package ar.edu.untref.aydoo.entrada;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.salida.GeneradorSalida;
import ar.edu.untref.aydoo.salida.NoExisteArchivoException;
import ar.edu.untref.aydoo.salida.NoExisteDirectorioException;

public class VerificadorDeParametros {

	private List<String> nuevaLista;

	public VerificadorDeParametros() {
		nuevaLista = new LinkedList<String>();
	}

	public void lectorDeParametros(String argumentos[]) throws IOException, NoExisteDirectorioException,
			NoExisteArchivoException, CaracteresInvalidosException, NoSeIngresaronParametrosException, ParametroInvalidoException {
		
		GeneradorSalida nuevoLector = new GeneradorSalida();
		
		if (argumentos.length == 0) {
			throw new NoSeIngresaronParametrosException();
		} else {
			for (int contador = 0; contador < argumentos.length; contador++) {

				this.nuevaLista.add(argumentos[contador]);
			}
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

			if (!validarParametrosIncorrectos(nuevo) || !validarParametrosIncorrectos(proximo)) {

				if (nuevo.toLowerCase().equals("--mode=default")) {
					nuevoLector.crearCarpetaConArchivo(proximo, "");
				} else if (nuevo.toLowerCase().equals("--mode=no-output")) {
					nuevoLector.mostrarDatosPorPantalla(proximo);
				} else {
					if (!(nuevo.substring(0, 2).equals("--"))) {
						nuevoLector.crearCarpetaConArchivo(nuevo, "");
					} else if (nuevo.toLowerCase().substring(0, 9).equals("--output=")
							&& !validarParametrosIncorrectos(nuevo)) {
						nuevoLector.crearCarpetaConArchivo(proximo, nuevo.substring(9));
					}else{
						throw new ParametroInvalidoException();
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
