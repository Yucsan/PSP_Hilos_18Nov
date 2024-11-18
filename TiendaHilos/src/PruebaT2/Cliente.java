package PruebaT2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cliente {
	private String nombre;
	private float dinero;
	private Lock bloqueo; 

	public Cliente(String nombre, float dinero, Lock bloqueo) {
		super();
		this.nombre = nombre;
		this.dinero = dinero;
		this.bloqueo = bloqueo;
	}

	public void opera() {
        float ale = (float) ((Math.random() * 500) + 1);

        // Adquirir el bloqueo global
        bloqueo.lock();
        try {
            System.out.println("Cliente: " + nombre + " inicia operación con ale: " + ale);
            for (int i = 1; i < 5; i++) {
                dinero += i;
                System.out.println("Cliente: " + nombre + " suma: " + i + ", total: " + dinero);
                Thread.sleep(500); // Simular una operación más lenta
            }
            System.out.println("Cliente: " + nombre + " finaliza operación, dinero total: " + dinero);
        } catch (InterruptedException e) {
            System.err.println("Operación interrumpida para: " + nombre);
        } finally {
            bloqueo.unlock(); // Liberar el bloqueo
        }
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
