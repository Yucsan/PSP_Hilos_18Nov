package PruebaT;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hilo1 extends Thread {

	private Cliente cliente;
	private static final String MAG = "\u001b[35m";
	public static final String RED = "\u001B[31m";
	private Lock bloqueo;

	public Hilo1(Cliente cli) {
		this.cliente = cli;
		//this.bloqueo = new ReentrantLock();
	}

	@Override
	public void run() {


		float ale = (float) ((Math.random() * 500) + 1);
		System.out.println("ale: " + ale);
			this.cliente.opera(ale);
			if (this.getName().equals("hfer"))
				System.out.println(MAG + "HILO FER");
			

	}

}
