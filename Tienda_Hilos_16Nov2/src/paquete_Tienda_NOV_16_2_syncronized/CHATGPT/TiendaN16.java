package paquete_Tienda_NOV_16_2_syncronized.CHATGPT;

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

    public synchronized void procesarCompra(ClienteN16 cliente) {
        while (enProceso) { // Espera activa hasta que el proceso actual termine
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Error durante la espera: " + e.getMessage());
            }
        }

        enProceso = true; // Marca que un cliente está siendo procesado
        System.out.println("Iniciando compra para: " + cliente.getNombre());

        List<ItemProducto> factura = cliente.getFactura();

        for (ItemProducto item : factura) {
            int cantidad = item.getCantidad();
            Integer idProducto = item.getCodigoProducto();
            int index = this.productos.indexOf(new Producto(idProducto));

            if (index != -1) {
                Producto producto = this.productos.get(index);

                // Verificar y actualizar stock
                if (producto.getStock() >= cantidad) {
                    producto.setStock(producto.getStock() - cantidad);
                    System.out.println(cliente.getNombre() + " compró " + cantidad + " unidades de " + producto.getNombreProd());
                } else {
                    System.out.println("Stock insuficiente de " + producto.getNombreProd() + " (Cliente: " + cliente.getNombre() + ")");
                }
            }
        }

        try {
            Thread.sleep(300); // Simular tiempo de compra
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
        System.out.println("Compra finalizada para: " + cliente.getNombre());
        enProceso = false; // Libera el proceso para el siguiente cliente
        notifyAll(); // Notifica a los demás hilos que pueden continuar
    }

    public void procesarClientes() {
        for (ClienteN16 cliente : carroClientes) {
            Thread hilo = new Thread(() -> procesarCompra(cliente));
            hilo.setName("Cliente-" + cliente.getNombre());
            hilo.start();
        }
    }

    public static void main(String[] args) {
        TiendaN16 tienda = new TiendaN16(); // Creas la tienda para que se creen los datos
        tienda.procesarClientes();
    }
}
