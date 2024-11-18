package RepasoB_2_hilos;

/*
 Crear un programa que jecute dos hilos uno a continuacion del otro
 Ambos hilos muestran un mensaje 25 veces en panatalla. "Ejecutando hilo nº"
 ¿que ocurre?
 Hay que comprobar que no estań sincronizados. (ejecuta los hilos como quiere. No llega a terminar
 la ejecución del hilo1 y viceversa).
 * */

public class SincronizandoHilosRepaso {

	public static void main(String[] args) {
		
		
		//En esta se le asigna nombre
		
		HiloA hilo0=new HiloA();
		hilo0.setName("HILO0");
		hilo0.start();
		
		HiloB hilo1=new HiloB();
		hilo1.setName("HILO1");
		hilo1.start();
		

		/*
		//En esta opcion usamos Runnable
		Runnable r1=new HiloA();
		((Thread) r1).setName("M1");
		Thread t1=new Thread(r1);
		t1.start();
		
		Runnable r2=new HiloB();
		((Thread) r2).setName("M2");
		Thread t2=new Thread(r2);
		t2.start();
		 */
	}

}
