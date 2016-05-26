package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lista extends Elemento {
	
	List<String> elementos;

	public Lista(String contenido) {
		super(contenido);
		this.elementos = new LinkedList<String>();
	}

	
	public String imprimir() {
			
		String resultado = "";

		Iterator<String> iteradorLista = this.elementos.iterator();
		while (iteradorLista.hasNext()) {
			String actual = iteradorLista.next();
			actual = this.Dividir(actual);
			resultado += "<li>" + actual + "</li>" + "\n";
		}
		
		return "<lu>" + "\n" + "<li>" + this.Dividir(this.contenido) + "</li>" + "\n" +  resultado + "</lu>" + "\n";
	}
	
	public void agregarElemento(Elemento elemento) {
		this.elementos.add(elemento.getContenido());
	}
	
	private String Dividir(String contenido){
		
		String resultado = contenido;
		
		if(resultado.contains("*")){
			String[] partes = contenido.split("\\*");
			String nuevoContenido = partes[1];
			resultado = nuevoContenido;
		}	
		
		return resultado;
	}

}
