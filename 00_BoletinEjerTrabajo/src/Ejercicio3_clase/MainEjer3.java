package Ejercicio3_clase;

import java.util.Scanner;

/*
3.- Diseñar un programa en modo consola que cree tres ficheros de texto con
los números del 0 al 10000. El primer fichero tiene una prioridad máxima con
respecto al segundo y la creación del tercer fichero debe ser en segundo plano.
Comprobar cuándo finaliza la creación de cada fichero con un mensaje en
consola.
 * */

public class MainEjer3 {
	
	public static void main(String[] args) {
		
		//HILO común
		HiloArchivo hilo0=new HiloArchivo();
		HiloArchivo hilo1=new HiloArchivo();
		HiloArchivo hilo2=new HiloArchivo();
		hilo0.setName("HILOArchivoEj3_1");
		hilo1.setName("HILOArchivoEj3_2");
		hilo2.setName("demonio");
		
		hilo0.start();
		try {
			hilo0.join();//espera a que el hilo sea interrumpido
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		hilo1.start();
		hilo2.setDaemon(true);
		hilo2.start();
		

		
		
		
		
	}


	
}
