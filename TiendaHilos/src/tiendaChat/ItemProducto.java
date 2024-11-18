package tiendaChat;

public class ItemProducto {
    private Integer codigoProducto;
    private Integer cantidad;
    private Double precio;

    public ItemProducto(Integer codigoProducto, Integer cantidad, Double precio) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getCodigoProducto() { return codigoProducto; }
    public Integer getCantidad() { return cantidad; }
    public Double getPrecio() { return precio; }
}
