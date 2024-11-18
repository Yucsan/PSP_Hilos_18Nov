package paquete_Tienda_NOV_16_2_Rentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TiendaN16 {

	private List<ClienteN16> carroClientes;
	private List<Producto> productos;

	private Lock bloqueoCompra; // Bloqueo global compartido

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
		ClienteN16 cli3 = new ClienteN16(3, "lola", carro1);
		this.carroClientes.add(cli1);
		this.carroClientes.add(cli2);
		this.carroClientes.add(cli3);
		this.productos = new ArrayList<>();
		this.productos.add(new Producto(1, "cortadora", 12, 12.2));
		this.productos.add(new Producto(2, "compostadora", 5, 122.2));
		this.productos.add(new Producto(3, "maceta", 14, 6.0));
		this.productos.add(new Producto(4, "jardinera", 5, 80.2));
		bloqueoCompra = new ReentrantLock();

	}

	

	//METODO QUE INICIA
	public void IteraClientes(TiendaN16 tienda) {
		
		bloqueoCompra.lock();
		try {

			for (ClienteN16 cliente : this.carroClientes) {
				HiloCompra hilo = new HiloCompra(cliente, tienda); // creamos 1 hilo por cliente
				Thread t = new Thread(hilo);
				t.start();
				
			}
			
		} finally {
			bloqueoCompra.unlock();
		}
	}

	public void ejecucion(ClienteN16 cli) {

		List<ItemProducto> factura = cli.getFactura();

		for (ItemProducto ite : factura) { // Recorrer la factura
			int cantidad = ite.getCantidad();
			Integer idPro = ite.getCodigoProducto();
			int inx = this.productos.indexOf(new Producto(idPro));
			if (inx != -1) {
				Producto producto = this.productos.get(inx);

				// Verificar y actualizar stock
				if (producto.getStock() - cantidad >= 0) {
					producto.setStock(producto.getStock() - cantidad);
					System.out.println(
							cli.getNombre() + " compró " + cantidad + " unidades de " + producto.getNombreProd());
				} else {
					System.out.println("Stock insuficiente para " + producto.getNombreProd() + " (Cliente: "
							+ cli.getNombre() + ")");
				}
			}
		}

		// tiempo entre compra y compra
		retraso(cli);
	}

	public void retraso(ClienteN16 cli) {
		try {
			Thread.sleep(300); // Simular tiempo de compra
			System.out.println(cli.getNombre() + " finalizó el proceso de compra.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		tienda.IteraClientes(tienda);
		
		//tienda.IteraClientes2(tienda);
	}

}
