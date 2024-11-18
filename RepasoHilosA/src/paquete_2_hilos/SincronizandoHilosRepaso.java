package paquete_2_hilos;

/*
 Crear un programa que jecute dos hilos uno a continuacion del otro
 Ambos hilos muestran un mensaje 25 veces en panatalla. "Ejecutando hilo nº"
 ¿que ocurre?
 Hay que comprobar que no estań sincronizados. (ejecuta los hilos como quiere. No llega a terminar
 la ejecución del hilo1 y viceversa).
 * */

public class SincronizandoHilosRepaso {

	public static void main(String[] args) {
		Hilo hilo0=new Hilo();
		hilo0.setName("HILO0");
		hilo0.start();
		
		Hilo hilo1=new Hilo();
		hilo1.setName("HILO1");
		hilo1.start();

	}

}
