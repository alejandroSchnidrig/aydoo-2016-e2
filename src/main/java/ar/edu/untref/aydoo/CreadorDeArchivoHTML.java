package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CreadorDeArchivoHTML {

	public List<Elemento> elementos;

	public CreadorDeArchivoHTML() {
		this.elementos = new LinkedList<Elemento>();
	}

	public void organizarElementos(List<Elemento> elementos) {

		Boolean existeSeccion = false;
		Boolean existeLista = false;
		Elemento seccionAuxiliar = null;
		Elemento listaAuxiliar = null;

		Iterator<Elemento> it = elementos.iterator();
		while(it.hasNext()){
			Elemento actual = it.next();

			if(!actual.getContenido().contains("---") && !actual.getContenido().contains("*") && existeSeccion == false	&& existeLista == false){
				this.elementos.add(actual);
			}

			if(actual.getContenido().contains("*") && existeSeccion == true){
				this.elementos.add(seccionAuxiliar);
				existeSeccion = false;
			}

			if(actual.getContenido().contains("---") && existeLista == true){	
				this.elementos.add(listaAuxiliar);
				existeLista = false;
			}

			if(!actual.getContenido().contains("*")){
				if(actual.getContenido().contains("---") && existeSeccion == true){
					this.elementos.add(seccionAuxiliar);
					seccionAuxiliar = actual;
				}else if (actual.getContenido().contains("---")){
					seccionAuxiliar = actual;
					existeSeccion = true;
				}else if(!actual.getContenido().contains("---") && existeSeccion == true){
					seccionAuxiliar.agregarElemento(actual);
				}
			}

			if(!actual.getContenido().contains("---")){
				if(!actual.getContenido().contains("*") && existeLista == true){
					this.elementos.add(listaAuxiliar);
					this.elementos.add(actual);
					existeLista = false;
				}else if(actual.getContenido().contains("*") && existeLista == true){
					listaAuxiliar.agregarElemento(actual);
				}else if(actual.getContenido().contains("*")){
					listaAuxiliar = actual;
					existeLista = true;
				}
			}
			
		}

		if(existeSeccion == true && existeLista == false){
			this.elementos.add(seccionAuxiliar);
		}else if(existeSeccion == false && existeLista == true){
			this.elementos.add(listaAuxiliar);
		}
	}

	public String TransformarContenidosAHTML() {
		
		String resultado = "";
		Iterator<Elemento> listaDeElementos = elementos.iterator();
		while (listaDeElementos.hasNext()) {
			Elemento actual = listaDeElementos.next();
			resultado += actual.transformarContenidoMD();
		}
		return resultado;

	}

}