package Ejer4SMS;

public class sms {

    private String mensaje;
    private boolean dentro;
    private String turno; // Hilo que tiene permiso para trabajar

    public sms() {
        this.mensaje = "";
        this.dentro = false;
        this.turno = "HILO 1"; // Inicia con HILO 1
    }
    
    public synchronized void enviaSMS(String nombre, String mensajeNuevo) {
    	 while (dentro) { // Esperar si no es el turno
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }


         this.dentro = true;
                 
         System.out.println(nombre + " procesando mensaje: " + mensajeNuevo);
         this.mensaje=mensajeNuevo;

         this.dentro=false;
         notifyAll();

         try {
             Thread.sleep(500);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     
    }
    

    public synchronized boolean isdentro() {
        return dentro;
    }

    public synchronized void setdentro(boolean dentro) {
        this.dentro = dentro;
    }

    public synchronized String getMensaje() {
        return mensaje;
    }

    public synchronized void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
