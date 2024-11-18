package ejercicio4_synchronizedObjeto;

public class Main {

	public static void main(String[] args) {

		// Crear un objeto de bloqueo compartido
		Object bloqueo = new Object();

		for (int i = 0; i < 10; i++) {
			Accion ac1 = new Accion("Hola", bloqueo);
			ac1.setName("Hilo Hola " + (i + 1));
			ac1.start();
		}

		for (int i = 0; i < 10; i++) {
			Accion ac2 = new Accion("Adios", bloqueo);
			ac2.setName("Hilo Adios " + (i + 1));
			ac2.start();
		}
	}

}
