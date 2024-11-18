package Ejercicio4_synchronized;


public class HilosSincronizados {
	public static void main(String[] args) {
		Mensaje mensaje = new Mensaje();
		HiloTarea hilo1 = new HiloTarea(mensaje);
		HiloTarea hilo2 = new HiloTarea(mensaje);
		
		hilo1.start();
		hilo2.start();
	}
}
