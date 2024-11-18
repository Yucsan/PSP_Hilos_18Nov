
package HilosInternet;


public class Persona extends Thread {

	private String nombre;
	private Saludo saludo;
	private boolean hola;

	public Persona(String nombre, Saludo saludo, boolean hola) {
		this.nombre = nombre;
		this.saludo = saludo;
		this.hola = hola;
	}

	@Override
	public void run() {
		System.out.println(nombre + " llego.");
		// verifico si es jefe
		if (hola) {
			saludo.hola(nombre);
		} else {
			saludo.adios(nombre);
		}
	}

}
