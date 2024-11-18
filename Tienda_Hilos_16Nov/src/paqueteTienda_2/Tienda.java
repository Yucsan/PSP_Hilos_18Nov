package paqueteTienda_2;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private List<Cliente> carroClientes;
    private List<Producto> productos;


    public Tienda() {
        this.carroClientes = new ArrayList<>();
        List<ItemProducto> carro1 = new ArrayList<>();
        carro1.add(new ItemProducto(1, 2, 12.2));
        carro1.add(new ItemProducto(3, 3, 23.0));
        carro1.add(new ItemProducto(2, 4, 5.95));
        Cliente cli1 = new Cliente(1, "juan", carro1);
        List<ItemProducto> carro2 = new ArrayList<>();
        carro2.add(new ItemProducto(1, 4, 12.2));
        carro2.add(new ItemProducto(2, 3, 23.0));
        Cliente cli2 = new Cliente(2, "antonia", carro2);
        Cliente cli3 = new Cliente(3, "lola", carro1);
        this.carroClientes.add(cli1);
        this.carroClientes.add(cli2);
        this.carroClientes.add(cli3);
        this.productos = new ArrayList<>();
        this.productos.add(new Producto(1, "cortadora", 12, 12.2));
        this.productos.add(new Producto(2, "compostadora", 5, 122.2));
        this.productos.add(new Producto(3, "maceta", 14, 6.0));
        this.productos.add(new Producto(4, "jardinera", 5, 80.2));
        
    }

    public void ejecucion(Cliente cli) {

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
                        System.out.println(cli.getNombre() + " compró " + cantidad + " unidades de "
                                + producto.getNombreProd());
                    } else {
                        System.out.println("Stock insuficiente para " + producto.getNombreProd() + " (Cliente: "
                                + cli.getNombre() + ")");
                    }
                }
            }

            // Simular proceso de compra
            compra(cli);       
    }

    public void compra(Cliente cli) {
        try {
            Thread.sleep(300); // Simular tiempo de compra
            System.out.println(cli.getNombre() + " finalizó el proceso de compra.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getCarroClientes() {
        return carroClientes;
    }

    public void setCarroClientes(List<Cliente> carroClientes) {
        this.carroClientes = carroClientes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
