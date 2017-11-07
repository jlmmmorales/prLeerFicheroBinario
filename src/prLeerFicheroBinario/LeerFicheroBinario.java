package prLeerFicheroBinario;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class LeerFicheroBinario {

	public static void main(String[] args) {
		
		try {
			int numLineas = 0;
			int numCaracteres = 0;
			int i = 1;
			FileInputStream fis = new FileInputStream("mensaje.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			if(dis.available() > 0){
				// Leo el número entero de lineas que vienen después.
				numLineas = dis.readInt();
				System.out.println("Número de lineas: "+numLineas);
			}
			while ((dis.available() > 0) && (i<=numLineas)) {
				System.out.println("Primer entero: "+ dis.readInt());
				numCaracteres = dis.readInt();
				System.out.println("Número de caracteres: "+ numCaracteres );
				leerNCaracteres(numCaracteres,dis);
				i++;
			}
			dis.close();
		} catch (IOException e){
			System.err.println("ERROR: Se produjo algún problema con el fichero mensaje.txt.");
		}
		

	}

	private static void leerNCaracteres(int numCaracteres, DataInputStream dis) throws IOException {
		char c;
		StringBuilder cadena = new StringBuilder("");
		
		for(int i=0; i<numCaracteres; i++){
			c = (char) (dis.readChar() -3);
			cadena.append(c);
		}
		System.out.println(cadena);
		
	}

}
