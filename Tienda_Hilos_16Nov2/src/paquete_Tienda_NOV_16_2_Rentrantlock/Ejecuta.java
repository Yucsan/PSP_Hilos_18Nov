package paquete_Tienda_NOV_16_2_Rentrantlock;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ejecuta {

	public static void main(String[] args) {
		//Lock bloqueoGlobal = new ReentrantLock();
		
		Ejecuta ej = new Ejecuta();

		TiendaN16 tienda = new TiendaN16(); // creas la tienda para que se creen los datos
		
		//tienda.IteraClientes();
		
		
		
		
		
		
		//List<ClienteN16> carroClientes = tienda.getCarroClientes(); // te traeas los clientes

		/*
			for (ClienteN16 cliente : carroClientes) {
				HiloCompra hilo = new HiloCompra(cliente); // creamos 1 hilo por cliente
				Thread t = new Thread(hilo);
				t.start();
			}
		*/
		
		
	}

}
