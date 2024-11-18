package tienda1;

import java.util.ArrayList;
import java.util.List;

public class HiloCompra implements Runnable {

	private Tienda tienda;
	private ClienteT1 cliente;

	public HiloCompra(Tienda tienda, ClienteT1 cliente) {
		this.tienda = tienda;
		this.cliente = cliente;
	}

	@Override
	public void run() {
		System.out.println("Iniciando compra para: " + cliente.getNombre());
		tienda.ejecucion(cliente);
		System.out.println("Compra finalizada para: " + cliente.getNombre());
	}

}
