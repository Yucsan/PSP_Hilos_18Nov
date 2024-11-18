
package HilosSyncronizedB;

public class Persona extends Thread {

	private String nombre;
	private Saludo saludo;
	private boolean esHola;

	public Persona(String nombre, Saludo saludo, boolean esHola) {
		this.nombre = nombre;
		this.saludo = saludo;
		this.esHola = esHola;
	}

	@Override
	public void run() {
		//System.out.println(nombre + " llego."); con esto veo cual llega primero
		// verifico si es Hola
		for(int i=0; i<10; i++) {			
			if (esHola) 
				saludo.saludoHola(nombre);
			else 
				saludo.saludoAdios(nombre);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//los hilos se ejecutan en desorden, tons si es uno u otro llamas a un metodo 
	

}
