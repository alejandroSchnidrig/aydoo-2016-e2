package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SubTituloTest {

	@Test
	public void ElContenidoDelTextoEsCorrecto() {

		Elemento unSubTitulo = new SubTitulo("## Cargas electricas en el espacio");

		Assert.assertEquals("## Cargas electricas en el espacio", unSubTitulo.getContenido());

	}

	@Test
	public void ImprimeBienUnTitulo() {

		Elemento unSubTitulo = new SubTitulo("## El estudio de la anti-materia");

		Assert.assertEquals("<h2>El estudio de la anti-materia</h2>", unSubTitulo.imprimir());
	}

}