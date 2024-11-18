package Ejercicio2_Boletin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Hilo extends Thread  {
	public static final String CYAN = "\u001b[36m";
	
	private int numero1;
	private int numero2;
	

	public Hilo(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}

	public void run() {
		    while (numero1 <= numero2) {  		    	
		    	if(getName().equals("HILO-1"))
					System.out.println(CYAN+"Ejecuta+ " +this.getName() +" NUMERO: "+numero1);
		        numero1++;
		    }
		    System.out.println(CYAN+"fin del :"+this.getName());
	}
}
