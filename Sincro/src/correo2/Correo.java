package correo2;

public class Correo {
    private boolean turno; // Controla el turno: true para un hilo, false para el otro.

    public Correo() {
        this.turno = true; // Comienza con turno para Hilo 1.
    }

    public synchronized void enviaCorreo(String nomHilo, String texto) {
        System.out.println(nomHilo + " " + texto);
    }

    public synchronized boolean isTurno() {
        return turno;
    }

    public synchronized void setTurno(boolean turno) {
        this.turno = turno;
    }
}
