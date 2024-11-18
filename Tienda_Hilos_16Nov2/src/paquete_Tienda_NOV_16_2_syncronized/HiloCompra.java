package paquete_Tienda_NOV_16_2_syncronized;


public class HiloCompra implements Runnable {

	private TiendaN16 tienda;
	private ClienteN16 cliente;
	


	public HiloCompra(ClienteN16 cliente, TiendaN16 tienda) { 
		this.tienda = tienda;
		this.cliente = cliente;
	}

	@Override
	public void run() {
			
			tienda.ejecucion(cliente);

		
	}

}
