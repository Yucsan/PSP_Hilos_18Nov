package HilosInternet;

public class Saludo {
	
	private boolean hallegado;
	
	public Saludo() {
		this.hallegado=false;
	}

	public synchronized void adios(String nombre) {

		try {
			
			if(!this.hallegado) {			  
				  wait();
				  System.out.println("\n" + nombre.toUpperCase() + "-: ADIOS.");				
			}else {
				 System.out.println("\n" + nombre.toUpperCase() + "-: HOLA.");
			}

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}

	public synchronized void hola(String nombre) {
			System.out.println("\n******** " + nombre + "-: HOLA .");
			this.hallegado = true;
			notifyAll();
	}

}
