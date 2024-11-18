package Ejer2BoletinZ;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainEj2 {

	private static int cont=1;
	
	public static int insertaN() {
		Scanner tecInt = new Scanner(System.in);
		boolean letras = true;
		int num = 0;
		
		while(num < 0 || letras) {
			try {
				letras = false;
				System.out.print("ingresa numero"+cont+": ");
				cont++;
				num = tecInt.nextInt();
			}catch(InputMismatchException e) {
				tecInt=new Scanner(System.in);
				letras = true;
				System.out.println("Introduzca caracteres numéricos");
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		
		
		int num1=0, num2=0;
		
		num1 = MainEj2.insertaN();
		num2 = MainEj2.insertaN();
		
		System.out.println("salimos del while");
		
		HiloEj2 t=new HiloEj2(num1,num2);
		Thread hilo = new Thread(t);
		hilo.setName("Hilo1Yuc");
		hilo.start();
		
		Demonio d=new Demonio(num1,num2);
		
		d.setDaemon(true);
		d.setName("demonYuc");
		d.start();
		
		
		boolean pregunta = d.isDaemon();
		System.out.println("Respuesta: "+pregunta);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
