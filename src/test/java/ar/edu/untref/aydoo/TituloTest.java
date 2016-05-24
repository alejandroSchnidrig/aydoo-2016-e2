package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {

	@Test
	public void ElContenidoDelTextoEsCorrecto() {

		Elemento unTitulo = new Titulo("# Cargas electricas en el espacio");

		Assert.assertEquals("# Cargas electricas en el espacio", unTitulo.getContenido());

	}

	@Test
	public void ImprimeBienUnTitulo() {

		Elemento unTitulo = new Titulo("# El estudio de la anti-materia");

		Assert.assertEquals("<h1>El estudio de la anti-materia</h1>\n", unTitulo.imprimir());
	}

}
