package tienda2;


public class HiloCompra implements Runnable {

	private Tienda tienda;
    private Cliente cliente;

    public HiloCompra(Tienda tienda, Cliente cliente) {
        this.tienda = tienda;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        //System.out.println("Iniciando compra para: " + cliente.getNombre());
        tienda.ejecucion(cliente);
        System.out.println("Compra finalizada para: " + cliente.getNombre());
        
    }
	
	

}
	
	
	
	
	



