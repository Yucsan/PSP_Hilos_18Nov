package ejercicio4_synchronizedObjeto;

class Accion extends Thread {
    private String msn;
    private static boolean turnoHola = true; 
    private static Object bloqueo = new Object();

    public Accion(String msn, Object bloqueo) {
        this.msn = msn;
        this.bloqueo = bloqueo;
    }

    public void mensaje() throws InterruptedException {
    	synchronized (bloqueo) { // Sincronizamos en el objeto bloqueo
            Thread nombreHilo = Thread.currentThread();

            while ((msn.equals("Hola") && !turnoHola) || (msn.equals("Adios") && turnoHola)) {
                System.out.println(nombreHilo.getName() + " está a la espera");
                bloqueo.wait(); // Espera si no es su turno
            }

            // Imprimir el mensaje
            System.out.println(msn);

            // Cambiar el turno
            turnoHola = !turnoHola; // Cambia el turno
            bloqueo.notifyAll(); // Notifica a los otros hilos
        }
    }

    public void run() {
        try {
            mensaje(); // Llamar al método mensaje
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
