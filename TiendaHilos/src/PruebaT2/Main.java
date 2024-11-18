package PruebaT2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		
		Lock rlock = new ReentrantLock();
		
		Cliente[] clientes = {
				new Cliente("fer", 300f, rlock),
				new Cliente("Ana", 100f, rlock),
				new Cliente("Gala", 800f, rlock),
		};
		
		for(Cliente c: clientes) {
			Hilo1 h=new Hilo1(c);
			h.setName("h"+c.getNombre());
			
			h.start();
			
		}
		
	}

}
