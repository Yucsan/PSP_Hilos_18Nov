package PruebaT;

public class Main {

	public static void main(String[] args) {
		
		Cliente[] clientes = {
				new Cliente("fer", 300f),
				new Cliente("Ana", 100f),
				new Cliente("Gala", 800f),
		};
		
		
		 
		for(Cliente c: clientes) {
			Hilo1 h=new Hilo1(c);
			h.setName("h"+c.getNombre());
			
			h.start();
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
