package Ultimo;

public class Main {

	public static void main(String[] args) {
		
		Telegrama tele=new Telegrama();
		HiloT hilo1=new HiloT(tele);
		hilo1.setName("HILO 1");
		
		HiloT hilo2=new HiloT(tele);
		hilo2.setName("HILO 2");
		
		hilo1.start();
		hilo2.start();
		

	}

}
