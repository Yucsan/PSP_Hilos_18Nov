package fecha_Sincronizado;

/*
 Crear un programa que jecute dos hilos uno a continuacion del otro
 Ambos hilos muestran un mensaje 25 veces en panatalla. "Ejecutando hilo nº"
 ¿que ocurre?
 Hay que comprobar que no estań sincronizados. (ejecuta los hilos como quiere. No llega a terminar
 la ejecución del hilo1 y viceversa).
 
  Solucion A: que los hilos sean simultaneos
 SolucionB hasta que no se termine de mostrar la fecha no se mostraran los numeros
 * */

public class hilosSincronizados {

	public static void main(String[] args) {
		
		HiloB hiloFecha=new HiloB();
		hiloFecha.setName("HILO1");
		hiloFecha.start();
		//doy prioridad al hilo0
		try {
			hiloFecha.join();//espera a que el hilo sea interrumpido
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Hilo hilo0=new Hilo();
		hilo0.setName("HILO0");
		hilo0.start();
		
	
		
		

	}

}
