package tienda2;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ejecuta {
	

	public static void main(String[] args) {
		
		Tienda tienda=new Tienda(); // creas la tienda para que se creen los datos
		List<Cliente> carroClientes = tienda.getCarroClientes(); //te traeas los clientes
		
		for(Cliente cliente: carroClientes) {
			HiloCompra hilo=new HiloCompra(tienda, cliente); //creamos 1 hilo por cliente
			Thread t= new Thread(hilo);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
