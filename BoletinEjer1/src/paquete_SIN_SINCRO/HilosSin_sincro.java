package paquete_SIN_SINCRO;

/*
 Crear un programa que jecute dos hilos uno a continuacion del otro
 Ambos hilos muestran un mensaje 25 veces en panatalla. "Ejecutando hilo nº"
 ¿que ocurre?
 Hay que comprobar que no estań sincronizados. (ejecuta los hilos como quiere. No llega a terminar
 la ejecución del hilo1 y viceversa).
 
 Solucion A: que los hilos sean simultaneos
 SolucionB hasta que no se termine de mostrar la fecha no se mostraran los numeros
 * */

public class HilosSin_sincro {

	public static void main(String[] args) {
		Hilo hilo1=new Hilo();
		hilo1.setName("HILO1");
		hilo1.start();
		Hilo hilo0=new Hilo();
		hilo0.setName("HILO0");
		hilo0.start();
		

	}

}
