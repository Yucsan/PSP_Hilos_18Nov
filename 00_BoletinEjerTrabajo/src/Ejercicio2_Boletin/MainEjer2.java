package Ejercicio2_Boletin;

import java.util.Scanner;

/*
2.- Diseñar un programa en modo consola que pida dos números naturales por
teclado. Debe crear una tarea que muestre en pantalla el valor del primer
número siempre y cuando sea menor que el del segundo. A posteriori
incrementa ese primer número. Finaliza cuando el valor incrementado es igual al
segundo número. Crea otra tarea que realice lo mismo pero que sea un Daemon
de tal forma que no termine nunca de ejecutarse. (el primer número será mayor
que el segundo). Mostrar en pantalla si la tarea es una aplicación o un Daemon.
Y cuando finalice la tarea debe aparecer también un mensaje indicando que
tarea ha terminad
 * */

public class MainEjer2 {
	
	public static void main(String[] args) {
		
		int numero1=0, numero2;
		
		Scanner tecInt=new Scanner(System.in);
		System.out.println("Ingresa 1 número natural");
		numero1 = tecInt.nextInt();
		System.out.println("Ingresa 2 número natural");
		numero2 = tecInt.nextInt();
		
		//HILO común
		Hilo hilo0=new Hilo(numero1, numero2);
		hilo0.setName("HILO-1");
		
		//Daemon
		Daemon dae=new Daemon(numero1, numero2);
		dae.setName("Demonio");
		dae.setDaemon(true);
		
		hilo0.start();
		dae.start();
		
		boolean preguntaDemonio = dae.isDaemon();
		System.out.println("Es Daemon: "+preguntaDemonio);
		
	}


	
}
