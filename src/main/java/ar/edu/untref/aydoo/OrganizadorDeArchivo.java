package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

public class OrganizadorDeArchivo {

	private Archivo unArchivo;

	public OrganizadorDeArchivo() {
		this.unArchivo = new Archivo("");
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
				this.unArchivo.agregarElemento(actual);
			}

			if(actual.getContenido().contains("*") && existeSeccion == true){
				this.unArchivo.agregarElemento(seccionAuxiliar);
				existeSeccion = false;
			}

			if(actual.getContenido().contains("---") && existeLista == true){	
				this.unArchivo.agregarElemento(listaAuxiliar);
				existeLista = false;
			}

			if(!actual.getContenido().contains("*")){
				if(actual.getContenido().contains("---") && existeSeccion == true){
					this.unArchivo.agregarElemento(seccionAuxiliar);
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
					this.unArchivo.agregarElemento(listaAuxiliar);
					this.unArchivo.agregarElemento(actual);
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
			this.unArchivo.agregarElemento(seccionAuxiliar);
		}else if(existeSeccion == false && existeLista == true){
			this.unArchivo.agregarElemento(listaAuxiliar);
		}
	}

	public String imprimir() {
		return this.unArchivo.imprimir();
	}

}