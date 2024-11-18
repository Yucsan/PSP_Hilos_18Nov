package Ejer4BoletinZ_1;

public class HilosEj4 implements Runnable {
	
	private Mensaje mensaje;
	private static int i=0;
	private static int j=0;
	
	public HilosEj4(Mensaje mensaje) {
		this.mensaje=mensaje;
	}
	
	
	//el synchronized se  puede poner en el bloque que queramos lo que hace es que 
	//se bloquea hasta que termine de ejecutarse
	@Override
	public void run() {
		
		String nombreHilo= Thread.currentThread().getName();

		synchronized(this.mensaje){			
			System.out.println(nombreHilo+ " enterado del mensaje de "+this.mensaje.getMensaje());
			if(nombreHilo.equals("hilo1"))
				this.mensaje.setMensaje(nombreHilo+": MSG"+this.i++);
			else
				this.mensaje.setMensaje(nombreHilo+": MSG"+this.j++);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
