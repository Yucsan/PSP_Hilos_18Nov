package tiendaChat;

public class HiloCompra extends Thread {
    private Cliente cliente;
    private Tienda tienda;

    public HiloCompra(Cliente cliente, Tienda tienda) {
        this.cliente = cliente;
        this.tienda = tienda;
    }

    public void run() {
        boolean compraCompleta = true;

        for (ItemProducto item : cliente.getFactura()) {
            Producto producto = tienda.obtenerProductoPorCodigo(item.getCodigoProducto());
            if (producto != null) {
                synchronized (producto) {
                    if (!producto.reducirStock(item.getCantidad())) {
                        compraCompleta = false;
                        System.out.println("No hay suficiente stock para el producto " + producto.getNombreProd() +
                                           " solicitado por el cliente " + cliente.getNombre());
                        break;
                    }
                }
            } else {
                compraCompleta = false;
                System.out.println("Producto no encontrado para el cliente " + cliente.getNombre());
                break;
            }
        }

        if (compraCompleta) {
            System.out.println("Compra completada con éxito para el cliente " + cliente.getNombre());
        } else {
            System.out.println("Compra fallida para el cliente " + cliente.getNombre() + ". Stock insuficiente.");
        }
    }
}
