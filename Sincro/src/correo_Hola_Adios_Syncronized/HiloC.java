package correo_Hola_Adios_Syncronized;

public class HiloC extends Thread {
	private Correo correo;
	private String nombre;

	 public HiloC(Correo correo, String nombre) {
	        this.correo = correo;
	        this.nombre = nombre;
	    }

	 @Override
	 public void run() {
	     for (int i = 0; i < 6; i++) {
	    	 
	         synchronized (correo) {
	             while ((correo.getBloqueo() && nombre.equals("HILO 2")) || 
	                    (!correo.getBloqueo() && nombre.equals("HILO 1"))) {
	                 try {
	                     correo.wait();
	                 } catch (InterruptedException e) {
	                     e.printStackTrace();
	                 }
	             }

	             // Acción del hilo en su turno.
	             String mensaje;
	             if (correo.getBloqueo()) {
	                 mensaje = "Hola";
	             } else {
	                 mensaje = "Adiós";
	             }
	             correo.enviaCorreo(nombre, mensaje);

	             // Alternar el turno.
	             correo.setBloqueo(!correo.getBloqueo());

	             correo.notifyAll();
	             
	         }
	         
	     }
	 }


}
