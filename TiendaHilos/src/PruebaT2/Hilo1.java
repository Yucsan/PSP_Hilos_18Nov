package PruebaT2;


public class Hilo1 extends Thread {

	private Cliente cliente;
	private static final String MAG = "\u001b[35m";
	public static final String RED = "\u001B[31m";

	public Hilo1(Cliente cli) {
		this.cliente = cli;

	}

	@Override
	public void run() {
		this.cliente.opera();
		if (this.getName().equals("hfer"))
			System.out.println(MAG + "HILO FER");
	}

}
