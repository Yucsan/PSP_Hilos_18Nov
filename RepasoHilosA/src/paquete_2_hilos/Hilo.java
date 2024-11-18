package paquete_2_hilos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hilo extends Thread  {
	public static final String BLUE = "\u001B[34m";
	public static final String RED = "\u001B[31m";
	private List<Integer>numeros = new ArrayList<Integer>();
	private Date fecha = new Date();
	
	public void run() {
		//List<Integer>numeros = new ArrayList<Integer>();
		int suma=0;
		for(int i=1; i<=20; i++) {
				suma +=i;
				numeros.add(suma);
				if(getName().equals("HILO0"))
					System.out.println(BLUE+"Ejecuta+ " +this.getName() +"nº "+i+numeros);
				else
					System.out.println(RED+"Ejecuta+ " +this.getName() +"fecha: "+i+fecha);
		}
	}
}
