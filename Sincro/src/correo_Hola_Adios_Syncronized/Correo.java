package correo_Hola_Adios_Syncronized;

public class Correo {
	
	private boolean bloqueo;
	
	public Correo() {
		this.bloqueo = true;
	}
	

	public synchronized void enviaCorreo(String nomHilo, String texto) {
			
		System.out.println(nomHilo+" "+texto);
		
	}


	public synchronized Boolean getBloqueo() {
		return bloqueo;
	}


	public synchronized void setBloqueo(Boolean bloqueo) {
		this.bloqueo = bloqueo;
	}
	
	
	
	
}
