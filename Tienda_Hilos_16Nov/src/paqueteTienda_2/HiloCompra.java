package paqueteTienda_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class HiloCompra implements Runnable {

	private Tienda tienda;
	private Cliente cliente;
	private Lock bloqueoGlobal; // Bloqueo global compartido

	public HiloCompra(Tienda tienda, Cliente cliente, Lock bloqueoGlobal) {
		this.tienda = tienda;
		this.cliente = cliente;
		this.bloqueoGlobal = bloqueoGlobal;
	}

	@Override
	public void run() {
		bloqueoGlobal.lock();
		try {
			System.out.println("Iniciando compra para: " + cliente.getNombre());
			tienda.ejecucion(cliente);
			System.out.println("Compra finalizada para: " + cliente.getNombre());
		} finally {
			bloqueoGlobal.unlock(); // Liberar el bloqueo
		}
	}

}
