package paquete_SIN_SINCRO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 Diseñar en java una aplicación multihilo: con dos líneas de ejecución,
 1 Una tarea mostrará una serie de sumas intermedias entre los nuemros 1 y 20
 De tal forma que aparezcan en líneas distintas:
 1
 1,3,6
 --- sucesivamente hasta sumar el último número que seria el 20
 2 otra tarea mostrara la fecha y la hora dekl sistema durante 10 segundos en pantalla
 * */

public class Hilo extends Thread  {
	public static final String BLUE = "\u001B[34m";
	public static final String RED = "\u001B[31m";
	private List<Integer>numeros = new ArrayList<Integer>();
	private Date fecha = new Date();
	
	public void run() {
		int suma=0;
		for(int i=1; i<=20; i++) {
				suma +=i;
				numeros.add(suma);
				if(getName().equals("HILO0"))
					System.out.println(BLUE+"Ejecuta+ " +this.getName() +"nº "+i+numeros);
				else {
					System.out.println(RED+"Ejecuta+ " +this.getName() +"fecha: "+fecha);
				}
		}
	}
}
