package paquete_Tienda_NOV_16_2_syncronized;

import java.util.ArrayList;
import java.util.List;

public class TiendaN16 {

	private List<ClienteN16> carroClientes;
	private List<Producto> productos;

	private boolean enProceso = false;

	public TiendaN16() {
		this.carroClientes = new ArrayList<>();
		List<ItemProducto> carro1 = new ArrayList<>();
		carro1.add(new ItemProducto(1, 2, 12.2));
		carro1.add(new ItemProducto(3, 3, 23.0));
		carro1.add(new ItemProducto(2, 4, 5.95));
		ClienteN16 cli1 = new ClienteN16(1, "juan", carro1);

		List<ItemProducto> carro2 = new ArrayList<>();
		carro2.add(new ItemProducto(1, 4, 12.2));
		carro2.add(new ItemProducto(2, 3, 23.0));
		ClienteN16 cli2 = new ClienteN16(2, "antonia", carro2);

		ClienteN16 cli3 = new ClienteN16(3, "lola", carro1); // lola tiene el mismo carrito que juan
		this.carroClientes.add(cli1);
		this.carroClientes.add(cli2);
		this.carroClientes.add(cli3);
		this.productos = new ArrayList<>();
		this.productos.add(new Producto(1, "cortadora", 12, 12.2));
		this.productos.add(new Producto(2, "compostadora", 5, 122.2));
		this.productos.add(new Producto(3, "maceta", 14, 6.0));
		this.productos.add(new Producto(4, "jardinera", 5, 80.2));
	}

    public void procesarClientes() {
        for (ClienteN16 cliente : carroClientes) {
            Thread hilo = new Thread(new HiloCompra(cliente, this));
            hilo.setName("Cliente-" + cliente.getNombre());
            hilo.start();
        }
    }

	// METODO QUE INICIA
	public void IteraClientes(TiendaN16 tienda) {

		for (ClienteN16 cliente : this.carroClientes) {
			Thread hilo = new Thread(new HiloCompra(cliente, tienda));
            hilo.setName("Cliente-" + cliente.getNombre());
            hilo.start();
            
		}
	}

	public synchronized void ejecucion(ClienteN16 cli) {

		try {
			while (this.enProceso) {
				wait();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		
		this.enProceso = true;
		System.out.println("Iniciando compra para: " + cli.getNombre());
		
		List<ItemProducto> factura = cli.getFactura();

		for (ItemProducto ite : factura) { // Recorrer la factura
			int cantidad = ite.getCantidad();
			Integer idPro = ite.getCodigoProducto();
			int inx = this.productos.indexOf(new Producto(idPro));
			
			if (inx != -1) {
				Producto producto = this.productos.get(inx);

				// Verificar y actualizar stock
				if (producto.getStock() >= cantidad) {
					producto.setStock(producto.getStock() - cantidad); // actualiza el producto
					System.out.println(
							cli.getNombre() + " compró " + cantidad + " unidades de " + producto.getNombreProd());
				} else {
					System.out.println( "Stock insuficiente de: " + producto.getNombreProd() + " Cliente: " + cli.getNombre());
				}
			}
		}
		
		try {
            Thread.sleep(300); // Simular tiempo de compra
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
		System.out.println("Compra finalizada para: " + cli.getNombre());
		this.enProceso = false;
		notifyAll();
	}
	
	
	

	public List<ClienteN16> getCarroClientes() {
		return carroClientes;
	}
	public void setCarroClientes(List<ClienteN16> carroClientes) {
		this.carroClientes = carroClientes;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
	public static void main(String[] args) {

		TiendaN16 tienda = new TiendaN16(); // creas la tienda para que se creen los datos
		//tienda.IteraClientes(tienda);

		 tienda.procesarClientes();
	}

}
