package tienda1;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ejecuta {

	public static void main(String[] args) {

		Ejecuta ej = new Ejecuta();

		Tienda tienda = new Tienda(); // creas la tienda para que se creen los datos
		List<ClienteT1> carroClientes = tienda.getCarroClientes(); // te traeas los clientes

		
			for (ClienteT1 cliente : carroClientes) {
				HiloCompra hilo = new HiloCompra(tienda, cliente); // creamos 1 hilo por cliente
				Thread t = new Thread(hilo);
				t.start();
			}

	}

}
