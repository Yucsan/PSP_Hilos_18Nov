package Ejer4SMS;

public class HiloR extends Thread {

    private sms mensaje;

    public HiloR(sms mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
        	String nombre = this.getName();
        	String mensajeNuevo = this.getName() + ": MSG" + i;
            mensaje.enviaSMS(nombre, mensajeNuevo);
        }
        
    }
}
