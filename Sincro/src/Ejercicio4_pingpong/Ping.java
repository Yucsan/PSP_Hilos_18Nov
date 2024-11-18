package Ejercicio4_pingpong;

class Ping implements Runnable {
    private String c;
    private int cual;
    private Object lock;
    private boolean isPing; // Identifica si el hilo es de tipo `ping` o `pong`
    private static boolean bandera = true;

    public Ping(String c, int cual, Object lock, boolean isPing) {
        this.c = c;
        this.cual = cual;
        this.lock = lock;
        this.isPing = isPing;
    }

    private void Imprimir() {
        synchronized (lock) {
            // Espera hasta que sea el turno adecuado para `ping` o `pong`
            while (isPing != bandera) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Imprime el mensaje
            System.out.println((isPing ? "" : "\t") + c + cual);

            // Cambia la bandera y notifica al otro hilo de este par
            bandera = !bandera;
            lock.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500); // Pausa para ver claramente la alternancia
                Imprimir();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}