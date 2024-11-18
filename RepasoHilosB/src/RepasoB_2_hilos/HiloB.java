package RepasoB_2_hilos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HiloB extends Thread  {
	public static final String RED = "\u001B[31m";
	private Date fecha = new Date();
	
	public void run() {
		for(int i=1; i<=20; i++) {
				System.out.println(RED+"Ejecuta+ " +this.getName() +" nº "+i+" "+fecha+"***");
		}
	}
}
