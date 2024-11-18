package ejercicio01_conceptos_hilos;

public class Hilo extends Thread {

	public void run() {
		System.out.println(
				"Dentro del Hilo:" + this.getName() + ", Prioridad: " + this.getPriority() + ", ID: " + this.getId());
		hiloEjecutandose();
		try {
			sleep(1000);
		} catch (InterruptedException e) {
		}
		if (interrupted()) {
			System.out.println("El hilo fue interrumpido");
		}
		System.out.println("Se sale del Hilo:" + this.getName());
	}

	public static void main(String args[]) {
		Hilo hilo1 = new Hilo();
		Hilo hilo2 = new Hilo();
		Hilo hilo3 = new Hilo();
		hilo1.setName("HILO1");
		hilo2.setName("HILO2");
		hilo3.setName("HILO3");
		Hilo[] hilos = { hilo1, hilo2, hilo3 };
		for (Hilo h : hilos) {
			h.start();
			System.out.println("Información del " + h.getName() + ": " + h.toString());
			System.out.println("el hilo se inicia, pero puede que todavía no haya terminiado...");
			if (h.isAlive()) {
				System.out.println("El hilo " + h.getName() + " se está ejecutando.");
				h.interrupt();
				System.out.println("El hilo " + h.getName() + " se ha interrumpido.");
			} else
				System.out.println("El hilo " + h.getName() + " ha finalizado.");

		}
		System.out.println("Fin de la ejecución del proceso padre");

	}

	public void hiloEjecutandose() {
		System.out.println("En este momento la CPU ejecuta: " + currentThread().getName() + "\n");
	}
}
