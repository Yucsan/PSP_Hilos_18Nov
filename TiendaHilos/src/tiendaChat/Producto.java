package tiendaChat;
public class Producto {
    private Integer codigoProducto;
    private String nombreProd;
    private Integer stock;
    private Double precio;

    public Producto(Integer codigoProducto, String nombreProd, Integer stock, Double precio) {
        this.codigoProducto = codigoProducto;
        this.nombreProd = nombreProd;
        this.stock = stock;
        this.precio = precio;
    }

    public synchronized boolean reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            return true;
        } else {
            return false;
        }
    }

    public Integer getCodigoProducto() { return codigoProducto; }
    public String getNombreProd() { return nombreProd; }
    public Integer getStock() { return stock; }
    public Double getPrecio() { return precio; }
}
