package Ejer4REPLICA;

public class MensajeReplica {

    private String mensaje;
    private boolean dentro;
    private String turno; // Hilo que tiene permiso para trabajar

    public MensajeReplica() {
        this.mensaje = "";
        this.dentro = false;
        this.turno = "HILO 1"; // Inicia con HILO 1
    }

    public boolean isdentro() {
        return dentro;
    }

    public void setdentro(boolean dentro) {
        this.dentro = dentro;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
