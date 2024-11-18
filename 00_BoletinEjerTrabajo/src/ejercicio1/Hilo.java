package ejercicio1;

public class Hilo extends Thread {

    public static void main(String args[]) {
        Hilo miHilo1 = new Hilo();
        Hilo miHilo2 = new Hilo();
        Hilo miHilo3 = new Hilo();

        miHilo1.setName("MIHILO1");
        miHilo2.setName("MIHILO2");
        miHilo3.setName("MIHILO3");

        Hilo[] hilos = { miHilo1, miHilo2, miHilo3 };

        for (Hilo miHilo : hilos) {
            miHilo.start();
            System.out.println("\nInformación del " + miHilo.getName() + ": " + miHilo.toString());
            System.out.println("el hilo " + miHilo.getName() + " se inicia, pero puede que todavía no haya terminiado...");

            if (miHilo.isAlive()) {
                System.out.println("El hilo " + miHilo.getName() + " se está ejecutando.");
                miHilo.interrupt();
                System.out.println("El hilo " + miHilo.getName() + " se ha interrumpido.");
            } else {
                System.out.println("El hilo " + miHilo.getName() + " ha finalizado.");

            }
        }
        
        System.out.println("\n-------------------------\nFin de la ejecución del proceso padre\n-------------------------\n");
    }

    public void run() {
        System.out.println(
                "Dentro del Hilo:" + this.getName() + ", Prioridad: " + this.getPriority() + ", ID: " + this.getId());
        hiloEjecutandose();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
        }
        if (interrupted()) {
            System.out.println("El hilo fue interrumpido");
        }
        System.out.println("Se sale del Hilo:" + this.getName());
    }

    public void hiloEjecutandose() {
        System.out.println("En este momento la CPU ejecuta: " + currentThread().getName() + "\n");
    }
}