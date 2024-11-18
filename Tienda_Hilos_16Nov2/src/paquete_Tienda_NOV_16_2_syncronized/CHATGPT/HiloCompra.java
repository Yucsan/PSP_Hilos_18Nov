package paquete_Tienda_NOV_16_2_syncronized.CHATGPT;


public class HiloCompra implements Runnable {

	private TiendaN16 tienda;
	private ClienteN16 cliente;
	


	public HiloCompra(ClienteN16 cliente, TiendaN16 tienda) { 
		this.tienda = tienda;
		this.cliente = cliente;
	}

	@Override
	public void run() {
			System.out.println("Iniciando compra para: " + cliente.getNombre());
			//tienda.ejecucion(cliente);
			System.out.println("Compra finalizada para: " + cliente.getNombre());
			
			System.out.println();
			System.out.println("***************************************************************************************************");
			System.out.println();
		
	}

}
