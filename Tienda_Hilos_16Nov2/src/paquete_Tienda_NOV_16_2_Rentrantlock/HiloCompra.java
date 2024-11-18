package paquete_Tienda_NOV_16_2_Rentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class HiloCompra implements Runnable {

	private TiendaN16 tienda;
	private ClienteN16 cliente;
	
	//private Lock bloqueoCompra; // Bloqueo global compartido

	public HiloCompra(ClienteN16 cliente, TiendaN16 tienda) { //, Lock bloqueoCompra
		this.tienda = tienda;
		this.cliente = cliente;
		//this.bloqueoCompra = bloqueoCompra;
	}

	@Override
	public void run() {
		//bloqueoCompra.lock();
		//try {
			System.out.println("Iniciando compra para: " + cliente.getNombre());
			tienda.ejecucion(cliente);
			System.out.println("Compra finalizada para: " + cliente.getNombre());
		/*} finally {
			//bloqueoCompra.unlock(); // Liberar el bloqueo
		}*/
	}

}
