package HilosSyncronizedA;

public class Saludo {
	
	private boolean llegado;
	
	public Saludo() {
		this.llegado=false;
	}

	public synchronized void saludoEmpleado(String nombre) {

		try {
			
			if(!this.llegado) {
				wait();
				System.out.println("\n" + nombre.toUpperCase() + "-: Buenos dias jefe.");				
			}else {
				System.out.println("\n" + nombre.toUpperCase() + "-: Disculpe por el retraso");	
			}
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}

	public synchronized void saludoJefe(String nombre) {
			System.out.println("\n******** " + nombre + "-: Buenos dias Empleados.");
			this.llegado = true;
			notifyAll();
	}

}
