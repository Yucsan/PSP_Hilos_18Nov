package correo2;

public class HiloC extends Thread {
    private Correo correo;
    private String nombre;

    public HiloC(Correo correo, String nombre) {
        this.correo = correo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (correo) {
                while ((correo.isTurno() && nombre.equals("Hilo 2")) ||
                       (!correo.isTurno() && nombre.equals("Hilo 1"))) {
                    try {
                        correo.wait(); // Espera su turno.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Acción del hilo en su turno.
                String mensaje = correo.isTurno() ? "Hola" : "Adiós";
                correo.enviaCorreo(nombre, mensaje);

                // Alternar el turno.
                correo.setTurno(!correo.isTurno());

                // Notificar al otro hilo.
                correo.notifyAll();
            }
        }
    }
}
