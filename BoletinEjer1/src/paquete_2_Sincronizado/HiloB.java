package paquete_2_Sincronizado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HiloB extends Thread  {
	public static final String RED = "\u001B[31m";
	
	public void run() {
		
		LocalDate fecha=LocalDate.now();
		LocalTime hora = LocalTime.now();
		LocalTime tiempo=LocalTime.now().plusSeconds(10);
		do {			
			System.out.println(RED+"Ejecuta+ " +this.getName() +"fecha: "+fecha);
			hora = LocalTime.now();
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}while(hora.isBefore(tiempo)); 
	}
	
}
