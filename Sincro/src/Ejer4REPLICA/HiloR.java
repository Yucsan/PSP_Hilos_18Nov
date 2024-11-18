package Ejer4REPLICA;

public class HiloR extends Thread {

    private MensajeReplica mensaje;

    public HiloR(MensajeReplica mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
        	
            synchronized (mensaje) {
                while (!this.getName().equals(mensaje.getTurno())) { // Esperar si no es el turno
                    try {
                        mensaje.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Hacer el trabajo
                mensaje.setdentro(true);
                
                String mensajeNuevo = this.getName() + ": MSG" + i;
                System.out.println(this.getName() + " procesando mensaje: " + mensajeNuevo);
                mensaje.setMensaje(mensajeNuevo);

                // Cambiar turno al otro hilo
                
                if(this.getName().equals("HILO 1")) {
                	mensaje.setTurno("HILO 2");
                }else {
                	mensaje.setTurno("HILO 1");
                }
                //mensaje.setTurno(this.getName().equals("HILO 1") ? "HILO 2" : "HILO 1");
                
                mensaje.setdentro(false);

                // Notificar a los demás hilos
                mensaje.notifyAll();

                // Simular tiempo de procesamiento
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
