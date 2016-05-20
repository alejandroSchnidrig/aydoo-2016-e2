package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	private static BufferedWriter bw;
	public static final void main(String arg[]) throws IOException{
		
		boolean contieneCaracteresEspeciales=false;
		for (int contadorParametros=1;contadorParametros<arg.length || 
				contieneCaracteresEspeciales == true;contadorParametros++){
			switch (arg[contadorParametros].toLowerCase()){
			case "--mode=default":
				escribirEnCarpeta(true);
				break;
			case "--mode=no-output":
				escribirEnCarpeta(false);
				break;
			default: 	
				if(arg[contadorParametros].matches("ñÑ áéíóú/;:,")){
					contieneCaracteresEspeciales=true;
				}else{
				      bw = new BufferedWriter(new FileWriter("index.html"));
				      bw.write("Se genera el index.html");
				}
				break;
			}
		}
	}
	
	public static void escribirEnCarpeta (boolean escribir) throws IOException{
	      bw = new BufferedWriter(new FileWriter("index.html"));
	      bw.write("Se genera el index.html");
	}
}